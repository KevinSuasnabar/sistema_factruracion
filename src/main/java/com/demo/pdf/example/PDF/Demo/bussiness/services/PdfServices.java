package com.demo.pdf.example.PDF.Demo.bussiness.services;

import com.demo.pdf.example.PDF.Demo.bussiness.builder.PdfBuilder;
import com.demo.pdf.example.PDF.Demo.bussiness.builder.PdfTableBuilder;
import com.demo.pdf.example.PDF.Demo.models.entity.Cliente;
import com.demo.pdf.example.PDF.Demo.models.entity.Factura;
import com.demo.pdf.example.PDF.Demo.models.entity.FacturaLine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.util.List;

@Service
public class PdfServices {

    private static final String[] TABLE_COLUMNS_HEADERS = {" - ","Nom. Prod ","Precio uni.","Cant."," Sub. total"};
    private static final String[] TABLE_COLUMNS_HEADERS_INVOICES = {" ", "Desc.", "Price", "Ud.", "€"};

    private static final float[] TABLE_COLUMNS_SIZES_TICKETS = {20, 100,25,25,50};
    private static final float[] TABLE_COLUMNS_SIZES_BUDGETS = {15, 90, 15, 25, 35, 15};
    private static final float[] TABLE_COLUMNS_SIZES_INVOICES = {15, 90, 35, 15, 35};

    public static final String USER_HOME = "user.home";
    public static final String PDF_FILE_EXT = ".pdf";

    private FileService fileService;

    @Value("${mi.company.logo}")
    private String logo;
    @Value("${mi.company.web}")
    private String web;
    @Value("${mi.company.phone}")
    private String phone;
    @Value("${mi.company.address}")
    private String direccion;
    @Value("${mi.company.email}")
    private String email;
    @Value("${mi.company.name}")
    private String nombre;

    private void addHead(PdfBuilder pdf) {
        pdf.image(this.logo).paragraphEmphasized("   "+this.nombre)
                .paragraph("Contacto: " + this.phone + "   -   " + this.direccion)
                .paragraph("Email: " + this.email + "  -  " + "Web: " + this.web);
        pdf.line();
    }

    private void addCostumerHead(PdfBuilder pdf, Cliente cliente) {
        pdf.paragraphEmphasized("COSTUMER");
        pdf.paragraphEmphasized(cliente.getNombres())
                .paragraph("DNI: " + cliente.getId());
                //.paragraph("Email: " + cliente.ge());
        pdf.line();
    }

    /*private void addBookingDetails(PdfBuilder pdf, int notCommitted, Ticket ticket) {
        if (notCommitted > 0) {
            pdf.paragraphEmphasized("Items pending delivery: " + notCommitted);
            if (ticket.getUser() != null) {
                pdf.paragraph("Contact phone: " + ticket.getUser().getMobile() + " - " + ticket.getUser().getUsername().substring(0,
                        (ticket.getUser().getUsername().length() > 10) ? 10 : ticket.getUser().getUsername().length()));
            }
            pdf.qrCode(ticket.getReference());
        }
    }*/

    /*private void addVoucherValue(PdfBuilder pdf, Voucher voucher) {
        pdf.paragraphEmphasized(voucher.getValue() + " €")
                .paragraphEmphasized(" ").line();
    }*/

    private void addFoot(PdfBuilder pdf) {
        pdf.line().paragraph("Items can be returned within 15 days of shopping");
        pdf.paragraphEmphasized("Thanks for your visit and please send us your suggestions to help us improve this service")
                .paragraphEmphasized(" ").line();
    }

    private void addFootVoucher(PdfBuilder pdf) {
        pdf.line().paragraph("Voucher can be used within 30 days after its creation");
        pdf.paragraphEmphasized("Thanks for your visit and please send us your suggestions to help us improve this service")
                .paragraphEmphasized(" ").line();
    }
    public byte[] generateVoucher(String path, Factura factura) {
        PdfBuilder pdf = new PdfBuilder(path);
        this.addHead(pdf);
        this.addCostumerHead(pdf,factura.getCliente());
        pdf.paragraph("BOLETA :");
        pdf.barCode(factura.getCodigoGenerado());
        PdfTableBuilder table = pdf.table(TABLE_COLUMNS_SIZES_TICKETS).tableColumnsHeader(TABLE_COLUMNS_HEADERS);
        for (int i = 0; i < factura.getItems().size(); i++) {
            FacturaLine fi = factura.getItems().get(i);
            table.tableCell(String.valueOf(i + 1),fi.getProducto().getNombre(),
                    String.valueOf(fi.getProducto().getPrecio()),
                    String.valueOf(fi.getCantidad()),String.valueOf(fi.getTotalPrice()));
        }
        table.tableColspanRight(factura.getTotal()+ " €").build();
        table.build();
        this.addFootVoucher(pdf);
        return pdf.build();

    }

    public byte[] readPdf(String filepath) {
        return fileService.read(System.getProperty(PdfBuilder.USER_HOME) + filepath + PdfBuilder.PDF_FILE_EXT);
    }
}
