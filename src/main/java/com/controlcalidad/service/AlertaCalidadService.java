package com.controlcalidad.service;

import org.springframework.stereotype.Service;
import com.controlcalidad.model.AlertaCalidad;
import com.controlcalidad.repository.IAlertaCalidadRepository;

/**
 * Implementación del servicio para AlertaCalidad.
 * Extiende GenericServiceImpl<AlertaCalidad, Integer, IAlertaCalidadRepository>
 * para heredar los 5 métodos CRUD genéricos.
 *
 * Solo necesita:
 * 1. Inyectar su repository via constructor (RequiredArgsConstructor o manual)
 * 2. Implementar setId() para indicar cómo asignar el ID en update()
 */
@Service
public class AlertaCalidadService
        extends GenericServiceImpl<AlertaCalidad, Integer, IAlertaCalidadRepository>
        implements IAlertaCalidadService {

    public AlertaCalidadService(IAlertaCalidadRepository repository) {
        super(repository);
    }

    /**
     * Indica a GenericServiceImpl cómo asignar el ID a la entidad AlertaCalidad
     * durante la operación update().
     */
    @Override
    protected void setId(AlertaCalidad entity, Integer id) {
        entity.setIdAlerta(id);
    }
}
