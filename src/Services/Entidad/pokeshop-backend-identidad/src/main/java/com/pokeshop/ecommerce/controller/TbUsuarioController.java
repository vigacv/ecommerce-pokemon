package com.pokeshop.ecommerce.controller;

import com.nyobyte.controller.GenericController;
import com.nyobyte.service.GenericCrud;
import com.pokeshop.ecommerce.dto.TbUsuarioDto;
import com.pokeshop.ecommerce.entity.entidad.TbUsuario;
import com.pokeshop.ecommerce.service.TbUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}