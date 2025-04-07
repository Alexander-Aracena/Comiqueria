package com.minpay.Comiqueria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class LineaVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "linea_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "linea_vta_id")
    private Venta venta;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "linea_prod_id")
    private Producto producto;

    @Column(name = "linea_cantidad")
    private int cantidad;
    
    @NonNull
    @Column(name = "linea_precio")
    private Double precio;

    public LineaVenta(Producto producto, int cantidad, Double precio) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }
}
