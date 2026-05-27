package com.controlcalidad.service;

import java.util.List;
import com.controlcalidad.model.BitacoraAuditoria;

public interface IBitacoraAuditoriaService {
	BitacoraAuditoria save(BitacoraAuditoria bitacoraAuditoria) throws Exception;
	BitacoraAuditoria update(BitacoraAuditoria bitacoraAuditoria, Integer id) throws Exception;
	List<BitacoraAuditoria> findAll() throws Exception;
	BitacoraAuditoria findById(Integer id) throws Exception;
	void delete(Integer id) throws Exception;
}
