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
import com.controlcalidad.model.Defecto;
import com.controlcalidad.service.IDefectoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/defectos")
@RequiredArgsConstructor
public class DefectoController {
	private final IDefectoService service;

	@GetMapping
	public List<Defecto> findAll() throws Exception {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Defecto findById(@PathVariable("id") Integer id) throws Exception {
		return service.findById(id);
	}

	@PostMapping
	public Defecto save(@RequestBody Defecto defecto) throws Exception {
		return service.save(defecto);
	}

	@PutMapping("/{id}")
	public Defecto update(@RequestBody Defecto defecto, @PathVariable("id") Integer id) throws Exception {
		return service.update(defecto, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
	}
}
