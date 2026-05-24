package com.controlcalidad.service;

import java.util.List;
import com.controlcalidad.model.DetalleInspeccion;

public interface IDetalleInspeccionService {
	DetalleInspeccion save(DetalleInspeccion detalle) throws Exception;
	DetalleInspeccion update(DetalleInspeccion detalle, Integer id) throws Exception;
	List<DetalleInspeccion> findAll() throws Exception;
	DetalleInspeccion findById(Integer id) throws Exception;
	void delete(Integer id) throws Exception;
}
