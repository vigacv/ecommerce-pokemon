using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Newtonsoft.Json;

namespace Catalog.Models
{
    public class Product
    {
        [JsonProperty(PropertyName = "id")]
        public string Id { get; set; }

        [JsonProperty(PropertyName = "name")]
        public string Name { get; set; }
        
        [JsonProperty(PropertyName = "description")]
        public string Description { get; set; }
        
        [JsonProperty(PropertyName = "price")]
        public decimal Price { get; set; }
        
        [JsonProperty(PropertyName = "pictureUris")]
        public ICollection<string> PictureUris { get; set; }
        
        [JsonProperty(PropertyName = "category")]
        public string Category { get; set; }
    }
}