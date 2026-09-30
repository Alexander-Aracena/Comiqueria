package com.minpay.Comiqueria.dto.response;

import java.math.BigDecimal;

public record LineaVentaResponseDTO(
    Long id,
    int cantidad,
    BigDecimal precioUnitario,
    BigDecimal subtotal,
    ProductoBasicoDTO producto
) {
    public static record ProductoBasicoDTO(
        Long id,
        String titulo
    ) {}
}