package com.xplorelatam.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.xplorelatam.model.Inspection;
import com.xplorelatam.service.IInspectionService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inspections")
@RequiredArgsConstructor
public class InspectionController {

    private final IInspectionService service; 

    @GetMapping
    public List<Inspection> findAll() throws Exception {
        return service.findAll();
    }

    @PostMapping
    public Inspection save(@RequestBody Inspection inspection) throws Exception {
        return service.save(inspection);
    }

    @GetMapping("/{id}")
    public Inspection findById(@PathVariable("id") Integer id) throws Exception {
        return service.findById(id);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}