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
import com.controlcalidad.model.AlertaCalidad;
import com.controlcalidad.service.IAlertaCalidadService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/alertas")
@RequiredArgsConstructor
public class AlertaCalidadController {
	private final IAlertaCalidadService service;

	@GetMapping
	public List<AlertaCalidad> findAll() throws Exception {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public AlertaCalidad findById(@PathVariable("id") Integer id) throws Exception {
		return service.findById(id);
	}

	@PostMapping
	public AlertaCalidad save(@RequestBody AlertaCalidad alerta) throws Exception {
		return service.save(alerta);
	}

	@PutMapping("/{id}")
	public AlertaCalidad update(@RequestBody AlertaCalidad alerta, @PathVariable("id") Integer id) throws Exception {
		return service.update(alerta, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
	}
}
