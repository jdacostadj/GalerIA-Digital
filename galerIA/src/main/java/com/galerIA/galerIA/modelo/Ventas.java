package com.galerIA.galerIA.modelo;

import com.galerIA.galerIA.others.VentasEmbeddable;
import jakarta.persistence.*;

@Entity
@Table(name = "ventas")

public class Ventas {

    @EmbeddedId
    private VentasEmbeddable ventaId;

    @Column(name = "nom_producto", nullable = false)
    private String nombreProducto;

    @Column(name = "cantidad_producto", nullable = false)
    private int cantidadProducto;

    @ManyToOne
    @JoinColumn(name = "cod_docum_comprador")
    private Compradores compradores;

    @Column(name = "total_venta")
    private int totalVenta;

    public Ventas() {
    }

    public Ventas(VentasEmbeddable ventaId, String nombreProducto, int cantidadProducto, Compradores compradores, int totalVenta) {
        this.ventaId = ventaId;
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.compradores = compradores;
        this.totalVenta = totalVenta;
    }

    public VentasEmbeddable getVentaId() {
        return ventaId;
    }

    public void setVentaId(VentasEmbeddable ventaId) {
        this.ventaId = ventaId;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Compradores getCompradores() {
        return compradores;
    }

    public void setCompradores(Compradores compradores) {
        this.compradores = compradores;
    }

    public int getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(int totalVenta) {
        this.totalVenta = totalVenta;
    }
}
