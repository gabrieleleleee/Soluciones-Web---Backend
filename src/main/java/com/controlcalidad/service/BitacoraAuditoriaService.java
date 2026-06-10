package com.controlcalidad.service;

import org.springframework.stereotype.Service;
import com.controlcalidad.model.BitacoraAuditoria;
import com.controlcalidad.repository.IBitacoraAuditoriaRepository;

/**
 * Implementación del servicio para BitacoraAuditoria.
 * Extiende GenericServiceImpl<BitacoraAuditoria, Integer, IBitacoraAuditoriaRepository>
 * para heredar los 5 métodos CRUD genéricos.
 *
 * Solo necesita:
 * 1. Inyectar su repository via constructor (RequiredArgsConstructor o manual)
 * 2. Implementar setId() para indicar cómo asignar el ID en update()
 */
@Service
public class BitacoraAuditoriaService
        extends GenericServiceImpl<BitacoraAuditoria, Integer, IBitacoraAuditoriaRepository>
        implements IBitacoraAuditoriaService {

    public BitacoraAuditoriaService(IBitacoraAuditoriaRepository repository) {
        super(repository);
    }

    /**
     * Indica a GenericServiceImpl cómo asignar el ID a la entidad BitacoraAuditoria
     * durante la operación update().
     */
    @Override
    protected void setId(BitacoraAuditoria entity, Integer id) {
        entity.setIdBitacora(id);
    }
}
