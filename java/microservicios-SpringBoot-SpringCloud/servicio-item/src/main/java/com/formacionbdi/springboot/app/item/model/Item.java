package com.formacionbdi.springboot.app.item.model;

import lombok.Data;

@Data
public class Item {
	
	public Item() {
		super();
	}

	public Item(Producto producto, Integer cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}

	private Producto producto;

	private Integer cantidad;
	
	public Double getTotal() {
		return producto.getPrecio() * cantidad.doubleValue();
	}
}
