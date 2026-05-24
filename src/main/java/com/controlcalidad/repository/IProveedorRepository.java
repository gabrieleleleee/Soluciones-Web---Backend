package com.controlcalidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.controlcalidad.model.Proveedor;

public interface IProveedorRepository extends JpaRepository<Proveedor, Integer> {

}
