package com.minpay.Comiqueria.dto.response;

public record LoginResponseDTO(
    Long id,
    String token,
    String email,
    String rol
) {}