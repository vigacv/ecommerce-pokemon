using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Catalog.Models;
using Microsoft.AspNetCore.Mvc;

namespace Catalog.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class ProductsController : ControllerBase
    {

        // [HttpGet]
        // public async Task<IActionResult> GetProducts()
        // {
        //     return Ok(await _cosmosDbService.GetItemsAsync("SELECT * FROM c"));
        // }

        // [HttpGet("{id}")]
        // public async Task<IActionResult> GetProduct(string id)
        // {
        //     var product = await _cosmosDbService.GetItemAsync(id);
        //     return Ok(product);
        // }

        // [HttpPost]
        // public async Task<IActionResult> CreateProduct(Product product)
        // {
        //     await _cosmosDbService.AddItemAsync(product);
        //     return Ok();
        // }

        // [HttpPut("{id}")]
        // public async Task<IActionResult> UpdateProduct(string id, Product product)
        // {
        //     await _cosmosDbService.UpdateItemAsync(id, product);
        //     return Ok();
        // }

        // [HttpDelete("{id}")]
        // public async Task<IActionResult> DeleteProduct(string id)
        // {
        //     await _cosmosDbService.DeleteItemAsync(id);
        //     return Ok();
        // }
    }
}