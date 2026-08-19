package com.co.shopeasy.logistica.service;


import com.co.shopeasy.logistica.entity.Camion;
import com.co.shopeasy.logistica.repository.CamionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CamionService {

    private final CamionRepository camionRepository;

    public CamionService(CamionRepository camionRepository) {
        this.camionRepository = camionRepository;
    }

    //registrar un Camion

    public Camion crarCamion(Camion camion) {

        if (camion == null){
            throw new IllegalArgumentException(
                    "Camion no puede ser null"
            );
        }

        if(camion.getPlaca()==null || camion.getPlaca().trim().isEmpty()){
            throw new IllegalArgumentException(
                    "La placa es Obligatoria."
            );
        }

        String placa = camion.getPlaca().trim().toUpperCase();

        if (camionRepository.existsByPlaca(placa)) {
            throw new IllegalArgumentException(
                "La placa ya esta registrado: " + placa
            );
        }

        camion.setPlaca(placa);

        return camionRepository.save(camion);
    }

    //listar camiones
    public List<Camion> ListarCamiones() {
        return camionRepository.findAll();
    }

    //Buscar un Camion
    public Camion buscarPorId(Long id) {
        if(id==null){
            throw new IllegalArgumentException(
                    "El id no puede ser null"
            );
        }

        return camionRepository.findById(id).orElseThrow(() -> new RuntimeException(
                "No se encontro el camion con el ID: " + id
                )
        );
    }
}
