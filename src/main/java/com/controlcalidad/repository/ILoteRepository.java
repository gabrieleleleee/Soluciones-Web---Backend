package com.controlcalidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controlcalidad.model.Lote;

public interface ILoteRepository extends JpaRepository<Lote, Integer> {

}
