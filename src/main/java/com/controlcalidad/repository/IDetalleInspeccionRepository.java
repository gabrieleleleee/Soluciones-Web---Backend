package com.controlcalidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.controlcalidad.model.DetalleInspeccion;

public interface IDetalleInspeccionRepository extends JpaRepository<DetalleInspeccion, Integer> {

}
