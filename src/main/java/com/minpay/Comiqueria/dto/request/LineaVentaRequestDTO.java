package com.minpay.Comiqueria.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record LineaVentaRequestDTO(
    @NotNull(message = "El ID del producto no puede ser nulo")
    Long idProducto,

    @NotNull(message = "La cantidad no puede ser nula")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    int cantidad
) {}