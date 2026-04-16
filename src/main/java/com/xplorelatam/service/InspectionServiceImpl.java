package com.xplorelatam.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.xplorelatam.model.Inspection;
import com.xplorelatam.repository.IInspectionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InspectionServiceImpl implements IInspectionService {

    private final IInspectionRepository repo; // Sin el = null

    @Override
    public Inspection save(Inspection inspection) throws Exception {
        return repo.save(inspection);
    }

    @Override
    public List<Inspection> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Inspection findById(Integer id) throws Exception {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}