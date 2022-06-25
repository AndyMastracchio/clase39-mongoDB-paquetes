package com.dh.paqueteria.repository;

import com.dh.paqueteria.entity.Estado;
import com.dh.paqueteria.entity.Paquete;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaqueteRepository  extends MongoRepository<Paquete,Integer> {
        List<Paquete> findAllByEstado(Estado estado);
}
