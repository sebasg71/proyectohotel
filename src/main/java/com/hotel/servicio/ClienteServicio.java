package com.hotel.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.modelo.Cliente;
import com.hotel.repositorio.ClienteRepositorio;

@Service
public class ClienteServicio implements ClienteServicioImpl {

    @Autowired
    private ClienteRepositorio clienterepositorio;

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) clienterepositorio.findAll();
    }

    @Override
    public Cliente save(Cliente cliente) {

        return clienterepositorio.save(cliente);
    }

    @Override
    public Cliente buscarporId(Long id) {
        return clienterepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        clienterepositorio.deleteById(id);
    }
}
