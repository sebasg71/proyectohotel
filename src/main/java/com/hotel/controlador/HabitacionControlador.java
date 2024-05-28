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

import com.hotel.modelo.Habitacion;

import com.hotel.servicio.HabitacionServicio;

@Controller
@RequestMapping("/vistas/Habitacion")
public class HabitacionControlador {

    @Autowired

    private HabitacionServicio habitacionServicio;

    @GetMapping("/")
    public String listadoHabitacion(Model modelo) {
        List<Habitacion> listadoHabitacion = habitacionServicio.findAll();
        modelo.addAttribute("Habitacion", listadoHabitacion);
        return "/vistas/Habitacion/habitacion";
    }

    @GetMapping("/create")
    public String crear(Model modelo) {

        Habitacion habitacion = new Habitacion();

        modelo.addAttribute("Titulo", "Habitacion");

        modelo.addAttribute("Habitacion", habitacion);
        return "/vistas/Habitacion/habitacion";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Habitacion habitacion, Model modelo) {
        modelo.addAttribute("Titulo: ", "Habitacion");
        modelo.addAttribute("Habitacion", habitacion);
        habitacionServicio.save(habitacion);
        return "redirect:/vistas/Habitacion/";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idhabitacion, Model modelo) {

        Habitacion habitacion = new Habitacion();

        if (idhabitacion > 0) {
            habitacion = habitacionServicio.buscarporId(idhabitacion);
            if (habitacion == null) {
                return "redirect:/vistas/Habitacion";
            }
        } else {
            return "redirect:/vistas/Habitacion";
        }

        modelo.addAttribute("Titulo", "Habitacion");
        modelo.addAttribute("Habitacion", habitacion);
        return "/vistas/Habitacion/habitacion";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") long id_habitacion, Model modelo) {

        Habitacion habitacion = new Habitacion();

        if (id_habitacion > 0) {
            habitacion = habitacionServicio.buscarporId(id_habitacion);
            if (habitacion == null) {
                return "redirect:/vistas/Habitacion";
            }
        } else {
            return "redirect:/vistas/Habitacion";
        }

        habitacionServicio.eliminar(id_habitacion);
        return "redirect:/vistas/Habitacion/";
    }
"holi"
}
