package com.galerIA.galerIA.repository;

import com.galerIA.galerIA.modelo.Cuenta;
import com.galerIA.galerIA.modelo.Productos;
import com.galerIA.galerIA.others.ProductosEmbeddable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ProductosRepository extends JpaRepository<Productos, ProductosEmbeddable> {

    Optional<Productos> findById(ProductosEmbeddable productosEmbeddable);

}
