package com.demo.pdf.example.PDF.Demo.controllers;

import com.demo.pdf.example.PDF.Demo.bussiness.services.PdfServices;
import com.demo.pdf.example.PDF.Demo.models.entity.Cliente;
import com.demo.pdf.example.PDF.Demo.models.entity.Factura;
import com.demo.pdf.example.PDF.Demo.models.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/v0")
public class PdfController {

    @Autowired
    private PdfServices pdfServices;

    @Autowired
    private IClienteService clienteService;


    public static final String PDFS = "/spring/pdfs/boleta";

    @PostMapping(produces = {"application/pdf", "application/json"})
    public byte[] pdf(@RequestBody Factura factura) {

        return  pdfServices.generateVoucher(PdfController.PDFS,factura);

    }
}
