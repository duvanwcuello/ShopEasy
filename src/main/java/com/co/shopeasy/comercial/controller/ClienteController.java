package com.co.shopeasy.comercial.controller;


import com.co.shopeasy.comercial.entity.Cliente;
import com.co.shopeasy.comercial.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")

public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService  service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Cliente> crear(
            @RequestBody Cliente cliente){

        Cliente nuevoCliente = service.crearCliente(cliente);

        return ResponseEntity.ok(nuevoCliente);
    }
    @GetMapping
    public ResponseEntity<List<Cliente>> listar(){

        List<Cliente> clientes = service.listarClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(
            @PathVariable Long id){

        return service.buscarClientePorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizar(
            @PathVariable Long id,
            @RequestBody Cliente cliente){

        Cliente actualizado = service.actualizarCliente(id, cliente);

        if(actualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(actualizado);
    }

    @DeleteMapping ("/[{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id){

        boolean eliminado = service.eliminarCliente(id);
        if(!eliminado){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
