package com.controlcalidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.controlcalidad.model.AccionCorrectiva;

public interface IAccionCorrectivaRepository extends JpaRepository<AccionCorrectiva, Integer> {

}
