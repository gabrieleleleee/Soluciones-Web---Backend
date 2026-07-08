package com.controlcalidad.service;

import com.controlcalidad.model.UnidadMedida;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUnidadMedidaService {
    UnidadMedida save(UnidadMedida entity) throws Exception;
    UnidadMedida update(UnidadMedida entity, Integer id) throws Exception;
    List<UnidadMedida> findAll() throws Exception;
    Page<UnidadMedida> findAll(Pageable pageable) throws Exception;
    UnidadMedida findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
