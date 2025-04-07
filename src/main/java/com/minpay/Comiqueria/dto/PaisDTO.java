package com.minpay.Comiqueria.dto;

import java.util.Set;
import lombok.Data;

@Data
public class PaisDTO {
    private Long id;
    private String nombre;
    private Set<ProvinciaDTO> provincias;

    public PaisDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public PaisDTO(String nombre) {
        this.nombre = nombre;
    }
    
    public PaisDTO(Long id, String nombre, Set<ProvinciaDTO> provincias) {
        this.id = id;
        this.nombre = nombre;
        this.provincias = provincias;
    }
}
