package com.project.controller;

import com.project.dto.CreateVaccineDTO;
import com.project.dto.VaccineDTO;
import com.project.entity.Provider;
import com.project.entity.Vaccine;
import com.project.entity.VaccineType;
import com.project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/public")
public class VaccineController {

    @Autowired
    private VaccineService vaccineService;
    @Autowired
    private VaccineTypeService vaccineTypeService;
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private StorageService storageService;
    @Autowired
    private ProviderService providerService;

    @GetMapping("/vaccines")
    public ResponseEntity<List<VaccineDTO>> getAllVaccine(@RequestParam int index) {
        List<VaccineDTO> vaccines = vaccineService.getAllVaccineDTO(index);
        if (vaccines.isEmpty()) {
            return new ResponseEntity<List<VaccineDTO>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<VaccineDTO>>(vaccines, HttpStatus.OK);
    }

    @GetMapping("/vaccines-not-pagination")
    public ResponseEntity<List<VaccineDTO>> getAllVaccineNotPagination() {
        List<VaccineDTO> vaccines = vaccineService.getAllVaccineDTONotPagination();
        if (vaccines.isEmpty()) {
            return new ResponseEntity<List<VaccineDTO>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<VaccineDTO>>(vaccines, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<VaccineDTO>> search(@RequestParam(defaultValue = "") String nameVaccine,
                                                   @RequestParam(defaultValue = "") String typeVaccine,
                                                   @RequestParam(defaultValue = "") String originVaccine,
                                                   @RequestParam(defaultValue = "") String statusVaccine) {

        List<VaccineDTO> vaccines = vaccineService.search(nameVaccine, typeVaccine, originVaccine);
        List<VaccineDTO> vaccineDTOList = new ArrayList<>();

        if (statusVaccine.equals("con")) {
            for (VaccineDTO vaccineDTO : vaccines) {
                if (vaccineDTO.getQuantity() > 0) {
                    vaccineDTOList.add(vaccineDTO);
                }
            }
        } else {
            for (VaccineDTO vaccineDTO : vaccines) {
                if (vaccineDTO.getQuantity() == 0) {
                    vaccineDTOList.add(vaccineDTO);
                }
            }
        }
        if (vaccines.isEmpty()) {
            return new ResponseEntity<List<VaccineDTO>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<VaccineDTO>>(vaccineDTOList, HttpStatus.OK);
    }

    @PostMapping("/vaccine-create")
    public ResponseEntity<Void> createVaccine(@RequestBody CreateVaccineDTO createVaccineDTO) {

        // Check provider
        Provider provider = providerService.searchNameProvider(createVaccineDTO.getProvider());

        if (provider == null) {
            providerService.createProvider(createVaccineDTO.getProvider());
            provider = providerService.searchNameProvider(createVaccineDTO.getProvider());
        }
        createVaccineDTO.setProvider(provider.getProviderId() + "");


        // Check vaccine type
        VaccineType vaccineType = vaccineTypeService.findVaccineType(createVaccineDTO.getTypeVaccine());

        if (vaccineType == null) {
            vaccineTypeService.createVaccineType(createVaccineDTO.getTypeVaccine());
            vaccineType = vaccineTypeService.findVaccineType(createVaccineDTO.getTypeVaccine());
        }
        createVaccineDTO.setTypeVaccine(vaccineType.getVaccineTypeId() + "");

        // Create vaccine
        vaccineService.createVaccine(createVaccineDTO);

        Vaccine vaccine = vaccineService.searchName(createVaccineDTO.getNameVaccine());

        storageService.createStorage((int) createVaccineDTO.getQuantity(), vaccine.getVaccineId());
        invoiceService.createInvoice(createVaccineDTO.getExpired(), createVaccineDTO.getUnitPrice(),
                (int) createVaccineDTO.getQuantity(), createVaccineDTO.getDayReceive(),
                provider.getProviderId(), vaccine.getVaccineId());
        HttpHeaders httpHeaders = new HttpHeaders();

        return new ResponseEntity<Void>(httpHeaders, HttpStatus.OK);
    }
}
