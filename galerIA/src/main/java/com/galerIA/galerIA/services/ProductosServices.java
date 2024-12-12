package com.galerIA.galerIA.services;

import com.galerIA.galerIA.modelo.Productos;
import com.galerIA.galerIA.modelo.Vendedores;
import com.galerIA.galerIA.others.ProductosEmbeddable;
import com.galerIA.galerIA.others.ProductosRequest;
import com.galerIA.galerIA.repository.ProductosRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.util.ReflectionUtils.findField;
import static org.springframework.util.ReflectionUtils.setField;

@Service

public class ProductosServices {

    private ProductosRepository productosRepository;

    public ProductosServices(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    //INSERTA
    public Productos insertaProducto(Productos productos){
        try {
            return productosRepository.save(productos);
        } catch (Exception e) {
            throw new RuntimeException("Error al insertar el producto !!!: "+ e);
        }
    }

    //ACTUALIZA
    public Productos actualizaProducto(Productos productos){

        try {
            productos.setCategoriaProducto(productos.getCategoriaProducto());
            productos.setNombreProducto(productos.getNombreProducto());
            productos.setCantidadProducto(productos.getCantidadProducto());
            productos.setPrecioProducto(productos.getPrecioProducto());

            return productosRepository.save(productos);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el producto !!!: "+ e);
        }
    }

    //ACTUALIZA 2
    public Productos actualizaProductosCampo(ProductosRequest productosRequest, Map<String, Object> cambios){

        Productos regProductos = productosRepository.findById(productosRequest.getProductosEmbeddable()).orElseThrow(()-> new RuntimeException("Error al actualizar por id"));

        cambios.forEach((key, value) -> {
            Field field;

            field = findField(Productos.class, key);
            field.setAccessible(true);
            setField(field, regProductos, value);
        });
        return productosRepository.save(regProductos);
    }

    //BORRA
    public void borraProducto(ProductosEmbeddable productosEmbeddable){
        try {
            productosRepository.deleteById(productosEmbeddable);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el producto !!!: "+e);
        }
    }

    //CONSULTA
    public List<Productos> consultaProducto(){
        try {
            return productosRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al consultar el producto: "+ e);
        }
    }

    //CONSULTA ID
    public Optional<Productos> consultaProductosId(ProductosEmbeddable productosEmbeddable){
        try {
            return productosRepository.findById(productosEmbeddable);
        } catch (Exception e) {
            throw new RuntimeException("Error al consultar el producto: "+ e);
        }
    }
}
