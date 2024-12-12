package com.galerIA.galerIA.modelo;

import com.galerIA.galerIA.others.ProductosEmbeddable;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "productos")

public class Productos {

    @EmbeddedId
    private ProductosEmbeddable productoId;

    @Column(name = "nom_producto", nullable = false)
    private String nombreProducto;

    @Column(name = "categoria_producto")
    private String categoriaProducto;

    @Column(name = "cantidad_producto", nullable = false)
    private int cantidadProducto;

    @Column(name = "val_producto", nullable = false)
    private int precioProducto;

    public Productos() {
    }

    public Productos(ProductosEmbeddable productoId, String nombreProducto, String categoriaProducto, int cantidadProducto, int precioProducto) {
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.categoriaProducto = categoriaProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioProducto = precioProducto;
    }

    public ProductosEmbeddable getProductoId() {
        return productoId;
    }

    public void setProductoId(ProductosEmbeddable productoId) {
        this.productoId = productoId;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }
}