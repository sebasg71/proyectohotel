package com.hotel.servicio;

import java.util.List;

import com.hotel.modelo.Hospedaje;

public interface HospedajeServicioImpl {
    List<Hospedaje> findAll();

    Hospedaje save(Hospedaje usuario);

    Hospedaje buscarporId(Long id);

    void eliminar(Long id);

}
