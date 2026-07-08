package com.controlcalidad.service;

import com.controlcalidad.model.DetalleInspeccion;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDetalleInspeccionService {
    DetalleInspeccion save(DetalleInspeccion entity) throws Exception;
    DetalleInspeccion update(DetalleInspeccion entity, Integer id) throws Exception;
    List<DetalleInspeccion> findAll() throws Exception;
    Page<DetalleInspeccion> findAll(Pageable pageable) throws Exception;
    DetalleInspeccion findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
