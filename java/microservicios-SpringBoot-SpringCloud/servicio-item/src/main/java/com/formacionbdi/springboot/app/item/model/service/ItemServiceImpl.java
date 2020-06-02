package com.formacionbdi.springboot.app.item.model.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.formacionbdi.springboot.app.item.clientes.DefaultItemService;
import com.formacionbdi.springboot.app.item.model.Item;
import com.formacionbdi.springboot.app.item.model.Producto;

@Service
public class ItemServiceImpl implements DefaultItemService {

    private final static Integer cantidad_defecto = 1;

    @Value("${servicio.producto.listar}")
    private String servicioProductoListar;

    @Value("${servicio.producto.ver}")
    private String servicioProductoVer;

    @Value("${servicio.producto.balanceo.carga.listar}")
    private String servicioProductoBalanceoCargaListar;

    @Value("${servicio.producto.balanceo.carga.crear}")
    private String servicioProductoCrear;

    @Value("${servicio.producto.balanceo.carga.borrar}")
    private String servicioProductoBorrar;

    @Value("${servicio.producto.balanceo.carga.editar}")
    private String servicioProductoEditar;

    @Value("${servicio.producto.balanceo.carga.ver}")
    private String servicioProductoBalanceoCargaVer;

    @Value("${servicio.producto.parametro.producto.id}")
    private String servicioProductoParamProductoId;

    @Autowired
    private RestTemplate clienteRest;

    @Override
    public List<Item> findAll() {
	List<Producto> productos = Arrays
		.asList(clienteRest.getForObject(servicioProductoBalanceoCargaListar, Producto[].class));
	return productos.stream().map(p -> new Item(p, cantidad_defecto)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
	Map<String, String> params = new HashMap<>();
	params.put(servicioProductoParamProductoId, id.toString());
	Producto producto = clienteRest.getForObject(servicioProductoBalanceoCargaVer, Producto.class, params);
	return new Item(producto, cantidad);
    }

    @Override
    public Producto save(Producto producto) {
	HttpEntity<Producto> body = new HttpEntity<Producto>(producto);
	ResponseEntity<Producto> response = clienteRest.exchange(servicioProductoCrear, HttpMethod.POST, body,
		Producto.class);
	return response.getBody();
    }

    @Override
    public Producto update(Producto producto, Long id) {
	HttpEntity<Producto> body = new HttpEntity<Producto>(producto);
	Map<String, String> params = new HashMap<>();
	params.put(servicioProductoParamProductoId, id.toString());

	ResponseEntity<Producto> response = clienteRest.exchange(servicioProductoEditar, HttpMethod.PUT, body,
		Producto.class, params);
	return response.getBody();
    }

    @Override
    public void delete(Long id) {
	Map<String, String> params = new HashMap<>();
	params.put(servicioProductoParamProductoId, id.toString());

	clienteRest.delete(servicioProductoBorrar, params);
    }
}
