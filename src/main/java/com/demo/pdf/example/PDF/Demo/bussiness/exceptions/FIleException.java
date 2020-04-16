package com.demo.pdf.example.PDF.Demo.bussiness.exceptions;

public class FIleException extends  RuntimeException{

    private static final String DESCRIPTION = "File exception";

    public FIleException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

}
