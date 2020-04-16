package com.demo.pdf.example.PDF.Demo.models.services;

import com.demo.pdf.example.PDF.Demo.models.entity.Factura;
import com.demo.pdf.example.PDF.Demo.models.repository.IFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImpl implements IFacturaService{

    @Autowired
    private IFacturaRepository facturaRepository;


    @Override
    public List<Factura> getAllInvoices() {
        return facturaRepository.findAll();
    }

    @Override
    public Factura createInvoice(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    public Factura findOneFactura(Long id) {
        return facturaRepository.findById(id).orElse(null);
    }
}
