package com.demo.pdf.example.PDF.Demo.models.services;

import com.demo.pdf.example.PDF.Demo.models.entity.Cliente;
import com.demo.pdf.example.PDF.Demo.models.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements  IClienteService{

    @Autowired
    private IClienteRepository clienteRepository;


    @Override
    public List<Cliente> getAllCustomers() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente createCustomer(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente findOneCustomer(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }
}
