package com.controlcalidad.service;

import org.springframework.stereotype.Service;
import com.controlcalidad.model.AccionCorrectiva;
import com.controlcalidad.repository.IAccionCorrectivaRepository;

/**
 * Implementación del servicio para AccionCorrectiva.
 * Extiende GenericServiceImpl<AccionCorrectiva, Integer, IAccionCorrectivaRepository>
 * para heredar los 5 métodos CRUD genéricos.
 *
 * Solo necesita:
 * 1. Inyectar su repository via constructor (RequiredArgsConstructor o manual)
 * 2. Implementar setId() para indicar cómo asignar el ID en update()
 */
@Service
public class AccionCorrectivaService
        extends GenericServiceImpl<AccionCorrectiva, Integer, IAccionCorrectivaRepository>
        implements IAccionCorrectivaService {

    public AccionCorrectivaService(IAccionCorrectivaRepository repository) {
        super(repository);
    }

    /**
     * Indica a GenericServiceImpl cómo asignar el ID a la entidad AccionCorrectiva
     * durante la operación update().
     */
    @Override
    protected void setId(AccionCorrectiva entity, Integer id) {
        entity.setIdAccion(id);
    }
}
