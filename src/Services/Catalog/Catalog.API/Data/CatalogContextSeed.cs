using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Catalog.Models;
using MongoDB.Driver;

namespace Catalog.API.Data
{
    public class CatalogContextSeed
    {
        public static async Task SeedAsync(ICatalogContext context)
        {
            if (!context.Products.Find(p => true).Any())
            {
                await context.Products.InsertManyAsync(GetPreconfiguredProducts());
            }
        }

        private static IEnumerable<Product> GetPreconfiguredProducts()
        {
            return new List<Product>{
                new Product()
                {
                    Id = Guid.NewGuid().ToString(),
                    Name = "Snorlax",
                    Description = "Carta Snorlax",
                    Price = 100,
                    Category = "cards",
                    Pictures = new List<ProductPicture>()
                    {
                        new ProductPicture()
                        {
                            Name = "Snorlax",
                            Uri = "https://assets.pokemon.com/assets/cms2-es-es/img/cards/web/SWSH11/SWSH11_ES_TG10.png"
                        }
                    }
                },
                new Product()
                {
                    Id = Guid.NewGuid().ToString(),
                    Name = "Piplup",
                    Description = "Carta Piplup",
                    Price = 200,
                    Category = "cards",
                    Pictures = new List<ProductPicture>()
                    {
                        new ProductPicture()
                        {
                            Name = "Piplup",
                            Uri = "https://assets.pokemon.com/assets/cms2-es-es/img/cards/web/SM5/SM5_ES_31.png"
                        }
                    }
                },
                new Product()
                {
                    Id = Guid.NewGuid().ToString(),
                    Name = "Chikorita",
                    Description = "Carta Chikorita",
                    Price = 400,
                    Category = "cards",
                    Pictures = new List<ProductPicture>()
                    {
                        new ProductPicture()
                        {
                            Name = "Chikorita",
                            Uri = "https://assets.pokemon.com/assets/cms2-es-es/img/cards/web/SM8/SM8_ES_5.png"
                        }
                    }
                },
                new Product()
                {
                    Id = Guid.NewGuid().ToString(),
                    Name = "Polo",
                    Description = "Eevee Pokémon Nature: Fall Black Heavyweight Crop Long-Sleeve Shirt - Women",
                    Price = 29.99M,
                    Category = "Polo",
                    Pictures = new List<ProductPicture>()
                    {
                        new ProductPicture()
                        {
                            Name = "Snorlax",
                            Uri = "https://www.pokemoncenter.com/products/images/P8432/741-95065/P8432_741-95065_01_full.jpg"
                        }
                    }
                },
                new Product()
                {
                    Id = Guid.NewGuid().ToString(),
                    Name = "Polera",
                    Description = "Mushroom Forest Pokémon Nature: Fall Charcoal Relaxed Fit Zip-Up Hoodie - Adult",
                    Price = 49.99M,
                    Category = "Polera",
                    Pictures = new List<ProductPicture>()
                    {
                        new ProductPicture()
                        {
                            Name = "Snorlax",
                            Uri = "https://www.pokemoncenter.com/products/images/P8432/741-95030/P8432_741-95030_01_full.jpg"
                        }
                    }
                },
                new Product()
                {
                    Id = Guid.NewGuid().ToString(),
                    Name = "Polo",
                    Description = "Treehouse Friends Pokémon Nature: Fall Green Relaxed Fit Crew Neck T-Shirt - Adult",
                    Price = 24.99M,
                    Category = "clothes",
                    Pictures = new List<ProductPicture>()
                    {
                        new ProductPicture()
                        {
                            Name = "Polo",
                            Uri = "https://www.pokemoncenter.com/products/images/P8432/741-95105/P8432_741-95105_01_full.jpg"
                        }
                    }
                },
                new Product()
                {
                    Id = Guid.NewGuid().ToString(),
                    Name = "Pikachu",
                    Description = "Pikachu & Robot Dedenne Toy Pokémon Holiday Workshop Plush - 8 ¾ In.",
                    Price = 27.99M,
                    Category = "plush",
                    Pictures = new List<ProductPicture>()
                    {
                        new ProductPicture()
                        {
                            Name = "Pikachu plush",
                            Uri = "https://www.pokemoncenter.com/products/images/P9040/701-97062/P9040_701-97062_01.jpg"
                        }
                    }
                },
                new Product()
                {
                    Id = Guid.NewGuid().ToString(),
                    Name = "Sprigatito",
                    Description = "Sprigatito Poké Plush - 7 ¾ In.",
                    Price = 15.99M,
                    Category = "plush",
                    Pictures = new List<ProductPicture>()
                    {
                        new ProductPicture()
                        {
                            Name = "Sprigatito plush",
                            Uri = "https://www.pokemoncenter.com/products/images/P8923/701-96548/P8923_701-96548_01.jpg"
                        }
                    }
                },
                new Product()
                {
                    Id = Guid.NewGuid().ToString(),
                    Name = "Eevee",
                    Description = "Eevee Pokémon Comfy Cuddlers Plush",
                    Price = 12.99M,
                    Category = "plush",
                    Pictures = new List<ProductPicture>()
                    {
                        new ProductPicture()
                        {
                            Name = "Eevee plush",
                            Uri = "https://www.pokemoncenter.com/products/images/P8667/701-96050/P8667_701-96050_01.jpg"
                        }
                    }
                },
                new Product()
                {
                    Id = Guid.NewGuid().ToString(),
                    Name = "Latias & Latios",
                    Description = "Kotobukiya Latias & Latios Figure",
                    Price = 149.99M,
                    Category = "figures",
                    Pictures = new List<ProductPicture>()
                    {
                        new ProductPicture()
                        {
                            Name = "Kotobukiya Latias & Latios Figure",
                            Uri = "https://www.pokemoncenter.com/products/images/P8571/710-95653/P8571_710-95653_01.jpg"
                        }
                    }
                },
                new Product()
                {
                    Id = Guid.NewGuid().ToString(),
                    Name = "Dragonite",
                    Description = "Delibird Holiday Express Dragonite Flatcar Figure",
                    Price = 39.99M,
                    Category = "figures",
                    Pictures = new List<ProductPicture>()
                    {
                        new ProductPicture()
                        {
                            Name = "Dragonite plush",
                            Uri = "https://www.pokemoncenter.com/products/images/P7694/703-09896/P7694_703-09896_01.jpg"
                        }
                    }
                },
                new Product()
                {
                    Id = Guid.NewGuid().ToString(),
                    Name = "Pokémon Scarlet & Violet",
                    Description = "Pokémon Scarlet & Pokémon Violet Double Pack",
                    Price = 119.99M,
                    Category = "videogames",
                    Pictures = new List<ProductPicture>()
                    {
                        new ProductPicture()
                        {
                            Name = "Pokémon Scarlet & Pokémon Violet Double Pack",
                            Uri = "https://www.pokemoncenter.com/products/images/P9119/716-97016/P9119_716-97016_01.jpg"
                        }
                    }
                },
                new Product()
                {
                    Id = Guid.NewGuid().ToString(),
                    Name = "Pokémon Brilliant Diamond & Shining Pearl",
                    Description = "Pokémon Brilliant Diamond & Pokémon Shining Pearl Double Pack",
                    Price = 119.98M,
                    Category = "videogames",
                    Pictures = new List<ProductPicture>()
                    {
                        new ProductPicture()
                        {
                            Name = "Pokémon Brilliant Diamond & Pokémon Shining Pearl Double Pack",
                            Uri = "https://www.pokemoncenter.com/products/images/P8679/716-95641/P8679_716-95641_01.jpg"
                        }
                    }
                },
                new Product()
                {
                    Id = Guid.NewGuid().ToString(),
                    Name = "Pokémon Legends: Arceus",
                    Description = "Action meets RPG as the Pokémon series reaches a new frontier",
                    Price = 59.99M,
                    Category = "videogames",
                    Pictures = new List<ProductPicture>()
                    {
                        new ProductPicture()
                        {
                            Name = "Pokémon Legends: Arceus",
                            Uri = "https://www.pokemoncenter.com/products/images/P8179/716-29910/P8179_716-29910_01.jpg"
                        }
                    }
                }
            };
        }
    }
}