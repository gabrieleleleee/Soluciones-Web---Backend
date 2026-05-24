package com.controlcalidad.service;

import java.util.List;
import com.controlcalidad.model.Proveedor;

public interface IProveedorService {
	Proveedor save(Proveedor proveedor) throws Exception;
	Proveedor update(Proveedor proveedor, Integer id) throws Exception;
	List<Proveedor> findAll() throws Exception;
	Proveedor findById(Integer id) throws Exception;
	void delete(Integer id) throws Exception;
}
