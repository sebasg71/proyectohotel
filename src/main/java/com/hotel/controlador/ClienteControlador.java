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
import com.hotel.servicio.ClienteServicio;

@Controller
@RequestMapping("/vistas/Cliente")
public class ClienteControlador {

    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping("/")
    public String listadoClientes(Model modelo) {
        List<Cliente> listadocliente = clienteServicio.findAll();
        modelo.addAttribute("Cliente", listadocliente);
        return "/vistas/Cliente/cliente";
    }

    @GetMapping("/create")
    public String crear(Model modelo) {

        Cliente cliente = new Cliente();
        modelo.addAttribute("Titulo", "Formulario Nuevo Cliente");
        modelo.addAttribute("Cliente", cliente);
        return "/vistas/Cliente/registroCliente";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Cliente cliente, Model modelo) {
        modelo.addAttribute("Titulo: ", "Formulario: Nuevo Cliente");
        modelo.addAttribute("Cliente", cliente);
        clienteServicio.save(cliente);
        return "redirect:/vistas/Cliente/";

    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idCliente, Model modelo) {

        Cliente cliente = new Cliente();

        if (idCliente > 0) {
            cliente = clienteServicio.buscarporId(idCliente);
            if (cliente == null) {
                return "redirect:/vistas/Cliente/";
            }
        } else {
            return "redirect:/vistas/Cliente/";
        }

        modelo.addAttribute("Titulo", "Formulario: Editar Cliente");
        modelo.addAttribute("Cliente", cliente);
        return "/vistas/Cliente/registroCliente";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long idCliente, Model modelo) {

        Cliente cliente = new Cliente();

        if (idCliente > 0) {
            cliente = clienteServicio.buscarporId(idCliente);
            if (cliente == null) {
                return "redirect:/vistas/Cliente";
            }
        } else {
            return "redirect:/vistas/Cliente";
        }

        clienteServicio.eliminar(idCliente);
        return "redirect:/vistas/Cliente/";
    }

}
