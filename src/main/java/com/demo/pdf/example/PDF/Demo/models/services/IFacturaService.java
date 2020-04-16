package com.demo.pdf.example.PDF.Demo.models.services;


import com.demo.pdf.example.PDF.Demo.models.entity.Factura;

import java.util.List;

public interface IFacturaService {

    public List<Factura> getAllInvoices();

    public Factura createInvoice(Factura factura);

    public Factura findOneFactura(Long id);

    public Factura updateFactura(Factura factura);
}
