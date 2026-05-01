package com.simonmov.MonitoreoFlotas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="vehiculo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {

    @Id
    @SequenceGenerator(
            name = "vehiculo_sequence",
            sequenceName = "vehiculo_sequence",
            initialValue = 100,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vehiculo_sequence"
    )
    private Integer id;

    private String placa;

    private float ubicacionX;

    private float ubicacionY;

    private float combustible;

    private float temperatura;

    @OneToOne
    private User user;

}
