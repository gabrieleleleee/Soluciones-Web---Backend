package com.controlcalidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.controlcalidad.model.Defecto;

public interface IDefectoRepository extends JpaRepository<Defecto, Integer> {

}
