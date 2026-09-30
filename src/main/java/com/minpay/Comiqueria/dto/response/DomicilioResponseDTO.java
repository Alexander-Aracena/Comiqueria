package com.minpay.Comiqueria.dto.response;

import com.minpay.Comiqueria.model.TipoDoc;
import java.time.LocalDate;

public record DomicilioResponseDTO(
    Long id,
    String calle,
    String altura,
    String departamento,
    String cp,
    LocalDate fechaAlta,
    LocalDate fechaBaja,
    LocalidadBasicoDTO localidad,
    ClienteBasicoDTO cliente
) {
    public static record LocalidadBasicoDTO(
        Long id,
        String nombre,
        DepartamentoBasicoDTO departamento
    ) {}
    
    public static record ClienteBasicoDTO(
        Long id,
        String nombre,
        String apellido,
        TipoDoc tipoDoc,
        String nroDocumento
    ) {}
    
    public static record DepartamentoBasicoDTO(
        Long id,
        String nombre,
        ProvinciaBasicoDTO provincia
    ) {}
    
    public static record ProvinciaBasicoDTO(
        Long id,
        String nombre,
        PaisBasicoDTO pais
    ) {}
    
    public static record PaisBasicoDTO(
        Long id,
        String nombre
    ) {}
}