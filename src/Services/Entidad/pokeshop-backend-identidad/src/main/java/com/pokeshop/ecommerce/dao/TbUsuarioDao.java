package com.pokeshop.ecommerce.dao;

import com.pokeshop.ecommerce.entity.entidad.TbUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TbUsuarioDao extends JpaRepository<TbUsuario, Integer> {

    Optional<TbUsuario> findByEmail(String email);

    Optional<TbUsuario> findByEmailAndEstado(String email, Boolean estado);

}