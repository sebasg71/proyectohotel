package com.hotel.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.hotel.modelo.Cliente;

public interface ClienteRepositorio extends CrudRepository<Cliente, Long> {

}
