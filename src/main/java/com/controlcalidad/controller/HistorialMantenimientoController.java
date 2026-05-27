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
import com.controlcalidad.model.HistorialMantenimiento;
import com.controlcalidad.service.IHistorialMantenimientoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/historiales-mantenimiento")
@RequiredArgsConstructor
public class HistorialMantenimientoController {
	private final IHistorialMantenimientoService service;

	@GetMapping
	public List<HistorialMantenimiento> findAll() throws Exception {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public HistorialMantenimiento findById(@PathVariable("id") Integer id) throws Exception {
		return service.findById(id);
	}

	@PostMapping
	public HistorialMantenimiento save(@RequestBody HistorialMantenimiento historial) throws Exception {
		return service.save(historial);
	}

	@PutMapping("/{id}")
	public HistorialMantenimiento update(@RequestBody HistorialMantenimiento historial, @PathVariable("id") Integer id) throws Exception {
		return service.update(historial, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
	}
}
