package com.ratondbiblioteca.jm1.items.model.client.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ratondbiblioteca.jm1.items.model.Item;
import com.ratondbiblioteca.jm1.items.model.Producto;
import com.ratondbiblioteca.jm1.items.model.item.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	private final static Integer cantidad_defecto = 1;

	@Value("${servicio.producto.listar}")
	private String servicioProductoListar;

	@Value("${servicio.producto.ver}")
	private String servicioProductoVer;

	@Value("${servicio.producto.parametro.producto.id}")
	private String servicioProductoParamProductoId;

	@Autowired
	private RestTemplate clienteRest;

	@Override
	public List<Item> findAll() {
		List<Producto> productos = Arrays
				.asList(clienteRest.getForObject(servicioProductoListar, Producto[].class));
		return productos.stream().map(p -> new Item(p, cantidad_defecto)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Map<String, String> params = new HashMap<>();
		params.put(servicioProductoParamProductoId, id.toString());
		Producto producto = clienteRest.getForObject(servicioProductoVer, Producto.class, params);
		return new Item(producto, cantidad);
	}
}
