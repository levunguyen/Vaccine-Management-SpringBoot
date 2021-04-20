package com.project.repository;

import com.project.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface StorageRepository extends JpaRepository<Storage,Integer> {
    /**
     * TinVT
     * create Storage
     * @return
     */
    @Modifying
    @Query(value = "insert into storage(quantity, vaccine_id) values(?1, ?2);", nativeQuery = true)
    void createStorage(int quantity, int vaccineId);

    /**
     * PhucNB
     * @param id
     * @return
     */
    @Query(value = "select  * from storage where vaccine_id = ?",nativeQuery = true)
    Storage getStorage(int id);

    /**
     * KhoaTA
     * Get quantity of a vaccine
     */
    Storage findAllByVaccine_VaccineIdIs(Integer id);
}
