package com.co.shopeasy.logistica.repository;

import com.co.shopeasy.logistica.entity.Asignacion;
import com.co.shopeasy.logistica.entity.Camion;
import com.co.shopeasy.logistica.entity.Conductor;
import com.co.shopeasy.seguridad.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AsignacionRepository extends CrudRepository<Asignacion, Long> {
    List<Asignacion> findByCamion(String camion);
    List<Asignacion> findByConductor(Conductor conductor);
    List<Asignacion> findSupervisor(Usuario supervisor);

    List<Asignacion> findByEstado(String estado);

    Optional<Asignacion> findByCamionAndEstado(
            Camion camion,
            String estado);

    Optional<Asignacion> findByConductorAndEstado(
            Conductor conductor,
            String estado);

}
