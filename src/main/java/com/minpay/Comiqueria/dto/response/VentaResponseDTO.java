package com.minpay.Comiqueria.dto.response;

import com.minpay.Comiqueria.model.EstadoVenta;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public record VentaResponseDTO(
    Long id,
    LocalDateTime fechaVenta,
    BigDecimal total,
    EstadoVenta estado,
    ClienteBasicoDTO cliente,
    Set<LineaVentaResponseDTO> lineas
) {
    public static record ClienteBasicoDTO(
        Long id,
        String nombre,
        String apellido,
        String tipoDoc,
        String nroDocumento
    ) {}
}