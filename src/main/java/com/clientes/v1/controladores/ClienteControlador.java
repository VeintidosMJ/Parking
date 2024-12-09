package com.clientes.v1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.clientes.v1.entidades.Cliente;
import com.clientes.v1.servicios.ClienteServicio;

@Controller
public class ClienteControlador {

    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping("/clientes/nuevo")
    public String mostrarFormularioCliente(Model modelo) {
        Cliente cliente = new Cliente();
        modelo.addAttribute("cliente", cliente);
        return "crear_cliente";
    }

    @PostMapping("/clientes")
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteServicio.guardarCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model modelo) {
        Cliente cliente = clienteServicio.clienteById(id);
        if (cliente == null) {
            throw new RuntimeException("cliente no encontrado para el ID: " + id);
        }
        modelo.addAttribute("cliente", cliente);
        return "editar_cliente"; // Nombre de la plantilla HTML
    }

    @PostMapping("/clientes/{id}")
    public String actualizarCliente(@PathVariable Long id, @ModelAttribute("cliente") Cliente cliente, Model modelo) {
        Cliente clienteExistente = clienteServicio.clienteById(id);

        clienteExistente.setId(id);
        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setApellido(cliente.getApellido());
        clienteExistente.setAuto(cliente.getAuto());
        clienteExistente.setPlaca(cliente.getPlaca());
        clienteExistente.setMembresia(cliente.getMembresia());

        clienteServicio.actualizarInfoCliente(clienteExistente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        clienteServicio.eliminarCliente(id);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes")
    public String listarClientes(Model modelo) {
        modelo.addAttribute("clientes", clienteServicio.listarClientes());
        return "clientes";
    }

}
