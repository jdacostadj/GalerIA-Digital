package com.galerIA.galerIA.controller;

import com.galerIA.galerIA.modelo.Compradores;
import com.galerIA.galerIA.modelo.Cuenta;
import com.galerIA.galerIA.services.CompradoresServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/compradores")
@CrossOrigin(origins = "http://localhost:5174") // Permite solicitudes desde tu cliente Vue

public class CompradoresController {

    private final CompradoresServices compradoresServices;

    public CompradoresController(CompradoresServices compradoresServices) {
        this.compradoresServices = compradoresServices;
    }

    //INSERTA
    @PostMapping
    public Compradores insertacomprador(@RequestBody Compradores compradores){
        return compradoresServices.insertaComprador(compradores);
    }

    //ACTUALIZA
    @PutMapping("/{cedula}")
    public Compradores actualizaComprador(@PathVariable String cedula, @RequestBody Compradores compradores){

        return compradoresServices.actualizaComprado(cedula,compradores);
    }

    //ACTUALIZA_2
    @PatchMapping("/{cedula}")
    public Compradores actualizaCompradorCampo(@PathVariable String cedula, @RequestBody Map<String,Object> cambios){
        Compradores regActualiza = compradoresServices.actualizaCompradoresCampo(cedula, cambios);
        return ResponseEntity.ok(regActualiza).getBody();
    }

    //BORRA
    @DeleteMapping("/{cedula}")
    public String borraComprador(@PathVariable String cedula){
        try {
            compradoresServices.borraComprador(cedula);
            return "Se ha borrado de forma correcta el comprador: "+ cedula;
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado error al eliminar comprador (Controlador) "+ cedula + " "+e);
        }
    }

    //CONSULTA GENERAL
    @GetMapping
    public List<Compradores> consultaCompradores(){
        return compradoresServices.consultaComprador();
    }

    //CONSULTA CEDULA
    @GetMapping("/{cedula}")
    public Optional<Compradores> consultaCompradorCedula(@PathVariable String cedula){
        return compradoresServices.consultaCompradorCedula(cedula);
    }

}
