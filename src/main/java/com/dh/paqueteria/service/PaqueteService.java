package com.dh.paqueteria.service;

import com.dh.paqueteria.entity.Estado;
import com.dh.paqueteria.entity.Paquete;

import java.util.List;

public interface PaqueteService {
    Paquete agregar(Paquete paquete);
    List<Paquete> listar();
    List<Paquete> paquetesEnCamino();
}
