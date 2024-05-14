package com.hotel.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name = "habitacion")
public class Habitacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_habitacion;

	@Column(name = "tipo_habitacion")
	private String tipoHabitacion;

	@Column(name = "piso")
	private int piso;

	@ManyToOne
	@JoinColumn(name = "id_reserva")
	private String idReserva;

	@ManyToOne
	@JoinColumn(name = "id_hospedaje")
	private String idHospedaje;
	
	
	
}
