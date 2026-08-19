package com.co.shopeasy.logistica.repository;

import com.co.shopeasy.logistica.entity.Conductor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ConductorRepository extends CrudRepository<Conductor, Long> {
    Optional<Conductor> findByDocumento(String documento);
    Optional<Conductor> findByNumeroLicencia(String numeroDocumento);

    boolean existsByDocumento(String documento);
    boolean existsByNumeroLicencia(String numeroDocumento);

}
