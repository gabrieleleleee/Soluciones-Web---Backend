package com.controlcalidad.service;

import com.controlcalidad.model.Inspeccion;
import java.util.List;

public interface IInspeccionService {
    Inspeccion save(Inspeccion entity) throws Exception;
    Inspeccion update(Inspeccion entity, Integer id) throws Exception;
    List<Inspeccion> findAll() throws Exception;
    Inspeccion findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
