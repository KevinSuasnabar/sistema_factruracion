package com.demo.pdf.example.PDF.Demo.bussiness.services;

import com.demo.pdf.example.PDF.Demo.bussiness.builder.PdfBuilder;
import com.demo.pdf.example.PDF.Demo.bussiness.builder.PdfTableBuilder;
import com.demo.pdf.example.PDF.Demo.models.entity.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PdfServices {

    private static final String[] TABLE_COLUMNS_HEADERS = {"ID","NOMBRES","CALLE","REFEREMCIAS"};
    private static final String[] TABLE_COLUMNS_HEADERS_INVOICES = {" ", "Desc.", "Price", "Ud.", "€"};

    private static final float[] TABLE_COLUMNS_SIZES_TICKETS = {25, 100,100,100};
    private static final float[] TABLE_COLUMNS_SIZES_BUDGETS = {15, 90, 15, 25, 35, 15};
    private static final float[] TABLE_COLUMNS_SIZES_INVOICES = {15, 90, 35, 15, 35};

    public static final String USER_HOME = "user.home";
    public static final String PDF_FILE_EXT = ".pdf";

    private FileService fileService;

    private void addHead(PdfBuilder pdf) {
        pdf.paragraphEmphasized("LISTADO DE CLIENTES");
                //.paragraph("NIF: " + this.nif + "   -   " + this.address)
                //.paragraph("Email: " + this.email + "  -  " + "Web: " + this.web);
        pdf.line();
    }

    private void addCostumerHead(PdfBuilder pdf, Cliente cliente) {
        pdf.paragraphEmphasized("COSTUMER");
        pdf.paragraphEmphasized(cliente.getNombres()).paragraphEmphasized("Tfn: " + cliente.getContacto())
                .paragraph("NIF: " + cliente.getId() + "   -   " + cliente.getDireccion().toString());
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

    private void addTable(PdfBuilder pdf, List<Cliente> clientes){
        PdfTableBuilder table = pdf.table(TABLE_COLUMNS_SIZES_TICKETS).tableColumnsHeader(TABLE_COLUMNS_HEADERS);

            clientes.forEach(cliente -> {
                table.tableCell(String.valueOf(cliente.getId()), "" + cliente.getNombres()," "+cliente.getDireccion().getCalle()," "+cliente.getDireccion().getReferencias());
            });
            table.build();

    }

    public byte[] generateVoucher(String path,List<Cliente> clientes) {
        PdfBuilder pdf = new PdfBuilder(path);
        this.addHead(pdf);
        //this.addCostumerHead(pdf,clientes);
        this.addTable(pdf,clientes);
        this.addFootVoucher(pdf);
        return pdf.build();

    }

    public byte[] readPdf(String filepath) {
        return fileService.read(System.getProperty(PdfBuilder.USER_HOME) + filepath + PdfBuilder.PDF_FILE_EXT);
    }
}
