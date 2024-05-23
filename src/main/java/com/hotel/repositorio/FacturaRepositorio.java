package com.hotel.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.hotel.modelo.Factura;

public interface FacturaRepositorio extends CrudRepository<Factura, Long> {

}
