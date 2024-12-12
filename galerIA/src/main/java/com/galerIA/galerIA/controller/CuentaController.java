package com.galerIA.galerIA.controller;

import com.galerIA.galerIA.modelo.Cuenta;
import com.galerIA.galerIA.services.CuentaServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/cuenta")
@CrossOrigin(origins = "http://localhost:5174") // Permite solicitudes desde tu cliente Vue

public class CuentaController {

    private final CuentaServices cuentaServices;

    public CuentaController(CuentaServices cuentaServices) {
        this.cuentaServices = cuentaServices;
    } 

    //INSERTA
    @PostMapping
    public ResponseEntity<?> insertaCuenta(@RequestBody Cuenta cuenta){
        try {
            Cuenta cuentaNueva = cuentaServices.insertaCuenta(cuenta);
            return ResponseEntity.status(HttpStatus.CREATED).body(cuentaNueva);
        }catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    //ACTUALIZA
    @PutMapping("/{id}")
    public Cuenta actualizaCuenta(@PathVariable String id, @RequestBody Cuenta cuenta){
        return cuentaServices.actualizaCuenta(id, cuenta);
    }

    //ACTUALIZA_2
    @PatchMapping("/{id}")
    public Cuenta actualizaCuentaCampo(@PathVariable String id, @RequestBody Map<String,Object> cambios){
        Cuenta regActualiza = cuentaServices.actualizaCuentaCampo(id, cambios);
        return ResponseEntity.ok(regActualiza).getBody();
    }

    //BORRAR
    @DeleteMapping("/{id}")
    public String borraCuenta(@PathVariable String id){
        try {
            cuentaServices.borraCuenta(id);
            return "Se ha borrado de forma correcta la cuenta: "+ id;
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado error al eliminar cuenta (Controlador) "+ id + " "+ e);
        }
    }

    //CONSULTA
    @GetMapping
    public List<Cuenta> consultaCuenta(){
        return cuentaServices.consultaCuenta();
    }

    //CONSULTA_ID
    @GetMapping("/{id}")
    public Optional<Cuenta> consultaCuentaId(@PathVariable String id){
        return cuentaServices.consultaCuentaId(id);
    }


}
