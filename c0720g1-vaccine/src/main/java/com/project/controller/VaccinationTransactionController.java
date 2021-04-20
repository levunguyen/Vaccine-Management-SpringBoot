package com.project.controller;

import com.project.dto.SearchCriteria;
import com.project.entity.VaccinationTransaction;
import com.project.repository.VaccinationHistoryRepository;
import com.project.service.VaccinationTransactionService;
import com.project.service.impl.VaccinationTransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "http://localhost:4200")
public class VaccinationTransactionController {

    @Autowired
    private VaccinationTransactionService vaccinationTransactionService;

    @Autowired
    private VaccinationHistoryRepository vaccinationHistoryRepository;

    /**
     * Made by Khanh phân trang, tìm kiếm , hiển thị list giao dịch
     */
    @GetMapping({"/vaccine-transaction-list"})
    public ResponseEntity<?> listVaccineTransaction(@PageableDefault(size = 5) Pageable pageable) {
        return new ResponseEntity<>(vaccinationTransactionService.findAll(pageable), HttpStatus.OK);
    }

    /**
     * Made by Khanh tìm kiếm , phân trang, hiển thị list tìm kiếm giao dịch
     */
    @PostMapping("/vaccine-transaction-search")
    public ResponseEntity<?> searchVaccineTransaction(@PageableDefault(size = 5) Pageable pageable,
                                                      @RequestBody SearchCriteria searchCriteria) {
        String keyWordForSearchNamePatient = "";
        String keyWordForSearchVaccineType = "";
        keyWordForSearchNamePatient = searchCriteria.getKeyword2();
        keyWordForSearchVaccineType = searchCriteria.getKeyword3();
        Page<VaccinationTransaction> vaccinationTransactions;
        vaccinationTransactions = vaccinationTransactionService.search(keyWordForSearchNamePatient, keyWordForSearchVaccineType, pageable);
        return new ResponseEntity<>(vaccinationTransactions, HttpStatus.OK);
    }

    /**
     * Made by Khanh tạo mới giao dịch
     */
    @PostMapping("/vaccine-transaction-create")
    public ResponseEntity<?> createVaccineTransaction(@RequestParam Integer idVaccineHistory,
                                                      @RequestParam double price,
                                                      @RequestParam Long quantity) {
        this.vaccinationTransactionService.save(idVaccineHistory, price, quantity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Made by Khanh sửa giao dịch
     */
    @PostMapping("/vaccine-transaction-edit-by-id")
    public ResponseEntity<?> editVaccineTransaction(@RequestParam Integer id,
                                                    @RequestParam double price,
                                                    @RequestParam Long quantity) {
        this.vaccinationTransactionService.edit(id, price, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Made by Khanh lấy văc xin bằng id
     */
    @GetMapping("/get-vaccine-transaction-id/{id}")
    public ResponseEntity<?> getId(@PathVariable Integer id) {
        return new ResponseEntity<>(this.vaccinationTransactionService.findById(id), HttpStatus.OK);
    }

    /**
     * Made by Khanh xóa giao dịch bằng id
     */
    @DeleteMapping("/vaccine-transaction-delete/{id}")
    public ResponseEntity<?> deleteVaccineTransaction(@PathVariable Integer id) {
        this.vaccinationTransactionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    /**
     * Made by Khanh lấy 1 đối tượng vaccine history bằng id
     */
    @GetMapping("/vaccine-history-patient/{id}")
    public ResponseEntity<?> findByIdNamePatient(@PathVariable Integer id) {
        return new ResponseEntity<>(this.vaccinationHistoryRepository.findById(id), HttpStatus.OK);
    }
}
