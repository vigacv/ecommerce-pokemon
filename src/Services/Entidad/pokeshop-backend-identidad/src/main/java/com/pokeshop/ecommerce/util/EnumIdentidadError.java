package com.pokeshop.ecommerce.util;

import com.nyobyte.util.GenericError;
import com.nyobyte.util.enumerado.EnumTypeException;

import static com.nyobyte.util.enumerado.EnumTypeException.A;
import static com.nyobyte.util.enumerado.EnumTypeException.E;

public enum EnumIdentidadError implements GenericError {

    /* ERRORES */
    // Generales
    ER000("PSI-ER-000", "", E),
    ER001("PSI-ER-001", "El id no debe ser null", E),
    ER002("PSI-ER-002", "El registro no existe", E),
    ER003("PSI-ER-003", "El registro no pertenece", E),
    ER004("PSI-ER-004", "Ya existe este registro", E),
    ER005("PSI-ER-005", "No se pueden eliminar los registros", E),
    ER006("PSI-ER-006", "No implementado", E),

    /* ADVERTENCIAS */
    // Generales
    AD000("PSI-AD-000", "", A),
    AD001("PSI-AD-001", "El número de documento es requerido", A),
    AD002("PSI-AD-002", "El código es requerido", A),
    AD003("PSI-AD-003", "El email es requerido", A),
    AD004("PSI-AD-004", "El nombre es requerido", A),
    AD005("PSI-AD-005", "El estado es requerido", A),

    // TbUsuario
    AD100("PSI-AD-100", "El usuario es requerido", A),
    AD101("PSI-AD-101", "La clave es requerida", A),

    // TbPersona
    AD201("PSI-AD-201", "El primer apellido es requerido", A),
    AD202("PSI-AD-202", "La dirección es requerida", A),
    AD203("PSI-AD-203", "El celular es requerido", A),
    AD204("PSI-AD-204", "El género es requerido", A),
    AD205("PSI-AD-205", "El estado civil es requerido", A),
    AD206("PSI-AD-206", "La fecha de nacimiento es requerida", A),

    // TbProveedor 3

    // TbTipoDocumento
    AD400("PSI-AD-400", "El tipo de documento es requerido", A),
    AD401("PSI-AD-401", "La descripción es requerida", A),
    AD402("PSI-AD-402", "La longitud mínima es requerida", A),
    AD403("PSI-AD-403", "La longitud máxima es requerida", A),

    // TbDistrito 5
    AD500("PSI-AD-500", "El distrito es requerido", A),
    ;

    EnumIdentidadError(String codigo, String mensaje, EnumTypeException type) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.type = type;
    }

    private final String codigo;
    private final String mensaje;
    private final EnumTypeException type;

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public EnumTypeException getType() {
        return type;
    }

}