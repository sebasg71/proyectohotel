package com.hotel.servicio;

import java.util.List;

import com.hotel.modelo.Servicio;

public interface ServicioServiceImpl {
    List<Servicio> findAll();

    Servicio save(Servicio usuario);

    Servicio buscarporId(Long id);

    void eliminar(Long id);

}
