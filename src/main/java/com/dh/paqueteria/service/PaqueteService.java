package com.dh.paqueteria.service;

import com.dh.paqueteria.entity.Estado;
import com.dh.paqueteria.entity.Paquete;
import com.dh.paqueteria.exceptions.BadRequestException;

import java.util.List;

public interface PaqueteService {
    Paquete agregar(Paquete paquete) throws BadRequestException;
    List<Paquete> listar();
    List<Paquete> paquetesEnCamino();
}
