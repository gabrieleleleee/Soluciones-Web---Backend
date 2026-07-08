package com.controlcalidad.service;

import com.controlcalidad.model.AlertaCalidad;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAlertaCalidadService {
    AlertaCalidad save(AlertaCalidad entity) throws Exception;
    AlertaCalidad update(AlertaCalidad entity, Integer id) throws Exception;
    List<AlertaCalidad> findAll() throws Exception;
    Page<AlertaCalidad> findAll(Pageable pageable) throws Exception;
    AlertaCalidad findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
