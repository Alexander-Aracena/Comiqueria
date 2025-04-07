package com.minpay.Comiqueria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@NoArgsConstructor
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aut_id")
    private Long id;
    
    @NonNull
    @Size(max = 30)
    @Column(name = "aut_nombre", length = 30)
    private String nombre;
    
    @NonNull
    @Size(max = 30)
    @Column(name = "aut_apellido", length = 30)
    private String apellido;
    
    @ManyToMany
    @JoinTable(
        name = "productos-autores",
        joinColumns = @JoinColumn(name = "aut_id"),
        inverseJoinColumns = @JoinColumn(name = "prod_id")
    )
    @EqualsAndHashCode.Exclude
    private Set<Producto> productos = new LinkedHashSet<>();
    
    @Column(name = "aut_fecha_alta")
    private LocalDate fechaAlta;
    
    @Column(name = "aut_fecha_baja")
    private LocalDate fechaBaja;

    public Autor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaAlta = LocalDate.now();
    }
}
