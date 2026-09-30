package com.minpay.Comiqueria.dto.response;

import com.minpay.Comiqueria.model.Rol;
import java.time.LocalDateTime;

public record UsuarioResponseDTO(
    Long id,
    String email,
    Rol rol,
    LocalDateTime fechaAlta,
    LocalDateTime fechaBaja,
    Long idClienteAsociado
) {}