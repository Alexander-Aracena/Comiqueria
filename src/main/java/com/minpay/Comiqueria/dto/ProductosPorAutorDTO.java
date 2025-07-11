package com.minpay.Comiqueria.dto;

import java.util.LinkedHashSet;
import java.util.Set;
import lombok.Data;

@Data
public class ProductosPorAutorDTO {
    private Long idAutor;
    private AutorResponseDTO autor;
    private Set<ProductoRequestDTO> productos = new LinkedHashSet();

    public ProductosPorAutorDTO() {
    }

    public ProductosPorAutorDTO(Long idAutor, AutorResponseDTO autor, Set<ProductoRequestDTO> productos) {
        this.idAutor = idAutor;
        this.autor = autor;
        this.productos = productos;
    }
}
