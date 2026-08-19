package com.co.shopeasy.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "asignaciones")

public class Asignacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name="camion_id", nullable = false)
    private Camion camion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conductor_id", nullable = false)
    private Conductor conductor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supervidor_id", nullable = false)
    private Usuario supervisor;

    @Column(nullable = false)
    private LocalDateTime fechaAsignacion;

    private LocalDateTime getFechaFinalizacion;

    @Column(nullable = false)
    private String estado;

    public Asignacion(){

    }

    public Asignacion(Camion camion,
                      Conductor conductor,
                      Usuario supervisor,
                      LocalDateTime fechaAsignacion,
                      LocalDateTime getFechaFinalizacion,
                      String estado) {

        this.camion = camion;
        this.conductor = conductor;
        this.supervisor = supervisor;
        this.fechaAsignacion = fechaAsignacion;
        this.getFechaFinalizacion = getFechaFinalizacion;
        this.estado = estado;
    }

    public Camion getCamion() {
        return camion;
    }

    public void setCamion(Camion camion) {
        this.camion = camion;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public Usuario getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Usuario supervisor) {
        this.supervisor = supervisor;
    }

    public LocalDateTime getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDateTime fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public LocalDateTime getGetFechaFinalizacion() {
        return getFechaFinalizacion;
    }

    public void setGetFechaFinalizacion(LocalDateTime getFechaFinalizacion) {
        this.getFechaFinalizacion = getFechaFinalizacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
