package com.hotel.servicio;

import java.util.List;
import java.util.concurrent.atomic.LongAccumulator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.modelo.Hospedaje;
import com.hotel.repositorio.HospedajeRepositorio;

@Service
public class HospedajeServicio implements HospedajeServicioImpl {

    @Autowired
    private HospedajeRepositorio hospedajerepositorio;

    @Override
    public List<Hospedaje> findAll() {
        return (List<Hospedaje>) hospedajerepositorio.findAll();
    }

    @Override
    public Hospedaje save(Hospedaje habitacion) {

        return hospedajerepositorio.save(habitacion);
    }

    @Override
    public Hospedaje buscarporId(Long id) {
        return hospedajerepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        hospedajerepositorio.deleteById(id);
    }
}
