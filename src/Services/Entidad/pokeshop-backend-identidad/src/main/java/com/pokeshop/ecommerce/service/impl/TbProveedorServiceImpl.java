package com.pokeshop.ecommerce.service.impl;

import com.pokeshop.ecommerce.dto.TbProveedorDto;
import com.pokeshop.ecommerce.service.TbProveedorService;
import com.pokeshop.ecommerce.util.EnumIdentidadError;
import com.pokeshop.ecommerce.util.ValidateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TbProveedorServiceImpl implements TbProveedorService {
    @Override
    public TbProveedorDto insert(TbProveedorDto tbProveedorDto) {
        ValidateUtil.evaluar(false, EnumIdentidadError.ER006);
        return null;
    }

    @Override
    public TbProveedorDto update(TbProveedorDto tbProveedorDto) {
        ValidateUtil.evaluar(false, EnumIdentidadError.ER006);
        return null;
    }

    @Override
    public void delete(TbProveedorDto tbProveedorDto) {
        ValidateUtil.evaluar(false, EnumIdentidadError.ER006);
    }

    @Override
    public TbProveedorDto findById(Integer integer, TbProveedorDto tbProveedorDto) {
        ValidateUtil.evaluar(false, EnumIdentidadError.ER006);
        return null;
    }
}
