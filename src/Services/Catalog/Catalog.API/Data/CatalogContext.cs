using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Catalog.Models;
using MongoDB.Driver;

namespace Catalog.API.Data
{
    public class CatalogContext : ICatalogContext
    {
        public CatalogContext(IConfiguration configuration)
        {
            var client = new MongoClient(configuration.GetValue<string>("CosmosDb:ConnectionString"));
            var database = client.GetDatabase(configuration.GetValue<string>("CosmosDb:DatabaseName"));

            Products = database.GetCollection<Product>(configuration.GetValue<string>("CosmosDb:CollectionName"));

            CatalogContextSeed.SeedAsync(this).Wait();
        }
        public IMongoCollection<Product> Products { get; }
    }
}