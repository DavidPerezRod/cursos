package com.formacionbdi.springboot.app.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.formacionbdi.springboot.app.item.model.Producto;

@FeignClient(name = "${spring.application.servicio.producto.name}"
// eliminamos el parámetro url para el balanceo de carga con ribbon
// si no lo hacemos siempre irá a la dirección que le estemos indicando
// en este parámetro
// ,url = "${spring.application.servicio.producto.url}")
)
public interface FeignItemService {

    @GetMapping(path = "${servicio.feign.listar}")
    public List<Producto> listar();

    @GetMapping(path = "${servicio.feign.ver}")
    public Producto detalleProducto(@PathVariable Long id);

    @PostMapping(path = "${servicio.feign.crear}")
    public Producto save(Producto producto);

    @PutMapping(path = "${servicio.feign.actualizar}")
    public Producto update(Producto producto, @PathVariable Long id);

    @DeleteMapping(path = "${servicio.feign.borrar}")
    public void delete(@PathVariable Long id);
}
