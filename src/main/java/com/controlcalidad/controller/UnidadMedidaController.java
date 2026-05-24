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
import com.controlcalidad.model.UnidadMedida;
import com.controlcalidad.service.IUnidadMedidaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/unidades-medida")
@RequiredArgsConstructor
public class UnidadMedidaController {
	private final IUnidadMedidaService service;

	@GetMapping
	public List<UnidadMedida> findAll() throws Exception {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public UnidadMedida findById(@PathVariable("id") Integer id) throws Exception {
		return service.findById(id);
	}

	@PostMapping
	public UnidadMedida save(@RequestBody UnidadMedida unidad) throws Exception {
		return service.save(unidad);
	}

	@PutMapping("/{id}")
	public UnidadMedida update(@RequestBody UnidadMedida unidad, @PathVariable("id") Integer id) throws Exception {
		return service.update(unidad, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
	}
}
