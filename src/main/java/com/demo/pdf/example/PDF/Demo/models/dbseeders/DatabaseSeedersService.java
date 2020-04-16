package com.demo.pdf.example.PDF.Demo.models.dbseeders;

import com.demo.pdf.example.PDF.Demo.models.entity.Cliente;
import com.demo.pdf.example.PDF.Demo.models.entity.Direccion;
import com.demo.pdf.example.PDF.Demo.models.entity.Factura;
import com.demo.pdf.example.PDF.Demo.models.repository.IClienteRepository;
import com.demo.pdf.example.PDF.Demo.models.repository.IFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DatabaseSeedersService {

    private IClienteRepository clienteRepository;
    private IFacturaRepository facturaRepository;

    @Autowired
    public DatabaseSeedersService(IClienteRepository clienteRepository,IFacturaRepository facturaRepository){
        this.clienteRepository=clienteRepository;
        this.facturaRepository=facturaRepository;
    }

    public void deleteAll(){
        this.clienteRepository.deleteAll();
        this.facturaRepository.deleteAll();
    }
    public void generateAllData(){

       /* System.out.println("--------------Clientes---------------");

        List<String> contacto =new ArrayList<>();
        List<String> contacto1 =new ArrayList<>();
        List<String> contacto2 =new ArrayList<>();

        List<String> referencias =new ArrayList<>();
        List<String> referencias1 =new ArrayList<>();
        List<String> referencias2 =new ArrayList<>();

        for (int i=0;i<2;i++){
            contacto.add("111111"+i);
            contacto1.add("22222"+i);
            contacto2.add("33333"+i);

            referencias.add("AV -"+i);
            referencias1.add("ESTACION -"+i);
            referencias2.add("PARADERO - "+i);

        }


            Cliente[] clientes = {
                new Cliente(contacto,"JOSE",new Direccion(referencias,"LOS MILAGROS")),
                new Cliente(contacto1,"FELIPE",new Direccion(referencias1,"LOS CIPRECES")),
                new Cliente(contacto2,"ANDREA",new Direccion(referencias2,"LOS PENURIAS")),
        };



        this.clienteRepository.saveAll(Arrays.asList(clientes));


        System.out.println("--------------Facturas---------------");

        Factura[] facturas = {
                new Factura("1A1B1C",25.5,clientes[0]),
                new Factura("2A2B2C",20.8,clientes[0]),
                new Factura("3A3B3C",25.7,clientes[0]),
                new Factura("4A4B4C",200.57,clientes[1]),
                new Factura("5A5B5C",208.85,clientes[1]),
                new Factura("6A6B6C",2.77,clientes[2]),
        };

        this.facturaRepository.saveAll(Arrays.asList(facturas));

        System.out.println("--------------Clientes refactoring con Facturas---------------");

        clientes[0].setFacturas(Arrays.asList(facturas[0],facturas[1],facturas[2]));
        clientes[1].setFacturas(Arrays.asList(facturas[3],facturas[4]));
        clientes[2].setFacturas(Arrays.asList(facturas[5]));

        this.clienteRepository.saveAll(Arrays.asList(clientes));
*/
    }



}
