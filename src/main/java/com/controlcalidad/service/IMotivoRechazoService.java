package com.controlcalidad.service;

import com.controlcalidad.model.MotivoRechazo;
import java.util.List;

public interface IMotivoRechazoService {
    MotivoRechazo save(MotivoRechazo entity) throws Exception;
    MotivoRechazo update(MotivoRechazo entity, Integer id) throws Exception;
    List<MotivoRechazo> findAll() throws Exception;
    MotivoRechazo findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
