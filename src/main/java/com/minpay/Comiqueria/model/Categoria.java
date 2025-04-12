package com.minpay.Comiqueria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.util.HashSet;
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
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private Long id;
    
    @NonNull
    @Size(max = 30)
    @Column(name = "cat_nombre", length = 30)
    private String nombre;
    
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Subcategoria> subcategorias = new HashSet<>();
}
