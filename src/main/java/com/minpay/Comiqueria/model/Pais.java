package com.minpay.Comiqueria.model;

import jakarta.persistence.*;
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
@SQLDelete(sql = "UPDATE paises SET pais_fecha_baja = NOW() WHERE pais_id = ?")
@Table(name = "paises")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pais_id")
    @EqualsAndHashCode.Include
    @ToString.Include
    private Long id;
    
    @NonNull
    @Size(max = 30)
    @Column(name = "pais_nombre", length = 30, unique = true)
    @EqualsAndHashCode.Include
    @ToString.Include
    private String nombre;
    
    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
    private Set<Provincia> provincias = new LinkedHashSet<>();
    
    @Column(name = "pais_fecha_alta")
    @ToString.Include
    private LocalDateTime fechaAlta = LocalDateTime.now();
    
    @Column(name = "pais_fecha_baja")
    @ToString.Include
    private LocalDateTime fechaBaja;
}