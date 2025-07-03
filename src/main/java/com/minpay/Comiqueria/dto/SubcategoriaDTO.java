package com.minpay.Comiqueria.dto;

import lombok.Data;

@Data
public class SubcategoriaDTO {
    private Long idSubcategoria;
    private String nombreSubcategoria;

    public SubcategoriaDTO() {
    }

    public SubcategoriaDTO(String nombreSubcategoria) {
        this.nombreSubcategoria = nombreSubcategoria;
    }

    public SubcategoriaDTO(Long idSubcategoria, String nombreSubcategoria) {
        this.idSubcategoria = idSubcategoria;
        this.nombreSubcategoria = nombreSubcategoria;
    }
}
