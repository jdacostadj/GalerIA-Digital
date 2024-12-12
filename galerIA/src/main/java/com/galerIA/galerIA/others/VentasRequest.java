package com.galerIA.galerIA.others;

import com.galerIA.galerIA.modelo.Ventas;

public class VentasRequest {

    private VentasEmbeddable ventasEmbeddable;
    private Ventas ventas;

    public VentasRequest(VentasEmbeddable ventasEmbeddable, Ventas ventas) {
        this.ventasEmbeddable = ventasEmbeddable;
        this.ventas = ventas;
    }

    public VentasRequest() {
    }

    public VentasEmbeddable getVentasEmbeddable() {
        return ventasEmbeddable;
    }

    public void setVentasEmbeddable(VentasEmbeddable ventasEmbeddable) {
        this.ventasEmbeddable = ventasEmbeddable;
    }

    public Ventas getVentas() {
        return ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }
}
