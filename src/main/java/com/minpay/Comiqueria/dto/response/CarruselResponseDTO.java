package com.minpay.Comiqueria.dto.response;

public record CarruselResponseDTO(
    Long id,
    String subtitulo,
    String texto,
    String imagen,
    String urlDestino,
    Integer orden,
    Boolean estaActivo
) {}