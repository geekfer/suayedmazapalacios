package fca.suayed.dao;

import fca.suayed.dto.ProductDto;
import fca.suayed.dto.ClientDto; 
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface StoreDao {

    @RegisterBeanMapper(ProductDto.class)
    @SqlQuery("SELECT * FROM productos")
    List<ProductDto> getProducts();

    @SqlUpdate("INSERT INTO productos (nombre, descripcion, precio, cantidad, sku) VALUES(:p.nombre, :p.descripcion, :p.precio, :p.cantidad, :p.sku)")
    void addProduct(@BindBean("p") ProductDto productDto);

   
// Nuevo menu agregado
    @RegisterBeanMapper(ClientDto.class)
    @SqlQuery("SELECT * FROM clientes")
    List<ClientDto> getClients();

    @SqlUpdate("INSERT INTO clientes (nombre, apellido_paterno, apellido_materno, rfc) VALUES(:c.nombre, :c.apellidoPaterno, :c.apellidoMaterno, :c.rfc)")
    void addClient(@BindBean("c") ClientDto clientDto);


}