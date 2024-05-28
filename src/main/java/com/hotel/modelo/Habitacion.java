package com.hotel.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitacion")
public class Habitacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_habitacion;
	@Column(name = "tipo_habitacion")
	private String tipoHabitacion;
	@Column(name = "piso")
	private int piso;
	@Column(name = "numero_habitacion")
	private int numeroHabitacion;
	@OneToMany(mappedBy = "habitacion", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH })
	private List<Articulo> listaArticulo;
	@OneToMany(mappedBy = "habitacion", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH })
	private List<Reserva> listaReserva;

	public Long getId_habitacion() {
		return id_habitacion;
	}

	public void setId_habitacion(Long id_habitacion) {
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

	public List<Articulo> getListaArticulo() {
		return listaArticulo;
	}

	public void setListaArticulo(List<Articulo> listaArticulo) {
		this.listaArticulo = listaArticulo;
	}

	public List<Reserva> getListaReserva() {
		return listaReserva;
	}

	public void setListaReserva(List<Reserva> listaReserva) {
		this.listaReserva = listaReserva;
	}

	public int getNumeroHabitacion() {
		return numeroHabitacion;
	}

	public void setNumeroHabitacion(int numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}

}
