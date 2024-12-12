package com.galerIA.galerIA.controller;


import com.galerIA.galerIA.modelo.Ventas;
import com.galerIA.galerIA.others.VentasEmbeddable;
import com.galerIA.galerIA.others.VentasRequest;
import com.galerIA.galerIA.services.VentasServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ventas")
@CrossOrigin(origins = "http://localhost:5174") // Permite solicitudes desde tu cliente Vue

public class VentasController {

    private final VentasServices ventasServices;

    public VentasController(VentasServices ventasServices) {
        this.ventasServices = ventasServices;
    }

    //INSERTA
    @PostMapping
    public Ventas insertaVenta(@RequestBody Ventas ventas){
        return ventasServices.insertaVenta(ventas);
    }

    //ACTUALIZA
    @PutMapping
    public Ventas ActualizaVentas(@RequestBody VentasRequest ventasRequest) {
        System.out.println("JD: getProductoId: "+ ventasRequest.getVentasEmbeddable().getProductoId().getProductoId());
        System.out.println("JD: getFactura: "+ ventasRequest.getVentasEmbeddable().getFactura());
        return ventasServices.actualizaVentas(ventasRequest.getVentas());
    }

    //ELIMINA
    @DeleteMapping
    public String eliminaVenta(@RequestBody VentasEmbeddable ventasEmbeddable){
        ventasServices.eliminaVenta(ventasEmbeddable);
        return "Se ha borrado de forma correcta el producto: ";
    }

    //CONSULTA
    @GetMapping
    public List<Ventas> consultaVentas(){
        return ventasServices.consultaVenta();
    }

    //CONSULTA ID
    @PostMapping("/id")
    public Optional<Ventas> consultaVentaId(@RequestBody VentasEmbeddable ventasEmbeddable){
        return ventasServices.consultaVentaId(ventasEmbeddable);
    }
}
