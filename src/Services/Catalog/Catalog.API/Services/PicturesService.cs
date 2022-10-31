using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Catalog.API.Data;
using Catalog.API.Infrastructure;
using Catalog.Models;
using MongoDB.Driver;

namespace Catalog.API.Services
{
    public class PicturesService : IPicturesService
    {
        private readonly IPicturesAccessor _picturesAccessor;
        private readonly ICatalogContext _catalogContext;

        public PicturesService(IPicturesAccessor picturesAccessor, ICatalogContext catalogContext)
        {
            _picturesAccessor = picturesAccessor;
            _catalogContext = catalogContext;
        }

        public async Task<bool> AddPicture(string productId, IFormFile file)
        {
            var picture = new ProductPicture
            {
                Name = file.FileName,
                Uri = await _picturesAccessor.UploadPicture(file)
            };

            var filter = Builders<Product>.Filter.Eq(p => p.Id, productId);
            var update = Builders<Product>.Update.Push(p => p.Pictures, picture);

            var updateResult = await _catalogContext.Products.UpdateOneAsync(filter, update);

            return updateResult.IsAcknowledged
                    && updateResult.ModifiedCount > 0;
        }

        public async Task<bool> DeletePicture(string productId, string pictureName)
        {
            //get picture uri
            var product = await _catalogContext.Products.Find(p => p.Id == productId).FirstOrDefaultAsync();
            var picture = product.Pictures.FirstOrDefault(p => p.Name == pictureName);
            if(picture == null)
            {
                return false;
            }
            var pictureUri = picture.Uri;

            await _picturesAccessor.DeletePicture(pictureUri);
            
            product.Pictures.Remove(picture);

            var updateResult = await _catalogContext
                                        .Products
                                        .ReplaceOneAsync(filter: g => g.Id == productId, replacement: product);

            return updateResult.IsAcknowledged
                    && updateResult.ModifiedCount > 0;
        }
    }
}