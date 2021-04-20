package com.project.repository;

import com.project.entity.Vaccination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface VaccinationManagerRepository extends JpaRepository<Vaccination, Integer> {


    /**
     * TrungTQ code: Phân trang có điều kiện về biến delete và vaccinationType và hiển thị danh sách
     */

    Page<Vaccination> findAllByDeleteFlagIsFalseAndVaccinationType_VaccinationTypeIdIs(Pageable pageable, int type);

    /**
     * TrungTQ Code: Query tìm id
     */

    @Query(
            value = "select e.* from Vaccination e where e.vaccination_id = ?1 and e.delete_flag = ?2 and e.vaccination_type_id = ?3",
            nativeQuery = true)
    Vaccination findByIdVaccination(int vaccinationId, int delete, int type);

    /**
     * TrungTQ Code: Query tạo mới
     */

    @Modifying
    @Query(
            value = "insert into vaccination(`date`, delete_flag, description, start_time, end_time, status, location_id, vaccination_type_id, vaccine_id) " +
                    "value (?1, ?2, ?3,?4, ?5, ?6, ?7, ?8, ?9)",
            nativeQuery = true)
    void saveVaccinationManager(String date, boolean delete, String description, String startTime, String endTime, boolean status, int location, int type, int vaccine);

    /**
     * TrungTQ Code: Query tạo cập nhập
     */

    @Modifying
    @Query(
            value = "update vaccination set " +
                    "`date` = ?1, description = ?2, start_time = ?3, end_time = ?4," +
                    "location_id = ?5, vaccine_id = ?6 " +
                    "where vaccination_id = ?7",
            nativeQuery = true)
    void updateVaccinationManager(String date, String description, String startTime, String endTime, int location, int vaccine, int vaccinationId);

    /**
     * TrungTQ code: Query xóa tạm thời thông tin một sự kiện tiêm chủng dự phòng
     */
    @Modifying
    @Query(
            value = "update vaccination set delete_flag = ?1 where vaccination_id = ?2", nativeQuery = true)
    void deleteVaccinationById(boolean delete, int id);

    /**
     * * TrungTQ code: Query cập nhập một sự kiện tiêm chủng dự phòng đã hoàn thành
     */
    @Modifying
    @Query(
            value = "update vaccination set status = ?1 where vaccination_id = ?2", nativeQuery = true)
    void updateVaccinationById(boolean status, int id);

    /**
     * TrungTQ code: Tìm kiếm cùng với phân trang ;
     */
    @Query(
            value = "select * from vaccine_management.vaccination " +
                    "join vaccine on vaccination.vaccine_id = vaccine.vaccine_id " +
                    "where vaccination.delete_flag = 0 " +
                    "and vaccination.vaccination_type_id = 1 " +
                    "and vaccination.`date` > ?1 " +
                    "and vaccination.`date` < ?2 " +
                    "and vaccine.name like ?3 " +
                    "and vaccination.status = ?4 " +
                    "order by vaccination.vaccination_id", nativeQuery = true)
    List<Vaccination> searchAllList(String startDate, String endDate, String name, String status);


}
