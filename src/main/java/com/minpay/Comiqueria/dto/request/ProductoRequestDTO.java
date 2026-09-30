package com.minpay.Comiqueria.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

public record ProductoRequestDTO(
    @NotBlank(message = "El título del producto no puede estar vacío")
    String titulo,

    @NotNull(message = "El precio del producto no puede ser nulo")
    @PositiveOrZero(message = "El precio debe ser un valor positivo o cero")
    BigDecimal precio,
    
    @PositiveOrZero(message = "El descuento debe ser un valor positivo o cero")
    Double descuento,

    @NotBlank(message = "La descripción del producto no puede estar vacía")
    String descripcion,

    @NotBlank(message = "La URL de la tapa del producto no puede estar vacía")
    String tapa,

    @NotBlank(message = "El ISBN no puede estar vacío")
    @Size(max = 30, message = "El ISBN no puede exceder los 30 caracteres")
    String isbn,

    @PositiveOrZero(message = "El peso debe ser un valor positivo o cero")
    int peso,

    @NotBlank(message = "Las dimensiones no pueden estar vacías")
    @Size(max = 30, message = "Las dimensiones no pueden exceder los 30 caracteres")
    String dimensiones,

    @PositiveOrZero(message = "Las páginas deben ser un valor positivo o cero")
    int paginas,

    Set<Long> idAutores,
    Long idSubcategoria,
    Long idEditorial,
    Boolean esNovedad,
    Boolean esVisibleEnHome
) {
    public ProductoRequestDTO {
        esNovedad = Objects.requireNonNullElse(esNovedad, false);
        esVisibleEnHome = Objects.requireNonNullElse(esVisibleEnHome, false);
    }
}