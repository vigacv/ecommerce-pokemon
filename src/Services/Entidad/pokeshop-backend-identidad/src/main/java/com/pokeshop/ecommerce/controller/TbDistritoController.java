package com.pokeshop.ecommerce.controller;

import com.pokeshop.ecommerce.dto.TbDistritoDto;
import com.pokeshop.ecommerce.entity.entidad.TbDistrito;
import com.pokeshop.ecommerce.entity.entidad.TbUsuario;
import com.pokeshop.ecommerce.service.GenericCrud;
import com.pokeshop.ecommerce.service.TbDistritoService;
import com.pokeshop.ecommerce.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@CrossOrigin
@RestController
@RequestMapping("/api/tbdistritos")
public class TbDistritoController extends GenericController<TbDistritoDto, TbDistrito, Integer> {

    @Autowired
    private TbDistritoService distritoService;

    @Override
    public GenericCrud<TbDistritoDto, TbDistrito, Integer> getCrud() {
        return distritoService;
    }

    @Override
    protected Integer getPK(TbDistritoDto dto) {
        return dto.getIdDistrito();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Integer id) {
        TbDistritoDto template = TbDistritoDto.builder().build();
        TbDistritoDto dto = getCrud().findById(id, template);
        if (dto != null) {
            WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findById(id));
            dto.add(linkTo.withRel(TbDistrito.class.getSimpleName() + "-resource"));
        }
        return ResponseEntity.ok(ApiResponse.ok("Obtener Distrito", dto));
    }

}