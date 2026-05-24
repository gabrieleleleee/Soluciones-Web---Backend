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
import com.controlcalidad.model.DetalleInspeccion;
import com.controlcalidad.service.IDetalleInspeccionService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/detalles-inspeccion")
@RequiredArgsConstructor
public class DetalleInspeccionController {
	private final IDetalleInspeccionService service;

	@GetMapping
	public List<DetalleInspeccion> findAll() throws Exception {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public DetalleInspeccion findById(@PathVariable("id") Integer id) throws Exception {
		return service.findById(id);
	}

	@PostMapping
	public DetalleInspeccion save(@RequestBody DetalleInspeccion detalle) throws Exception {
		return service.save(detalle);
	}

	@PutMapping("/{id}")
	public DetalleInspeccion update(@RequestBody DetalleInspeccion detalle, @PathVariable("id") Integer id) throws Exception {
		return service.update(detalle, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
	}
}
