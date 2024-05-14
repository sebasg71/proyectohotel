package com.hotel.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.hotel.modelo.Reserva;

public interface ReservaRepositorio extends CrudRepository<Reserva, Integer> {

}
