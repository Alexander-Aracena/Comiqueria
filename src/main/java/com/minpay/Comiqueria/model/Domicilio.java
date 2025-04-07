package com.minpay.Comiqueria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

@Data
@Entity
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dom_id")
    private Long id;
    
    @NonNull
    @Column(columnDefinition = "TEXT", name = "dom_calle")
    private String calle;
    
    @NonNull
    @Size(max = 10)
    @Column(name = "dom_altura", length = 10)
    private String altura;
    
    @Size(max = 10)
    @Column(name = "dom_depto", length = 10)
    private String departamento;
    
    @NonNull
    @Size(max = 8)
    @Column(name = "dom_cp", length = 8)
    private String cp;
    
    @ManyToOne
    @NonNull
    @JoinColumn(name = "dom_loc_id", nullable = false)
    private Localidad localidad;
    
    @ManyToOne
    @JoinColumn(name = "dom_cte_id")
    private Cliente cliente;
}