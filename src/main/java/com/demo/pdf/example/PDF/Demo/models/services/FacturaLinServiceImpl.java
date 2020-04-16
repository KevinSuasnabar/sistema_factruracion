package com.demo.pdf.example.PDF.Demo.models.services;

import com.demo.pdf.example.PDF.Demo.models.entity.FacturaLine;
import com.demo.pdf.example.PDF.Demo.models.repository.IFacturaLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaLinServiceImpl implements  IFacturaLineService{

    @Autowired
    private IFacturaLineRepository facturaLineRepository;

    @Override
    public FacturaLine save(FacturaLine facturaLine) {
        return facturaLineRepository.save(facturaLine);
    }
}
