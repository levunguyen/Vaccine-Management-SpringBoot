package com.project.controller;

import com.project.dto.VaccinationByRequestDTO;
import com.project.dto.VaccineDTO;
import com.project.entity.*;
import com.project.repository.VaccinationHistoryRepository;
import com.project.service.PatientService;
import com.project.service.VaccinationHistoryService;
import com.project.service.VaccinationService;
import com.project.service.VaccineService;
import com.project.validation.VaccinationByRequestDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * PhuocTC
 **/

@RestController
@CrossOrigin(value = "*", allowedHeaders = "*")
@RequestMapping(value = "/api")
public class VaccinationByRequest {

    @Autowired
    private VaccineService vaccineService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private VaccinationService vaccinationService;

    @Autowired
    private VaccinationHistoryService vaccinationHistoryService;

    @Autowired
    private VaccinationByRequestDTOValidator vaccinationByRequestDTOValidator;


    /**
     * PhuocTC: Tìm kiếm + Phân trang
     **/
    @GetMapping(value = "/public/vaccine/list")
    public ResponseEntity<Page<Vaccine>> getListVaccine(@PageableDefault(size = 5) Pageable pageable,
                                                        @RequestParam(defaultValue = "") String name,
                                                        @RequestParam(defaultValue = "") String vaccineTypeName,
                                                        @RequestParam(defaultValue = "") String origin,
                                                        @RequestParam(defaultValue = "") String status) {
        Page<Vaccine> vaccineList;

        if (status.equals("false")) {
            vaccineList = vaccineService.findAllByQuantityIsNotExits(name, vaccineTypeName, origin, pageable);
        } else if (status.equals("true")) {
            vaccineList = vaccineService.findAllByQuantityIsExits(name, vaccineTypeName, origin, pageable);
        } else {
            vaccineList = vaccineService.findAllByNameContainingAndVaccineType_NameContainingAndOriginContaining(name, vaccineTypeName, origin, pageable);
        }

        if (vaccineList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(vaccineList, HttpStatus.OK);
        }


    }


    /**
     * PhuocTC: Get Vắc-xin theo Id
     **/
    @GetMapping(value = "/public/vaccination/get-vaccine/{id}")
    public ResponseEntity<?> registerVaccination(@PathVariable Integer id) {

        VaccineDTO vaccineDTO = vaccineService.getVaccineById(id);

        Vaccine vaccine = vaccineService.getVaccineByIdNameQuery(id);

        if (vaccineDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(vaccine, HttpStatus.OK);
        }
    }


    /**
     * PhuocTC: Tạo mới đăng ký tim theo yêu cầu
     **/
    @PostMapping(value = "/public/vaccination/create")
    public ResponseEntity<?> registerPatient(@Valid @RequestBody VaccinationByRequestDTO vaccinationByRequestDTO,
                                             BindingResult bindingResult) throws UnsupportedEncodingException, MessagingException {

        Patient patientTemp = patientService.getPatientById(vaccinationByRequestDTO.getPatientId());
        Vaccine vaccineTemp = vaccineService.findById(vaccinationByRequestDTO.getVaccineId());

        Vaccination vaccinationTemp = null;
        VaccinationHistory vaccinationHistoryTemp= null;
        if (vaccineTemp.getDuration() != null) {
            for (int i = 0; i < vaccineTemp.getTimes(); i++) {
                vaccinationTemp = new Vaccination();
                vaccinationTemp.setVaccine(vaccineTemp);
                vaccinationTemp.setDate(vaccinationByRequestDTO.getDateVaccination());

//                String[] dateSplit = vaccinationByRequestDTO.getDateVaccination().split("-");
//                dateSplit[0] = String.valueOf(Integer.parseInt(dateSplit[0]) - 1900);
//                Date date = new Date(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]) - 1, Integer.parseInt(dateSplit[2]));
//                if (i > 0) {
//                    date.setDate((vaccineTemp.getDuration() * (i)));
//                }
//                String year = date.getYear() + 1900 + "";
//                String month = date.getMonth() < 10 ? "0"+ (date.getMonth() + 1) : (date.getMonth() + 1) + "";
//                String day = date.getDate() < 10 ? "0" + date.getDate() : date.getDate() + "";
//                LocalDate localDate = LocalDate.parse(year + "-" + month + "-" + day);

                LocalDate localDate = LocalDate.parse(vaccinationByRequestDTO.getDateVaccination());
                vaccinationTemp.setDate(localDate.plusDays(vaccineTemp.getDuration() * i).toString());
                vaccinationTemp.setLocation(new Location(1));
                vaccinationTemp.setVaccinationType(new VaccinationType(2));
                vaccinationTemp.setStatus(false);
                vaccinationTemp.setDeleteFlag(false);

                String[] timeSplit = vaccinationByRequestDTO.getTimeVaccination().split("-");
                timeSplit[0] = timeSplit[0].trim();
                timeSplit[1] = timeSplit[1].trim();

                vaccinationTemp.setStartTime(timeSplit[0]);
                vaccinationTemp.setEndTime(timeSplit[1]);
                if(i>0){
                    vaccinationTemp.setDescription("Tiêm nhắc");
                }

                vaccinationTemp = vaccinationService.registerVaccination(vaccinationTemp);


                vaccinationHistoryTemp = new VaccinationHistory();
                vaccinationHistoryTemp.setPatient(patientTemp);
                vaccinationHistoryTemp.setVaccination(vaccinationTemp);
                vaccinationHistoryTemp.setStatus(false);
                vaccinationHistoryTemp.setVaccinationTimes(i+1);
                vaccinationHistoryTemp.setStartTime(timeSplit[0]);
                vaccinationHistoryTemp.setEndTime(timeSplit[1]);

                vaccinationHistoryService.registerVaccinationHistory(vaccinationHistoryTemp);
            }
        } else {
            vaccinationTemp = new Vaccination();
            vaccinationTemp.setVaccine(vaccineTemp);
            vaccinationTemp.setDate(vaccinationByRequestDTO.getDateVaccination());

            String[] dateSplit = vaccinationByRequestDTO.getDateVaccination().split("-");

            dateSplit[0] = String.valueOf(Integer.parseInt(dateSplit[0]) - 1900);

            Date date = new Date(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]) - 1, Integer.parseInt(dateSplit[2]));

            String year = date.getYear() + 1900 + "";
            String month = date.getMonth() < 10 ? "0"+ (date.getMonth() + 1) : (date.getMonth() + 1) + "";
            String day = date.getDate() < 10 ? "0" + date.getDate() : date.getDate() + "";

            LocalDate localDate = LocalDate.parse(year + "-" + month + "-" + day);

            vaccinationTemp.setDate(localDate.toString());

            vaccinationTemp.setLocation(new Location(1));
            vaccinationTemp.setVaccinationType(new VaccinationType(2));
            vaccinationTemp.setStatus(false);
            vaccinationTemp.setDeleteFlag(false);

            String[] timeSplit = vaccinationByRequestDTO.getTimeVaccination().split("-");
            timeSplit[0] = timeSplit[0].trim();
            timeSplit[1] = timeSplit[1].trim();

            vaccinationTemp.setStartTime(timeSplit[0]);
            vaccinationTemp.setEndTime(timeSplit[1]);
            vaccinationTemp = vaccinationService.registerVaccination(vaccinationTemp);


            vaccinationHistoryTemp = new VaccinationHistory();
            vaccinationHistoryTemp.setPatient(patientTemp);
            vaccinationHistoryTemp.setVaccination(vaccinationTemp);
            vaccinationHistoryTemp.setStatus(false);

            vaccinationHistoryTemp.setStartTime(timeSplit[0]);
            vaccinationHistoryTemp.setEndTime(timeSplit[1]);

            vaccinationHistoryService.registerVaccinationHistory(vaccinationHistoryTemp);
        }

        this.vaccinationHistoryService.sendMail(vaccinationByRequestDTO, patientTemp, vaccineTemp, vaccinationTemp);


        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("/public/profile")
    public ResponseEntity<?> getListPatientByEmail(@RequestParam String email) {
        List<Patient> patientList = patientService.findAllByEmail(email, false);

        if (patientList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(patientList, HttpStatus.OK);
    }


    @GetMapping("/public/profile-personal")
    public ResponseEntity<?> getListVaccinationHistoryByPatient(@PageableDefault(size = 5) Pageable pageable,
                                                                @RequestParam(defaultValue = "") Integer patientId,
                                                                @RequestParam(defaultValue = "") String name,
                                                                @RequestParam(defaultValue = "") String date) {


        Page<VaccinationHistory> vaccinationHistoryList;

        if (date.equals("")) {
            vaccinationHistoryList =  vaccinationHistoryService.findAllByPatient_PatientIdAndVaccination_Vaccine_NameContainingAndDeleteFlag(patientId,name,false, pageable);
        } else {
            vaccinationHistoryList =  vaccinationHistoryService.findAllByPatient_PatientIdAndVaccination_Vaccine_NameContainingAndVaccination_Date(patientId,name,date,false, pageable);
        }


        if (vaccinationHistoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(vaccinationHistoryList, HttpStatus.OK);
    }

    @GetMapping(value = "/public/get-total-vaccination-in-date")
    public ResponseEntity<?> getTotalVaccinationInDate(@RequestParam(defaultValue = "") String date) {

        List<Integer> integerList = new ArrayList<>();

        if (!date.equals("")) {

            integerList.add(vaccinationHistoryService.getAllVaccinationByDate(date, false));
            integerList.add(vaccinationHistoryService.getAllVaccinationByDate(date, "08:00:00",false));
            integerList.add(vaccinationHistoryService.getAllVaccinationByDate(date, "09:30:00",false));
            integerList.add(vaccinationHistoryService.getAllVaccinationByDate(date, "13:30:00",false));
            integerList.add(vaccinationHistoryService.getAllVaccinationByDate(date, "15:00:00",false));

            return new ResponseEntity<>(integerList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }


    @GetMapping(value = "/public/get-list-vaccine")
    public ResponseEntity<?> getListVaccine(@PageableDefault Pageable pageable) {
        Page<Vaccine> vaccineList = vaccineService.getAllVaccineByDuration(pageable);

        if (vaccineList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(vaccineList, HttpStatus.OK);
        }
    }
}
