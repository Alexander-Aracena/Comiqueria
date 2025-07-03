package com.minpay.Comiqueria.dto;

import lombok.Data;

@Data
public class EditorialDTO {
    private Long id;
    private String nombre;

    public EditorialDTO(String nombre) {
        this.nombre = nombre;
    }

    public EditorialDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
