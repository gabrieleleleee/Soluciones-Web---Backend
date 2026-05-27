package com.controlcalidad.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.controlcalidad.model.HistorialMantenimiento;
import com.controlcalidad.repository.IHistorialMantenimientoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HistorialMantenimientoService implements IHistorialMantenimientoService {
	private final IHistorialMantenimientoRepository repo;

	@Override
	public HistorialMantenimiento save(HistorialMantenimiento historial) throws Exception {
		return repo.save(historial);
	}

	@Override
	public HistorialMantenimiento update(HistorialMantenimiento historial, Integer id) throws Exception {
		historial.setIdMantenimiento(id);
		return repo.save(historial);
	}

	@Override
	public List<HistorialMantenimiento> findAll() throws Exception {
		return repo.findAll();
	}

	@Override
	public HistorialMantenimiento findById(Integer id) throws Exception {
		return repo.findById(id).orElse(new HistorialMantenimiento());
	}

	@Override
	public void delete(Integer id) throws Exception {
		repo.deleteById(id);
	}
}
