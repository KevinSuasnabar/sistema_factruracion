package com.demo.pdf.example.PDF.Demo.models.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "contactos")
    private List<String> contacto;

    private String nombres;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "cliente")
    private List<Factura> facturas;

    @Embedded
    private Direccion direccion;

    public Cliente() {
    }

    public Cliente(List<String> contacto, String nombres, List<Factura> facturas, Direccion direccion) {
        this.contacto = contacto;
        this.nombres = nombres;
        this.facturas = facturas;
        this.direccion = direccion;
    }

    public Cliente(List<String> contacto, String nombres,Direccion direccion) {
        this.contacto = contacto;
        this.nombres = nombres;
        this.direccion = direccion;
    }

    public List<String> getContacto() {
        return contacto;
    }

    public void setContacto(List<String> contacto) {
        this.contacto = contacto;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void addContacto(String phone){
        if(this.contacto==null){
            this.contacto=new ArrayList<>();
        }
        this.contacto.add(phone);
    }

}
