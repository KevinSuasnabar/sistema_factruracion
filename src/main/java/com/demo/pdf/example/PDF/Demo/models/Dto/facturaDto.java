package com.demo.pdf.example.PDF.Demo.models.Dto;

import com.demo.pdf.example.PDF.Demo.models.entity.Factura;
import com.demo.pdf.example.PDF.Demo.models.entity.FacturaLine;

import java.util.List;

public class facturaDto {

    private List<FacturaLine> items;

    private Long idUsuario;

    private String descripcion;

    private String codigoGenerado;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoGenerado() {
        return codigoGenerado;
    }

    public void setCodigoGenerado(String codigoGenerado) {
        this.codigoGenerado = codigoGenerado;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<FacturaLine> getItems() {
        return items;
    }

    public void setItems(List<FacturaLine> items) {
        this.items = items;
    }

}
