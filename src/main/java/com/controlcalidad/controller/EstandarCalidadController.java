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

import com.controlcalidad.dto.EstandarCalidadDto;
import com.controlcalidad.model.EstandarCalidad;
import com.controlcalidad.model.Producto;
import com.controlcalidad.service.IEstandarCalidadService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/estandares")
@RequiredArgsConstructor
public class EstandarCalidadController {
	private final IEstandarCalidadService service;

	@GetMapping
	public ResponseEntity<List<EstandarCalidad>> findAll() throws Exception {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<EstandarCalidad> findById(@PathVariable("id") Integer id) throws Exception {
		return ResponseEntity.ok(service.findById(id));
	}

	@PostMapping
	public ResponseEntity<EstandarCalidad> save(@Valid @RequestBody EstandarCalidadDto dto) throws Exception {
		Producto producto = new Producto();
		producto.setIdProducto(dto.getIdProducto());
		producto.setEstado(true);
		EstandarCalidad estandar = new EstandarCalidad();
		estandar.setProducto(producto);
		estandar.setNombreParametro(dto.getNombreParametro());
		estandar.setUnidadMedida(dto.getUnidadMedida());
		estandar.setValorMinimo(dto.getValorMinimo());
		estandar.setValorMaximo(dto.getValorMaximo());
		estandar.setDescripcion(dto.getDescripcion());
		estandar.setEstado(dto.isEstado());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(estandar));
	}

	@PutMapping("/{id}")
	public ResponseEntity<EstandarCalidad> update(@Valid @RequestBody EstandarCalidadDto dto,
			@PathVariable("id") Integer id) throws Exception {
		Producto producto = new Producto();
		producto.setIdProducto(dto.getIdProducto());
		producto.setEstado(true);
		EstandarCalidad estandar = new EstandarCalidad();
		estandar.setProducto(producto);
		estandar.setNombreParametro(dto.getNombreParametro());
		estandar.setUnidadMedida(dto.getUnidadMedida());
		estandar.setValorMinimo(dto.getValorMinimo());
		estandar.setValorMaximo(dto.getValorMaximo());
		estandar.setDescripcion(dto.getDescripcion());
		estandar.setEstado(dto.isEstado());
		return ResponseEntity.ok(service.update(estandar, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
