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

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id") // para no generar una tercera tabla indicamos el id que ira en la tabla facturas
    private Cliente cliente;

    public Factura(String codigoGenerado, Double monto,Cliente cliente) {
        this.codigoGenerado = codigoGenerado;
        this.monto = monto;
        this.cliente=cliente;
    }

    public Factura(){}

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

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
