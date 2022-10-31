using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Catalog.Models;

namespace Catalog.API.Services
{
    public interface IProductsService
    {
        Task<List<Product>> GetProducts();
        Task<Product> GetProduct(string id);
        Task Create(Product product);
        Task<bool> Update(string id, Product product);
        Task<bool> Delete(string id);
    }
}