package com.demo.pdf.example.PDF.Demo.bussiness.services;

import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
public class PdfServices {

    private static final String[] TABLE_COLUMNS_HEADERS = {" ", "Desc.", "Ud.", "Dto.%", "€", "E."};
    private static final String[] TABLE_COLUMNS_HEADERS_INVOICES = {" ", "Desc.", "Price", "Ud.", "€"};

    private static final float[] TABLE_COLUMNS_SIZES_TICKETS = {15, 90, 15, 25, 35, 15};
    private static final float[] TABLE_COLUMNS_SIZES_BUDGETS = {15, 90, 15, 25, 35, 15};
    private static final float[] TABLE_COLUMNS_SIZES_INVOICES = {15, 90, 35, 15, 35};

    public static final String USER_HOME = "user.home";
    public static final String PDF_FILE_EXT = ".pdf";

    String name="HOLA MUNDO";
    String phone="992439534";

    private void addHead(PdfBuilder pdf) {
        pdf.paragraphEmphasized(this.name).paragraphEmphasized("Tfn: " + this.phone);
        pdf.line();
    }

    public byte[] generateVoucher(String path) {
        PdfBuilder pdf = new PdfBuilder(path);
        this.addHead(pdf);
        return pdf.build();

    }
}
