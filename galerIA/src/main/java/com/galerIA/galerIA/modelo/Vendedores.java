package com.galerIA.galerIA.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "vendedores")

public class Vendedores {

    @Id
    @Column(name = "cod_docum_vendedor")
    private String documento;

    @OneToOne
    @JoinColumn(name = "id_cuenta")
    private Cuenta cuenta;

    @Column(name = "nom_vendedor", nullable = false)
    private String nombreApellido;

    @Column(name = "corrreo_vendedor", nullable = false)
    private String correo;

    @Column(name = "celular_vendedor")
    private int celular;

    @Column(name = "direccion_vendedor")
    private String direccion;

    public Vendedores(String documento, Cuenta cuenta, String nombreApellido, String correo, int celular, String direccion) {
        this.documento = documento;
        this.cuenta = cuenta;
        this.nombreApellido = nombreApellido;
        this.correo = correo;
        this.celular = celular;
        this.direccion = direccion;
    }

    public Vendedores() {
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
