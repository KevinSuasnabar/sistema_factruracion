package com.demo.pdf.example.PDF.Demo.bussiness.services;

public class PdfException extends RuntimeException{

    private static final String DESCRIPTION = "Pdf. File exception";

    public PdfException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
}
