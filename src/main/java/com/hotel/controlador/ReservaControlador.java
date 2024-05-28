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

import com.hotel.modelo.Cliente;
import com.hotel.modelo.Empleado;
import com.hotel.modelo.Habitacion;
import com.hotel.modelo.Reserva;
import com.hotel.servicio.ClienteServicio;
import com.hotel.servicio.EmpleadoServicio;
import com.hotel.servicio.HabitacionServicio;
import com.hotel.servicio.ReservaServicio;

@Controller
@RequestMapping("/vistas/Reserva")
public class ReservaControlador {

    @Autowired
    private ReservaServicio reservaServicio;
    private HabitacionServicio habitacionServicio;
    private EmpleadoServicio empleadoServicio;
    private ClienteServicio clienteServicio;

    public ReservaControlador(ReservaServicio reservaServicio, HabitacionServicio habitacionServicio,
            EmpleadoServicio empleadoServicio, ClienteServicio clienteServicio) {
        this.reservaServicio = reservaServicio;
        this.habitacionServicio = habitacionServicio;
        this.empleadoServicio = empleadoServicio;
        this.clienteServicio = clienteServicio;
    }

    @GetMapping("/")
    public String listadoReserva(Model modelo) {
        List<Reserva> listadoreserva = reservaServicio.findAll();
        modelo.addAttribute("Reserva", listadoreserva);
        return "/vistas/Reserva/reserva";
    }

    @GetMapping("/create")
    public String crear(Model modelo) {

        Reserva reserva = new Reserva();

        Iterable<Habitacion> habitacion = habitacionServicio.findAll();
        Iterable<Empleado> empleado = empleadoServicio.findAll();
        Iterable<Cliente> cliente = clienteServicio.findAll();
        modelo.addAttribute("Titulo", "Reserva");

        modelo.addAttribute("Habitacion", habitacion);
        modelo.addAttribute("Empleado", empleado);
        modelo.addAttribute("Cliente", cliente);
        modelo.addAttribute("Reserva", reserva);

        return "/vistas/Reserva/registrarReserva";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Reserva reserva, Model modelo) {
        modelo.addAttribute("Titulo: ", "Reserva");
        modelo.addAttribute("Reserva", reserva);
        reservaServicio.save(reserva);
        return "redirect:/vistas/Reserva/";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id_Reserva, Model modelo) {

        Reserva reserva = new Reserva();

        if (id_Reserva > 0) {
            reserva = reservaServicio.buscarporId(id_Reserva);
            if (reserva == null) {
                return "redirect:/vistas/Reserva";
            }
        } else {
            return "redirect:/vistas/Reserva";
        }

        modelo.addAttribute("Titulo", "Formulario: Reserva");
        modelo.addAttribute("Reserva", reserva);
        return "/vistas/Articulo/reserva";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") long id_Reserva, Model modelo) {

        Reserva reserva = new Reserva();

        if (id_Reserva > 0) {
            reserva = reservaServicio.buscarporId(id_Reserva);
            if (reserva == null) {
                return "redirect:/vistas/Reserva";
            }
        } else {
            return "redirect:/vistas/Reserva";
        }

        reservaServicio.eliminar(id_Reserva);
        return "redirect:/vistas/Reserva/";
    }

}