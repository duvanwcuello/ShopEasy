package com.co.shopeasy.logistica.controller;

import com.co.shopeasy.logistica.entity.Conductor;
import com.co.shopeasy.logistica.service.ConductorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/conductores")
public class ConductorController {

    private final ConductorService conductorService;

    public ConductorController(ConductorService conductorService) {
        this.conductorService = conductorService;
    }

    @GetMapping
    public ResponseEntity<List<Conductor>> getAll() {
        List<Conductor> list = conductorService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conductor> getById(@PathVariable Long id) {
        Optional<Conductor> opt = conductorService.findById(id);
        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Conductor> create(@Valid @RequestBody Conductor conductor) {
        Conductor created = conductorService.save(conductor);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conductor> update(@PathVariable Long id, @Valid @RequestBody Conductor conductor) {
        Optional<Conductor> updated = conductorService.update(id, conductor);
        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = conductorService.delete(id);
        if (deleted) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}