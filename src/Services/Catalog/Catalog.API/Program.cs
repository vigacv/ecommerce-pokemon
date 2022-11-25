using System.Configuration;
using Catalog.API.Data;
using Catalog.API.Infrastructure;
using Catalog.API.Mapper;
using Catalog.API.Services;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

builder.Services.AddCors(opt => {
    opt.AddPolicy("CorsPolicy", policy => {
        policy.WithOrigins(builder.Configuration["FrontendUrl"]);
    });
});

builder.Services.AddScoped<ICatalogContext, CatalogContext>();
builder.Services.AddScoped<IProductsService, ProductsService>();
builder.Services.AddScoped<IPicturesAccessor, PicturesAccessor>();
builder.Services.AddScoped<IPicturesService, PicturesService>();

builder.Services.AddAutoMapper(typeof(MappingProfiles));

var app = builder.Build();

app.UseCors("CorsPolicy");

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

// app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
