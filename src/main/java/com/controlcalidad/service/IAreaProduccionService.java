package com.controlcalidad.service;

import com.controlcalidad.model.AreaProduccion;
import java.util.List;

public interface IAreaProduccionService {
    AreaProduccion save(AreaProduccion entity) throws Exception;
    AreaProduccion update(AreaProduccion entity, Integer id) throws Exception;
    List<AreaProduccion> findAll() throws Exception;
    AreaProduccion findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
