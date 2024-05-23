package com.hotel.servicio;

import java.util.List;

import com.hotel.modelo.Cliente;

public interface ClienteServicioImpl {
    List<Cliente> findAll();

    Cliente save(Cliente usuario);

    Cliente buscarporId(Long id);

    void eliminar(Long id);

}
