package com.project.controller;

import com.project.dto.SearchCriteria;
import com.project.entity.Storage;
import com.project.entity.Vaccine;
import com.project.repository.VaccineTypeRepository;
import com.project.service.StorageService;
import com.project.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.project.service.ImportAndExportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "http://localhost:4200")
public class ImportExportController {
    @Autowired
    private ImportAndExportService importAndExportService;

    @Autowired
    private VaccineTypeRepository vaccineTypeRepository;
    /**
     * Phuc NB
     */
    @Autowired
    private VaccineService vaccineService;
    @Autowired
    StorageService storageService;

    /**
     * Made by Khanh hiển thị list vaccine
     */
    @PostMapping("/vaccine-price-list")
    public ResponseEntity<?> listPriceVaccine(@PageableDefault(size = 5) Pageable pageable
    ) {
        return new ResponseEntity<>(importAndExportService.findAll("export", pageable), HttpStatus.OK);
    }

    /**
     * Made by Khanh tìm kiếm , phân trang, hiển thị list vaccine
     */
    @PostMapping("/vaccine-price-search")
    public ResponseEntity<?> searchVaccinePrice(@PageableDefault(size = 5) Pageable pageable,
                                                @RequestBody SearchCriteria searchCriteria) {
        String keyWordForSearchVaccineType = "";
        String keyWordForSearchVaccineOrigin = "";

        keyWordForSearchVaccineType = searchCriteria.getKeyword2();
        keyWordForSearchVaccineOrigin = searchCriteria.getKeyword3();
        return new ResponseEntity<>(importAndExportService.search("export",
                keyWordForSearchVaccineType, keyWordForSearchVaccineOrigin, pageable), HttpStatus.OK);

    }

    /**
     * Made by Khanh chỉnh sửa giá vaccine
     */
    @PutMapping("/vaccine-price-edit/{id}/{price}")
    public ResponseEntity<?> editPriceVaccine(@PathVariable Integer id, @PathVariable Long price) {
        this.importAndExportService.editPrice(id, price);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Made by Khanh lấy đối tượng export bằng id
     */
    @GetMapping("/getExportId/{id}")
    public ResponseEntity<?> getId(@PathVariable Integer id) {
        return new ResponseEntity<>(this.importAndExportService.findById(id), HttpStatus.OK);
    }

    /**
     * Made by Khanh lấy tên kiểu vắc xin
     */
    @GetMapping("/getVaccineType")
    public ResponseEntity<?> getVaccineType() {
        return new ResponseEntity<>(this.vaccineTypeRepository.findAll(), HttpStatus.OK);
    }

    /**
     * Made by Khanh lấy xuất sứ văc xin
     */
    @GetMapping("/getOriginVaccine")
    public ResponseEntity<?> getOriginVaccine() {
        return new ResponseEntity<>(this.vaccineService.getAllVaccine(), HttpStatus.OK);
    }

    /**
     * Phuc NB
     * xử lý nghiệp vụ trừ số lượng khi xuất kho
     */
    @GetMapping("/{id}/exportVaccine")
    public ResponseEntity<?> exportVaccine(@Validated @PathVariable Integer id, @RequestParam("input") Long input) {
        Storage storageList = storageService.getStorage(id);
//        for (Storage storage : storageList) {
//            if (storage.getQuantity() > 0 ) {
//                if (storage.getQuantity() <= input){
//                   input = input - storage.getQuantity();
//                   storage.setQuantity(0L);
//                   storageService.saveStorage(storage);
//                    continue;
//                }
////                else if (storage.getQuantity() == input){
////                    input = input - storage.getQuantity();
////                    storage.setQuantity(0L);
////                    storageService.saveStorage(storage);
////                    continue;
////                }
//                storage.setQuantity(storage.getQuantity() - input);
//                storageService.saveStorage(storage);
//            }
//        }
        if (storageList.getQuantity() < input){
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }else {
            storageList.setQuantity(storageList.getQuantity() - input);
            storageService.saveStorage(storageList);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }

    /**
     * Phuc NB
     * lấy ra id của vắc-xin cần xuất kho
     **/
    @GetMapping("/getVaccine/{idVaccine}")
    public ResponseEntity<Vaccine> findVaccineById(@PathVariable Integer idVaccine) {
        Vaccine vaccine;
        vaccine = vaccineService.findById(idVaccine);
        if (vaccine == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(vaccine, HttpStatus.OK);
        }
    }
}
