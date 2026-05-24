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
import com.controlcalidad.model.AccionCorrectiva;
import com.controlcalidad.service.IAccionCorrectivaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/acciones-correctivas")
@RequiredArgsConstructor
public class AccionCorrectivaController {
	private final IAccionCorrectivaService service;

	@GetMapping
	public List<AccionCorrectiva> findAll() throws Exception {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public AccionCorrectiva findById(@PathVariable("id") Integer id) throws Exception {
		return service.findById(id);
	}

	@PostMapping
	public AccionCorrectiva save(@RequestBody AccionCorrectiva accion) throws Exception {
		return service.save(accion);
	}

	@PutMapping("/{id}")
	public AccionCorrectiva update(@RequestBody AccionCorrectiva accion, @PathVariable("id") Integer id) throws Exception {
		return service.update(accion, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
	}
}
