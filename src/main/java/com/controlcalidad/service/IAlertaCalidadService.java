package com.controlcalidad.service;

import java.util.List;
import com.controlcalidad.model.AlertaCalidad;

public interface IAlertaCalidadService {
	AlertaCalidad save(AlertaCalidad alerta) throws Exception;
	AlertaCalidad update(AlertaCalidad alerta, Integer id) throws Exception;
	List<AlertaCalidad> findAll() throws Exception;
	AlertaCalidad findById(Integer id) throws Exception;
	void delete(Integer id) throws Exception;
}
