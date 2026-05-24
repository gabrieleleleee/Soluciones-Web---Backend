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
import com.controlcalidad.model.Inspeccion;
import com.controlcalidad.service.IInspeccionService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inspecciones")
@RequiredArgsConstructor
public class InspeccionController {
	private final IInspeccionService service;

	@GetMapping
	public List<Inspeccion> findAll() throws Exception {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Inspeccion findById(@PathVariable("id") Integer id) throws Exception {
		return service.findById(id);
	}

	@PostMapping
	public Inspeccion save(@RequestBody Inspeccion inspeccion) throws Exception {
		return service.save(inspeccion);
	}

	@PutMapping("/{id}")
	public Inspeccion update(@RequestBody Inspeccion inspeccion, @PathVariable("id") Integer id) throws Exception {
		return service.update(inspeccion, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
	}
}
