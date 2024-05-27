package com.hotel.servicio;

import java.util.List;

import com.hotel.modelo.Articulo;

public interface ArticuloServicioImpl {
    List<Articulo> findAll();

    Articulo save(Articulo usuario);

    Articulo buscarporId(Long id);

    void eliminar(Long id);

}
