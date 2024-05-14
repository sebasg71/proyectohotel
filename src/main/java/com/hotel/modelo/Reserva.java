package com.hotel.modelo;


import java.time.LocalDate;
import java.time.LocalTime;
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
@Table(name="reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_reserva;
	
	@Column(name="fecha_reserva")
	private LocalDate fechaReserva;
	
	@Column(name="hora_reserva")
	private LocalTime horaReserva;
	
	@ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente Cliente;
	
	@ManyToOne
	@JoinColumn(name="id_empleado")
    private Empleado empleado;
	
	@OneToMany(mappedBy="reserva", cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private List<Habitacion> habitacion;

	public Cliente getCliente() {
		return Cliente;
	}

	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}

	
}
