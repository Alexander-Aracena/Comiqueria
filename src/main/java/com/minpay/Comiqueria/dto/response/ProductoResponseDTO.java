package com.minpay.Comiqueria.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public record ProductoResponseDTO(
    Long id,
    String titulo,
    BigDecimal precio,
    BigDecimal descuento,
    String descripcion,
    String tapa,
    String isbn,
    int peso,
    String dimensiones,
    int paginas,
    Set<AutorBasicoDTO> autores,
    SubcategoriaBasicoDTO subcategoria,
    EditorialBasicoDTO editorial,
    Boolean esNovedad,
    Boolean esVisibleEnHome,
    Integer ranking,
    LocalDateTime fechaAlta,
    LocalDateTime fechaBaja
) {
    public static record AutorBasicoDTO(
        Long id,
        String nombre,
        String apellido
    ) {}
    
    public static record SubcategoriaBasicoDTO(
        Long id,
        String nombre,
        CategoriaBasicoDTO categoria
    ) {}
    
    public static record CategoriaBasicoDTO(
        Long id,
        String nombre
    ) {}
    
    public static record EditorialBasicoDTO(
        Long id,
        String nombre
    ) {}
}