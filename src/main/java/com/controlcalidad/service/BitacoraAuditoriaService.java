package com.controlcalidad.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.controlcalidad.model.BitacoraAuditoria;
import com.controlcalidad.repository.IBitacoraAuditoriaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BitacoraAuditoriaService implements IBitacoraAuditoriaService {
	private final IBitacoraAuditoriaRepository repo;

	@Override
	public BitacoraAuditoria save(BitacoraAuditoria bitacora) throws Exception {
		return repo.save(bitacora);
	}

	@Override
	public BitacoraAuditoria update(BitacoraAuditoria bitacora, Integer id) throws Exception {
		bitacora.setIdBitacora(id);
		return repo.save(bitacora);
	}

	@Override
	public List<BitacoraAuditoria> findAll() throws Exception {
		return repo.findAll();
	}

	@Override
	public BitacoraAuditoria findById(Integer id) throws Exception {
		return repo.findById(id).orElse(new BitacoraAuditoria());
	}

	@Override
	public void delete(Integer id) throws Exception {
		repo.deleteById(id);
	}
}
