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

import com.hotel.modelo.Articulo;
import com.hotel.modelo.Habitacion;
import com.hotel.servicio.ArticuloServicio;
import com.hotel.servicio.HabitacionServicio;

@Controller
@RequestMapping("/vistas/Articulos")
public class ArticuloControlador {

    @Autowired
    private ArticuloServicio articuloservicio;
    private HabitacionServicio habitacionServicio;

    public ArticuloControlador(ArticuloServicio articuloServicio, HabitacionServicio habitacionServicio) {
        this.articuloservicio = articuloServicio;
        this.habitacionServicio = habitacionServicio;
    }

    @GetMapping("/")
    public String listadoArticulo(Model modelo) {
        List<Articulo> listadoarticulo = articuloservicio.findAll();
        modelo.addAttribute("Articulo", listadoarticulo);
        return "/vistas/Articulos/articulos";
    }

    @GetMapping("/create")
    public String crear(Model modelo) {

        Articulo articulo = new Articulo();

        Iterable<Habitacion> habitacion = habitacionServicio.findAll();
        modelo.addAttribute("Titulo", "Articulo");
        modelo.addAttribute("Habitacion", habitacion);
        modelo.addAttribute("Articulo", articulo);
        return "/vistas/Articulos/registroArticulos";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Articulo articulo, Model modelo) {
        modelo.addAttribute("Titulo: ", "Articulo");
        modelo.addAttribute("Articulo", articulo);
        articuloservicio.save(articulo);
        return "redirect:/vistas/Articulos/";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idArticulo, Model modelo) {

        Articulo articulo = new Articulo();

        if (idArticulo > 0) {
            articulo = articuloservicio.buscarporId(idArticulo);
            if (articulo == null) {
                return "redirect:/vistas/Articulos/";
            }
        } else {
            return "redirect:/vistas/Articulos/";
        }

        modelo.addAttribute("Titulo", "Formulario: Editar Articulo");
        modelo.addAttribute("Articulo", articulo);
        return "/vistas/Articulos/registroArticulos";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") long idArticulo, Model modelo) {

        Articulo articulo = new Articulo();

        if (idArticulo > 0) {
            articulo = articuloservicio.buscarporId(idArticulo);
            if (articulo == null) {
                return "redirect:/vistas/Articulos/";
            }
        } else {
            return "redirect:/vistas/Articulos/";
        }

        articuloservicio.eliminar(idArticulo);
        return "redirect:/vistas/Articulos/";
    }

}
