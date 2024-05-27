package com.hotel.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.modelo.Articulo;
import com.hotel.repositorio.ArticuloRepositorio;

@Service
public class ArticuloServicio implements ArticuloServicioImpl {

    @Autowired
    private ArticuloRepositorio articulorepositorio;

    @Override
    public List<Articulo> findAll() {
        return (List<Articulo>) articulorepositorio.findAll();
    }

    @Override
    public Articulo save(Articulo articulo) {

        return articulorepositorio.save(articulo);
    }

    @Override
    public Articulo buscarporId(Long id) {
        return articulorepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        articulorepositorio.deleteById(id);
    }
}
