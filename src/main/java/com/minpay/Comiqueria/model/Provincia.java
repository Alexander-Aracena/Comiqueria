package com.minpay.Comiqueria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prov_id")
    private Long id;
    
    @NonNull
    @Size(max = 30)
    @Column(name = "prov_nombre", length = 30)
    private String nombre;
    
    @OneToMany(mappedBy = "provincia", cascade = CascadeType.ALL)
    private Set<Localidad> localidades;
    
    @ManyToOne
    @JoinColumn(name = "prov_pais_id")
    private Pais pais;

    public Provincia(String nombre, Pais pais) {
        this.nombre = nombre;
        this.pais = pais;
    }
}