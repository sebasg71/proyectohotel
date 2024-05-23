package com.hotel.servicio;

import java.util.List;

import com.hotel.modelo.Factura;

public interface FacturaServicioImpl {
    List<Factura> findAll();

    Factura save(Factura usuario);

    Factura buscarporId(Long id);

    void eliminar(Long id);

}
