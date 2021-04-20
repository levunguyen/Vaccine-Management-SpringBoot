package com.project.repository;

import com.project.dto.PatientDTO;
import com.project.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    Page<Patient> findAllByDeleteFlagIsFalse(Pageable pageable);

    @Query(value = "select * from patient where patient_id = ?", nativeQuery = true)
    Patient findById(int id);

    @Transactional
    @Modifying
    @Query(value = "update patient as p " +
            "set p.name =?1,p.date_of_birth =?2,p.gender =?3" +
            ",p.guardian =?4,p.phone =?5,p.address =?6,p.email =?7 where patient_id =?8", nativeQuery = true)
    void editPatient(String name, String date_of_birth, String gender, String guardian, String phone,
                     String address, String email, Integer id);

    @Query(value = "select * " +
            "from patient " +
            "where delete_flag = 0 and patient.name like %?1% and patient.patient_id like %?2%",
            nativeQuery = true)
    List<Patient> search(String name, String id);

    @Query(value = "select count(email) from patient where email = ?", nativeQuery = true)
    Integer findByEmail(String email);

    @Query(value = "select count(phone) from patient where phone = ?", nativeQuery = true)
    Integer findByPhone(String email);

    @Query(value = "select max(patient_id) from patient", nativeQuery = true)
    int findLatestPatientId();

    @Modifying
    @Transactional
    @Query(value = "insert into patient(name,date_of_birth,gender,guardian,phone,address,email) values (?1,?2,?3,?4,?5,?6,?7)", nativeQuery = true)
    void savePatient(String name, String dateOfBirth, String gender, String guardian, String phone, String address, String email);

    List<Patient> findAllByEmailAndDeleteFlag(String email, Boolean deleteFlag);

    Patient findAllByAccount_AccountIdAndDeleteFlag(int id, Boolean deleteFlag);

    @Modifying
    @Transactional
    @Query(value = "insert into patient(name,date_of_birth,gender,guardian,phone,address,email,account_id,delete_flag) values (?1,?2,?3,?4,?5,?6,?7,?8,?9)", nativeQuery = true)
    void savePatientToRegister(String name, String dateOfBirth, String gender, String guardian, String phone, String address, String email, Integer accountId, Boolean deleteFlag);
}
