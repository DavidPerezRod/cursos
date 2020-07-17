package com.ratondbiblioteca.jm1.productos.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ratondbiblioteca.jm1.productos.models.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long>{

	
}
