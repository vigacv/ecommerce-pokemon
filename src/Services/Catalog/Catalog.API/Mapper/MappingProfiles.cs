using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using AutoMapper;
using Catalog.API.Models;
using Catalog.Models;

namespace Catalog.API.Mapper
{
    public class MappingProfiles : Profile
    {
        public MappingProfiles()
        {
            CreateMap<ProductForm, Product>()
                .ForMember(opt => opt.Pictures, x => x.Ignore());

            CreateMap<Product, Product>()
                .ForMember(opt => opt.Pictures, x => x.Ignore());
        }
    }
}