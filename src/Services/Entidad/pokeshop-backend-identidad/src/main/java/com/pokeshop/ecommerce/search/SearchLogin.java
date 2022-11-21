package com.pokeshop.ecommerce.search;

import lombok.Data;

import java.io.Serializable;

@Data
public class SearchLogin implements Serializable {

    private static final long serialVersionUID = 1L;
    private String email;
    private String clave;

}