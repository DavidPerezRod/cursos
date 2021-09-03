package com.formacionbdi.springboot.app.item.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.formacionbdi.springboot.app.item.clientes.DefaultItemService;
import com.formacionbdi.springboot.app.item.clientes.FeignItemService;
import com.formacionbdi.springboot.app.item.model.Item;
import com.formacionbdi.springboot.app.item.model.Producto;

@Service
@Primary
public class ItemServicesFeign implements DefaultItemService {

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

    @Override
    public Producto save(Producto producto) {
	return feignService.save(producto);
    }

    @Override
    public Producto update(Producto producto, Long id) {
	return feignService.update(producto, id);
    }

    @Override
    public void delete(Long id) {
	feignService.delete(id);
    }
}
