package com.ratondbiblioteca.jm1.items.model.service.client.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ratondbiblioteca.jm1.items.model.Producto;

@FeignClient(name = "${spring.application.servicio.producto.name}")
public interface FeignItemService {

    @GetMapping(path = "${servicio.feign.listar}")
    public List<Producto> listar();

    @GetMapping(path = "${servicio.feign.ver}")
    public Producto detalleProducto(@PathVariable Long id);
}
