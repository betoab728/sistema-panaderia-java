create procedure sp_findAll_Producto()
	select p.producto_id, p.producto_nombre, c.categoria_nombre, p.producto_costo, p.producto_precio, p.producto_cantvendida from producto p, categoria c where c.categoria_id = p.categoria_id;

create PROCEDURE `sp_insert_Cliente`(in membresia_id int, in cliente_orden varchar(45), in cliente_nombres varchar(45), in cliente_apellidos varchar(45),
 in cliente_edad varchar(45), in cliente_telefono varchar(45),in dni char(8))
insert into cliente (`membresia_id`,`cliente_orden`,`cliente_nombres`,`cliente_apellidos`,`cliente_edad`,`cliente_telefono`,`dni`)
 values(membresia_id, cliente_orden, cliente_nombres, cliente_apellidos, cliente_edad, cliente_telefono, dni)

create procedure sp_find_Cliente(in cliente_id int)
	select c.cliente_id, c.dni,c.cliente_nombres, c.cliente_apellidos, m.membresia_nombre, c.cliente_edad, c.cliente_telefono from cliente c, membresia m where c.membresia_id = m.membresia_id and c.cliente_id = cliente_id;
    
create PROCEDURE `sp_update_Cliente`(in pcliente_id int, in pmembresia_id int, in pcliente_orden varchar(45), in pcliente_nombres varchar(45), 
in pcliente_apellidos varchar(45), in pcliente_edad varchar(45), in pcliente_telefono varchar(45), in pdni char(8))
update cliente set membresia_id = pmembresia_id, cliente_orden = pcliente_orden, cliente_nombres = pcliente_nombres, cliente_apellidos = pcliente_apellidos,
 cliente_edad = pcliente_edad, cliente_telefono = pcliente_telefono ,dni=pdni where cliente_id = pcliente_id
/*Para buscar por dni o nombre*/
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_find_Cliente_Criterio`(in dni varchar(8),in nombre varchar(45), in criterio varchar(45))
BEGIN
IF (criterio=0) then
select * from cliente c where c.dni like CONCAT('%',dni, '%') ;

else
select * from cliente c where c.cliente_nombres like CONCAT('%',nombre, '%') ;
end if;
END

/*CATEGORIA*/

create procedure sp_findAll_Categoria()
 select c.categoria_id,categoria_categoriaid,categoria_nombre from categoria c ;

create procedure sp_find_Categoria(in categoria_id int)
	select c.categoria_id,categoria_categoriaid,categoria_nombrecategoria from categoria c where c.categoria_id=categoria_id;

create procedure sp_insert_Categoria(in categoria_categoriaid int,in categoria_nombre varchar(45))
	insert into categoria(categoria_categoriaid,categoria_nombre ) values (categoria_categoriaid,categoria_nombre);

create procedure sp_update_Categoria(in categoria_id int, in categoria_categoriaid int,in categoria_nombre varchar(45))
	update categoria set categoria_categoriaid=categoria_categoriaid,categoria_nombre=categoria_nombre where categoria_id=pcategoria_id;

/*FIN CATEGORIA*/

/* PRODUCTO */

create procedure sp_find_Producto(in producto_id int)
	select p.producto_id, p.producto_nombre, c.categoria_nombre, p.producto_costo, p.producto_precio, p.producto_cantvendida from producto p, categoria c where c.categoria_id = p.categoria_id and p.producto_id=producto_id;

create procedure sp_find_Producto(in producto_id int)
	select p.producto_id, p.producto_nombre, c.categoria_nombre, p.producto_costo, p.producto_precio, p.producto_cantvendida from producto p, categoria c where c.categoria_id = p.categoria_id and p.producto_id=producto_id;

create procedure sp_insert_Producto(in producto_id int,in producto_nombre varchar(45),producto_costo decimal(10,2), producto_precio decimal(10,2))
	insert into producto(categoria_id,producto_nombre,producto_costo,producto_precio ) values (producto_id,producto_nombre,producto_costo,producto_precio);

create procedure sp_update_Producto(in producto_id int, in categoria_id int,in producto_nombre varchar(45),producto_costo decimal(10,2), producto_precio decimal(10,2))
	update producto p set p.producto_nombre=producto_nombre,p.producto_costo=producto_costo,p.producto_precio=producto_precio where p.producto_id=producto_id;
    
/*FIN PRODUCTO*/


/* inicio  */
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_find_Cliente_Criterio`(in dni varchar(8),in nombre varchar(45), in criterio varchar(45))
BEGIN
IF (criterio=0) then
select * from cliente c where c.dni like CONCAT('%',dni, '%') ;

else
select * from cliente c where c.cliente_nombres like CONCAT('%',nombre, '%') ;

end if;

END

-------
CREATE PROCEDURE `sp_insert_Pedido` (in pclienteid int, in pfecha datetime, in ptotal decimal(10,2))
BEGIN
insert into pedido(cliente_id,pedido_fecha,pedido_total) values (pclienteid,pfecha,ptotal);
END
----
CREATE PROCEDURE `sp_insert_Pedido` (INOUT pedido_id int, in pclienteid int, in pfecha datetime, in ptotal decimal(10,2))
BEGIN
insert into pedido(cliente_id,pedido_fecha,pedido_total) values (pclienteid,pfecha,ptotal);
set pedido_id=LAST_INSERT_ID();
END

-----

CREATE PROCEDURE `sp_insert_DetallePedido` (in pedido_id int,in producto_id int,in cantidad int,in precio decimal(10,2))
BEGIN
insert into detallepedido( producto_id,pedido_id,detallepedido_cantidad,detallepedido_precio) values (producto_id,pedido_id,cantidad,precio);

END
----
CREATE PROCEDURE `sp_findAll_Pedido` ()
BEGIN
select p.pedido_fecha,p.pedido_id ,concat( c.cliente_nombres,' ',c.cliente_apellidos) cliente, p.pedido_total 
 from pedido p left join cliente c on c.cliente_id=p.cliente_id ;
END




/* fin */
