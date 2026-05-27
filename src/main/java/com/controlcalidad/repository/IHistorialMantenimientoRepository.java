package com.controlcalidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.controlcalidad.model.HistorialMantenimiento;

public interface IHistorialMantenimientoRepository extends JpaRepository<HistorialMantenimiento, Integer> {

}
