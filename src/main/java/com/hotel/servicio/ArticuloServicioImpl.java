package com.hotel.servicio;

import java.util.List;

import com.hotel.modelo.Articulo;

public interface ArticuloServicioImpl {
    List<Articulo> findAll();

    Articulo save(Articulo usuario);

    Articulo buscarporId(Integer id);

    void eliminar(Integer id);

}
