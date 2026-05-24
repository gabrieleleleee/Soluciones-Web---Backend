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
import com.controlcalidad.model.Proveedor;
import com.controlcalidad.service.IProveedorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/proveedores")
@RequiredArgsConstructor
public class ProveedorController {
	private final IProveedorService service;

	@GetMapping
	public List<Proveedor> findAll() throws Exception {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Proveedor findById(@PathVariable("id") Integer id) throws Exception {
		return service.findById(id);
	}

	@PostMapping
	public Proveedor save(@RequestBody Proveedor proveedor) throws Exception {
		return service.save(proveedor);
	}

	@PutMapping("/{id}")
	public Proveedor update(@RequestBody Proveedor proveedor, @PathVariable("id") Integer id) throws Exception {
		return service.update(proveedor, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
	}
}
