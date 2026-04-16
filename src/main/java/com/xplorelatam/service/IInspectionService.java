package com.xplorelatam.service;

import java.util.List;
import com.xplorelatam.model.Inspection;

public interface IInspectionService {
    Inspection save(Inspection inspection) throws Exception;
    List<Inspection> findAll() throws Exception;
    Inspection findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}