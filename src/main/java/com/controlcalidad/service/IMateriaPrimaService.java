package com.controlcalidad.service;

import com.controlcalidad.model.MateriaPrima;
import java.util.List;

public interface IMateriaPrimaService {
    MateriaPrima save(MateriaPrima entity) throws Exception;
    MateriaPrima update(MateriaPrima entity, Integer id) throws Exception;
    List<MateriaPrima> findAll() throws Exception;
    MateriaPrima findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
