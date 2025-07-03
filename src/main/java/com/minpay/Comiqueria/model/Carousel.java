package com.minpay.Comiqueria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Carousel {
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
    @Size(max = 50)
    @Column(name = "car_imagen", length = 50)
    private String imagen;
}