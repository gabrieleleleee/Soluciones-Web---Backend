package com.controlcalidad.service;

import com.controlcalidad.model.HistorialMantenimiento;
import java.util.List;

public interface IHistorialMantenimientoService {
    HistorialMantenimiento save(HistorialMantenimiento entity) throws Exception;
    HistorialMantenimiento update(HistorialMantenimiento entity, Integer id) throws Exception;
    List<HistorialMantenimiento> findAll() throws Exception;
    HistorialMantenimiento findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
