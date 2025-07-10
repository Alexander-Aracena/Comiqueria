package com.minpay.Comiqueria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@NoArgsConstructor
@Table(name = "carruseles")
public class Carrusel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;
    
    @NonNull
    @Size(max = 50)
    @Column(name = "car_subtitulo", length = 50)
    private String subtitulo;
    
    @NonNull
    @Size(max = 100)
    @Column(name = "car_texto", length = 100)
    private String texto;
    
    @NonNull
    @Column(name = "car_imagen", columnDefinition = "TEXT")
    private String imagen;
    
    @NonNull
    @Column(name = "car_destino", columnDefinition = "TEXT")
    private String urlDestino;
    
    @Column(name = "car_orden")
    private Integer orden;
    
    @Column(name = "car_esta_activo")
    private Boolean estaActivo = true;
}