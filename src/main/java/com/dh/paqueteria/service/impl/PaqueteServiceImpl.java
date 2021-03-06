package com.dh.paqueteria.service.impl;

import com.dh.paqueteria.entity.Estado;
import com.dh.paqueteria.entity.Paquete;
import com.dh.paqueteria.exceptions.BadRequestException;
import com.dh.paqueteria.repository.PaqueteRepository;
import com.dh.paqueteria.service.PaqueteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaqueteServiceImpl implements PaqueteService {

    private PaqueteRepository paqueteRepository;

    public PaqueteServiceImpl(PaqueteRepository paqueteRepository) {
        this.paqueteRepository = paqueteRepository;
    }

    public Paquete agregar(Paquete paquete) throws BadRequestException {
        // Agregado en ejercicio clase 41
        if (paqueteRepository.findPaqueteByCodigo(paquete.getCodigo()) != null) {
            throw new BadRequestException("Ya existe un paquete con el codigo :" + paquete.getCodigo());
        }

        // Agregado en ejercicio clase 42
        if (paquete.getDestino() == null) {
            throw new BadRequestException("El paquete debe contener un destino");
        }

        return paqueteRepository.save(paquete);
    }

    public List<Paquete> listar() {
        return paqueteRepository.findAll();
    }

    public List<Paquete> paquetesEnCamino() {
        return paqueteRepository.findAllByEstado(Estado.EN_CAMINO);
    }

}
