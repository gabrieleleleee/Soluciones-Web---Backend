package com.controlcalidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.controlcalidad.model.AlertaCalidad;

public interface IAlertaCalidadRepository extends JpaRepository<AlertaCalidad, Integer> {

}
