package com.galerIA.galerIA.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentas")
public class Cuenta {

    @Id
    @Column(name = "id_cuenta")
    private String cuenta;

    @Column(name = "contrasena_cuenta", nullable = false)
    private String contrasena;

    @Column(name = "rol_cuenta", nullable = false)
    private String rol;

    public Cuenta(String cuenta, String contrasena, String rol) {
        this.cuenta = cuenta;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public Cuenta() {
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
