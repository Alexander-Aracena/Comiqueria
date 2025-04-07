package com.minpay.Comiqueria.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Set;
import lombok.Data;
import lombok.NonNull;

@Data
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vta_id")
    private Long id;
    
    @NonNull
    @Column(name = "vta_fecha_vta", nullable = false)
    private LocalDate fecha_venta;
    
    @NonNull
    @Column(name = "vta_total", nullable = false)
    private Double total;
    
    @NonNull
    @Column(name = "vta_linea_id", nullable = false)
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private Set<LineaVenta> lineas;
    
    @NonNull
    @ManyToOne
    @JoinColumn(name = "vta_cte_id", nullable = false)
    private Cliente cliente;
}
