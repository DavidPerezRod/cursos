package com.ratondbiblioteca.jm1.items.model.item.service;

import java.util.List;

import com.ratondbiblioteca.jm1.items.model.Item;

public interface ItemService {
	
	public List<Item> findAll();
	public Item findById (Long id, Integer cantidad);
}
