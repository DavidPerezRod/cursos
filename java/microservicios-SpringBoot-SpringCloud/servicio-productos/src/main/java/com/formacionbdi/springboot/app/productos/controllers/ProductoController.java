package com.formacionbdi.springboot.app.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.productos.models.entities.Producto;
import com.formacionbdi.springboot.app.productos.models.service.IProductoService;

@RestController
public class ProductoController {

//  para recoger el valor de una variable de entorno que no sea por parametrización
//	@Autowired
//	private Environment environment;
	
	@Value("${server.port}")
	private Integer puerto;
	
	@Autowired
	private IProductoService service;
	
	@GetMapping("/listar")
	public List<Producto> listarProductos(){
		return service.findAll().stream().map(producto ->{
//			producto.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
			producto.setPort(puerto);
			return producto;
		}).collect(Collectors.toList());
	}

	@GetMapping("/ver/{id}")
	public Producto detalleProducto(@PathVariable Long id){
		Producto producto= service.findById(id);
//		producto.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		producto.setPort(puerto);
		
// Código para pruebas de fallo con cirtuit breaker		
//		boolean ok = false;
//		if (ok == false) {
//			throw new Exception("No se pudo cargar el producto");
//		}
		
		return producto;
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto crear(@RequestBody Producto producto) {
		return service.save(producto);
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto editar(@RequestBody Producto producto, @PathVariable Long id) {
		Producto entity= service.findById(id);
		entity.setNombre(producto.getNombre());
		entity.setPrecio(producto.getPrecio());
		return service.save(entity);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		service.deleteById(id);
	}
}
