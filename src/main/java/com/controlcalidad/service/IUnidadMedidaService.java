package com.controlcalidad.service;

import java.util.List;
import com.controlcalidad.model.UnidadMedida;

public interface IUnidadMedidaService {
	UnidadMedida save(UnidadMedida unidadMedida) throws Exception;
	UnidadMedida update(UnidadMedida unidadMedida, Integer id) throws Exception;
	List<UnidadMedida> findAll() throws Exception;
	UnidadMedida findById(Integer id) throws Exception;
	void delete(Integer id) throws Exception;
}
