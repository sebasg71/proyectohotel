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
	private Reserva reserva;

	@ManyToOne
	@JoinColumn(name = "id_hospedaje")
	private Hospedaje idHospedaje;

	public long getId_habitacion() {
		return id_habitacion;
	}

	public void setId_habitacion(long id_habitacion) {
		this.id_habitacion = id_habitacion;
	}

	public String getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Hospedaje getIdHospedaje() {
		return idHospedaje;
	}

	public void setIdHospedaje(Hospedaje idHospedaje) {
		this.idHospedaje = idHospedaje;
	}

}
