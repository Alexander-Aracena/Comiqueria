package com.minpay.Comiqueria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
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
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cte_id")
    @EqualsAndHashCode.Include
    @ToString.Include
    private Long id;
    
    @NonNull
    @Size(max = 30)
    @Column(name = "cte_nombre", length = 30)
    @EqualsAndHashCode.Include
    @ToString.Include
    private String nombre;
    
    @NonNull
    @Size(max = 30)
    @Column(name = "cte_apellido", length = 30)
    @EqualsAndHashCode.Include
    @ToString.Include
    private String apellido;
    
    @NonNull
    @Column(name = "cte_fecha_nac")
    @EqualsAndHashCode.Include
    @ToString.Include
    private LocalDate fecha_nac;
    
    @Enumerated(EnumType.STRING)
    @NonNull
    @Column(name = "cte_sexo")
    @EqualsAndHashCode.Include
    @ToString.Include
    private Sexo sexo;
    
    @NonNull
    @Column(name = "cte_documento")
    @EqualsAndHashCode.Include
    @ToString.Include
    private String nroDocumento;
    
    @Enumerated(EnumType.STRING)
    @NonNull
    @Column(name = "cte_tipo_doc")
    @EqualsAndHashCode.Include
    @ToString.Include
    private TipoDoc tipoDoc;
    
    @NonNull
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Domicilio> domicilios = new HashSet<>();
    
    @NonNull
    @Column(name = "cte_telefono")
    @EqualsAndHashCode.Include
    @ToString.Include
    private String telefono;
    
    @ManyToMany
    @JoinTable(
        name = "cte_producto_favorito", 
        joinColumns = @JoinColumn(name = "cte_id"), 
        inverseJoinColumns = @JoinColumn(name = "prod_id")
    )
    private Set<Producto> favoritos = new HashSet<>();
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Venta> ventas = new HashSet<>();
}