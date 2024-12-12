package com.galerIA.galerIA.repository;

import com.galerIA.galerIA.modelo.Ventas;
import com.galerIA.galerIA.others.VentasEmbeddable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VentasRepository extends JpaRepository<Ventas, VentasEmbeddable> {

    Optional<Ventas> findById(VentasEmbeddable ventasEmbeddable);

}
