/*PROBLANDO CLIENTES*/
INSERT INTO clientes(id,calle,nombres) VALUES(1,'LOS CIPRECES','KEVIN JEFF');
INSERT INTO clientes(id,calle,nombres) VALUES(2,'LOS LAURELES','JUAN SOTO');
INSERT INTO clientes(id,calle,nombres) VALUES(3,'LOS CACAHUATES','FELIE SSSSL');


/*POBLANDO CONTACTOS*/
INSERT INTO contactos(cliente_id,contacto) VALUES(1,'1111111');
INSERT INTO contactos(cliente_id,contacto) VALUES(1,'2222222');
INSERT INTO contactos(cliente_id,contacto) VALUES(1,'3333333');
INSERT INTO contactos(cliente_id,contacto) VALUES(2,'4444444');
INSERT INTO contactos(cliente_id,contacto) VALUES(2,'555555');
INSERT INTO contactos(cliente_id,contacto) VALUES(3,'6666666');
INSERT INTO contactos(cliente_id,contacto) VALUES(3,'777777');

/*POBLANDO CLIENTE_REFERENCIAS*/
INSERT INTO cliente_referencias(cliente_id,referencias) VALUES(1,'AV jose agranda');
INSERT INTO cliente_referencias(cliente_id,referencias) VALUES(2,'ESTACION jorge');
INSERT INTO cliente_referencias(cliente_id,referencias) VALUES(2,'AV naranjal');
INSERT INTO cliente_referencias(cliente_id,referencias) VALUES(3,'AV peru');
INSERT INTO cliente_referencias(cliente_id,referencias) VALUES(3,'PARAD carmelitas');


/*POBLANDO PRODUCTOS*/
INSERT INTO productos(nombre,precio) VALUES('Galleta Oreo',0.80);
INSERT INTO productos(nombre,precio) VALUES('Helado Donito',0.80);
INSERT INTO productos(nombre,precio) VALUES('Piqueos',0.80);
INSERT INTO productos(nombre,precio) VALUES('Pastel',0.50);
INSERT INTO productos(nombre,precio) VALUES('Yogurt 1L',3.50);
INSERT INTO productos(nombre,precio) VALUES('Doritos',1.00);
INSERT INTO productos(nombre,precio) VALUES('Coca-Cola',1.50);


/*POBLANDO CATEGORIAS*/
INSERT INTO categorias(nombre) VALUES ('Bebidas');
INSERT INTO categorias(nombre) VALUES ('Lacteos');
INSERT INTO categorias(nombre) VALUES ('Golosinas');

/*POBLANDO PRODUCTO_CATEGORIAS*/
INSERT INTO productos_categorias(producto_id,categoria_id) VALUES (1,3);
INSERT INTO productos_categorias(producto_id,categoria_id) VALUES (2,2);
INSERT INTO productos_categorias(producto_id,categoria_id) VALUES (3,3);
INSERT INTO productos_categorias(producto_id,categoria_id) VALUES (4,3);
INSERT INTO productos_categorias(producto_id,categoria_id) VALUES (5,2);
INSERT INTO productos_categorias(producto_id,categoria_id) VALUES (6,3);
INSERT INTO productos_categorias(producto_id,categoria_id) VALUES (7,1);

/*POBLANDO LINEAS_FACTURAS*/
/*POBLANDO FACTURAS*/
INSERT INTO facturas(codigo_generado,descripcion,cliente_id,create_at) VALUES('1A1B1C','prueba 1',1,NOW());
    INSERT INTO lineas_facturas(cantidad,factura_id,producto_id) VALUES (2,1,1);
    INSERT INTO lineas_facturas(cantidad,factura_id,producto_id) VALUES (1,1,2);

INSERT INTO facturas(codigo_generado,descripcion,cliente_id,create_at) VALUES('2A2B2C','prueba 2',1,NOW());
    INSERT INTO lineas_facturas(cantidad,factura_id,producto_id) VALUES (2,2,3);

INSERT INTO facturas(codigo_generado,descripcion,cliente_id,create_at) VALUES('3A3B3C','prueba 3',2,NOW());
    INSERT INTO lineas_facturas(cantidad,factura_id,producto_id) VALUES (3,3,4);
    INSERT INTO lineas_facturas(cantidad,factura_id,producto_id) VALUES (1,3,5);

INSERT INTO facturas(codigo_generado,descripcion,cliente_id,create_at) VALUES('4A4B4C','prueba 4',3,NOW());
    INSERT INTO lineas_facturas(cantidad,factura_id,producto_id) VALUES (5,4,6);



