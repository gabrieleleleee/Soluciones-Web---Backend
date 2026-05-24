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
import com.controlcalidad.model.MotivoRechazo;
import com.controlcalidad.service.IMotivoRechazoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/motivos-rechazo")
@RequiredArgsConstructor
public class MotivoRechazoController {
	private final IMotivoRechazoService service;

	@GetMapping
	public List<MotivoRechazo> findAll() throws Exception {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public MotivoRechazo findById(@PathVariable("id") Integer id) throws Exception {
		return service.findById(id);
	}

	@PostMapping
	public MotivoRechazo save(@RequestBody MotivoRechazo motivo) throws Exception {
		return service.save(motivo);
	}

	@PutMapping("/{id}")
	public MotivoRechazo update(@RequestBody MotivoRechazo motivo, @PathVariable("id") Integer id) throws Exception {
		return service.update(motivo, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) throws Exception {
		service.delete(id);
	}
}
