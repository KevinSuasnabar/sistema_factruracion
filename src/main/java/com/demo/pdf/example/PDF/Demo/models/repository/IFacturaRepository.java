package com.demo.pdf.example.PDF.Demo.models.repository;

import com.demo.pdf.example.PDF.Demo.models.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacturaRepository extends JpaRepository<Factura,Long> {
}
