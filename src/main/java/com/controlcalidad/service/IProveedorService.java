package com.controlcalidad.service;

import com.controlcalidad.model.Proveedor;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProveedorService {
    Proveedor save(Proveedor entity) throws Exception;
    Proveedor update(Proveedor entity, Integer id) throws Exception;
    List<Proveedor> findAll() throws Exception;
    Page<Proveedor> findAll(Pageable pageable) throws Exception;
    Proveedor findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
