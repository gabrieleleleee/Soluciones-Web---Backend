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
import com.controlcalidad.model.MaquinariaEquipo;
import com.controlcalidad.service.IMaquinariaEquipoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/maquinarias")
@RequiredArgsConstructor
public class MaquinariaEquipoController {
	private final IMaquinariaEquipoService service;

	@GetMapping
	public List<MaquinariaEquipo> findAll() throws Exception {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public MaquinariaEquipo findById(@PathVariable("id") Integer id) throws Exception {
		return service.findById(id);
	}

	@PostMapping
	public MaquinariaEquipo save(@RequestBody MaquinariaEquipo maquinaria) throws Exception {
		return service.save(maquinaria);
	}

	@PutMapping("/{id}")
	public MaquinariaEquipo update(@RequestBody MaquinariaEquipo maquinaria, @PathVariable("id") Integer id) throws Exception {
		return service.update(maquinaria, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
	}
}
