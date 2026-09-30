package com.minpay.Comiqueria.dto.response;

import com.minpay.Comiqueria.model.Sexo;
import com.minpay.Comiqueria.model.TipoDoc;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public record ClienteResponseDTO(
    Long id,
    String nombre,
    String apellido,
    LocalDate fechaNac,
    Sexo sexo,
    String nroDocumento,
    TipoDoc tipoDoc,
    String telefono,
    LocalDateTime fechaAlta,
    LocalDateTime fechaBaja,
    UsuarioBasicoDTO usuario,
    Set<ProductoBasicoDTO> favoritos,
    Set<VentaBasicoDTO> ventasRecientes
) {
    public static record UsuarioBasicoDTO(
        Long id,
        String email
    ) {}
    
    public static record ProductoBasicoDTO(
        Long id,
        String titulo
    ) {}
    
    public static record VentaBasicoDTO(
        Long id,
        LocalDateTime fechaVenta
    ) {}
}