package com.project.repository;

import com.project.entity.VaccinationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationTypeRepository extends JpaRepository<VaccinationType , Integer> {
}
