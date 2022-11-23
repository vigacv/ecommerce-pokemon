package com.pokeshop.ecommerce.service.impl;

import com.pokeshop.ecommerce.dao.TbPersonaDao;
import com.pokeshop.ecommerce.dto.TbPersonaDto;
import com.pokeshop.ecommerce.dto.TbUsuarioDto;
import com.pokeshop.ecommerce.entity.entidad.TbPersona;
import com.pokeshop.ecommerce.exception.GenericException;
import com.pokeshop.ecommerce.service.TbPersonaService;
import com.pokeshop.ecommerce.service.TbUsuarioService;
import com.pokeshop.ecommerce.util.EnumIdentidadError;
import com.pokeshop.ecommerce.util.ValidateUtil;
import com.pokeshop.ecommerce.util.enumerado.EnumGeneralError;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class TbPersonaServiceImpl implements TbPersonaService {

    @Autowired
    private TbPersonaDao personaDao;

    @Autowired
    private TbUsuarioService usuarioService;

    @Override
    public TbPersonaDto insert(TbPersonaDto dto) {
        ValidateUtil.requerido(dto.getTbUsuario(), EnumIdentidadError.AD100);
        TbUsuarioDto usuario = usuarioService.insert(dto.getTbUsuario());
        validate(dto, "I");
        dto.setTbUsuario(usuario);
        dto.setEmail(usuario.getEmail());
        TbPersona e = personaDao.save(dto.toEntity());
        return dto.fromEntity(dto, e);
    }

    @Override
    public TbPersonaDto update(TbPersonaDto tbPersonaDto) {
        ValidateUtil.evaluar(false, EnumIdentidadError.ER006);
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void delete(TbPersonaDto dto) {
        if (personaDao.existsById(dto.getIdPersona())) {
            try {
                personaDao.delete(dto.toEntity());
            } catch (Exception e) {
                if (e.getCause() instanceof ConstraintViolationException) {
                    ValidateUtil.evaluar(false, EnumIdentidadError.ER005,
                            "No se puede eliminar la persona: Se encontraron registros asociados a la persona.");
                }
            }
        } else {
            throw new GenericException(EnumGeneralError.AD000001);
        }
    }

    @Override
    public TbPersonaDto findById(Integer id, TbPersonaDto dto) {
        Optional<TbPersona> optional = personaDao.findById(id);
        return optional.isPresent() ? dto.fromEntity(dto, optional.get()) : null;
    }

    private void validate(TbPersonaDto dto, String type) {
        ValidateUtil.requerido(dto.getNroDocumento(), EnumIdentidadError.AD001);
        ValidateUtil.requerido(dto.getNombre(), EnumIdentidadError.AD004);
        ValidateUtil.requerido(dto.getApellido1(), EnumIdentidadError.AD201);
        ValidateUtil.requerido(dto.getDireccion(), EnumIdentidadError.AD202);
        ValidateUtil.requerido(dto.getCelular(), EnumIdentidadError.AD203);
        ValidateUtil.requerido(dto.getGenero(), EnumIdentidadError.AD204);
        ValidateUtil.requerido(dto.getEstadoCivil(), EnumIdentidadError.AD205);
        ValidateUtil.requerido(dto.getFechaNacimiento(), EnumIdentidadError.AD206);
        ValidateUtil.requerido(dto.getTbTipoDocumento(), EnumIdentidadError.AD400);
        ValidateUtil.requerido(dto.getTbTipoDocumento().getIdTipoDocumento(), EnumIdentidadError.AD400);
        ValidateUtil.requerido(dto.getTbDistrito(), EnumIdentidadError.AD500);
        ValidateUtil.requerido(dto.getTbDistrito().getIdDistrito(), EnumIdentidadError.AD500);
        ValidateUtil.requerido(dto.getEstado(), EnumIdentidadError.AD005);
        Optional<TbPersona> optional = personaDao.findByNroDocumento(dto.getNroDocumento());
        if (type.equals("I")) {
            optional.ifPresent(e -> ValidateUtil.evaluar(false, EnumIdentidadError.ER004,
                    "La persona ya se encuentra registrado con número de documento : " + e.getNroDocumento()));
        } else if (type.equals("U")) {
            ValidateUtil.requerido(dto.getIdPersona(), EnumIdentidadError.ER001);
            ValidateUtil.evaluar(optional.isPresent(), EnumIdentidadError.ER002);
            ValidateUtil.evaluar(optional.get().getIdPersona().equals(dto.getIdPersona()), EnumIdentidadError.ER003);
        }
    }

}