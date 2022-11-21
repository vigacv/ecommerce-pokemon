using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using AutoMapper;
using Catalog.API.Data;
using Catalog.API.Infrastructure;
using Catalog.API.Models;
using Catalog.Models;
using MongoDB.Driver;

namespace Catalog.API.Services
{
    public class ProductsService : IProductsService
    {
        private readonly ICatalogContext _context;
        private readonly IPicturesAccessor _picturesAccessor;
        private readonly IMapper _mapper;

        public ProductsService(ICatalogContext context, IMapper mapper, IPicturesAccessor picturesService)
        {
            _context = context;
            _mapper = mapper;
            _picturesAccessor = picturesService;
        }

        public async Task<List<Product>> GetProducts()
        {
            return await _context.Products
                        .Find(p => true)
                        .ToListAsync();
        }

        public async Task<List<Product>> GetProductsByCategory(string category)
        {
            return await _context.Products
                        .Find(p => p.Category == category)
                        .ToListAsync();
        }

        public async Task<Product> GetProduct(string id)
        {
            return await _context.Products
                        .Find(p => p.Id == id)
                        .FirstOrDefaultAsync();
        }

        public async Task<Product> Create(ProductForm productForm)
        {
            var product = _mapper.Map<Product>(productForm);

            product.Id = Guid.NewGuid().ToString();

            foreach (var file in productForm.Pictures)
            {
                var picture = new ProductPicture
                {
                    Name = file.FileName,
                    Uri = await _picturesAccessor.UploadPicture(file)
                };
                product.Pictures.Add(picture);
            }
            await _context.Products.InsertOneAsync(product);
            
            return product;
        }

        public async Task<bool> Update(string id, Product product)
        {
            var productToUpdate = await _context.Products.Find(p => p.Id == id).FirstOrDefaultAsync();
            if (productToUpdate == null)
            {
                return false;
            }
            productToUpdate.Name = product.Name;
            productToUpdate.Description = product.Description;
            productToUpdate.Price = product.Price;
            productToUpdate.Category = product.Category;

            var updateResult = await _context
                                        .Products
                                        .ReplaceOneAsync(filter: g => g.Id == id, replacement: productToUpdate);

            return updateResult.IsAcknowledged
                    && updateResult.ModifiedCount > 0;
        }

        public async Task<bool> Delete(string id)
        {
            FilterDefinition<Product> filter = Builders<Product>.Filter.Eq(p => p.Id, id);

            DeleteResult deleteResult = await _context
                                                .Products
                                                .DeleteOneAsync(filter);

            return deleteResult.IsAcknowledged
                && deleteResult.DeletedCount > 0;
        }
    }
}