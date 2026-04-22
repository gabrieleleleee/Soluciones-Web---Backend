package com.controlcalidad.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlcalidad.model.Producto;
import com.controlcalidad.service.IProductoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {
	private final IProductoService service;
	
	@GetMapping // GET, POST, PUT, DELETE
	public List<Producto> findAll() throws Exception{
		return service.findAll();
	}
	
	@GetMapping("/{id}") // GET
	public Producto findById(@PathVariable("id") Integer id) throws Exception{
		return service.findById(id);
	}
	
	@PostMapping // POST
	public Producto save(@RequestBody Producto producto) throws Exception{
		return service.save(producto);
	}
	
	@PutMapping("/{id}") // PUT
	public Producto update(@RequestBody Producto producto, @PathVariable("id") Integer id) throws Exception{
		return service.update(producto, id);
	}
	
	@DeleteMapping("/{id}") // DELETE
	public void delete(@PathVariable("id") Integer id) throws Exception{
		service.delete(id);
	}
}
