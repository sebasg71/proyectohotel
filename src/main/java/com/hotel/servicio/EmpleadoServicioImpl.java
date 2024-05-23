
package com.hotel.servicio;

import java.util.List;

import com.hotel.modelo.Empleado;

public interface EmpleadoServicioImpl {
    List<Empleado> findAll();

    Empleado save(Empleado usuario);

    Empleado buscarporId(Long id);

    void eliminar(Long id);

}
