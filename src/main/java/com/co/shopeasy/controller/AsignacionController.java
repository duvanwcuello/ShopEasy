package com.co.shopeasy.controller;

import com.co.shopeasy.service.AsignacionService;
import com.co.shopeasy.entity.Asignacion;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asignaciones")
public class AsignacionController {

    private final AsignacionService asignacionService;

    public AsignacionController(AsignacionService asignacionService) {
        this.asignacionService = asignacionService;
    }

    @GetMapping
    public ResponseEntity<List<Asignacion>> getAll() {
        return ResponseEntity.ok(asignacionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asignacion> getById(@PathVariable Long id) {
        Optional<Asignacion> opt = asignacionService.findById(id);
        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Asignacion> create(@Valid @RequestBody Asignacion asignacion) {
        Asignacion created = asignacionService.save(asignacion);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asignacion> update(@PathVariable Long id, @Valid @RequestBody Asignacion asignacion) {
        Optional<Asignacion> updated = asignacionService.update(id, asignacion);
        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = asignacionService.delete(id);
        if (deleted) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

    // Ejemplo de endpoint específico: asignar conductor a pedido
    @PostMapping("/{id}/asignar-conductor/{conductorId}")
    public ResponseEntity<Asignacion> asignarConductor(@PathVariable Long id, @PathVariable Long conductorId) {
        Optional<Asignacion> result = asignacionService.assignDriver(id, conductorId);
        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}