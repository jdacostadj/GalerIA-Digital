package com.galerIA.galerIA.repository;

import com.galerIA.galerIA.modelo.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CuentaRepository extends JpaRepository<Cuenta, String> {

    //Optional<Cuenta> findById(String id);
    void deleteById(String id);

}
