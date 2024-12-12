package com.galerIA.galerIA.others;

import com.galerIA.galerIA.modelo.Productos;

public class ProductosRequest {
    private ProductosEmbeddable productosEmbeddable;
    private Productos productos;

    public ProductosRequest(ProductosEmbeddable productosEmbeddable, Productos productos) {
        this.productosEmbeddable = productosEmbeddable;
        this.productos = productos;
    }

    public ProductosRequest() {
    }

    public ProductosEmbeddable getProductosEmbeddable() {
        return productosEmbeddable;
    }

    public void setProductosEmbeddable(ProductosEmbeddable productosEmbeddable) {
        this.productosEmbeddable = productosEmbeddable;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }
}
