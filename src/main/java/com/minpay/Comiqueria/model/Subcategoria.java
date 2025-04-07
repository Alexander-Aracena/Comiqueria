package com.minpay.Comiqueria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Subcategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subcat_id")
    private Long id;
    
    @NonNull
    @Size(max = 30)
    @Column(name = "subcat_nombre", length = 30)
    private String nombre;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "subcat_cat_id")
    private Categoria categoria;
    
    @OneToMany(mappedBy = "subcategoria", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Producto> productos;

    public Subcategoria(String nombre, Categoria categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
    }
}