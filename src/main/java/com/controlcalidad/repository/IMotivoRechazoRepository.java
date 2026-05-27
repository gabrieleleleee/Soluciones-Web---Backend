package com.controlcalidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.controlcalidad.model.MotivoRechazo;

public interface IMotivoRechazoRepository extends JpaRepository<MotivoRechazo, Integer> {

}
