package com.hotel.repositorio;

import org.springframework.data.repository.CrudRepository;

import modelo.entidad.Cliente;

public interface ClienteRepositorio extends CrudRepository<Cliente, Long>{

}
