package com.hotel.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.hotel.modelo.Empleado;

public interface EmpleadoRepositorio extends CrudRepository<Empleado, Long> {
}
