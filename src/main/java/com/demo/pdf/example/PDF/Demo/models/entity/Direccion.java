package com.demo.pdf.example.PDF.Demo.models.entity;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import java.util.List;

@Embeddable
public class Direccion {

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable
    private List<String> referencias;

    private String calle;

    public Direccion(List<String> referencias,String calle){
        this.calle=calle;
        this.referencias=referencias;
    }
    public Direccion(){}

    public List<String> getReferencias() {
        return referencias;
    }

    public String getCalle() {
        return calle;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "referencias=" + referencias +
                ", calle='" + calle + '\'' +
                '}';
    }
}
