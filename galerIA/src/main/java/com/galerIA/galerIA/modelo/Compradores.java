package com.galerIA.galerIA.modelo;

import jakarta.persistence.*;


@Entity
@Table(name = "compradores")
public class Compradores {

    @Id
    @Column(name = "cod_docum_comprador")
    private String documento;

    @OneToOne
    @JoinColumn(name = "id_cuenta", referencedColumnName = "id_cuenta")
    private Cuenta cuenta;

    @Column(name = "nom_comprador", nullable = false)
    private String nombreApellido;

    @Column(name = "corrreo_comprador", nullable = false)
    private String correo;

    @Column(name = "celular_comprador")
    private int celular;

    @Column(name = "direccion_comprador")
    private String direccion;


    public Compradores(String documento, Cuenta cuenta, String nombreApellido, String correo, int celular, String direccion) {
        this.documento = documento;
        this.cuenta = cuenta;
        this.nombreApellido = nombreApellido;
        this.correo = correo;
        this.celular = celular;
        this.direccion = direccion;
    }

    public Compradores() {
    }

    public Compradores(String documento) {
        this.documento = documento;
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