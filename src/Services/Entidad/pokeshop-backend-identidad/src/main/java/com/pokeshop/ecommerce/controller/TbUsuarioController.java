package com.pokeshop.ecommerce.controller;

import com.nyobyte.controller.GenericController;
import com.nyobyte.service.GenericCrud;
import com.nyobyte.util.ApiResponse;
import com.pokeshop.ecommerce.dto.TbUsuarioDto;
import com.pokeshop.ecommerce.entity.entidad.TbUsuario;
import com.pokeshop.ecommerce.search.SearchLogin;
import com.pokeshop.ecommerce.service.TbUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@CrossOrigin
@RestController
@RequestMapping("/api/tbusuarios")
public class TbUsuarioController extends GenericController<TbUsuarioDto, TbUsuario, Integer> {

    @Autowired
    private TbUsuarioService usuarioService;

    @Override
    public GenericCrud<TbUsuarioDto, TbUsuario, Integer> getCrud() {
        return usuarioService;
    }

    @Override
    protected Integer getPK(TbUsuarioDto dto) {
        return dto.getIdUsuario();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Integer id) {
        TbUsuarioDto template = TbUsuarioDto.builder().build();
        TbUsuarioDto dto = getCrud().findById(id, template);
        if (dto != null) {
            WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findById(id));
            dto.add(linkTo.withRel(TbUsuario.class.getSimpleName() + "-resource"));
        }
        return ResponseEntity.ok(ApiResponse.ok("Obtener Usuario", dto));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody SearchLogin search) {
        TbUsuarioDto dto = usuarioService.login(search);
        String resp = dto == null ? "Usuario no encontrado" : "Usuario logeado exitosamente";
        return ResponseEntity.ok(ApiResponse.ok(resp, dto));
    }

}