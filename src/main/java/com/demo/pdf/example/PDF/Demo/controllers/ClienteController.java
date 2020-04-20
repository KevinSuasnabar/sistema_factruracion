package com.demo.pdf.example.PDF.Demo.controllers;

import com.demo.pdf.example.PDF.Demo.models.Dto.ProductoDto;
import com.demo.pdf.example.PDF.Demo.models.Dto.facturaDto;
import com.demo.pdf.example.PDF.Demo.models.entity.Cliente;
import com.demo.pdf.example.PDF.Demo.models.entity.Factura;
import com.demo.pdf.example.PDF.Demo.models.entity.FacturaLine;
import com.demo.pdf.example.PDF.Demo.models.entity.Producto;
import com.demo.pdf.example.PDF.Demo.models.services.IClienteService;
import com.demo.pdf.example.PDF.Demo.models.services.IFacturaLineService;
import com.demo.pdf.example.PDF.Demo.models.services.IFacturaService;
import com.demo.pdf.example.PDF.Demo.models.services.IProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/v0")
public class ClienteController {

    private static final String FACTURAS="/facturas";
    private static final String COMPRA="/factura";
    private static final String PRODUCTOS="/productos";


    @Autowired
    private IFacturaService facturaService;

    @Autowired
    private IFacturaLineService facturaLineService;

    @Autowired
    private IProductoService productoService;

    @Autowired
    private IClienteService clienteService;

    @Autowired
    private ModelMapper modelMapper;


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

    @GetMapping(PRODUCTOS)
    public List<ProductoDto> getProductos(){

        List<Producto> productos = productoService.getProductos();
        return productos.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private final ProductoDto convertToDto(Producto producto) {
        ProductoDto postDto = modelMapper.map(producto, ProductoDto.class);
        return postDto;
    }

    /*private ProductoDto convertToEntity(PostDto postDto) throws ParseException {
        PRod post = modelMapper.map(postDto, Post.class);
        post.setSubmissionDate(postDto.getSubmissionDateConverted(
                userService.getCurrentUser().getPreference().getTimezone()));

        if (postDto.getId() != null) {
            Post oldPost = postService.getPostById(postDto.getId());
            post.setRedditID(oldPost.getRedditID());
            post.setSent(oldPost.isSent());
        }
        return post;
    }*/





}
