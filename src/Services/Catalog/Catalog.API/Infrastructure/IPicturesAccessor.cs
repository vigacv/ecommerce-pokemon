using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Catalog.API.Infrastructure
{
    public interface IPicturesAccessor
    {
        Task<string> UploadPicture(IFormFile picture);
        Task DeletePicture(string pictureUri);
    }
}