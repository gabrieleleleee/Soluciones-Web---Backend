package com.controlcalidad.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.controlcalidad.model.DevolucionLote;
import com.controlcalidad.repository.IDevolucionLoteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DevolucionLoteService implements IDevolucionLoteService {
	private final IDevolucionLoteRepository repo;

	@Override
	public DevolucionLote save(DevolucionLote devolucion) throws Exception {
		return repo.save(devolucion);
	}

	@Override
	public DevolucionLote update(DevolucionLote devolucion, Integer id) throws Exception {
		devolucion.setIdDevolucion(id);
		return repo.save(devolucion);
	}

	@Override
	public List<DevolucionLote> findAll() throws Exception {
		return repo.findAll();
	}

	@Override
	public DevolucionLote findById(Integer id) throws Exception {
		return repo.findById(id).orElse(new DevolucionLote());
	}

	@Override
	public void delete(Integer id) throws Exception {
		repo.deleteById(id);
	}
}
