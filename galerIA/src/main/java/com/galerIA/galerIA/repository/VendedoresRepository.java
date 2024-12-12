package com.galerIA.galerIA.repository;

import com.galerIA.galerIA.modelo.Vendedores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendedoresRepository extends JpaRepository<Vendedores, String> {

    Optional<Vendedores> findById (String cedula);
    void deleteById(String cedula);
}
