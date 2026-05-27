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
import com.controlcalidad.model.CapacitacionPersonal;
import com.controlcalidad.service.ICapacitacionPersonalService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/capacitaciones")
@RequiredArgsConstructor
public class CapacitacionPersonalController {
	private final ICapacitacionPersonalService service;

	@GetMapping
	public List<CapacitacionPersonal> findAll() throws Exception {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public CapacitacionPersonal findById(@PathVariable("id") Integer id) throws Exception {
		return service.findById(id);
	}

	@PostMapping
	public CapacitacionPersonal save(@RequestBody CapacitacionPersonal capacitacion) throws Exception {
		return service.save(capacitacion);
	}

	@PutMapping("/{id}")
	public CapacitacionPersonal update(@RequestBody CapacitacionPersonal capacitacion, @PathVariable("id") Integer id) throws Exception {
		return service.update(capacitacion, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
	}
}
