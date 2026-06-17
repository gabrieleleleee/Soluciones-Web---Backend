package com.controlcalidad.service;

import com.controlcalidad.model.EstandarCalidad;
import java.util.List;

public interface IEstandarCalidadService {
    EstandarCalidad save(EstandarCalidad entity) throws Exception;
    EstandarCalidad update(EstandarCalidad entity, Integer id) throws Exception;
    List<EstandarCalidad> findAll() throws Exception;
    EstandarCalidad findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
