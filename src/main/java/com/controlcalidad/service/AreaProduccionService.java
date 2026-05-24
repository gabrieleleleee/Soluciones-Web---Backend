package com.controlcalidad.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.controlcalidad.model.AreaProduccion;
import com.controlcalidad.repository.IAreaProduccionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AreaProduccionService implements IAreaProduccionService {
	private final IAreaProduccionRepository repo;

	@Override
	public AreaProduccion save(AreaProduccion area) throws Exception {
		return repo.save(area);
	}

	@Override
	public AreaProduccion update(AreaProduccion area, Integer id) throws Exception {
		area.setIdArea(id);
		return repo.save(area);
	}

	@Override
	public List<AreaProduccion> findAll() throws Exception {
		return repo.findAll();
	}

	@Override
	public AreaProduccion findById(Integer id) throws Exception {
		return repo.findById(id).orElse(new AreaProduccion());
	}

	@Override
	public void delete(Integer id) throws Exception {
		repo.deleteById(id);
	}
}
