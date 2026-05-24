package com.controlcalidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.controlcalidad.model.Permiso;

public interface IPermisoRepository extends JpaRepository<Permiso, Integer> {

}
