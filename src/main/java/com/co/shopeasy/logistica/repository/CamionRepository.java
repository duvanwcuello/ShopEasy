package com.co.shopeasy.logistica.repository;

import com.co.shopeasy.logistica.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CamionRepository extends  JpaRepository<Camion, Long>{

    Optional<Camion> findByplaca(String placa);

    Boolean existsByPlaca(String placa);
}