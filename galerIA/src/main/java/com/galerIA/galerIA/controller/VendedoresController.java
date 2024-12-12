package com.galerIA.galerIA.controller;

import com.galerIA.galerIA.modelo.Compradores;
import com.galerIA.galerIA.modelo.Vendedores;
import com.galerIA.galerIA.services.VendedoresServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/vendedores")
@CrossOrigin(origins = "http://localhost:5174") // Permite solicitudes desde tu cliente Vue

public class VendedoresController {

    private final VendedoresServices vendedoresServices;

    public VendedoresController(VendedoresServices vendedoresServices) {
        this.vendedoresServices = vendedoresServices;
    }

    //INSERTA
    @PostMapping
    public Vendedores insertaVendedor(@RequestBody Vendedores vendedores){
        return vendedoresServices.insertaVendedor(vendedores);
    }

    //ACTUALIZA
    @PutMapping("/{cedula}")

    public Vendedores actualizaVendedor(@PathVariable String cedula, @RequestBody Vendedores vendedores){

        System.out.println("JD: cedula=>"+ cedula);
        System.out.println("JD: getDocumento=>"+ vendedores.getDocumento());
        System.out.println("JD: getCuenta=>"+vendedores.getCuenta().getCuenta());
        System.out.println("JD: getNombreApellido=>"+ vendedores.getNombreApellido());
        System.out.println("JD: getDireccion=>"+ vendedores.getDireccion());
        System.out.println("JD: getCorreo=>"+ vendedores.getCorreo());
        System.out.println("JD: getCelular=>"+ vendedores.getCelular());

        return vendedoresServices.actualizaVendedor(cedula,vendedores);
    }

    //ACTUALIZA_2
    @PatchMapping("/{cedula}")
    public Vendedores actualizaVendedorCampo(@PathVariable String cedula, @RequestBody Map<String,Object> cambios){
        Vendedores regActualiza = vendedoresServices.actualizaVendedoresCampo(cedula, cambios);
        return ResponseEntity.ok(regActualiza).getBody();
    }

    //BORRA
    @DeleteMapping("/{cedula}")
    public String borraVendedor(@PathVariable String cedula){
        try {
            vendedoresServices.borraVendedor(cedula);
            return "Se ha borrado de forma correcta el comprador: "+ cedula;
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado error al eliminar comprador (Controlador) "+ cedula + " "+e);
        }
    }

    //CONSULTA
    @GetMapping
    public List<Vendedores> consultaVendedores(){
        return vendedoresServices.consultaVendedores();
    }

    //CONSULTA CEDULA
    @GetMapping("/{cedula}")
    public Optional<Vendedores> consultaVendedorCedula(@PathVariable String cedula){

        System.out.println("JD: consultaVendedorCedula cedula=>"+ cedula);
        return vendedoresServices.consultaVendedorCedula(cedula);
    }

}
