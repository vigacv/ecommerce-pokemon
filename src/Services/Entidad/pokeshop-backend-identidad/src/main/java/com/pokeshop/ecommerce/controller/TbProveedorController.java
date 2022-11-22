package com.pokeshop.ecommerce.controller;

import com.pokeshop.ecommerce.dto.TbProveedorDto;
import com.pokeshop.ecommerce.entity.entidad.TbProveedor;
import com.pokeshop.ecommerce.entity.entidad.TbUsuario;
import com.pokeshop.ecommerce.service.GenericCrud;
import com.pokeshop.ecommerce.service.TbProveedorService;
import com.pokeshop.ecommerce.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@CrossOrigin
@RestController
@RequestMapping("/api/tbproveedores")
public class TbProveedorController extends GenericController<TbProveedorDto, TbProveedor, Integer> {

    @Autowired
    private TbProveedorService proveedorService;

    @Override
    public GenericCrud<TbProveedorDto, TbProveedor, Integer> getCrud() {
        return proveedorService;
    }

    @Override
    protected Integer getPK(TbProveedorDto dto) {
        return dto.getIdProveedor();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Integer id) {
        TbProveedorDto template = TbProveedorDto.builder().build();
        TbProveedorDto dto = getCrud().findById(id, template);
        if (dto != null) {
            WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findById(id));
            dto.add(linkTo.withRel(TbProveedor.class.getSimpleName() + "-resource"));
        }
        return ResponseEntity.ok(ApiResponse.ok("Obtener Proveedor", dto));
    }

}