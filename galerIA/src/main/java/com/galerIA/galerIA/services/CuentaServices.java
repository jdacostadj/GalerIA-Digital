package com.galerIA.galerIA.services;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.galerIA.galerIA.modelo.Cuenta;
import com.galerIA.galerIA.repository.CuentaRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.security.Key;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.util.ReflectionUtils.findField;
import static org.springframework.util.ReflectionUtils.setField;

@Service

public class CuentaServices {

    private CuentaRepository cuentaRepository;

    public CuentaServices(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    //INSERTA
    public Cuenta insertaCuenta(Cuenta cuenta){
        try{
            if (cuentaRepository.existsById(cuenta.getCuenta())){
                throw new RuntimeException("Fallo al insertar cuenta: "+ cuenta.getCuenta());
            }
            return cuentaRepository.save(cuenta);
        } catch (Exception e) {
            throw new RuntimeException("Fallo al insertar cuenta: "+ e);
        }
    }

    //ACTUALIZA
    public Cuenta actualizaCuenta (String id, Cuenta cuenta){
        try {
            cuenta.setContrasena(cuenta.getContrasena());
            cuenta.setRol(cuenta.getRol());

            return cuentaRepository.save(cuenta);

        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar cuenta: "+ id + " " +e);
        }

    }

    //ACTUALIZA_2

    public Cuenta actualizaCuentaCampo(String id, Map<String,Object> cambios){

        Cuenta regActualiza = cuentaRepository.findById(id).orElseThrow(()-> new RuntimeException("Error al actualizar por id"));

        cambios.forEach((key, value) -> {
            Field field;

            field = findField(Cuenta.class, key);
            field.setAccessible(true);
            setField(field, regActualiza, value);
        });
        return cuentaRepository.save(regActualiza);
    }

    //BORRAR
    public void borraCuenta(String id) {

        try{
            cuentaRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Fallo al eliminar cuenta: "+ id +" "+ e);
        }
    }

    //CONSULTA
    public List<Cuenta> consultaCuenta(){
        try{
            return cuentaRepository.findAll();
        }
        catch (Exception e) {
            throw new RuntimeException("Fallo al realizar consulta: "+ e);
        }

    }

    //CONSULTA_ID
    public Optional<Cuenta> consultaCuentaId(String id){
        try{
            return cuentaRepository.findById(id);
        }
        catch (Exception e) {
            throw new RuntimeException("Fallo al realizar consulta: "+ e);
        }
    }

}
