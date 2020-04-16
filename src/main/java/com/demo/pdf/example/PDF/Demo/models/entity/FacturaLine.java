package com.demo.pdf.example.PDF.Demo.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "lineas_facturas")
public class FacturaLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "sub_total")
    //private Double sub_total;

    private Integer cantidad;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "factura_id")
    private Factura factura;

    public FacturaLine( Producto producto, Factura factura,Integer cantidad) {
        //this.sub_total = sub_total;
        this.producto = producto;
        this.factura = factura;
        this.cantidad=cantidad;
    }

    public FacturaLine() {
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public Double getSub_total() {
        return sub_total;
    }

    public void setSub_total(Double precio) {
        this.sub_total = precio;
    }*/

    @JsonIgnoreProperties({"producto","hibernateLazyInitializer","handler"})
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @JsonIgnoreProperties({"items","hibernateLazyInitializer","handler"})
    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    //para calcular el importe
    public Double getTotalPrice() {
        return getProducto().getPrecio()*getCantidad();
    }
}
