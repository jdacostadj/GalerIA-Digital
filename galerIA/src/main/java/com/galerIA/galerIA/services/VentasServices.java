package com.galerIA.galerIA.services;

import com.galerIA.galerIA.modelo.Productos;
import com.galerIA.galerIA.modelo.Ventas;
import com.galerIA.galerIA.others.ProductosRequest;
import com.galerIA.galerIA.others.VentasEmbeddable;
import com.galerIA.galerIA.others.VentasRequest;
import com.galerIA.galerIA.repository.VentasRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.util.ReflectionUtils.findField;
import static org.springframework.util.ReflectionUtils.setField;

@Service

public class VentasServices {

    private VentasRepository ventasRepository;

    public VentasServices(VentasRepository ventasRepository) {
        this.ventasRepository = ventasRepository;
    }

    //INSERTA
    public Ventas insertaVenta(Ventas ventas){
        try {
            return ventasRepository.save(ventas);
        } catch (Exception e) {
            throw new RuntimeException("Error al insertar Venta "+ e);
        }
    }

    //ACTUALIZA
    public Ventas actualizaVentas(Ventas ventas){
        ventas.setTotalVenta(ventas.getTotalVenta());
        ventas.setVentaId(ventas.getVentaId());
        ventas.setCantidadProducto(ventas.getCantidadProducto());
        ventas.setNombreProducto(ventas.getNombreProducto());
        ventas.setCompradores(ventas.getCompradores());

        return ventasRepository.save(ventas);
    }

    /*
    //ACTUALIZA 2
    public Ventas actualizaVentasCampo(VentasRequest ventasRequest, Map<String, Object> cambios){

        Ventas regVentas = ventasRepository.findById(ventasRequest.getVentasEmbeddable()).orElseThrow(()-> new RuntimeException("Error al actualizar por id"));

        cambios.forEach((key, value) -> {
            Field field;

            field = findField(Productos.class, key);
            field.setAccessible(true);
            setField(field, regVentas, value);
        });
        return ventasRepository.save(regVentas);
    }*/

    //ELIMINA
    public void eliminaVenta(VentasEmbeddable ventasEmbeddable){
        try {
            ventasRepository.deleteById(ventasEmbeddable);
        } catch (Exception e) {
            throw new RuntimeException("Error al Eliminar Venta"+ e);
        }

    }

    //CONSULTA
    public List<Ventas> consultaVenta(){
        try {
            return ventasRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al consultar Venta"+ e);
        }
    }

    //CONSULTA ID
    public Optional<Ventas> consultaVentaId(VentasEmbeddable ventasEmbeddable){
        try {
            return ventasRepository.findById(ventasEmbeddable);
        } catch (Exception e) {
            throw new RuntimeException("Error al consultar Venta: "+ ventasEmbeddable.getFactura() +" "+ e);
        }
    }
}
