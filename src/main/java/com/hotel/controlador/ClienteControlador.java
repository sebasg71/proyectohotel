package com.hotel.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        // crear objeto
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

}
