package com.controlcalidad.service;

import org.springframework.stereotype.Service;
import com.controlcalidad.model.CategoriaProducto;
import com.controlcalidad.repository.ICategoriaProductoRepository;

/**
 * Implementación del servicio para CategoriaProducto.
 * Extiende GenericServiceImpl<CategoriaProducto, Integer, ICategoriaProductoRepository>
 * para heredar los 5 métodos CRUD genéricos.
 *
 * Solo necesita:
 * 1. Inyectar su repository via constructor (RequiredArgsConstructor o manual)
 * 2. Implementar setId() para indicar cómo asignar el ID en update()
 */
@Service
public class CategoriaProductoService
        extends GenericServiceImpl<CategoriaProducto, Integer, ICategoriaProductoRepository>
        implements ICategoriaProductoService {

    public CategoriaProductoService(ICategoriaProductoRepository repository) {
        super(repository);
    }

    /**
     * Indica a GenericServiceImpl cómo asignar el ID a la entidad CategoriaProducto
     * durante la operación update().
     */
    @Override
    protected void setId(CategoriaProducto entity, Integer id) {
        entity.setIdCategoria(id);
    }
}
