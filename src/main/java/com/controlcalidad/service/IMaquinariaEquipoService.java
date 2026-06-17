package com.controlcalidad.service;

import com.controlcalidad.model.MaquinariaEquipo;
import java.util.List;

public interface IMaquinariaEquipoService {
    MaquinariaEquipo save(MaquinariaEquipo entity) throws Exception;
    MaquinariaEquipo update(MaquinariaEquipo entity, Integer id) throws Exception;
    List<MaquinariaEquipo> findAll() throws Exception;
    MaquinariaEquipo findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
