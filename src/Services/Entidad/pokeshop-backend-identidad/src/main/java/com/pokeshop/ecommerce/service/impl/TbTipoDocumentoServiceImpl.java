package com.pokeshop.ecommerce.service.impl;

import com.nyobyte.util.ValidateUtil;
import com.pokeshop.ecommerce.dao.TbTipoDocumentoDao;
import com.pokeshop.ecommerce.dto.TbTipoDocumentoDto;
import com.pokeshop.ecommerce.entity.entidad.TbTipoDocumento;
import com.pokeshop.ecommerce.service.TbTipoDocumentoService;
import com.pokeshop.ecommerce.util.EnumIdentidadError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class TbTipoDocumentoServiceImpl implements TbTipoDocumentoService {

    @Autowired
    private TbTipoDocumentoDao tipoDocumentoDao;

    @Override
    public TbTipoDocumentoDto insert(TbTipoDocumentoDto dto) {
        validate(dto, "I");
        TbTipoDocumento e = tipoDocumentoDao.save(dto.toEntity());
        return dto.fromEntity(dto, e);
    }

    @Override
    public TbTipoDocumentoDto update(TbTipoDocumentoDto dto) {
        ValidateUtil.evaluar(false, EnumIdentidadError.ER006);
        return null;
    }

    @Override
    public void delete(TbTipoDocumentoDto dto) {
        ValidateUtil.evaluar(false, EnumIdentidadError.ER006);
    }

    @Override
    public TbTipoDocumentoDto findById(Integer id, TbTipoDocumentoDto dto) {
        ValidateUtil.evaluar(false, EnumIdentidadError.ER006);
        return null;
    }

    private void validate(TbTipoDocumentoDto dto, String type) {
        ValidateUtil.requerido(dto.getNombre(), EnumIdentidadError.AD004);
        ValidateUtil.requerido(dto.getDescripcion(), EnumIdentidadError.AD401);
        ValidateUtil.requerido(dto.getLongitudMinima(), EnumIdentidadError.AD402);
        ValidateUtil.requerido(dto.getLongitudMaxima(), EnumIdentidadError.AD403);
        ValidateUtil.requerido(dto.getEstado(), EnumIdentidadError.AD005);
        Optional<TbTipoDocumento> optional = tipoDocumentoDao.findByCodigo(dto.getCodigo());
        if (type.equals("I")) {
            optional.ifPresent(e -> ValidateUtil.evaluar(false, EnumIdentidadError.ER004,
                    "El tipo de documento ya se encuentra registrado con el código : " + e.getCodigo()));
        } else if (type.equals("U")) {
            ValidateUtil.requerido(dto.getIdTipoDocumento(), EnumIdentidadError.ER001);
            ValidateUtil.evaluar(optional.isPresent(), EnumIdentidadError.ER002);
            ValidateUtil.evaluar(optional.get().getIdTipoDocumento().equals(dto.getIdTipoDocumento()), EnumIdentidadError.ER003);
        }
    }

}