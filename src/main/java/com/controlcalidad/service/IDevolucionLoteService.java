package com.controlcalidad.service;

import java.util.List;
import com.controlcalidad.model.DevolucionLote;

public interface IDevolucionLoteService {
	DevolucionLote save(DevolucionLote devolucion) throws Exception;
	DevolucionLote update(DevolucionLote devolucion, Integer id) throws Exception;
	List<DevolucionLote> findAll() throws Exception;
	DevolucionLote findById(Integer id) throws Exception;
	void delete(Integer id) throws Exception;
}
