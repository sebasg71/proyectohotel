package com.hotel.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotel.modelo.Empleado;

import com.hotel.servicio.EmpleadoServicio;

@Controller
@RequestMapping("/vistas/Empleados")
public class EmpleadoControlador {
    @Autowired
    private EmpleadoServicio empleadoServicio;

    @GetMapping("/")
    public String listadoEmpleado(Model modelo) {
        List<Empleado> listadoEmpleado = empleadoServicio.findAll();
        modelo.addAttribute("Empleado", listadoEmpleado);
        return "/vistas/Empleados/empleados";
    }

    @GetMapping("/create")
    public String crear(Model modelo) {
        Empleado empleado = new Empleado();
        modelo.addAttribute("Titulo", "empleado");
        modelo.addAttribute("Empleado", empleado);
        return "/vistas/Empleado/empleado";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Empleado empleado, Model modelo) {
        modelo.addAttribute("Titulo: ", "empleado");
        modelo.addAttribute("Empleado", empleado);
        empleadoServicio.save(empleado);
        return "redirect:/vistas/Empleado/";

    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idEmpleado, Model modelo) {

        Empleado empleado = new Empleado();

        if (idEmpleado > 0) {
            empleado = empleadoServicio.buscarporId(idEmpleado);
            if (empleado == null) {
                return "redirect:/vistas/Empleado";
            }
        } else {
            return "redirect:/vistas/Empleado";
        }

        modelo.addAttribute("Titulo", " Gestion:empleado");
        modelo.addAttribute("Empleado", empleado);
        return "/vistas/Empleado/GestionarEmpleado";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long idEmpleado, Model modelo) {

        Empleado empleado = new Empleado();

        if (idEmpleado > 0) {
            empleado = empleadoServicio.buscarporId(idEmpleado);
            if (empleado == null) {
                return "redirect:/vistas/Empleado";
            }
        } else {
            return "redirect:/vistas/Empleado";
        }

        empleadoServicio.eliminar(idEmpleado);
        return "redirect:/vistas/Empleado/";
    }

}
