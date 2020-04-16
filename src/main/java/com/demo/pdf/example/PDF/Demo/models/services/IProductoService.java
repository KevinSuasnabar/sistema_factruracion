package com.demo.pdf.example.PDF.Demo.models.services;

import com.demo.pdf.example.PDF.Demo.models.entity.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> getProductos();

    public Producto createProducto(Producto producto);

    public Producto getProductoById(Long id);
}
