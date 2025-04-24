package com.minpay.Comiqueria.dto;

import java.util.LinkedHashSet;
import java.util.Set;
import lombok.Data;

@Data
public class ProductosPorAutorDTO {
    private Long idAutor;
    private AutorDTO autor;
    private Set<ProductoDTO> productos = new LinkedHashSet();

    public ProductosPorAutorDTO() {
    }

    public ProductosPorAutorDTO(Long idAutor, AutorDTO autor, Set<ProductoDTO> productos) {
        this.idAutor = idAutor;
        this.autor = autor;
        this.productos = productos;
    }
}
