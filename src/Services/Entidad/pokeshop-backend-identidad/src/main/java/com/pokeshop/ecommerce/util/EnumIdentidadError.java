package com.pokeshop.ecommerce.util;

import com.nyobyte.util.GenericError;
import com.nyobyte.util.enumerado.EnumTypeException;

import static com.nyobyte.util.enumerado.EnumTypeException.A;
import static com.nyobyte.util.enumerado.EnumTypeException.E;

public enum EnumIdentidadError implements GenericError {

    /// Errores
    /// Generales
    ER00000("PSI00000", "", E),
    ER00001("PSI00001", "El código ya existe", E),
    ER00002("PSI00002", "Se ha alcanzado el límite de correlativos", E),
    ER00003("PSI00003", "El id no debe ser null", E),
    ER00004("PSI00004", "La entidad no existe", E),
    ER00005("PSI00005", "El codigo ya se encuentra registrado", E),
    ER00006("PSI00006", "No se pueden eliminar los registros", E),
    ER00007("PSI00007", "El rango de fechas ya se encuentra registrado en otro rango", E),
    ER00008("PSI00008", "Ya existe un registro con control predeterminado", E),
    ER00009("PSI00009", "Ya existe un registro con este id", E),
    ER00010("PSI00010", "El id debe ser null", E),
    ER00011("PSI00011", "El codigo no pertenece a este registro", E),
    ER00012("PSI00012", "El formato de fecha ingresado es incorrecto", E),
    ER00013("PSI00013", "Los formatos de la imagen deben de ser image/png, image/jpeg, image/jpg o image/svg", E),
    ER00014("PSI00014", "No se pueden eliminar los registros", E),
    ER00015("PSI00015", "La imagen es muy pesada, debe ser menor a 10MB", E),

    /// Advertencias
    /// Generales
    AD100000("GEN10000", "", A),
    AD100001("GEN10001", "El código es requerido", A),
    AD100002("GEN10002", "El nombre es requerido", A),
    AD100003("GEN10003", "El estado es requerido", A),
    AD100004("GEN10004", "La fecha es requerida ", A),

    // TbUsuario
    AD100100("MSI100000", "", A),

    // TbPersona
    AD100400("RC100400", "El primer apellido es requerido", A),
    AD100401("RC100401", "La dirección es requerida", A),
    AD100402("RC100402", "El celular es requerido", A),
    AD100403("RC100403", "El género es requerido", A),
    AD100404("RC100404", "El número de documento es requerido", A),
    AD100405("RC100405", "El tipo de documento es requerido", A),
    AD100406("RC100406", "El estado civil es requerido", A),
    AD100407("RC100407", "El distrito es requerido", A),

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