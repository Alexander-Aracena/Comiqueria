package com.minpay.Comiqueria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.util.HashSet;
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
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    @EqualsAndHashCode.Include
    @ToString.Include
    private Long id;
    
    @NonNull
    @Column(columnDefinition = "TEXT", name = "prod_titulo")
    @EqualsAndHashCode.Include
    @ToString.Include
    private String titulo;
    
    @NonNull
    @Column(name = "prod_precio")
    @EqualsAndHashCode.Include
    @ToString.Include
    private Double precio;
    
    @NonNull
    @Column(columnDefinition = "TEXT", name = "prod_descripcion")
    @EqualsAndHashCode.Include
    @ToString.Include
    private String descripcion;
    
    @NonNull
    @Column(columnDefinition = "TEXT", name = "prod_tapa")
    @EqualsAndHashCode.Include
    @ToString.Include
    private String tapa;
    
    @NonNull
    @Size(max = 30)
    @Column(name = "prod_isbn", length = 30)
    @EqualsAndHashCode.Include
    @ToString.Include
    private String isbn;
    
    @Column(name = "prod_peso")
    @EqualsAndHashCode.Include
    @ToString.Include
    private int peso;
    
    @NonNull
    @Size(max = 30)
    @Column(name = "prod_dimensiones", length = 30)
    @EqualsAndHashCode.Include
    @ToString.Include
    private String dimensiones;
    
    @Column(name = "prod_paginas")
    @EqualsAndHashCode.Include
    @ToString.Include
    private int paginas;
    
    @ManyToMany(mappedBy = "productos")
    private Set<Autor> autores = new HashSet<>();
    
    @ManyToOne
    @JoinColumn(name = "prod_subcat_id")
    private Subcategoria subcategoria;
    
    @ManyToOne
    @JoinColumn(name = "prod_edit_id")
    private Editorial editorial;
    
    @Column(name = "prod_esNovedad")
    @EqualsAndHashCode.Include
    @ToString.Include
    private Boolean esNovedad;
    
    @Column(name = "prod_esOferta")
    @EqualsAndHashCode.Include
    @ToString.Include
    private Boolean esOferta;
    
    @Column(name = "prod_esMasVendido")
    @EqualsAndHashCode.Include
    @ToString.Include
    private Boolean esMasVendido;
    
    @Column(name = "prod_index")
    @EqualsAndHashCode.Include
    @ToString.Include
    private Boolean index;
    
    @ManyToMany(mappedBy = "favoritos")
    private Set<Cliente> clientes;
    
    @Column(name = "prod_linea_id")
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private Set<LineaVenta> lineasVenta = new HashSet<>();

    public Producto(String titulo, Double precio, String descripcion, String tapa, String isbn, int peso, String dimensiones, int paginas, Subcategoria subcategoria, Editorial editorial, Boolean esNovedad, Boolean esOferta, Boolean esMasVendido, Boolean index) {
        this.titulo = titulo;
        this.precio = precio;
        this.descripcion = descripcion;
        this.tapa = tapa;
        this.isbn = isbn;
        this.peso = peso;
        this.dimensiones = dimensiones;
        this.paginas = paginas;
        this.autores = new LinkedHashSet<>();
        this.subcategoria = subcategoria;
        this.editorial = editorial;
        this.esNovedad = esNovedad;
        this.esOferta = esOferta;
        this.esMasVendido = esMasVendido;
        this.index = index;
    }
}