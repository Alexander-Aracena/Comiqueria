package com.minpay.Comiqueria.dto;

import com.minpay.Comiqueria.model.Domicilio;
import com.minpay.Comiqueria.model.Sexo;
import com.minpay.Comiqueria.model.TipoDoc;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;

@Data
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private Sexo sexo;
    private TipoDoc tipoDoc;
    private String nroDoc;
    private Set<DomicilioDTO> domicilios = new HashSet<>();
    private String telefono;
}
