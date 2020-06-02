package com.formacionbdi.springboot.app.item.clientes;

import java.util.List;

import com.formacionbdi.springboot.app.item.model.Item;
import com.formacionbdi.springboot.app.item.model.Producto;

public interface DefaultItemService {
	
	public List<Item> findAll();
	public Item findById (Long id, Integer cantidad);
	public Producto save(Producto producto);
	public Producto update (Producto producto, Long id);
	public void delete (Long id);
}
