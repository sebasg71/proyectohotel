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

import com.hotel.modelo.Hospedaje;
import com.hotel.modelo.Reserva;
import com.hotel.servicio.HospedajeServicio;
import com.hotel.servicio.ReservaServicio;

@Controller
@RequestMapping("/vistas/Hospedaje")
public class HospedajeControlador {

    @Autowired
    private ReservaServicio reservaServicio;
    private HospedajeServicio hospedajeServicio;

    public HospedajeControlador(ReservaServicio reservaServicio, HospedajeServicio hospedajeServicio) {
        this.reservaServicio = reservaServicio;
        this.hospedajeServicio = hospedajeServicio;
    }

    @GetMapping("/")
    public String listadoHabitacion(Model modelo) {
        List<Hospedaje> listadoHopedaje = hospedajeServicio.findAll();
        modelo.addAttribute("Hospedaje", listadoHopedaje);
        return "/vistas/Hospedaje/hospedaje";
    }

    @GetMapping("/create")
    public String crear(Model modelo) {

        Hospedaje hospedaje = new Hospedaje();

        Iterable<Reserva> reserva = reservaServicio.findAll();

        modelo.addAttribute("Titulo", "Reserva");

        modelo.addAttribute("Hospedaje", hospedaje);
        modelo.addAttribute("Reserva", reserva);
        return "/vistas/Hospedaje/registrarHospedaje";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Hospedaje hospedaje, Model modelo) {
        modelo.addAttribute("Titulo: ", "Hospedaje");
        modelo.addAttribute("Hospedaje", hospedaje);
        hospedajeServicio.save(hospedaje);
        return "redirect:/vistas/Hospedaje/";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id_hospedaje, Model modelo) {

        Hospedaje hospedaje = new Hospedaje();

        if (id_hospedaje > 0) {
            hospedaje = hospedajeServicio.buscarporId(id_hospedaje);
            if (hospedaje == null) {
                return "redirect:/vistas/Hospedaje/";
            }
        } else {
            return "redirect:/vistas/Hospedaje/";
        }

        modelo.addAttribute("Titulo", "hospedaje");
        modelo.addAttribute("Hospedaje", hospedaje);
        return "/vistas/Hospedaje/registrarHospedaje";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") long id_hospedaje, Model modelo) {

        Hospedaje hospedaje = new Hospedaje();

        if (id_hospedaje > 0) {
            hospedaje = hospedajeServicio.buscarporId(id_hospedaje);
            if (hospedaje == null) {
                return "redirect:/vistas/Hospedaje/";
            }
        } else {
            return "redirect:/vistas/Hospedaje/";
        }

        hospedajeServicio.eliminar(id_hospedaje);
        return "redirect:/vistas/Hospedaje/";
    }
}
