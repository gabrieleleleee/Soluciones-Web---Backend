package com.controlcalidad.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.controlcalidad.model.Permiso;
import com.controlcalidad.repository.IPermisoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PermisoService implements IPermisoService {
	private final IPermisoRepository repo;

	@Override
	public Permiso save(Permiso permiso) throws Exception {
		return repo.save(permiso);
	}

	@Override
	public Permiso update(Permiso permiso, Integer id) throws Exception {
		permiso.setIdPermiso(id);
		return repo.save(permiso);
	}

	@Override
	public List<Permiso> findAll() throws Exception {
		return repo.findAll();
	}

	@Override
	public Permiso findById(Integer id) throws Exception {
		return repo.findById(id).orElse(new Permiso());
	}

	@Override
	public void delete(Integer id) throws Exception {
		repo.deleteById(id);
	}
}
