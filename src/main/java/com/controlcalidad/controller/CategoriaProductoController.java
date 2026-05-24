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
import com.controlcalidad.model.CategoriaProducto;
import com.controlcalidad.service.ICategoriaProductoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaProductoController {
	private final ICategoriaProductoService service;

	@GetMapping
	public List<CategoriaProducto> findAll() throws Exception {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public CategoriaProducto findById(@PathVariable("id") Integer id) throws Exception {
		return service.findById(id);
	}

	@PostMapping
	public CategoriaProducto save(@RequestBody CategoriaProducto categoria) throws Exception {
		return service.save(categoria);
	}

	@PutMapping("/{id}")
	public CategoriaProducto update(@RequestBody CategoriaProducto categoria, @PathVariable("id") Integer id) throws Exception {
		return service.update(categoria, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
	}
}
