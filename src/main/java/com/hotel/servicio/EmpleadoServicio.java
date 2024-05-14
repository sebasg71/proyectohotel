package com.hotel.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.modelo.Empleado;
import com.hotel.repositorio.EmpleadoRepositorio;

@Service
public class EmpleadoServicio implements EmpleadoServicioImpl {

    @Autowired
    private EmpleadoRepositorio empleadorepositorio;

    @Override
    public List<Empleado> findAll() {
        return (List<Empleado>) empleadorepositorio.findAll();
    }

    @Override
    public Empleado save(Empleado empleado) {

        return empleadorepositorio.save(empleado);
    }

    @Override
    public Empleado buscarporId(Integer id) {
        return empleadorepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        empleadorepositorio.deleteById(id);
    }
}
