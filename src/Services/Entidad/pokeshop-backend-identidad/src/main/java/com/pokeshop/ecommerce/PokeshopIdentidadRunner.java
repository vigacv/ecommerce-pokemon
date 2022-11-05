package com.pokeshop.ecommerce;

import com.pokeshop.ecommerce.dto.TbDistritoDto;
import com.pokeshop.ecommerce.dto.TbTipoDocumentoDto;
import com.pokeshop.ecommerce.service.TbDistritoService;
import com.pokeshop.ecommerce.service.TbTipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PokeshopIdentidadRunner implements CommandLineRunner {

    @Autowired
    private TbTipoDocumentoService tipoDocumentoService;

    @Autowired
    private TbDistritoService distritoService;

    @Override
    public void run(String... args) throws Exception {
/*
        // TbTipoDocumentos
        TbTipoDocumentoDto tipoDocumento1 = new TbTipoDocumentoDto(null, "1", "DNI", "DOC. NACIONAL DE IDENTIDAD", 8, 8, true);
        TbTipoDocumentoDto tipoDocumento2 = new TbTipoDocumentoDto(null, "4", "CEX", "CARNET DE EXTRANJERIA", 8, 12, false);
        TbTipoDocumentoDto tipoDocumento3 = new TbTipoDocumentoDto(null, "A", "CDI", "CED. DIPLOMATICA DE IDENTIDAD", 8, 10, false);
        TbTipoDocumentoDto tipoDocumento4 = new TbTipoDocumentoDto(null, "7", "PAS", "PASAPORTE", 8, 12, false);
        TbTipoDocumentoDto tipoDocumento5 = new TbTipoDocumentoDto(null, "6", "RUC", "REG. UNICO DE CONTRIBUYENTE", 11, 11, true);
        TbTipoDocumentoDto tipoDocumento6 = new TbTipoDocumentoDto(null, "0", "DTNDOR", "DOC. TRIB. NO DOM. SIN RUC", 8, 10, false);
        tipoDocumentoService.insert(tipoDocumento1);
        tipoDocumentoService.insert(tipoDocumento2);
        tipoDocumentoService.insert(tipoDocumento3);
        tipoDocumentoService.insert(tipoDocumento4);
        tipoDocumentoService.insert(tipoDocumento5);
        tipoDocumentoService.insert(tipoDocumento6);

        // TbDistrito
        TbDistritoDto distrito1 = new TbDistritoDto(null, "0001", "Lima", true);
        TbDistritoDto distrito2 = new TbDistritoDto(null, "0002", "Ancón", true);
        TbDistritoDto distrito3 = new TbDistritoDto(null, "0003", "Ate", true);
        TbDistritoDto distrito4 = new TbDistritoDto(null, "0004", "Breña", true);
        TbDistritoDto distrito5 = new TbDistritoDto(null, "0005", "Carabayllo", true);
        TbDistritoDto distrito6 = new TbDistritoDto(null, "0006", "Chaclacayo", true);
        TbDistritoDto distrito7 = new TbDistritoDto(null, "0007", "Chorrillos", true);
        TbDistritoDto distrito8 = new TbDistritoDto(null, "0008", "Cieneguilla", true);
        TbDistritoDto distrito9 = new TbDistritoDto(null, "0009", "Comas", true);
        TbDistritoDto distrito10 = new TbDistritoDto(null, "0010", "El Agustino", true);
        TbDistritoDto distrito11 = new TbDistritoDto(null, "0011", "Independencia", true);
        TbDistritoDto distrito12 = new TbDistritoDto(null, "0012", "Jesús María", true);
        TbDistritoDto distrito13 = new TbDistritoDto(null, "0013", "La Molina", true);
        TbDistritoDto distrito14 = new TbDistritoDto(null, "0014", "La Victoria", true);
        TbDistritoDto distrito15 = new TbDistritoDto(null, "0015", "Lince", true);
        TbDistritoDto distrito16 = new TbDistritoDto(null, "0016", "Los Olivos", true);
        TbDistritoDto distrito17 = new TbDistritoDto(null, "0017", "Lurigancho", true);
        TbDistritoDto distrito18 = new TbDistritoDto(null, "0018", "Lurín", true);
        TbDistritoDto distrito19 = new TbDistritoDto(null, "0019", "Magdalena del Mar", true);
        TbDistritoDto distrito20 = new TbDistritoDto(null, "0020", "Magdalena Vieja", true);
        TbDistritoDto distrito21 = new TbDistritoDto(null, "0021", "Miraflores", true);
        TbDistritoDto distrito22 = new TbDistritoDto(null, "0022", "Pachacámac", true);
        TbDistritoDto distrito23 = new TbDistritoDto(null, "0023", "Pucusana", true);
        TbDistritoDto distrito24 = new TbDistritoDto(null, "0024", "Puente Piedra", true);
        TbDistritoDto distrito25 = new TbDistritoDto(null, "0025", "Puente Hermosa", true);
        TbDistritoDto distrito26 = new TbDistritoDto(null, "0026", "Puente Negra", true);
        TbDistritoDto distrito27 = new TbDistritoDto(null, "0027", "Rimac", true);
        TbDistritoDto distrito28 = new TbDistritoDto(null, "0028", "San Bartolo", true);
        TbDistritoDto distrito29 = new TbDistritoDto(null, "0029", "San Borja", true);
        TbDistritoDto distrito30 = new TbDistritoDto(null, "0030", "San Isidro", true);
        TbDistritoDto distrito31 = new TbDistritoDto(null, "0031", "San Juan de Lurigancho", true);
        TbDistritoDto distrito32 = new TbDistritoDto(null, "0032", "San Juan de Miraflores", true);
        TbDistritoDto distrito33 = new TbDistritoDto(null, "0033", "San Luis", true);
        TbDistritoDto distrito34 = new TbDistritoDto(null, "0034", "San Martín de Porres", true);
        TbDistritoDto distrito35 = new TbDistritoDto(null, "0035", "San Miguel", true);
        TbDistritoDto distrito36 = new TbDistritoDto(null, "0036", "Santa Anita", true);
        TbDistritoDto distrito37 = new TbDistritoDto(null, "0037", "Santa María del Mar", true);
        TbDistritoDto distrito38 = new TbDistritoDto(null, "0038", "Santa Rosa", true);
        TbDistritoDto distrito39 = new TbDistritoDto(null, "0039", "Santiago de Surco", true);
        TbDistritoDto distrito40 = new TbDistritoDto(null, "0040", "Surquillo", true);
        TbDistritoDto distrito41 = new TbDistritoDto(null, "0041", "Villa El Salvador", true);
        TbDistritoDto distrito42 = new TbDistritoDto(null, "0042", "Villa María del Triunfo", true);

        TbDistritoDto distrito43 = new TbDistritoDto(null, "0043", "Callao", true);
        TbDistritoDto distrito44 = new TbDistritoDto(null, "0044", "Bellavista", true);
        TbDistritoDto distrito45 = new TbDistritoDto(null, "0045", "Carmen de la Legua Reynoso", true);
        TbDistritoDto distrito46 = new TbDistritoDto(null, "0046", "La Perla", true);
        TbDistritoDto distrito47 = new TbDistritoDto(null, "0047", "La Punta", true);
        TbDistritoDto distrito48 = new TbDistritoDto(null, "0048", "Ventanilla", true);

        distritoService.insert(distrito1);
        distritoService.insert(distrito2);
        distritoService.insert(distrito3);
        distritoService.insert(distrito4);
        distritoService.insert(distrito5);
        distritoService.insert(distrito6);
        distritoService.insert(distrito7);
        distritoService.insert(distrito8);
        distritoService.insert(distrito9);
        distritoService.insert(distrito10);
        distritoService.insert(distrito11);
        distritoService.insert(distrito12);
        distritoService.insert(distrito13);
        distritoService.insert(distrito14);
        distritoService.insert(distrito15);
        distritoService.insert(distrito16);
        distritoService.insert(distrito17);
        distritoService.insert(distrito18);
        distritoService.insert(distrito19);
        distritoService.insert(distrito20);
        distritoService.insert(distrito21);
        distritoService.insert(distrito22);
        distritoService.insert(distrito23);
        distritoService.insert(distrito24);
        distritoService.insert(distrito25);
        distritoService.insert(distrito26);
        distritoService.insert(distrito27);
        distritoService.insert(distrito28);
        distritoService.insert(distrito29);
        distritoService.insert(distrito30);
        distritoService.insert(distrito31);
        distritoService.insert(distrito32);
        distritoService.insert(distrito33);
        distritoService.insert(distrito34);
        distritoService.insert(distrito35);
        distritoService.insert(distrito36);
        distritoService.insert(distrito37);
        distritoService.insert(distrito38);
        distritoService.insert(distrito39);
        distritoService.insert(distrito40);
        distritoService.insert(distrito41);
        distritoService.insert(distrito42);
        distritoService.insert(distrito43);
        distritoService.insert(distrito44);
        distritoService.insert(distrito45);
        distritoService.insert(distrito46);
        distritoService.insert(distrito47);
        distritoService.insert(distrito48);
 */

    }

}