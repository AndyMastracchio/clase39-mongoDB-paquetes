package com.dh.paqueteria.controller;

import com.dh.paqueteria.entity.Paquete;
import com.dh.paqueteria.exceptions.BadRequestException;
import com.dh.paqueteria.service.PaqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paquetes")
public class PaqueteController {

    private final PaqueteService paqueteService;

    @Autowired
    public PaqueteController(PaqueteService paqueteService) {
        this.paqueteService = paqueteService;
    }

    @PostMapping("/new")
    public Paquete registar(@RequestBody Paquete paquete) throws BadRequestException {
        return paqueteService.agregar(paquete);
    }

    @GetMapping
    public List<Paquete> listar() {
        return paqueteService.listar();
    }

    @GetMapping("/en-camino")
    public List<Paquete> enCamino() {
        return paqueteService.paquetesEnCamino();
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> procesarErrorBadRequest(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
