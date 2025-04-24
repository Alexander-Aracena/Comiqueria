package com.minpay.Comiqueria.dto;

import com.minpay.Comiqueria.model.Sexo;
import com.minpay.Comiqueria.model.TipoDoc;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private Sexo sexo;
    private TipoDoc tipoDoc;
    private String nroDoc;
    private Set<ProductoDTO> favoritos = new LinkedHashSet<>();
    private Set<DomicilioDTO> domicilios = new LinkedHashSet<>();
    private String telefono;

    public ClienteDTO(Long id, String nombre, String apellido, LocalDate fechaNac, Sexo sexo, TipoDoc tipoDoc, String nroDoc, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.tipoDoc = tipoDoc;
        this.nroDoc = nroDoc;
        this.telefono = telefono;
    }

    public ClienteDTO(String nombre, String apellido, LocalDate fechaNac, Sexo sexo, TipoDoc tipoDoc, String nroDoc, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.tipoDoc = tipoDoc;
        this.nroDoc = nroDoc;
        this.telefono = telefono;
    }
}
