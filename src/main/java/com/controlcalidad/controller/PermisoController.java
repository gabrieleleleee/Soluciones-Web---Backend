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
import com.controlcalidad.model.Permiso;
import com.controlcalidad.service.IPermisoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/permisos")
@RequiredArgsConstructor
public class PermisoController {
	private final IPermisoService service;

	@GetMapping
	public List<Permiso> findAll() throws Exception {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Permiso findById(@PathVariable("id") Integer id) throws Exception {
		return service.findById(id);
	}

	@PostMapping
	public Permiso save(@RequestBody Permiso permiso) throws Exception {
		return service.save(permiso);
	}

	@PutMapping("/{id}")
	public Permiso update(@RequestBody Permiso permiso, @PathVariable("id") Integer id) throws Exception {
		return service.update(permiso, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
	}
}
