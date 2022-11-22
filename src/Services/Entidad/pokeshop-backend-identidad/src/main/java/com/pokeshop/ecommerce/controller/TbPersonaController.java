package com.pokeshop.ecommerce.controller;

import com.pokeshop.ecommerce.dto.TbPersonaDto;
import com.pokeshop.ecommerce.entity.entidad.TbPersona;
import com.pokeshop.ecommerce.entity.entidad.TbUsuario;
import com.pokeshop.ecommerce.service.GenericCrud;
import com.pokeshop.ecommerce.service.TbPersonaService;
import com.pokeshop.ecommerce.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@CrossOrigin
@RestController
@RequestMapping("/api/tbpersonas")
public class TbPersonaController extends GenericController<TbPersonaDto, TbPersona, Integer> {

    @Autowired
    private TbPersonaService personaService;

    @Override
    public GenericCrud<TbPersonaDto, TbPersona, Integer> getCrud() {
        return personaService;
    }

    @Override
    protected Integer getPK(TbPersonaDto dto) {
        return dto.getIdPersona();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Integer id) {
        TbPersonaDto template = TbPersonaDto.builder().build();
        TbPersonaDto dto = getCrud().findById(id, template);
        if (dto != null) {
            WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findById(id));
            dto.add(linkTo.withRel(TbPersona.class.getSimpleName() + "-resource"));
        }
        return ResponseEntity.ok(ApiResponse.ok("Obtener Persona", dto));
    }

}