package com.controlcalidad.service;

import com.controlcalidad.model.AlertaCalidad;
import java.util.List;

public interface IAlertaCalidadService {
    AlertaCalidad save(AlertaCalidad entity) throws Exception;
    AlertaCalidad update(AlertaCalidad entity, Integer id) throws Exception;
    List<AlertaCalidad> findAll() throws Exception;
    AlertaCalidad findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
