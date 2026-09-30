package com.minpay.Comiqueria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Size;
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
import org.hibernate.annotations.SQLDelete;

@Getter
@Setter
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SQLDelete(sql = "UPDATE departamentos SET dep_fecha_baja = NOW() WHERE dep_id = ?")
@Table(name = "departamentos", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"dep_nombre", "prov_id"})
})
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dep_id")
    @EqualsAndHashCode.Include
    @ToString.Include
    private Long id;

    @NonNull
    @Size(max = 50)
    @Column(name = "dep_nombre", length = 50)
    @EqualsAndHashCode.Include
    @ToString.Include
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    @JoinColumn(name = "dep_prov_id", nullable = false)
    private Provincia provincia;

    @OneToMany(mappedBy = "departamento")
    private Set<Localidad> localidades = new LinkedHashSet<>();

    @Column(name = "dep_fecha_alta")
    private LocalDateTime fechaAlta = LocalDateTime.now();
    
    @Column(name = "dep_fecha_baja")
    private LocalDateTime fechaBaja;
}