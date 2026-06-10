package com.controlcalidad.service;

import org.springframework.stereotype.Service;
import com.controlcalidad.model.HistorialMantenimiento;
import com.controlcalidad.repository.IHistorialMantenimientoRepository;

/**
 * Implementación del servicio para HistorialMantenimiento.
 * Extiende GenericServiceImpl<HistorialMantenimiento, Integer, IHistorialMantenimientoRepository>
 * para heredar los 5 métodos CRUD genéricos.
 *
 * Solo necesita:
 * 1. Inyectar su repository via constructor (RequiredArgsConstructor o manual)
 * 2. Implementar setId() para indicar cómo asignar el ID en update()
 */
@Service
public class HistorialMantenimientoService
        extends GenericServiceImpl<HistorialMantenimiento, Integer, IHistorialMantenimientoRepository>
        implements IHistorialMantenimientoService {

    public HistorialMantenimientoService(IHistorialMantenimientoRepository repository) {
        super(repository);
    }

    /**
     * Indica a GenericServiceImpl cómo asignar el ID a la entidad HistorialMantenimiento
     * durante la operación update().
     */
    @Override
    protected void setId(HistorialMantenimiento entity, Integer id) {
        entity.setIdMantenimiento(id);
    }
}
