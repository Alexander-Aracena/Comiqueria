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
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pais_id")
    private Long id;
    
    @NonNull
    @Size(max = 30)
    @Column(name = "pais_nombre", length = 30)
    private String nombre;
    
    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
    private Set<Provincia> provincias;
}