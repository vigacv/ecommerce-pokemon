package com.pokeshop.ecommerce.service;

import com.nyobyte.service.GenericCrud;
import com.pokeshop.ecommerce.dto.TbUsuarioDto;
import com.pokeshop.ecommerce.entity.entidad.TbUsuario;
import com.pokeshop.ecommerce.search.SearchLogin;

public interface TbUsuarioService extends GenericCrud<TbUsuarioDto, TbUsuario, Integer> {

    TbUsuarioDto login(SearchLogin search);

}