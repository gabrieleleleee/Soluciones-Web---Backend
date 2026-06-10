package com.controlcalidad.service;

import org.springframework.stereotype.Service;
import com.controlcalidad.model.CapacitacionPersonal;
import com.controlcalidad.repository.ICapacitacionPersonalRepository;

/**
 * Implementación del servicio para CapacitacionPersonal.
 * Extiende GenericServiceImpl<CapacitacionPersonal, Integer, ICapacitacionPersonalRepository>
 * para heredar los 5 métodos CRUD genéricos.
 *
 * Solo necesita:
 * 1. Inyectar su repository via constructor (RequiredArgsConstructor o manual)
 * 2. Implementar setId() para indicar cómo asignar el ID en update()
 */
@Service
public class CapacitacionPersonalService
        extends GenericServiceImpl<CapacitacionPersonal, Integer, ICapacitacionPersonalRepository>
        implements ICapacitacionPersonalService {

    public CapacitacionPersonalService(ICapacitacionPersonalRepository repository) {
        super(repository);
    }

    /**
     * Indica a GenericServiceImpl cómo asignar el ID a la entidad CapacitacionPersonal
     * durante la operación update().
     */
    @Override
    protected void setId(CapacitacionPersonal entity, Integer id) {
        entity.setIdCapacitacion(id);
    }
}
