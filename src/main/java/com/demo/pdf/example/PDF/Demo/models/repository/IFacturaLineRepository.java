package com.demo.pdf.example.PDF.Demo.models.repository;

import com.demo.pdf.example.PDF.Demo.models.entity.FacturaLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacturaLineRepository extends JpaRepository<FacturaLine,Long> {
}
