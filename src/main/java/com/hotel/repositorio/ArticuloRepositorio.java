package com.hotel.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.hotel.modelo.Articulo;

public interface ArticuloRepositorio extends CrudRepository<Articulo, Integer> {

}
