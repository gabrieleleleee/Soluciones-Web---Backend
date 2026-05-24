package com.controlcalidad.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.controlcalidad.model.CapacitacionPersonal;
import com.controlcalidad.repository.ICapacitacionPersonalRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CapacitacionPersonalService implements ICapacitacionPersonalService {
	private final ICapacitacionPersonalRepository repo;

	@Override
	public CapacitacionPersonal save(CapacitacionPersonal capacitacion) throws Exception {
		return repo.save(capacitacion);
	}

	@Override
	public CapacitacionPersonal update(CapacitacionPersonal capacitacion, Integer id) throws Exception {
		capacitacion.setIdCapacitacion(id);
		return repo.save(capacitacion);
	}

	@Override
	public List<CapacitacionPersonal> findAll() throws Exception {
		return repo.findAll();
	}

	@Override
	public CapacitacionPersonal findById(Integer id) throws Exception {
		return repo.findById(id).orElse(new CapacitacionPersonal());
	}

	@Override
	public void delete(Integer id) throws Exception {
		repo.deleteById(id);
	}
}
