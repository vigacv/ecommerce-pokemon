package com.pokeshop.ecommerce.dao;

import com.pokeshop.ecommerce.entity.entidad.TbDistrito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TbDistritoDao extends JpaRepository<TbDistrito, Integer> {

    Optional<TbDistrito> findByCodigo(String codigo);

}