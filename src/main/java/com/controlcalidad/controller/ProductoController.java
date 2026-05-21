package com.controlcalidad.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlcalidad.dto.ProductoDto;
import com.controlcalidad.model.Producto;
import com.controlcalidad.service.IProductoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {
	private final IProductoService service;

	@GetMapping
	public ResponseEntity<List<Producto>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Producto> findById(@PathVariable("id") Integer id) throws Exception {
		return ResponseEntity.ok(service.findById(id));
	}

	@PostMapping
	public ResponseEntity<Producto> save(@Valid @RequestBody ProductoDto dto) throws Exception {
		Producto producto = new Producto();
		producto.setCodigo(dto.getCodigo());
		producto.setNombre(dto.getNombre());
		producto.setDescripcion(dto.getDescripcion());
		producto.setUnidadMedida(dto.getUnidadMedida());
		producto.setPrecioUnitario(dto.getPrecioUnitario());
		producto.setEstado(dto.isEstado());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(producto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Producto> update(@Valid @RequestBody ProductoDto dto,
			@PathVariable("id") Integer id) throws Exception {
		Producto producto = new Producto();
		producto.setCodigo(dto.getCodigo());
		producto.setNombre(dto.getNombre());
		producto.setDescripcion(dto.getDescripcion());
		producto.setUnidadMedida(dto.getUnidadMedida());
		producto.setPrecioUnitario(dto.getPrecioUnitario());
		producto.setEstado(dto.isEstado());
		return ResponseEntity.ok(service.update(producto, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
