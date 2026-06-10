package com.controlcalidad.service;

import org.springframework.stereotype.Service;
import com.controlcalidad.model.MotivoRechazo;
import com.controlcalidad.repository.IMotivoRechazoRepository;

/**
 * Implementación del servicio para MotivoRechazo.
 * Extiende GenericServiceImpl<MotivoRechazo, Integer, IMotivoRechazoRepository>
 * para heredar los 5 métodos CRUD genéricos.
 *
 * Solo necesita:
 * 1. Inyectar su repository via constructor (RequiredArgsConstructor o manual)
 * 2. Implementar setId() para indicar cómo asignar el ID en update()
 */
@Service
public class MotivoRechazoService
        extends GenericServiceImpl<MotivoRechazo, Integer, IMotivoRechazoRepository>
        implements IMotivoRechazoService {

    public MotivoRechazoService(IMotivoRechazoRepository repository) {
        super(repository);
    }

    /**
     * Indica a GenericServiceImpl cómo asignar el ID a la entidad MotivoRechazo
     * durante la operación update().
     */
    @Override
    protected void setId(MotivoRechazo entity, Integer id) {
        entity.setIdMotivo(id);
    }
}
