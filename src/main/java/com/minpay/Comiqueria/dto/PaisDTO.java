package com.minpay.Comiqueria.dto;

import java.util.LinkedHashSet;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaisDTO {
    private Long id;
    private String nombre;
    private Set<ProvinciaDTO> provincias = new LinkedHashSet<>();

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
