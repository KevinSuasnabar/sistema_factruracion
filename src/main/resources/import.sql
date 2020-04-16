/*PROBLANDO CLIENTES*/
INSERT INTO clientes(id,calle,nombres) VALUES(1,'LOS CIPRECES','KEVIN JEFF');
INSERT INTO clientes(id,calle,nombres) VALUES(2,'LOS LAURELES','JUAN SOTO');
INSERT INTO clientes(id,calle,nombres) VALUES(3,'LOS CACAHUATES','FELIE SSSSL');

/*POBLANDO FACTURAS*/
INSERT INTO facturas(id,codigo_generado,monto,cliente_id) VALUES(1,'1A1B1C',20.5,1);
INSERT INTO facturas(id,codigo_generado,monto,cliente_id) VALUES(2,'2A2B2C',288.5,1);
INSERT INTO facturas(id,codigo_generado,monto,cliente_id) VALUES(3,'3A3B3C',277.5,1);
INSERT INTO facturas(id,codigo_generado,monto,cliente_id) VALUES(4,'4A4B4C',27.5,2);
INSERT INTO facturas(id,codigo_generado,monto,cliente_id) VALUES(5,'5A5B5C',28.5,2);
INSERT INTO facturas(id,codigo_generado,monto,cliente_id) VALUES(6,'6A6B6C',21.5,3);

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


