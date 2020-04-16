package com.demo.pdf.example.PDF.Demo.controllers;

import com.demo.pdf.example.PDF.Demo.models.entity.Factura;
import com.demo.pdf.example.PDF.Demo.models.services.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v0")
public class ClienteController {

    private static final String CLIENTES="/facturas";

    @Autowired
    private IFacturaService facturaService;


    @GetMapping(CLIENTES)
    public List<Factura> getFacturas(){
        return facturaService.getAllInvoices();
    }
}
