package com.galerIA.galerIA.others;

import com.galerIA.galerIA.modelo.Cuenta;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
@Embeddable
public class ProductosEmbeddable {

    // Se crea metodo para contener las dos PK de tabla productos

    @Column(name = "id_producto")
    private String producto;

    @ManyToOne
    @JoinColumn(name = "id_cuenta")
    private Cuenta cuenta;

    public ProductosEmbeddable() {
    }

    public ProductosEmbeddable(String producto, Cuenta cuenta) {
        this.producto = producto;
        this.cuenta = cuenta;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
