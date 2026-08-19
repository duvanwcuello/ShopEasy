package com.co.shopeasy.comercial.service;

import com.co.shopeasy.comercial.entity.Cliente;
import com.co.shopeasy.comercial.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {

        this.repository = repository;
    }

    public Cliente crearCliente(Cliente cliente) {

        return repository.save(cliente);
    }

    public List<Cliente> listarClientes() {

        return repository.findAll();
    }

    public Optional<Cliente> buscarClientePorId(Long id) {
        return repository.findById(id);
    }

    public Cliente actualizarCliente(Long id, Cliente datosCliente) {
        Optional<Cliente> clienteExistente = repository.findById(id);

        if (clienteExistente.isPresent()) {
            Cliente cliente = clienteExistente.get();

            cliente.setNombre(datosCliente.getNombre());
            cliente.setApellido(datosCliente.getApellido());
            cliente.setCorreo(datosCliente.getCorreo());
            cliente.setTelefono(datosCliente.getTelefono());
            return repository.save(cliente);
        }
         return  null;
    }

    public boolean eliminarCliente(Long id) {
        if (repository. existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

}