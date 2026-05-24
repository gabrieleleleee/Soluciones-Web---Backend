package com.controlcalidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.controlcalidad.model.CategoriaProducto;

public interface ICategoriaProductoRepository extends JpaRepository<CategoriaProducto, Integer> {

}
