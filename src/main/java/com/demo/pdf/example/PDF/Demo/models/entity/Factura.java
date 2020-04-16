package com.demo.pdf.example.PDF.Demo.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "facturas")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_generado")
    private String codigoGenerado;

    private Double monto;

    public Factura(String codigoGenerado, Double monto) {
        this.codigoGenerado = codigoGenerado;
        this.monto = monto;
    }

    public Factura(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoGenerado() {
        return codigoGenerado;
    }

    public void setCodigoGenerado(String codigoGenerado) {
        this.codigoGenerado = codigoGenerado;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", codigoGenerado='" + codigoGenerado + '\'' +
                ", monto=" + monto +
                '}';
    }
}
