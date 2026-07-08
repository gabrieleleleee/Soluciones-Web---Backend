package com.controlcalidad.service;

import com.controlcalidad.model.AreaProduccion;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAreaProduccionService {
    AreaProduccion save(AreaProduccion entity) throws Exception;
    AreaProduccion update(AreaProduccion entity, Integer id) throws Exception;
    List<AreaProduccion> findAll() throws Exception;
    Page<AreaProduccion> findAll(Pageable pageable) throws Exception;
    AreaProduccion findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
