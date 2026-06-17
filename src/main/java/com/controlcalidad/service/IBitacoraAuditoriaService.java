package com.controlcalidad.service;

import com.controlcalidad.model.BitacoraAuditoria;
import java.util.List;

public interface IBitacoraAuditoriaService {
    BitacoraAuditoria save(BitacoraAuditoria entity) throws Exception;
    BitacoraAuditoria update(BitacoraAuditoria entity, Integer id) throws Exception;
    List<BitacoraAuditoria> findAll() throws Exception;
    BitacoraAuditoria findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
