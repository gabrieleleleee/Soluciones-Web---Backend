package com.controlcalidad.service;

import org.springframework.stereotype.Service;
import com.controlcalidad.model.DevolucionLote;
import com.controlcalidad.repository.IDevolucionLoteRepository;

/**
 * Implementación del servicio para DevolucionLote.
 * Extiende GenericServiceImpl<DevolucionLote, Integer, IDevolucionLoteRepository>
 * para heredar los 5 métodos CRUD genéricos.
 *
 * Solo necesita:
 * 1. Inyectar su repository via constructor (RequiredArgsConstructor o manual)
 * 2. Implementar setId() para indicar cómo asignar el ID en update()
 */
@Service
public class DevolucionLoteService
        extends GenericServiceImpl<DevolucionLote, Integer, IDevolucionLoteRepository>
        implements IDevolucionLoteService {

    public DevolucionLoteService(IDevolucionLoteRepository repository) {
        super(repository);
    }

    /**
     * Indica a GenericServiceImpl cómo asignar el ID a la entidad DevolucionLote
     * durante la operación update().
     */
    @Override
    protected void setId(DevolucionLote entity, Integer id) {
        entity.setIdDevolucion(id);
    }
}
