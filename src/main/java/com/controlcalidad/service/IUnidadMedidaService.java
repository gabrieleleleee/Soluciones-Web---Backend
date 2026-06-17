package com.controlcalidad.service;

import com.controlcalidad.model.UnidadMedida;
import java.util.List;

public interface IUnidadMedidaService {
    UnidadMedida save(UnidadMedida entity) throws Exception;
    UnidadMedida update(UnidadMedida entity, Integer id) throws Exception;
    List<UnidadMedida> findAll() throws Exception;
    UnidadMedida findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
