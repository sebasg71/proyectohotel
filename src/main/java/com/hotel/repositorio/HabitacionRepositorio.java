package com.hotel.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.hotel.modelo.Habitacion;

public interface HabitacionRepositorio extends CrudRepository<Habitacion, Long> {

}
