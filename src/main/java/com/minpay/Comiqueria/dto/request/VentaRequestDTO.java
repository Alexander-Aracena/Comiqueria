package com.minpay.Comiqueria.dto.request;

import com.minpay.Comiqueria.dto.request.LineaVentaRequestDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Set;

public record VentaRequestDTO(
    @NotNull(message = "El ID del cliente no puede ser nulo")
    Long idCliente,

    @NotEmpty(message = "La venta debe tener al menos una línea de venta")
    Set<LineaVentaRequestDTO> lineas
) {}