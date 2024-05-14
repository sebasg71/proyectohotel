package com.hotel.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_servicio;

    @Column(name="nombre_servicio")
	private String nombreServicio;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name="detalle")
	private String detalle;

    @ManyToOne
	@JoinColumn(name="id_hospedaje")
    private Hospedaje hospedaje;

}
