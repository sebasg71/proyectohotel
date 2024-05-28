package com.hotel.servicio;

import java.util.List;

import com.hotel.modelo.Habitacion;

public interface HabitacionServicioImpl {
    List<Habitacion> findAll();

    Habitacion save(Habitacion habitacion);

    Habitacion buscarporId(Long id);

    void eliminar(Long id);

}
