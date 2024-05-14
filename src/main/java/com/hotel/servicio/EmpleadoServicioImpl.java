package com.hotel.servicio;

import java.util.List;

import com.hotel.modelo.Empleado;

public interface EmpleadoServicioImpl {
    List<Empleado> findAll();

    Empleado save(Empleado usuario);

    Empleado buscarporId(Integer id);

    void eliminar(Integer id);

}
