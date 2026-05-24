package com.controlcalidad.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.controlcalidad.model.MotivoRechazo;
import com.controlcalidad.repository.IMotivoRechazoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MotivoRechazoService implements IMotivoRechazoService {
	private final IMotivoRechazoRepository repo;

	@Override
	public MotivoRechazo save(MotivoRechazo motivo) throws Exception {
		return repo.save(motivo);
	}

	@Override
	public MotivoRechazo update(MotivoRechazo motivo, Integer id) throws Exception {
		motivo.setIdMotivo(id);
		return repo.save(motivo);
	}

	@Override
	public List<MotivoRechazo> findAll() throws Exception {
		return repo.findAll();
	}

	@Override
	public MotivoRechazo findById(Integer id) throws Exception {
		return repo.findById(id).orElse(new MotivoRechazo());
	}

	@Override
	public void delete(Integer id) throws Exception {
		repo.deleteById(id);
	}
}
