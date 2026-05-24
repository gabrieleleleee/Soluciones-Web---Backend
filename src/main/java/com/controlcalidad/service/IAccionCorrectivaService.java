package com.controlcalidad.service;

import java.util.List;
import com.controlcalidad.model.AccionCorrectiva;

public interface IAccionCorrectivaService {
	AccionCorrectiva save(AccionCorrectiva accion) throws Exception;
	AccionCorrectiva update(AccionCorrectiva accion, Integer id) throws Exception;
	List<AccionCorrectiva> findAll() throws Exception;
	AccionCorrectiva findById(Integer id) throws Exception;
	void delete(Integer id) throws Exception;
}
