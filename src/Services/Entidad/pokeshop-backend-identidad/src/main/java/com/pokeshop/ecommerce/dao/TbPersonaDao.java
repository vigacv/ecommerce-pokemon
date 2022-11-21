package com.pokeshop.ecommerce.dao;

import com.pokeshop.ecommerce.entity.entidad.TbPersona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TbPersonaDao extends JpaRepository<TbPersona, Integer> {

    Optional<TbPersona> findByNroDocumento(String nroDocumento);

}