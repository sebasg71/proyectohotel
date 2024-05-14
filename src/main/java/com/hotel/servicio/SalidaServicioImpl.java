package com.hotel.servicio;

import java.util.List;

import com.hotel.modelo.Salida;

public interface SalidaServicioImpl {
    List<Salida> findAll();

    Salida save(Salida usuario);

    Salida buscarporId(Integer id);

    void eliminar(Integer id);

}
