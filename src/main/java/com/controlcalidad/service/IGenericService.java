package com.controlcalidad.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Interfaz genérica base para todos los servicios del sistema.
 * <T> = tipo de la entidad (Rol, Producto, Lote, etc.)
 * <ID> = tipo del identificador (Integer en todos nuestros casos)
 *
 * Cada IXxxService extiende esta interfaz, eliminando la repetición
 * de los 5 métodos CRUD en cada servicio.
 */
public interface IGenericService<T, ID> {

    T save(T entity) throws Exception;

    T update(T entity, ID id) throws Exception;

    List<T> findAll() throws Exception;

    Page<T> findAll(Pageable pageable) throws Exception;

    T findById(ID id) throws Exception;

    void delete(ID id) throws Exception;
}
