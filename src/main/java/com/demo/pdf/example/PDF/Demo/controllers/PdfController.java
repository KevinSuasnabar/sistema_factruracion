package com.demo.pdf.example.PDF.Demo.controllers;

import com.demo.pdf.example.PDF.Demo.bussiness.services.PdfBuilder;
import com.demo.pdf.example.PDF.Demo.bussiness.services.PdfServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/v0")
public class PdfController {

    @Autowired
    private PdfServices pdfServices;


    public static final String PDFS = "/spring/pdfs/a1";

    @GetMapping(produces = {"application/pdf", "application/json"})
    public byte[] pdf() {

    byte[] a=pdfServices.generateVoucher(PdfController.PDFS);

        return a;
    }
}
