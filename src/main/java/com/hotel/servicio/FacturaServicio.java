package com.hotel.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.modelo.Factura;
import com.hotel.repositorio.FacturaRepositorio;

@Service
public class FacturaServicio implements FacturaServicioImpl {

    @Autowired
    private FacturaRepositorio facturarepositorio;

    @Override
    public List<Factura> findAll() {
        return (List<Factura>) facturarepositorio.findAll();
    }

    @Override
    public Factura save(Factura factura) {

        return facturarepositorio.save(factura);
    }

    @Override
    public Factura buscarporId(Integer id) {
        return facturarepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        facturarepositorio.deleteById(id);
    }
}
