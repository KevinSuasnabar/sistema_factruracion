package com.demo.pdf.example.PDF.Demo.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "facturas")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_generado")
    private String codigoGenerado;

    private String descripcion;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id") // para no generar una tercera tabla indicamos el id que ira en la tabla facturas
    private Cliente cliente;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "factura")
    private List<FacturaLine> items;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_at")
    private Date createAt;

    public Factura(Long id, String codigoGenerado, String descripcion, Cliente cliente, List<FacturaLine> items, Date createAt) {
        this.id = id;
        this.codigoGenerado = codigoGenerado;
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.items = items;
        this.createAt = createAt;
    }

    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
    }

    public Factura(){}

    @JsonIgnoreProperties({"factura","hibernateLazyInitializer","handler"})
    public List<FacturaLine> getItems() {
        return items;
    }

    public void setItems(List<FacturaLine> items) {
        this.items = items;
    }

    @JsonIgnoreProperties({"facturas","hibernateLazyInitializer","handler"})
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public Double getTotal() {
        Double total = 0.0;

        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getTotalPrice();
        }

        return total;
    }

}
