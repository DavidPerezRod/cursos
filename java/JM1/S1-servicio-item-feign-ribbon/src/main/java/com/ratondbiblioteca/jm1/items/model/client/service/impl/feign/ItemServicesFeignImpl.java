package com.ratondbiblioteca.jm1.items.model.client.service.impl.feign;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ratondbiblioteca.jm1.items.model.Item;
import com.ratondbiblioteca.jm1.items.model.item.service.ItemService;
import com.ratondbiblioteca.jm1.items.model.service.client.feign.FeignItemService;

@Service
@Primary
public class ItemServicesFeignImpl implements ItemService {

	private final static Integer cantidad_defecto = 1;

	@Autowired
	private FeignItemService feignService;

	@Override
	public List<Item> findAll() {
		return feignService.listar().stream().map(p -> new Item(p, cantidad_defecto)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(feignService.detalleProducto(id), cantidad);
	}
}
