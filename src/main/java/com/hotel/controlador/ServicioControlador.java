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
import com.hotel.modelo.Servicio;
import com.hotel.servicio.HospedajeServicio;
import com.hotel.servicio.ServicioService;

@Controller
@RequestMapping("/vistas/Servicio")
public class ServicioControlador {

    @Autowired
    private  ServicioService servicioService;
    private  HospedajeServicio hospedajeServicio;

    @GetMapping("/")
    public String listadoServicio(Model modelo) {
        List<Servicio> listadoservicio = servicioService.findAll();
        modelo.addAttribute("Servicio", listadoservicio);
        return "/vistas/Servicio/servicio";
    }

    @GetMapping("/create")
    public String crear(Model modelo) {

        Servicio servicio = new Servicio();
        Iterable<Hospedaje>hospedaje=hospedajeServicio.findAll();
        modelo.addAttribute("Titulo", "Servicio");

        modelo.addAttribute("Servicio",servicio );
        modelo.addAttribute("Hospedaje",hospedaje );
        return "/vistas/Servicio/servicio";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Servicio servicio, Model modelo) {
        modelo.addAttribute("Titulo: ", "Servicio");
        modelo.addAttribute("Servicio", servicio);
        servicioService.save(servicio);
        return "redirect:/vistas/Servicio/";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id_servicio, Model modelo) {

        Servicio servicio = new Servicio();

        if (id_servicio > 0) {
            servicio = servicioService.buscarporId(id_servicio);
            if (servicio == null) {
                return "redirect:/vistas/Servicio";
            }
        } else {
            return "redirect:/vistas/Servicio";
        }

        modelo.addAttribute("Titulo", "Formulario: Editar servicio");
        modelo.addAttribute("Servicio", servicio);
        return "/vistas/Servicio/servicio";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") long id_servicio, Model modelo) {

        Servicio servicio = new Servicio();

        if (id_servicio > 0) {
            servicio = servicioService.buscarporId(id_servicio);
            if (servicio == null) {
                return "redirect:/vistas/Servicio";
            }
        } else {
            return "redirect:/vistas/Servicio";
        }

        servicioService.eliminar(id_servicio);
        return "redirect:/vistas/Servicio/";
    }

}
