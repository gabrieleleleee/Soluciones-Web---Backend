package com.controlcalidad.service;

import java.util.List;
import com.controlcalidad.model.MotivoRechazo;

public interface IMotivoRechazoService {
	MotivoRechazo save(MotivoRechazo motivoRechazo) throws Exception;
	MotivoRechazo update(MotivoRechazo motivoRechazo, Integer id) throws Exception;
	List<MotivoRechazo> findAll() throws Exception;
	MotivoRechazo findById(Integer id) throws Exception;
	void delete(Integer id) throws Exception;
}
