package com.minpay.Comiqueria.dto;

import java.util.LinkedHashSet;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProvinciaDTO {
    private Long id;
    private String nombre;
    private Set<LocalidadDTO> localidades = new LinkedHashSet<>();

    public ProvinciaDTO(String nombre) {
        this.nombre = nombre;
    }

    public ProvinciaDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public ProvinciaDTO(Long id, String nombre, Set<LocalidadDTO> localidades) {
        this.id = id;
        this.nombre = nombre;
        this.localidades = localidades;
    }
}
