
using Azure.Storage.Blobs;

namespace Catalog.API.Infrastructure
{
    public class PicturesAccessor : IPicturesAccessor
    {
        private readonly BlobContainerClient _container;
        public PicturesAccessor(IConfiguration configuration)
        {
            _container = new BlobContainerClient(configuration.GetValue<string>("BlobStorage:ConnectionString"),
                configuration.GetValue<string>("BlobStorage:ContainerName"));

            _container.CreateIfNotExists();
        }

        public async Task<string> UploadPicture(IFormFile picture)
        {
            var blob = _container.GetBlobClient(picture.FileName);
            await blob.UploadAsync(picture.OpenReadStream());
            return blob.Uri.AbsoluteUri; 
        }

        public Task DeletePicture(string pictureUri)
        {
            BlobUriBuilder blobUriBuilder = new BlobUriBuilder(new Uri(pictureUri));
            var sourceBlob = _container.GetBlobClient(blobUriBuilder.BlobName);

            return sourceBlob.DeleteIfExistsAsync();
        }
    }
}