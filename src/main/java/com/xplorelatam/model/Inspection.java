package com.xplorelatam.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inspections")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Inspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idInspection;

    @Column(nullable = false, length = 50)
    private String lotNumber; 

    @Column(nullable = false, length = 100)
    private String productType; 

    @Column(nullable = false)
    private Double qualityScore; 

    @Column(length = 250)
    private String observations; 

    @Column(nullable = false)
    private boolean isApproved; 
}