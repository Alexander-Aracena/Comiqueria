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
public class Venta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vta_id")
    @EqualsAndHashCode.Include
    @ToString.Include
    private Long id;
    
    @NonNull
    @Column(name = "vta_fecha_vta", nullable = false)
    @EqualsAndHashCode.Include
    @ToString.Include
    private LocalDate fecha_venta;
    
    @NonNull
    @Column(name = "vta_total", nullable = false)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Double total;
    
    @NonNull
    @Column(name = "vta_linea_id", nullable = false)
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private Set<LineaVenta> lineas = new LinkedHashSet<>();
    
    @NonNull
    @ManyToOne
    @JoinColumn(name = "vta_cte_id", nullable = false)
    private Cliente cliente;
}
