package com.hotel.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.modelo.Habitacion;
import com.hotel.repositorio.HabitacionRepositorio;

@Service
public class HabitacionServicio implements HabitacionServicioImpl {

    @Autowired
    private HabitacionRepositorio habitacionrepositorio;

    @Override
    public List<Habitacion> findAll() {
        return (List<Habitacion>) habitacionrepositorio.findAll();
    }

    @Override
    public Habitacion save(Habitacion habitacion) {

        return habitacionrepositorio.save(habitacion);
    }

    @Override
    public Habitacion buscarporId(Long id) {
        return habitacionrepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        habitacionrepositorio.deleteById(id);
    }
}
