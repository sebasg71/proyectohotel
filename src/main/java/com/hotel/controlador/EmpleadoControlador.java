package com.hotel.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.modelo.Cliente;
import com.hotel.modelo.Empleado;
import com.hotel.servicio.ClienteServicio;
import com.hotel.servicio.EmpleadoServicio;

@Controller
@RequestMapping("/vistas/Empleado")
public class EmpleadoControlador {
    @Autowired
    private EmpleadoServicio empleadoServicio;

    @GetMapping("/")
    public String listadoEmpleado(Model modelo) {
        List<Empleado> listadoEmpleado = empleadoServicio.findAll();
        modelo.addAttribute("Empleado", listadoEmpleado);
        return "/vistas/Empleado/empleado";
    }

    @GetMapping("/create")
    public String crear(Model modelo) {
        Empleado empleado = new Empleado();
        modelo.addAttribute("Titulo", "empleado");
        modelo.addAttribute("Empleado", empleado);
        return "/vistas/Empleado/empleado";
    }

}
