package com.hotel.servicio;

import java.util.List;

import com.hotel.modelo.Reserva;

public interface ReservaServicioImpl {
    List<Reserva> findAll();

    Reserva save(Reserva usuario);

    Reserva buscarporId(Long id);

    void eliminar(Long id);

}
