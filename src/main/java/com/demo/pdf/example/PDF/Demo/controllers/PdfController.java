package com.demo.pdf.example.PDF.Demo.controllers;

import com.demo.pdf.example.PDF.Demo.bussiness.services.PdfServices;
import com.demo.pdf.example.PDF.Demo.models.entity.Cliente;
import com.demo.pdf.example.PDF.Demo.models.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v0")
public class PdfController {

    @Autowired
    private PdfServices pdfServices;

    @Autowired
    private IClienteService clienteService;


    public static final String PDFS = "/spring/pdfs/a1";

    @GetMapping(produces = {"application/pdf", "application/json"})
    public byte[] pdf() {

        List<Cliente> clientes=clienteService.getAllCustomers();

    byte[] a=pdfServices.generateVoucher(PdfController.PDFS,clientes);

        return a;
    }
}
