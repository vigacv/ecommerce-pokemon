using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Catalog.API.Models;
using Catalog.Models;

namespace Catalog.API.Services
{
    public interface IProductsService
    {
        Task<List<Product>> GetProducts();
        Task<List<Product>> GetProductsByCategory(string category);
        Task<Product> GetProduct(string id);
        Task<Product> Create(ProductForm product);
        Task<bool> Update(string id, Product product);
        Task<bool> Delete(string id);
    }
}