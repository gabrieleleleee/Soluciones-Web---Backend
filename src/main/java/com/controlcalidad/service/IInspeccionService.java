package com.controlcalidad.service;

import com.controlcalidad.model.Inspeccion;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IInspeccionService {
    Inspeccion save(Inspeccion entity) throws Exception;
    Inspeccion update(Inspeccion entity, Integer id) throws Exception;
    List<Inspeccion> findAll() throws Exception;
    Page<Inspeccion> findAll(Pageable pageable) throws Exception;
    Inspeccion findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
