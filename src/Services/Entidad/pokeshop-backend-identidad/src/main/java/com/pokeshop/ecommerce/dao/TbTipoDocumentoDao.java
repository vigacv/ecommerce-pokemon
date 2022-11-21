package com.pokeshop.ecommerce.dao;

import com.pokeshop.ecommerce.entity.entidad.TbTipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TbTipoDocumentoDao extends JpaRepository<TbTipoDocumento, Integer> {

    Optional<TbTipoDocumento> findByCodigo(String codigo);

}