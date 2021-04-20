package com.project.service.impl;

import com.project.entity.Vaccination;
import com.project.dto.VaccinationManagerDto;
import com.project.repository.VaccinationManagerRepository;
import com.project.service.VaccinationManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccinationManagerServiceImpl implements VaccinationManagerService {
    @Autowired
    private VaccinationManagerRepository vaccinationManagerRepository;

    /**
     * TrungTQ code: Lấy danh sách vaccination phân trang
     */
    @Override
    public Page<Vaccination> findAllVaccination(Pageable pageable, int type) {
        return vaccinationManagerRepository.findAllByDeleteFlagIsFalseAndVaccinationType_VaccinationTypeIdIs(pageable, type);
    }

    /**
     * TrungTQ code: tìm kiếm và phân trang
     */
    @Override
    public Page<Vaccination> searchAllVaccinationManager(String startDate, String endDate, String name, String status, int pageable, int type) {
        List<Vaccination> vaccinationList = vaccinationManagerRepository.searchAllList(startDate, endDate, '%' + name + '%', status);

        Pageable pageableContent = PageRequest.of(pageable, 5);
        int startPage = (int) pageableContent.getOffset();
        int endPage = Math.min((startPage + pageableContent.getPageSize()), vaccinationList.size());
        Page<Vaccination> vaccinationPage = new PageImpl<Vaccination>(vaccinationList.subList(startPage, endPage), pageableContent, vaccinationList.size());
        return vaccinationPage;
    }

    /**
     * TrungTQ code: Lấy vaccination theo ID
     */
    @Override
    public Vaccination findByIdVaccinationManager(Integer id) {
        return vaccinationManagerRepository.findByIdVaccination(id, 0, 1);
    }

    /**
     * TrungTQ code: Thêm mới vaccination
     */
    @Override
    public void saveVaccinationManager(VaccinationManagerDto vaccinationManagerDto) {
        vaccinationManagerRepository.saveVaccinationManager(vaccinationManagerDto.getDate(), false, vaccinationManagerDto.getDescription(), vaccinationManagerDto.getStartTime(), vaccinationManagerDto.getEndTime(), false, 1, 1, vaccinationManagerDto.getVaccineId());
    }

    /**
     * TrungTQ code: cập nhật vaccination
     */
    @Override
    public void updateVaccinationManager(VaccinationManagerDto vaccinationManagerDto) {
        vaccinationManagerRepository.updateVaccinationManager(vaccinationManagerDto.getDate(), vaccinationManagerDto.getDescription(), vaccinationManagerDto.getStartTime(), vaccinationManagerDto.getEndTime(), vaccinationManagerDto.getLocationId(), vaccinationManagerDto.getVaccineId(), vaccinationManagerDto.getVaccinationId());
    }


    /**
     * TrungTQ code: cập nhật vaccination trạng thái đã hoàn thành hay chưa
     */
    @Override
    public void updateStatusVaccinationManager(Integer id) {
        vaccinationManagerRepository.updateVaccinationById(true, id);
    }

    /**
     * TrungTQ code: xóa vaccination qua biến delete_flag
     */
    @Override
    public void removeVaccinationManager(Integer id) {
        vaccinationManagerRepository.deleteVaccinationById(true, id);
    }
}
