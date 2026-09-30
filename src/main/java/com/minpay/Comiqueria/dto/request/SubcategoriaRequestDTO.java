package com.minpay.Comiqueria.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record SubcategoriaRequestDTO(
    @NotBlank(message = "El nombre de la subcategoría no puede estar vacío")
    @Size(max = 50, message = "El nombre de la subcategoría no puede exceder los 50 caracteres")
    String nombre,

    @NotNull(message = "El ID de la categoría padre no puede ser nulo")
    Long idCategoria
) {}