package com.controlcalidad.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.controlcalidad.model.Inspeccion;
import com.controlcalidad.repository.IInspeccionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InspeccionService implements IInspeccionService {
	private final IInspeccionRepository repo;

	@Override
	public Inspeccion save(Inspeccion inspeccion) throws Exception {
		return repo.save(inspeccion);
	}

	@Override
	public Inspeccion update(Inspeccion inspeccion, Integer id) throws Exception {
		inspeccion.setIdInspeccion(id);
		return repo.save(inspeccion);
	}

	@Override
	public List<Inspeccion> findAll() throws Exception {
		return repo.findAll();
	}

	@Override
	public Inspeccion findById(Integer id) throws Exception {
		return repo.findById(id).orElse(new Inspeccion());
	}

	@Override
	public void delete(Integer id) throws Exception {
		repo.deleteById(id);
	}
}
