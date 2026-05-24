package com.controlcalidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.controlcalidad.model.Inspeccion;

public interface IInspeccionRepository extends JpaRepository<Inspeccion, Integer> {

}
