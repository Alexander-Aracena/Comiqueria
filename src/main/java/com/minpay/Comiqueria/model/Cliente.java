package com.minpay.Comiqueria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;
import lombok.Data;
import lombok.NonNull;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cte_id")
    private Long id;
    
    @NonNull
    @Size(max = 30)
    @Column(name = "cte_nombre", length = 30)
    private String nombre;
    
    @NonNull
    @Size(max = 30)
    @Column(name = "cte_apellido", length = 30)
    private String apellido;
    
    @NonNull
    @Column(name = "cte_fecha_nac")
    private LocalDate fecha_nac;
    
    @Enumerated(EnumType.STRING)
    @NonNull
    @Column(name = "cte_sexo")
    private Sexo sexo;
    
    @NonNull
    @Column(name = "cte_documento")
    private String nroDocumento;
    
    @Enumerated(EnumType.STRING)
    @NonNull
    @Column(name = "cte_tipo_doc")
    private TipoDoc tipoDoc;
    
    @NonNull
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Domicilio> domicilios;
    
    @NonNull
    @Column(name = "cte_telefono")
    private String telefono;
    
    @ManyToMany
    @JoinTable(
        name = "cte_producto_favorito", 
        joinColumns = @JoinColumn(name = "cte_id"), 
        inverseJoinColumns = @JoinColumn(name = "prod_id")
    )
    private Set<Producto> favoritos;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Venta> ventas;
}