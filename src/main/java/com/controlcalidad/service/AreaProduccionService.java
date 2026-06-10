package com.controlcalidad.service;

import org.springframework.stereotype.Service;
import com.controlcalidad.model.AreaProduccion;
import com.controlcalidad.repository.IAreaProduccionRepository;

/**
 * Implementación del servicio para AreaProduccion.
 * Extiende GenericServiceImpl<AreaProduccion, Integer, IAreaProduccionRepository>
 * para heredar los 5 métodos CRUD genéricos.
 *
 * Solo necesita:
 * 1. Inyectar su repository via constructor (RequiredArgsConstructor o manual)
 * 2. Implementar setId() para indicar cómo asignar el ID en update()
 */
@Service
public class AreaProduccionService
        extends GenericServiceImpl<AreaProduccion, Integer, IAreaProduccionRepository>
        implements IAreaProduccionService {

    public AreaProduccionService(IAreaProduccionRepository repository) {
        super(repository);
    }

    /**
     * Indica a GenericServiceImpl cómo asignar el ID a la entidad AreaProduccion
     * durante la operación update().
     */
    @Override
    protected void setId(AreaProduccion entity, Integer id) {
        entity.setIdArea(id);
    }
}
