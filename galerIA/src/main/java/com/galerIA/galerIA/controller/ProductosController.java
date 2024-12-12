package com.galerIA.galerIA.controller;

import com.galerIA.galerIA.modelo.Productos;
import com.galerIA.galerIA.modelo.Vendedores;
import com.galerIA.galerIA.others.ProductosEmbeddable;
import com.galerIA.galerIA.others.ProductosRequest;
import com.galerIA.galerIA.services.ProductosServices;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "http://localhost:5174") // Permite solicitudes desde tu cliente Vue

public class ProductosController {

    private final ProductosServices productosServices;

    public ProductosController(ProductosServices productosServices) {
        this.productosServices = productosServices;
    }

    //INSERTA
    @PostMapping
    public Productos insertaProductos(@RequestBody Productos productos){
        return productosServices.insertaProducto(productos);
    }

    //ACTUALIZA
    @PutMapping
    public Productos actualizaProducto(@RequestBody ProductosRequest productosRequest){
        return productosServices.actualizaProducto(productosRequest.getProductos());
    }

    //ACTIALIZA_2
    /*Se debe preguntar porque normalmente recibe dato de busqueda, seguido del objeto a actualizar,
    * La cosa es que por la forma de esta tabla se debe recibir objeto para la busqueda y no dato*/

    //BORRA
    @DeleteMapping
    public String borraProducto(@RequestBody ProductosEmbeddable productosEmbeddable){
        try {
            productosServices.borraProducto(productosEmbeddable);
            return "Se ha borrado de forma correcta el producto: "+ productosEmbeddable.getCuenta() + productosEmbeddable.getProducto();
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado error al eliminar producto (Controlador) "+ productosEmbeddable.getCuenta() + productosEmbeddable.getProducto() + " "+e);
        }
    }

    //CONSULTA
    @GetMapping
    public List<Productos> consultaProductos(){
        return productosServices.consultaProducto();
    }

    //CONSULTA ID
    @PostMapping("/id")
    public Optional<Productos> consultaProductosId(@RequestBody ProductosEmbeddable productosEmbeddable){
        return productosServices.consultaProductosId(productosEmbeddable);
    }

}
