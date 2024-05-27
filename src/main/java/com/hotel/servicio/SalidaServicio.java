package com.hotel.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.modelo.Salida;
import com.hotel.repositorio.SalidaRepositorio;

@Service
public class SalidaServicio implements SalidaServicioImpl {

    @Autowired
    private SalidaRepositorio salidarepositorio;

    @Override
    public List<Salida> findAll() {
        return (List<Salida>) salidarepositorio.findAll();
    }

    @Override
    public Salida save(Salida salida) {

        return salidarepositorio.save(salida);
    }

    @Override
    public Salida buscarporId(Long id) {
        return salidarepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        salidarepositorio.deleteById(id);
    }
}
