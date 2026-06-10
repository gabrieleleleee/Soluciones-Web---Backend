package com.controlcalidad.service;

import org.springframework.stereotype.Service;
import com.controlcalidad.model.DetalleInspeccion;
import com.controlcalidad.repository.IDetalleInspeccionRepository;

/**
 * Implementación del servicio para DetalleInspeccion.
 * Extiende GenericServiceImpl<DetalleInspeccion, Integer, IDetalleInspeccionRepository>
 * para heredar los 5 métodos CRUD genéricos.
 *
 * Solo necesita:
 * 1. Inyectar su repository via constructor (RequiredArgsConstructor o manual)
 * 2. Implementar setId() para indicar cómo asignar el ID en update()
 */
@Service
public class DetalleInspeccionService
        extends GenericServiceImpl<DetalleInspeccion, Integer, IDetalleInspeccionRepository>
        implements IDetalleInspeccionService {

    public DetalleInspeccionService(IDetalleInspeccionRepository repository) {
        super(repository);
    }

    /**
     * Indica a GenericServiceImpl cómo asignar el ID a la entidad DetalleInspeccion
     * durante la operación update().
     */
    @Override
    protected void setId(DetalleInspeccion entity, Integer id) {
        entity.setIdDetalle(id);
    }
}
