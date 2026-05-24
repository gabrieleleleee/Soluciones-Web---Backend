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
import com.controlcalidad.model.MateriaPrima;
import com.controlcalidad.service.IMateriaPrimaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/materias-primas")
@RequiredArgsConstructor
public class MateriaPrimaController {
	private final IMateriaPrimaService service;

	@GetMapping
	public List<MateriaPrima> findAll() throws Exception {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public MateriaPrima findById(@PathVariable("id") Integer id) throws Exception {
		return service.findById(id);
	}

	@PostMapping
	public MateriaPrima save(@RequestBody MateriaPrima materiaPrima) throws Exception {
		return service.save(materiaPrima);
	}

	@PutMapping("/{id}")
	public MateriaPrima update(@RequestBody MateriaPrima materiaPrima, @PathVariable("id") Integer id) throws Exception {
		return service.update(materiaPrima, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
	}
}
