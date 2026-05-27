package com.controlcalidad.service;

import java.util.List;
import com.controlcalidad.model.HistorialMantenimiento;

public interface IHistorialMantenimientoService {
	HistorialMantenimiento save(HistorialMantenimiento historial) throws Exception;
	HistorialMantenimiento update(HistorialMantenimiento historial, Integer id) throws Exception;
	List<HistorialMantenimiento> findAll() throws Exception;
	HistorialMantenimiento findById(Integer id) throws Exception;
	void delete(Integer id) throws Exception;
}
