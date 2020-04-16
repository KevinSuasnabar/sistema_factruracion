package com.demo.pdf.example.PDF.Demo.models.services;


import com.demo.pdf.example.PDF.Demo.models.entity.Cliente;

import java.util.List;

public interface IClienteService {

    public List<Cliente> getAllCustomers();

    public Cliente createCustomer(Cliente cliente);

    public Cliente findOneCustomer(Long id);
}
