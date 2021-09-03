package com.formacionbdi.springboot.app.item.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.item.clientes.DefaultItemService;
import com.formacionbdi.springboot.app.item.model.Item;
import com.formacionbdi.springboot.app.item.model.Producto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RefreshScope
@RestController
public class ItemController {

	private static Logger log= org.slf4j.LoggerFactory.getLogger(ItemController.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private DefaultItemService service;

	@Value("${configuracion.texto}")
	private String texto;
	
	@GetMapping("/listar")
	public List<Item> listar() {
		return service.findAll();
	}

	@HystrixCommand(fallbackMethod = "metodoAlternativo")
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return service.findById(id, cantidad);
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto crear(@RequestBody Producto producto) {
		return service.save(producto);
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto editar(@RequestBody Producto producto, @PathVariable Long id) {
		return service.update(producto, id);
	}

	@DeleteMapping("/borrar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrar(@PathVariable Long id) {
		service.delete(id);
	}
	
	public Item metodoAlternativo(Long id, Integer cantidad) {
		Item item= new Item();
		Producto producto = new Producto();
		
 		item.setCantidad(cantidad);
		producto.setId(id);
		producto.setNombre("Metodo alternativo");
		producto.setPrecio(500.00);
		item.setProducto(producto);
		return item;
	}
	
	@GetMapping("/obtener-config")
	public ResponseEntity<?> obtenerConfig(@Value("${server.port}")String puerto){
		log.info(texto);
	
		Map<String, String>json=new HashMap<>();
		json.put("texto", texto);
		json.put("puerto", puerto);
		
		if (env.getActiveProfiles().length>0 && env.getActiveProfiles()[0].equals("dev")) {
			json.put("autor.nombre", env.getProperty("configuracion.autor.name"));
			json.put("autor.email", env.getProperty("configuracion.autor.email"));		
		}
		
		return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
	}
}
