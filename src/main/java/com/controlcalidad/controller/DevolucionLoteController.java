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
import com.controlcalidad.model.DevolucionLote;
import com.controlcalidad.service.IDevolucionLoteService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/devoluciones")
@RequiredArgsConstructor
public class DevolucionLoteController {
	private final IDevolucionLoteService service;

	@GetMapping
	public List<DevolucionLote> findAll() throws Exception {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public DevolucionLote findById(@PathVariable("id") Integer id) throws Exception {
		return service.findById(id);
	}

	@PostMapping
	public DevolucionLote save(@RequestBody DevolucionLote devolucion) throws Exception {
		return service.save(devolucion);
	}

	@PutMapping("/{id}")
	public DevolucionLote update(@RequestBody DevolucionLote devolucion, @PathVariable("id") Integer id) throws Exception {
		return service.update(devolucion, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
	}
}
