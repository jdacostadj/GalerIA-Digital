package com.galerIA.galerIA.services;

import com.galerIA.galerIA.modelo.Vendedores;
import com.galerIA.galerIA.repository.CuentaRepository;
import com.galerIA.galerIA.repository.VendedoresRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.util.ReflectionUtils.findField;
import static org.springframework.util.ReflectionUtils.setField;

@Service

public class VendedoresServices {

    public VendedoresRepository vendedoresRepository;
    public CuentaRepository cuentaRepository;

    public VendedoresServices(VendedoresRepository vendedoresRepository, CuentaRepository cuentaRepository) {
        this.vendedoresRepository = vendedoresRepository;
        this.cuentaRepository = cuentaRepository;
    }

    //INSERTA
    public Vendedores insertaVendedor(Vendedores vendedores){
        try {
            cuentaRepository.findById(vendedores.getCuenta().getCuenta()).orElseThrow(()->new RuntimeException("Error al buscar cuenta"));
            return vendedoresRepository.save(vendedores);
        } catch (Exception e) {
            throw new RuntimeException("Error al insertar vendedor: "+ e);
        }
    }

    //ACTUALIZA GENERAL
    public Vendedores actualizaVendedor(String cedula, Vendedores vendedores){
        try {
            vendedores.setCelular(vendedores.getCelular());
            vendedores.setCorreo(vendedores.getCorreo());
            vendedores.setCuenta(vendedores.getCuenta());
            vendedores.setDireccion(vendedores.getDireccion());
            vendedores.setDocumento(vendedores.getDocumento());
            vendedores.setNombreApellido(vendedores.getNombreApellido());

            return vendedoresRepository.save(vendedores);
        } catch (Exception e) {
            throw new RuntimeException("Falló al actualizar el vendedor:  "+ cedula + " " + e);
        }
    }

    //ACTUALIZA_2
    public Vendedores actualizaVendedoresCampo(String cedula, Map<String,Object> cambios){

        Vendedores regActualiza = vendedoresRepository.findById(cedula).orElseThrow(()-> new RuntimeException("Error al actualizar por cedula"));

        cambios.forEach((key, value) -> {
            Field field;

            field = findField(Vendedores.class, key);
            field.setAccessible(true);
            setField(field, regActualiza, value);
        });
        return vendedoresRepository.save(regActualiza);
    }

    //ELIMINA
    public void borraVendedor(String cedula){
        try{
            vendedoresRepository.deleteById(cedula);
        } catch (Exception e) {
            throw new RuntimeException("Falló al eliminar el vendedor: " +cedula+ " " + e);
        }

    }


    //CONSULTA
    public List<Vendedores> consultaVendedores(){
        try {
            return vendedoresRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al consultar vendedor: "+e);
        }
    }

    //CONSULTA CEDULA
    public Optional<Vendedores> consultaVendedorCedula(String cedula){
        try {
            return vendedoresRepository.findById(cedula);
        } catch (Exception e) {
            throw new RuntimeException("Error al consultar vendedor: "+ cedula+ " " +e);
        }
    }

}
