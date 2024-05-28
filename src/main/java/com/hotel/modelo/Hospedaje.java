package com.hotel.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "hospedaje")
public class Hospedaje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_hospedaje;

	@Column(name = "ciudad_domicilio")
	private String ciudadDomicilio;

	@Column(name = "motivo_hospedaje")
	private String motivoHospedaje;

	@OneToMany(mappedBy = "hospedaje", cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE,
			CascadeType.DETACH,
			CascadeType.REFRESH
	})
	private List<Salida> salidas;

	@OneToMany(mappedBy = "hospedaje", cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE,
			CascadeType.DETACH,
			CascadeType.REFRESH
	})
	private List<Servicio> servicios;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "idReserva")
	private Reserva reserva;

	public Long getId_hospedaje() {
		return id_hospedaje;
	}

	public void setId_hospedaje(Long id_hospedaje) {
		this.id_hospedaje = id_hospedaje;
	}

	public String getCiudadDomicilio() {
		return ciudadDomicilio;
	}

	public void setCiudadDomicilio(String ciudadDomicilio) {
		this.ciudadDomicilio = ciudadDomicilio;
	}

	public String getMotivoHospedaje() {
		return motivoHospedaje;
	}

	public void setMotivoHospedaje(String motivoHospedaje) {
		this.motivoHospedaje = motivoHospedaje;
	}

	public List<Salida> getSalidas() {
		return salidas;
	}

	public void setSalidas(List<Salida> salidas) {
		this.salidas = salidas;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

}
