package com.galerIA.galerIA.repository;

import com.galerIA.galerIA.modelo.Compradores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompradoresRepository extends JpaRepository<Compradores, String> {

    //Optional<Compradores> findById(String cedula);
    void deleteById(String cedula);

}
