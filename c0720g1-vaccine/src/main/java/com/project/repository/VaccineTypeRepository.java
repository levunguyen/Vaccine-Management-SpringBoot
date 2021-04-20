package com.project.repository;

import com.project.entity.VaccineType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface VaccineTypeRepository extends JpaRepository<VaccineType,Integer> {

    /**
     * TinVT
     * create vaccineType
     * @return
     */
    @Modifying
    @Query(value = "insert into vaccine_type(name) values (?1);", nativeQuery = true)
    void createVaccineType(String name);

    /**
     * TinVT
     * find vaccineType by name
     * @return
     */
    @Query(value = "select * from vaccine_type where name = ?;",nativeQuery = true)
    VaccineType findName(String name);
}