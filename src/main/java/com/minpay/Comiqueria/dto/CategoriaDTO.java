package com.minpay.Comiqueria.dto;

import java.util.LinkedHashSet;
import java.util.Set;
import lombok.Data;

@Data
public class CategoriaDTO {
    private Long idCategoria;
    private String nombreCategoria;
    private Set<SubcategoriaDTO> subcategorias = new LinkedHashSet();
}
