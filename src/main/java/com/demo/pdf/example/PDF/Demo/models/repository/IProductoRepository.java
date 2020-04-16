package com.demo.pdf.example.PDF.Demo.models.repository;

import com.demo.pdf.example.PDF.Demo.models.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto,Long> {
}
