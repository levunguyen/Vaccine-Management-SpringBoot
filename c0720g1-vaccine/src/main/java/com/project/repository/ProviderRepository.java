package com.project.repository;

import com.project.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ProviderRepository extends JpaRepository<Provider,Integer> {

    /**
     * TinVT
     * create Provider
     * @return
     */
    @Modifying
    @Query(value = "insert into provider(name) values(?1);", nativeQuery = true)
    void createProvider(String name);

    /**
     * TinVT
     * find by name Provider
     * @return
     */
    @Query(value = "select * from provider where provider.name = ?",nativeQuery = true)
    Provider searchNameProvider(String name);
}
