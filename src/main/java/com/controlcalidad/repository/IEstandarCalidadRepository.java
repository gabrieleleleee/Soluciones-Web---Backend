package com.controlcalidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controlcalidad.model.EstandarCalidad;

public interface IEstandarCalidadRepository extends JpaRepository<EstandarCalidad, Integer> {

}
