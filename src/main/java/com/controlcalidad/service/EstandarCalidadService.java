package com.controlcalidad.service;

import org.springframework.stereotype.Service;
import com.controlcalidad.model.EstandarCalidad;
import com.controlcalidad.repository.IEstandarCalidadRepository;

/**
 * Implementación del servicio para EstandarCalidad.
 * Extiende GenericServiceImpl<EstandarCalidad, Integer, IEstandarCalidadRepository>
 * para heredar los 5 métodos CRUD genéricos.
 *
 * Solo necesita:
 * 1. Inyectar su repository via constructor (RequiredArgsConstructor o manual)
 * 2. Implementar setId() para indicar cómo asignar el ID en update()
 */
@Service
public class EstandarCalidadService
        extends GenericServiceImpl<EstandarCalidad, Integer, IEstandarCalidadRepository>
        implements IEstandarCalidadService {

    public EstandarCalidadService(IEstandarCalidadRepository repository) {
        super(repository);
    }

    /**
     * Indica a GenericServiceImpl cómo asignar el ID a la entidad EstandarCalidad
     * durante la operación update().
     */
    @Override
    protected void setId(EstandarCalidad entity, Integer id) {
        entity.setIdEstandar(id);
    }
}
