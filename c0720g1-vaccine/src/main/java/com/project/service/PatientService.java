package com.project.service;
import com.project.dto.PatientDTO;
import com.project.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface PatientService {

    Page<Patient> findAllPatient2(Pageable pageable);

    Patient findPatientById(int id);

    Page<Patient> search(String name, String id, int pageable);

    void editPatient(Patient patient);

    void addPatient(String name, String dateOfBirth, String gender, String guardian, String phone, String address, String email,Integer accountId,Boolean deleteFlag);

    Patient create(Patient patientTemp);

    Integer findByEmail(String email);

    Integer findByPhone(String phone);

    List<Patient> findAllByEmail(String email, boolean b);

    Patient findByAccountId(int id, boolean b);

    Patient getPatientById(Integer patientId);

}
