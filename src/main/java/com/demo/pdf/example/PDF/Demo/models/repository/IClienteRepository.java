package com.demo.pdf.example.PDF.Demo.models.repository;

import com.demo.pdf.example.PDF.Demo.models.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente,Long> {
}
