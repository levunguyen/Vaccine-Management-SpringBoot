package com.project.controller;

import com.project.entity.Location;
import com.project.entity.Vaccination;
import com.project.dto.VaccinationManagerDto;
import com.project.entity.Vaccine;
import com.project.service.LocationService;
import com.project.service.VaccinationManagerService;
import com.project.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
/**
 * TrungTQ Code: Dùng tạo địa chỉ api và mở khóa chặn để truy cập dữ liệu
 */
@RequestMapping("/api/public/vaccination-manager")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VaccinationManagerController {

    @Autowired
    private VaccinationManagerService vaccinationManagerService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private VaccineService vaccineService;

    /**
     * TrungTQ Code: Dùng để lấy danh sách vs phân trang sự kiện tiêm chủng định kỳ
     */

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Page<Vaccination>> listAllVaccination(@PageableDefault(size = 5) Pageable pageable,
                                                                @RequestParam int type) {
        Page<Vaccination> vaccinations = vaccinationManagerService.findAllVaccination(pageable, type);
        if (vaccinations.isEmpty()) {
            return new ResponseEntity<Page<Vaccination>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Page<Vaccination>>(vaccinations, HttpStatus.OK);
    }

    /**
     * TrungTQ Code: Dùng để lấy danh sách phân trang và tìm kiếm sự kiện tiêm chủng định kỳ
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<Page<Vaccination>> searchAllVaccination(@RequestParam String startDate,
                                                                  @RequestParam String endDate,
                                                                  @RequestParam String name,
                                                                  @RequestParam String status,
                                                                  @RequestParam int pageable,
                                                                  @RequestParam int type) {
        Page<Vaccination> vaccinations = vaccinationManagerService.searchAllVaccinationManager(startDate, endDate, name, status, pageable, type);
        if (vaccinations.isEmpty()) {
            return new ResponseEntity<Page<Vaccination>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Page<Vaccination>>(vaccinations, HttpStatus.OK);
    }

    /**
     * TrungTQ Code: Dùng để lấy sự kiện tiêm chủng định kỳ ở id=?
     */
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vaccination> findVaccinationById(@PathVariable("id") Integer id) {
        Vaccination vaccination = vaccinationManagerService.findByIdVaccinationManager(id);
        if (vaccination == null) {
            return new ResponseEntity<Vaccination>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Vaccination>(vaccination, HttpStatus.OK);
    }

    /**
     * TrungTQ Code: Dùng để tạo mới sự kiện tiêm chủng định kỳ
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createVaccinations(@Valid @RequestBody VaccinationManagerDto vaccinationManagerDto, BindingResult bindingResult, UriComponentsBuilder ucBuilder) {
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError());
            return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
        }
        vaccinationManagerService.saveVaccinationManager(vaccinationManagerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/findById/{id}").buildAndExpand(vaccinationManagerDto.getVaccinationId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    /**
     * TrungTQ code: Dùng để cập nhập thông tin sự kiện tiêm chủng định kỳ
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Vaccination> updateVaccination(@PathVariable("id") Integer id, @RequestBody VaccinationManagerDto vaccinationManagerDto) {
        Vaccination currentVaccination = vaccinationManagerService.findByIdVaccinationManager(id);
        if (currentVaccination == null) {
            return new ResponseEntity<Vaccination>(HttpStatus.NOT_FOUND);
        }
        vaccinationManagerService.updateVaccinationManager(vaccinationManagerDto);

        return new ResponseEntity<Vaccination>(currentVaccination, HttpStatus.OK);
    }

    /**
     * TrungTQ Code: Dùng để chỉnh sửa đã thực hiện công việc tiêm chủng định kỳ hoàn thành hay chưa.
     */
    @RequestMapping(value = "/status/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Vaccination> updateVaccination(@PathVariable("id") Integer id) {

        Vaccination vaccination = vaccinationManagerService.findByIdVaccinationManager(id);
        if (vaccination == null) {
            return new ResponseEntity<Vaccination>(HttpStatus.NOT_FOUND);
        }
        vaccinationManagerService.updateStatusVaccinationManager(id);
        return new ResponseEntity<Vaccination>(HttpStatus.OK);
    }

    /**
     * TrungTQ Code: Dùng để xóa sự kiện tiêm chủng định kỳ
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Vaccination> deleteVaccination(@PathVariable("id") Integer id) {

        Vaccination vaccination = vaccinationManagerService.findByIdVaccinationManager(id);
        if (vaccination == null) {
            return new ResponseEntity<Vaccination>(HttpStatus.NOT_FOUND);
        }
        vaccinationManagerService.removeVaccinationManager(id);
        return new ResponseEntity<Vaccination>(HttpStatus.OK);
    }

    /**
     * TrungTQ Code: Lấy danh sách địa điểm xảy ra sự kiện tiêm chủng định kỳ
     */
    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    public ResponseEntity<List<Location>> listAllLocation() {
        List<Location> locations = locationService.findAllLocation();
        if (locations.isEmpty()) {
            return new ResponseEntity<List<Location>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Location>>(locations, HttpStatus.OK);
    }

    /**
     * TrungTQ Code: Lấy danh sách vắc-xin xảy ra sự kiện tiêm chủng định kỳ
     */
    @RequestMapping(value = "/vaccines", method = RequestMethod.GET)
    public ResponseEntity<List<Vaccine>> listAllVaccine() {
        List<Vaccine> vaccine = vaccineService.getAllVaccine();
        if (vaccine.isEmpty()) {
            return new ResponseEntity<List<Vaccine>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Vaccine>>(vaccine, HttpStatus.OK);
    }
}
