package com.controlcalidad.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Implementación genérica base para todos los servicios del sistema.
 * <T>  = tipo de la entidad (Rol, Producto, Lote, etc.)
 * <ID> = tipo del identificador (Integer en todos nuestros casos)
 * <R>  = tipo del Repository que extiende JpaRepository<T, ID>
 *
 * Cada XxxService extiende esta clase y solo necesita:
 * 1. Llamar al super constructor con su repository
 * 2. Implementar setId() para el método update
 */
public abstract class GenericServiceImpl<T, ID, R extends JpaRepository<T, ID>>
        implements IGenericService<T, ID> {

    // El repository específico de cada entidad, inyectado por el constructor
    protected final R repository;

    protected GenericServiceImpl(R repository) {
        this.repository = repository;
    }

    /**
     * Cada subclase debe implementar este método para asignar el ID
     * a la entidad antes de actualizar.
     * Ejemplo en RolService: entity.setIdRol(id)
     */
    protected abstract void setId(T entity, ID id);

    @Override
    public T save(T entity) throws Exception {
        return repository.save(entity);
    }

    @Override
    public T update(T entity, ID id) throws Exception {
        // Verificar que existe antes de actualizar
        if (!repository.existsById(id)) {
            throw new RuntimeException("Registro con id " + id + " no encontrado");
        }
        // Asignar el ID usando el método abstracto que cada subclase implementa
        setId(entity, id);
        return repository.save(entity);
    }

    @Override
    public List<T> findAll() throws Exception {
        return repository.findAll();
    }

    @Override
    public T findById(ID id) throws Exception {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Registro con id " + id + " no encontrado"));
    }

    @Override
    public void delete(ID id) throws Exception {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Registro con id " + id + " no encontrado");
        }
        repository.deleteById(id);
    }
}
