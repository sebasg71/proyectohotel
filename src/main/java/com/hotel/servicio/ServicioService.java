package com.hotel.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.modelo.Servicio;
import com.hotel.repositorio.ServicioRepositorio;

@Service
public class ServicioService implements ServicioServiceImpl {

    @Autowired
    private ServicioRepositorio serviciorepositorio;

    @Override
    public List<Servicio> findAll() {
        return (List<Servicio>) serviciorepositorio.findAll();
    }

    @Override
    public Servicio save(Servicio servicio) {

        return serviciorepositorio.save(servicio);
    }

    @Override
    public Servicio buscarporId(Integer id) {
        return serviciorepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        serviciorepositorio.deleteById(id);
    }
}
