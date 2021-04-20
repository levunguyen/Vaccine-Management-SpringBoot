package com.project.repository;

import java.util.List;

import com.project.dto.VaccineDTO;
import com.project.entity.Vaccine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface VaccineRepository extends JpaRepository<Vaccine, Integer> {

    @Query(value = "select * from vaccine where vaccine_id = ?", nativeQuery = true)
    Vaccine findByVaccineId(Integer id);

    Page<Vaccine> findAllByNameContainingAndVaccineType_NameContainingAndOriginContaining(String name, String vaccineType_name, String origin, Pageable pageable);

    Page<Vaccine> findAllByNameContainingAndVaccineType_NameContainingAndOriginContainingAndQuantityGreaterThan(String name, String vaccineType_name, String origin, Long quantity, Pageable pageable);

    Page<Vaccine> findAllByNameContainingAndVaccineType_NameContainingAndOriginContainingAndQuantityLessThan(String name, String vaccineType_name, String origin, Long quantity, Pageable pageable);

    @Query(value = "select vaccine.vaccine_id as vaccineId, vaccine.name as name, vaccine_type.name as vaccineType, vaccine.origin as origin from vaccine " +
            "join vaccine_type on vaccine.vaccine_type_id = vaccine_type.vaccine_type_id " +
            "where vaccine.vaccine_id = ?1", nativeQuery = true)
    VaccineDTO getVaccineById(Integer id);

    @Query(value = "select vaccine.vaccine_id as id,vaccine.name as name, vaccine_type.name as vaccineType,invoice.transaction_date as dayReceive, " +
            "vaccine.license_code as licenseCode, vaccine.origin as origin, vaccine.dosage as dosage, " +
            "vaccine.expired as expired, vaccine.maintenance as maintenance, vaccine.age as age, vaccine.duration as duration, vaccine.times as times, storage.quantity as quantity " +
            "from vaccine " +
            "left join vaccine_type on vaccine.vaccine_type_id = vaccine_type.vaccine_type_id " +
            "left join storage on storage.vaccine_id = vaccine.vaccine_id " +
            "left join invoice on invoice.vaccine_id = vaccine.vaccine_id " +
            "where vaccine.delete_flag = 0 " +
            "group by vaccine.vaccine_id limit ?1,5;", nativeQuery = true)
    List<VaccineDTO> getAllVaccineDTO(int index);

    @Query(value = "SELECT vaccine.vaccine_id as id,vaccine.name as name, vaccine_type.name as vaccineType,invoice.transaction_date as dayReceive, " +
            "vaccine.license_code as licenseCode, vaccine.origin as origin, vaccine.dosage as dosage," +
            "vaccine.expired as expired, vaccine.maintenance as maintenance, vaccine.age as age, storage.quantity as quantity" +
            " FROM vaccine " +
            "left join vaccine_type on vaccine.vaccine_type_id = vaccine_type.vaccine_type_id " +
            "left join storage on storage.vaccine_id = vaccine.vaccine_id " +
            "left join invoice on invoice.vaccine_id = vaccine.vaccine_id " +
            "WHERE vaccine.delete_flag = 0 " +
            "group by vaccine.vaccine_id", nativeQuery = true)
    List<VaccineDTO> getAllVaccineDTONotPagination();

    @Query(value = "SELECT vaccine.vaccine_id as id,vaccine.name as name, vaccine_type.name as vaccineType,invoice.transaction_date as dayReceive, " +
            "vaccine.license_code as licenseCode, vaccine.origin as origin, vaccine.dosage as dosage," +
            "vaccine.expired as expired, vaccine.maintenance as maintenance, vaccine.age as age, storage.quantity as quantity " +
            "FROM vaccine left join vaccine_type on vaccine.vaccine_type_id = vaccine_type.vaccine_type_id " +
            "left join storage on storage.vaccine_id = vaccine.vaccine_id " +
            "left join invoice on invoice.vaccine_id = vaccine.vaccine_id " +
            "where vaccine.name like %?1% and vaccine_type.name like %?2% and vaccine.origin like %?3% " +
            "and vaccine.delete_flag = 0 " +
            "group by vaccine.vaccine_id", nativeQuery = true)
    List<VaccineDTO> search(String name, String vaccineType, String origin);

    @Modifying
    @Query(value = "insert into vaccine(vaccine.name, vaccine.dosage, vaccine.license_code , vaccine.maintenance, " +
            "vaccine.origin, vaccine.expired, vaccine.age, vaccine.quantity, vaccine.vaccine_type_id,vaccine.duration, " +
            "vaccine.times, vaccine.delete_flag)\n" +
            "value(?1, ?2, ?3, ?4, ?5,?6, ?7, ?8, ?9,?10,?11,0);", nativeQuery = true)
    void createVaccine(String nameVaccine, double dosageVaccine, String licenseCode, String maintenance, String origin,
                       String expired, String age, int quantity, int vaccineTypeId, int vaccineDuration, int vaccineTimes);

    @Query(value = "select * from vaccine where vaccine.name = ?1", nativeQuery = true)
    Vaccine searchName(String name);

    @Query(value = "select * from vaccine", nativeQuery = true)
    List<Vaccine> getAllVaccine();

    Page<Vaccine> findAllByDurationIsNotNull(Pageable pageable);
}

