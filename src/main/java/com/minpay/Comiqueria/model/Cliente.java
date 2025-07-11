package com.minpay.Comiqueria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
@Table(name = "clientes")
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
    private LocalDate fechaNac;

    @Enumerated(EnumType.STRING)
    @NonNull
    @Column(name = "cte_sexo")
    @EqualsAndHashCode.Include
    @ToString.Include
    private Sexo sexo;

    @NonNull
    @Column(name = "cte_documento", unique = true)
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
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST)
    private Set<Domicilio> domicilios = new LinkedHashSet<>();

    @NonNull
    @Size(max = 20)
    @Column(name = "cte_telefono", length = 20)
    @EqualsAndHashCode.Include
    @ToString.Include
    private String telefono;
    
    @NonNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usr_id", unique = true, nullable = false)
    private Usuario usuario;

    @Column(name = "cte_fecha_alta")
    private LocalDateTime fechaAlta = LocalDateTime.now();

    @Column(name = "cte_fecha_baja")
    private LocalDateTime fechaBaja;

    @Column(name = "cte_esta_vigente")
    private Boolean estaVigente = true;

    @ManyToMany
    @JoinTable(
            name = "cte_producto_favorito",
            joinColumns = @JoinColumn(name = "cte_id"),
            inverseJoinColumns = @JoinColumn(name = "prod_id")
    )
    private Set<Producto> favoritos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "cliente")
    private Set<Venta> ventas = new LinkedHashSet<>();
}
