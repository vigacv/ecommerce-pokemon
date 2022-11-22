package com.pokeshop.ecommerce.controller;

import com.pokeshop.ecommerce.dto.TbTipoDocumentoDto;
import com.pokeshop.ecommerce.entity.entidad.TbTipoDocumento;
import com.pokeshop.ecommerce.entity.entidad.TbUsuario;
import com.pokeshop.ecommerce.service.GenericCrud;
import com.pokeshop.ecommerce.service.TbTipoDocumentoService;
import com.pokeshop.ecommerce.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@CrossOrigin
@RestController
@RequestMapping("/api/tbtipodocumentos")
public class TbTipoDocumentoController extends GenericController<TbTipoDocumentoDto, TbTipoDocumento, Integer> {

    @Autowired
    private TbTipoDocumentoService tipoDocumentoService;

    @Override
    public GenericCrud<TbTipoDocumentoDto, TbTipoDocumento, Integer> getCrud() {
        return tipoDocumentoService;
    }

    @Override
    protected Integer getPK(TbTipoDocumentoDto dto) {
        return dto.getIdTipoDocumento();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Integer id) {
        TbTipoDocumentoDto template = TbTipoDocumentoDto.builder().build();
        TbTipoDocumentoDto dto = getCrud().findById(id, template);
        if (dto != null) {
            WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findById(id));
            dto.add(linkTo.withRel(TbTipoDocumento.class.getSimpleName() + "-resource"));
        }
        return ResponseEntity.ok(ApiResponse.ok("Obtener Tipo Documento", dto));
    }

}