package com.demo.pdf.example.PDF.Demo.controllers;

import com.demo.pdf.example.PDF.Demo.models.Dto.facturaDto;
import com.demo.pdf.example.PDF.Demo.models.entity.Cliente;
import com.demo.pdf.example.PDF.Demo.models.entity.Factura;
import com.demo.pdf.example.PDF.Demo.models.entity.FacturaLine;
import com.demo.pdf.example.PDF.Demo.models.services.IClienteService;
import com.demo.pdf.example.PDF.Demo.models.services.IFacturaLineService;
import com.demo.pdf.example.PDF.Demo.models.services.IFacturaService;
import com.demo.pdf.example.PDF.Demo.models.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v0")
public class ClienteController {

    private static final String FACTURAS="/facturas";
    private static final String COMPRA="/factura";

    @Autowired
    private IFacturaService facturaService;

    @Autowired
    private IFacturaLineService facturaLineService;

    @Autowired
    private IProductoService productoService;

    @Autowired
    private IClienteService clienteService;


    @GetMapping(FACTURAS)
    public List<Factura> obtenerFacturas(){
        return facturaService.getAllInvoices();
    }

    @PostMapping(COMPRA)
    public ResponseEntity<?> crearFactura(@RequestBody facturaDto facturaDto){
        List<FacturaLine> itemsObtenidos= facturaDto.getItems();
        Long idCliente= facturaDto.getIdUsuario();



        Cliente cliente=clienteService.findOneCustomer(idCliente);

        Factura factura=new Factura();
        factura=facturaService.createInvoice(factura);

        List<FacturaLine> tmp=new ArrayList<>();
        for(FacturaLine fl: itemsObtenidos){
            tmp.add(facturaLineService.save(new FacturaLine(productoService.getProductoById(
                    fl.getProducto().getId()),factura,fl.getCantidad())));
        }
        factura.setItems(tmp);
        factura.setCliente(cliente);
        factura.setDescripcion(facturaDto.getDescripcion());
        factura.setCodigoGenerado(facturaDto.getCodigoGenerado());

        facturaService.updateFactura(factura);

        return new ResponseEntity<>(factura, HttpStatus.CREATED);

    }



}
