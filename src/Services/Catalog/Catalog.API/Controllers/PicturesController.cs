using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Catalog.API.Models;
using Catalog.API.Services;
using Microsoft.AspNetCore.Mvc;

namespace Catalog.API.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class PicturesController : ControllerBase
    {
        private readonly IPicturesService _picturesService;
        public PicturesController(IPicturesService picturesService)
        {
            _picturesService = picturesService;
        }

        [HttpPut("{productId}")]
        public async Task<IActionResult> AddPicture(string productId, [FromForm] PictureForm pictureForm)
        {
            var result = await _picturesService.AddPicture(productId, pictureForm.File);
            if (!result) return BadRequest();
            return Ok();
        }

        [HttpDelete("{productId}/{pictureName}")]

        public async Task<IActionResult> DeletePicture(string productId, string pictureName)
        {
            var result = await _picturesService.DeletePicture(productId, pictureName);
            if (!result) return NotFound();
            
            return Ok();
        }
    }
}