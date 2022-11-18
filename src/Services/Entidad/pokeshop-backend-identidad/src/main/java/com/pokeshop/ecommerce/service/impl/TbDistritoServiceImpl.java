package com.pokeshop.ecommerce.service.impl;

import com.pokeshop.ecommerce.dao.TbDistritoDao;
import com.pokeshop.ecommerce.dto.TbDistritoDto;
import com.pokeshop.ecommerce.entity.entidad.TbDistrito;
import com.pokeshop.ecommerce.service.TbDistritoService;
import com.pokeshop.ecommerce.util.EnumIdentidadError;
import com.pokeshop.ecommerce.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class TbDistritoServiceImpl implements TbDistritoService {

    @Autowired
    private TbDistritoDao distritoDao;

    @Override
    public TbDistritoDto insert(TbDistritoDto dto) {
        validate(dto, "I");
        TbDistrito e = distritoDao.save(dto.toEntity());
        return dto.fromEntity(dto, e);
    }

    @Override
    public TbDistritoDto update(TbDistritoDto dto) {
        ValidateUtil.evaluar(false, EnumIdentidadError.ER006);
        return null;
    }

    @Override
    public void delete(TbDistritoDto dto) {
        ValidateUtil.evaluar(false, EnumIdentidadError.ER006);
    }

    @Override
    public TbDistritoDto findById(Integer id, TbDistritoDto dto) {
        ValidateUtil.evaluar(false, EnumIdentidadError.ER006);
        return null;
    }

    private void validate(TbDistritoDto dto, String type) {
        ValidateUtil.requerido(dto.getNombre(), EnumIdentidadError.AD004);
        ValidateUtil.requerido(dto.getEstado(), EnumIdentidadError.AD005);
        Optional<TbDistrito> optional = distritoDao.findByCodigo(dto.getCodigo());
        if (type.equals("I")) {
            optional.ifPresent(e -> ValidateUtil.evaluar(false, EnumIdentidadError.ER004,
                    "El distrito ya se encuentra registrado con el código : " + e.getCodigo()));
        } else if (type.equals("U")) {
            ValidateUtil.requerido(dto.getIdDistrito(), EnumIdentidadError.ER001);
            ValidateUtil.evaluar(optional.isPresent(), EnumIdentidadError.ER002);
            ValidateUtil.evaluar(optional.get().getIdDistrito().equals(dto.getIdDistrito()), EnumIdentidadError.ER003);
        }
    }

}