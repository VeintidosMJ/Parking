package com.clientes.v1.servicios;

import java.util.List;

import com.clientes.v1.entidades.Cliente;

public interface ClienteServicio {

    public List<Cliente> listarClientes();

    public Cliente guardarCliente(Cliente cliente);

    public Cliente clienteById(Long id);

    public Cliente actualizarInfoCliente(Cliente cliente);

    public void eliminarCliente(Long id);
}
