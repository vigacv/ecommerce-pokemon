package com.pokeshop.ecommerce.service.impl;

import com.nyobyte.exception.GenericException;
import com.nyobyte.util.ValidateUtil;
import com.nyobyte.util.enumerado.EnumGeneralError;
import com.pokeshop.ecommerce.dao.TbUsuarioDao;
import com.pokeshop.ecommerce.dto.TbPersonaDto;
import com.pokeshop.ecommerce.dto.TbProveedorDto;
import com.pokeshop.ecommerce.dto.TbUsuarioDto;
import com.pokeshop.ecommerce.entity.entidad.TbUsuario;
import com.pokeshop.ecommerce.search.SearchLogin;
import com.pokeshop.ecommerce.service.TbUsuarioService;
import com.pokeshop.ecommerce.util.EnumIdentidadError;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class TbUsuarioServiceImpl implements TbUsuarioService {

    @Autowired
    private TbUsuarioDao usuarioDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public TbUsuarioDto insert(TbUsuarioDto dto) {
        validate(dto, "I");
        dto.setClave(passwordEncoder.encode(dto.getClave()));
        TbUsuario e = usuarioDao.save(dto.toEntity());
        return dto.fromEntity(dto, e);
    }

    @Override
    public TbUsuarioDto update(TbUsuarioDto dto) {
        validate(dto, "U");
        dto.setClave(passwordEncoder.encode(dto.getClave()));
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
                    ValidateUtil.evaluar(false, EnumIdentidadError.ER005,
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
        return optional.isPresent() ? dto.fromEntity(dto, optional.get()) : null;
    }

    @Override
    public TbUsuarioDto login(SearchLogin search) {
        Optional<TbUsuario> optional = usuarioDao.findByEmailAndEstado(search.getEmail(), true);
        boolean existe = false;
        if (optional.isPresent()) {
            existe = passwordEncoder.matches(search.getClave(), optional.get().getClave());
        }
        TbUsuarioDto dto = TbUsuarioDto.builder()
                .defTbPersonaForidPersona(new TbPersonaDto())
                .defTbProveedorForidProveedor(new TbProveedorDto())
                .build();
        return optional.isPresent() && existe ? dto.fromEntity(dto, optional.get()) : null;
    }

    private void validate(TbUsuarioDto dto, String type) {
        ValidateUtil.requerido(dto.getEmail(), EnumIdentidadError.AD001);
        ValidateUtil.requerido(dto.getClave(), EnumIdentidadError.AD101);
        ValidateUtil.requerido(dto.getEstado(), EnumIdentidadError.AD005);
        Optional<TbUsuario> optional = usuarioDao.findByEmail(dto.getEmail());
        if (type.equals("I")) {
            optional.ifPresent(e -> ValidateUtil.evaluar(false, EnumIdentidadError.ER004,
                    "El usuario ya se encuentra registrado con email : " + e.getEmail()));
        } else if (type.equals("U")) {
            ValidateUtil.requerido(dto.getIdUsuario(), EnumIdentidadError.ER001);
            ValidateUtil.evaluar(optional.isPresent(), EnumIdentidadError.ER002);
            ValidateUtil.evaluar(optional.get().getIdUsuario().equals(dto.getIdUsuario()), EnumIdentidadError.ER003);
        }
    }

}