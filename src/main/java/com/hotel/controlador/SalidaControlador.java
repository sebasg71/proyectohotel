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
import com.hotel.modelo.Salida;
import com.hotel.servicio.HospedajeServicio;
import com.hotel.servicio.SalidaServicio;

@Controller
@RequestMapping("/vistas/Salida")
public class SalidaControlador {

    @Autowired
    private  SalidaServicio salidaServicio;
    private HospedajeServicio hospedajeServicio;

    @GetMapping("/")
    public String listadosalida(Model modelo) {
        List<Salida> listadosalida = salidaServicio.findAll();
        modelo.addAttribute("Salida", listadosalida);
        return "/vistas/Salida/salida";
    }

    @GetMapping("/create")
    public String crear(Model modelo) {

        Salida salida = new Salida();

        Iterable<Hospedaje>hospedaje=hospedajeServicio.findAll();
        modelo.addAttribute("Titulo","salida");
        
        modelo.addAttribute("Salida", salida);
        modelo.addAttribute("Titulo", hospedaje);
        return "/vistas/Hospedaje/hospedaje";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Salida salida, Model modelo) {
        modelo.addAttribute("Titulo: ", "Salida");
        modelo.addAttribute("Salida", salida);
        salidaServicio.save(salida);
        return "redirect:/vistas/Salida/";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idSalida, Model modelo) {

        Salida salida = new Salida();

        if (idSalida > 0) {
            salida = salidaServicio.buscarporId(idSalida);
            if (salida == null) {
                return "redirect:/vistas/Salida";
            }
        } else {
            return "redirect:/vistas/Salida";
        }

        modelo.addAttribute("Titulo", "Salida");
        modelo.addAttribute("Salida", salida);
        return "/vistas/Salida/salida";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") long id_salida, Model modelo) {

        Salida salida = new Salida();

        if (id_salida > 0) {
            salida = salidaServicio.buscarporId(id_salida);
            if (salida == null) {
                return "redirect:/vistas/Salida";
            }
        } else {
            return "redirect:/vistas/Salida";
        }

        salidaServicio.eliminar(id_salida);
        return "redirect:/vistas/Salida/";
    }

}