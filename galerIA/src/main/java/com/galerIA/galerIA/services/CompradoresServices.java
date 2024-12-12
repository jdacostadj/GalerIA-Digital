package com.galerIA.galerIA.services;

import com.galerIA.galerIA.modelo.Compradores;
import com.galerIA.galerIA.modelo.Cuenta;
import com.galerIA.galerIA.repository.CompradoresRepository;
import com.galerIA.galerIA.repository.CuentaRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.util.ReflectionUtils.findField;
import static org.springframework.util.ReflectionUtils.setField;

@Service

public class CompradoresServices {

    private CompradoresRepository compradoresRepository;
    private CuentaRepository cuentaRepository;

    public CompradoresServices(CompradoresRepository compradoresRepository, CuentaRepository cuentaRepository) {
        this.compradoresRepository = compradoresRepository;
        this.cuentaRepository = cuentaRepository;
    }

    //INSERTA
    public Compradores insertaComprador(Compradores compradores){
        try {
            cuentaRepository.findById(compradores.getCuenta().getCuenta()).orElseThrow(()->new RuntimeException("Error al buscar cuenta"));
            return compradoresRepository.save(compradores);
        } catch (Exception e) {
            throw new RuntimeException("Falló al insertar el comprador: "+ e);
        }
    }

    //ACTUALIZA GENERAL
    public Compradores actualizaComprado(String cedula, Compradores compradores){
        try {
            compradores.setCelular(compradores.getCelular());
            compradores.setCorreo(compradores.getCorreo());
            compradores.setCuenta(compradores.getCuenta());
            compradores.setDireccion(compradores.getDireccion());
            compradores.setDocumento(compradores.getDocumento());
            compradores.setNombreApellido(compradores.getNombreApellido());

            return compradoresRepository.save(compradores);
        } catch (Exception e) {
            throw new RuntimeException("Falló al actualizar el comprador:  "+ cedula + " " + e);
        }
    }

    //ACTUALIZA_2

    public Compradores actualizaCompradoresCampo(String cedula, Map<String,Object> cambios){

        Compradores regActualiza = compradoresRepository.findById(cedula).orElseThrow(()-> new RuntimeException("Error al actualizar por cedula"));

        cambios.forEach((key, value) -> {
            Field field;

            field = findField(Compradores.class, key);
            field.setAccessible(true);
            setField(field, regActualiza, value);
        });
        return compradoresRepository.save(regActualiza);
    }

    //ELIMINA
    public void borraComprador(String cedula){
        try{
            compradoresRepository.deleteById(cedula);
        } catch (Exception e) {
            throw new RuntimeException("Falló al eliminar el comprador: " +cedula+ " " + e);
        }

    }

    //CONSULTA
    public List<Compradores> consultaComprador(){
        try {
            return compradoresRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Falló al consultar compradores: " + e);
        }
    }

    //CONSULTA CEDULA
    public Optional<Compradores> consultaCompradorCedula(String cedula){
        try {
            return compradoresRepository.findById(cedula);
        } catch (Exception e) {
            throw new RuntimeException("Falló al consultar comprador: " +cedula+ " " + e);
        }
    }

}
