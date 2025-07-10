package com.minpay.Comiqueria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "autores", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"aut_nombre", "aut_apellido"})
})
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aut_id")
    @ToString.Include
    private Long id;
    
    @NonNull
    @Size(max = 30)
    @Column(name = "aut_nombre", length = 30)
    @ToString.Include
    private String nombre;
    
    @NonNull
    @Size(max = 30)
    @Column(name = "aut_apellido", length = 30)
    @ToString.Include
    private String apellido;
    
    @ManyToMany
    @JoinTable(
        name = "productos-autores",
        joinColumns = @JoinColumn(name = "aut_id"),
        inverseJoinColumns = @JoinColumn(name = "prod_id")
    )
    private Set<Producto> productos = new LinkedHashSet<>();
    
    @Column(name = "aut_fecha_alta")
    @ToString.Include
    private LocalDate fechaAlta = LocalDate.now();
    
    @Column(name = "aut_fecha_baja")
    @ToString.Include
    private LocalDate fechaBaja;
    
    @Column(name = "aut_esta_vigente")
    @ToString.Include
    private Boolean estaVigente = true;
}
