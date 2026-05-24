package com.controlcalidad.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.controlcalidad.model.AccionCorrectiva;
import com.controlcalidad.repository.IAccionCorrectivaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccionCorrectivaService implements IAccionCorrectivaService {
	private final IAccionCorrectivaRepository repo;

	@Override
	public AccionCorrectiva save(AccionCorrectiva accion) throws Exception {
		return repo.save(accion);
	}

	@Override
	public AccionCorrectiva update(AccionCorrectiva accion, Integer id) throws Exception {
		accion.setIdAccion(id);
		return repo.save(accion);
	}

	@Override
	public List<AccionCorrectiva> findAll() throws Exception {
		return repo.findAll();
	}

	@Override
	public AccionCorrectiva findById(Integer id) throws Exception {
		return repo.findById(id).orElse(new AccionCorrectiva());
	}

	@Override
	public void delete(Integer id) throws Exception {
		repo.deleteById(id);
	}
}
