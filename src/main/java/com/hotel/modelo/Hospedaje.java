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
@Table(name = "hospedaje")
public class Hospedaje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_hospedaje;

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

}
