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
import com.controlcalidad.model.AreaProduccion;
import com.controlcalidad.service.IAreaProduccionService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/areas-produccion")
@RequiredArgsConstructor
public class AreaProduccionController {
	private final IAreaProduccionService service;

	@GetMapping
	public List<AreaProduccion> findAll() throws Exception {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public AreaProduccion findById(@PathVariable("id") Integer id) throws Exception {
		return service.findById(id);
	}

	@PostMapping
	public AreaProduccion save(@RequestBody AreaProduccion area) throws Exception {
		return service.save(area);
	}

	@PutMapping("/{id}")
	public AreaProduccion update(@RequestBody AreaProduccion area, @PathVariable("id") Integer id) throws Exception {
		return service.update(area, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
	}
}
