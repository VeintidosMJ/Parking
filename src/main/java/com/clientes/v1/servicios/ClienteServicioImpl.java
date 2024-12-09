package com.clientes.v1.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clientes.v1.entidades.Cliente;
import com.clientes.v1.repositorios.ClienteRepositorio;

@Service
public class ClienteServicioImpl implements ClienteServicio {

    @Autowired
    ClienteRepositorio clienteRepositorio;

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    @Override
    public Cliente clienteById(Long id) {
        return clienteRepositorio.findById(id)
                .orElse(null);
    }

    @Override
    public Cliente actualizarInfoCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepositorio.deleteById(id);
    }

}
