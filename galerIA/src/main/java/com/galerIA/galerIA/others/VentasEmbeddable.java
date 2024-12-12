package com.galerIA.galerIA.others;

import com.galerIA.galerIA.modelo.Productos;
import jakarta.persistence.*;

@Embeddable

public class VentasEmbeddable {

    // Se crea metodo para contener las dos PK de tabla Ventas

    @Column(name = "id_factura")
    private String factura;

    @ManyToOne(cascade = CascadeType.PERSIST)  // Cascada de persistencia para asegurar funcionamiento
    @JoinColumns({
            @JoinColumn(name = "id_producto", referencedColumnName = "id_producto"),
            @JoinColumn(name = "id_cuenta", referencedColumnName = "id_cuenta")
    })
    private Productos productoId;

    public VentasEmbeddable() {
    }

    public VentasEmbeddable(String factura, Productos productoId) {
        this.factura = factura;
        this.productoId = productoId;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public Productos getProductoId() {
        return productoId;
    }

    public void setProductoId(Productos productoId) {
        this.productoId = productoId;
    }
}
