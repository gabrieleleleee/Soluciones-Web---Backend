package com.controlcalidad.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.controlcalidad.model.AlertaCalidad;
import com.controlcalidad.repository.IAlertaCalidadRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlertaCalidadService implements IAlertaCalidadService {
	private final IAlertaCalidadRepository repo;

	@Override
	public AlertaCalidad save(AlertaCalidad alerta) throws Exception {
		return repo.save(alerta);
	}

	@Override
	public AlertaCalidad update(AlertaCalidad alerta, Integer id) throws Exception {
		alerta.setIdAlerta(id);
		return repo.save(alerta);
	}

	@Override
	public List<AlertaCalidad> findAll() throws Exception {
		return repo.findAll();
	}

	@Override
	public AlertaCalidad findById(Integer id) throws Exception {
		return repo.findById(id).orElse(new AlertaCalidad());
	}

	@Override
	public void delete(Integer id) throws Exception {
		repo.deleteById(id);
	}
}
