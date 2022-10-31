using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Catalog.API.Services
{
    public interface IPicturesService
    {
        Task<bool> DeletePicture(string productId, string pictureUri);
        Task<bool> AddPicture(string productId, IFormFile file);
    }
}