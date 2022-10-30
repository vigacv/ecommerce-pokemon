package com.pokeshop.ecommerce.service.impl;

import com.nyobyte.exception.GenericException;
import com.nyobyte.util.ValidateUtil;
import com.nyobyte.util.enumerado.EnumGeneralError;
import com.pokeshop.ecommerce.dao.TbUsuarioDao;
import com.pokeshop.ecommerce.dto.TbUsuarioDto;
import com.pokeshop.ecommerce.entity.entidad.TbUsuario;
import com.pokeshop.ecommerce.service.TbUsuarioService;
import com.pokeshop.ecommerce.util.EnumIdentidadError;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class TbUsuarioServiceImpl implements TbUsuarioService {

    @Autowired
    private TbUsuarioDao usuarioDao;

    @Override
    public TbUsuarioDto insert(TbUsuarioDto dto) {
        validate(dto, "I");
        TbUsuario e = usuarioDao.save(dto.toEntity());
        return dto.fromEntity(dto, e);
    }

    @Override
    public TbUsuarioDto update(TbUsuarioDto dto) {
        validate(dto, "U");
        TbUsuario e = usuarioDao.save(dto.toEntity());
        return dto.fromEntity(dto, e);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void delete(TbUsuarioDto dto) {
        if (usuarioDao.existsById(dto.getIdUsuario())) {
            try {
                usuarioDao.delete(dto.toEntity());
            } catch (Exception e) {
                if (e.getCause() instanceof ConstraintViolationException) {
                    ValidateUtil.evaluar(false, EnumIdentidadError.ER00006,
                            "No se puede eliminar el usuario: Se encontraron registros asociados al usuario.");
                }
            }
        } else {
            throw new GenericException(EnumGeneralError.AD000001);
        }
    }

    @Override
    public TbUsuarioDto findById(Integer id, TbUsuarioDto dto) {
        Optional<TbUsuario> optional = usuarioDao.findById(id);
        return optional.isPresent() ? dto.fromEntity(dto, optional.get()) : dto;
    }

    private void validate(TbUsuarioDto dto, String type) {
        ValidateUtil.requerido(dto.getEmail(), EnumIdentidadError.AD100001);
        ValidateUtil.requerido(dto.getClave(), EnumIdentidadError.AD100002);
        ValidateUtil.requerido(dto.getEstado(), EnumIdentidadError.AD100003);
        Optional<TbUsuario> optional = usuarioDao.findByEmail(dto.getEmail());
        if (type.equals("R")) {
            optional.ifPresent(e -> ValidateUtil.evaluar(false, EnumIdentidadError.ER00005,
                    "El distrito ya se encuentra registrado con email : " + e.getEmail()));
        } else if (type.equals("E")) {
            ValidateUtil.evaluar(optional.isPresent(), EnumIdentidadError.ER00011);
            ValidateUtil.evaluar(optional.get().getIdUsuario().equals(dto.getIdUsuario()), EnumIdentidadError.ER00011);
        }
    }

}