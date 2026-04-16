package com.xplorelatam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xplorelatam.model.Inspection;

public interface IInspectionRepository extends JpaRepository<Inspection, Integer> {
    
}