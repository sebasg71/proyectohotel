package com.hotel.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.modelo.Reserva;
import com.hotel.repositorio.ReservaRepositorio;

@Service
public class ReservaServicio implements ReservaServicioImpl {

    @Autowired
    private ReservaRepositorio reservarepositorio;

    @Override
    public List<Reserva> findAll() {
        return (List<Reserva>) reservarepositorio.findAll();
    }

    @Override
    public Reserva save(Reserva reserva) {

        return reservarepositorio.save(reserva);
    }

    @Override
    public Reserva buscarporId(Long id) {
        return reservarepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        reservarepositorio.deleteById(id);
    }
}
