package com.project.repository;

import com.project.dto.PeriodicVaccinationDto;
import com.project.dto.RegistrablePeriodicalVaccinationDTO;
import com.project.dto.TimeDTO;
import com.project.entity.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VaccinationRepository extends JpaRepository<Vaccination,Integer> {


    /**KhoaTA
     * find all periodical vaccination with date > date.now()
     * Test NativeQuery
     */
//    @Query(value = "select vaccination.vaccination_id as vaccinationId, vaccination.date, vaccination.start_time as startTime, vaccination.end_time as endTime, vaccine.name as vaccineName, vaccine_type.name as vaccineTypeName, vaccine.age as age, vaccination.description, location.name as location, vaccine.origin as country from vaccination " +
//            "join vaccination_type on vaccination.vaccination_type_id = vaccination_type.vaccination_type_id " +
//            "join vaccine on vaccination.vaccine_id = vaccine.vaccine_id " +
//            "join location on vaccination.location_id = location.location_id " +
//            "join vaccine_type on vaccine.vaccine_type_id = vaccine_type.vaccine_type_id " +
//            "where vaccination.date > now() and vaccination.vaccination_type_id = 1 LIMIT 1,5", nativeQuery = true)
//    List<RegistrablePeriodicalVaccinationDTO> findAllRegistrableVaccination();

    /**KhoaTA
     *find periodical vaccination with date > date.now() and id = argument
     */
    @Query(value = "select vaccination.vaccination_id as vaccinationId, vaccination.date, vaccination.start_time as startTime, vaccination.end_time as endTime, vaccine.name as vaccineName, vaccine_type.name as vaccineTypeName, vaccine.age as age, vaccination.description, location.name as location, vaccine.origin as country,  vaccine.image as image, vaccine.times, vaccine.duration  from vaccination " +
            "join vaccination_type on vaccination.vaccination_type_id = vaccination_type.vaccination_type_id " +
            "join vaccine on vaccination.vaccine_id = vaccine.vaccine_id " +
            "join location on vaccination.location_id = location.location_id " +
            "join vaccine_type on vaccine.vaccine_type_id = vaccine_type.vaccine_type_id " +
            "where vaccination.date > now() and vaccination.vaccination_type_id = 1 and vaccination.vaccination_id = ?1 ", nativeQuery = true)
    RegistrablePeriodicalVaccinationDTO findRegistrableVaccinationById(Integer id);

    /**KhoaTA
     *find all age of vaccination
     */
    @Query(value = "select vaccine.age as age from vaccination " +
            "join vaccination_type on vaccination.vaccination_type_id = vaccination_type.vaccination_type_id " +
            "join vaccine on vaccination.vaccine_id = vaccine.vaccine_id " +
            "where vaccination.date > now() and vaccination.vaccination_type_id = 1 GROUP BY vaccine.age", nativeQuery = true)
    List<String> findAllAge();

    /**KhoaTA
     *find all available vaccination time stamps
     */
    @Query(value = "select vaccination.start_time as startTime, vaccination.end_time as endTime from vaccination " +
            "where vaccination.date > now() and vaccination.vaccination_type_id = 1 and vaccination.delete_flag = 0 group by vaccination.start_time, vaccination.end_time", nativeQuery = true)
    List<TimeDTO> findAllTimeStamp();

    /**KhoaTA
     *get the total page of search data with date
     */
    @Query(value = "select count(vaccination.vaccination_id) from vaccination " +
            "join vaccination_type on vaccination.vaccination_type_id = vaccination_type.vaccination_type_id " +
            "join vaccine on vaccination.vaccine_id = vaccine.vaccine_id " +
            "join location on vaccination.location_id = location.location_id " +
            "join vaccine_type on vaccine.vaccine_type_id = vaccine_type.vaccine_type_id " +
            "where vaccine.age like ?1 " +
            "and vaccination.date like ?2  " +
            "and vaccination.start_time like ?3  " +
            "and vaccination.end_time like ?4  " +
            "and vaccine.name like ?5  " +
            "and vaccination.description like ?6 " +
            "and vaccination.vaccination_type_id = 1 " +
            "and vaccination.delete_flag = 0", nativeQuery = true)
    int findTotalPage(String age, String date, String startTime, String endTime, String vaccineName, String description);
    /**KhoaTA
     *get the total page of search data without date
     */
    @Query(value = "select count(vaccination.vaccination_id) from vaccination " +
            "join vaccination_type on vaccination.vaccination_type_id = vaccination_type.vaccination_type_id " +
            "join vaccine on vaccination.vaccine_id = vaccine.vaccine_id " +
            "join location on vaccination.location_id = location.location_id " +
            "join vaccine_type on vaccine.vaccine_type_id = vaccine_type.vaccine_type_id " +
            "where vaccine.age like ?1 " +
            "and vaccination.date > now()  " +
            "and vaccination.start_time like ?2  " +
            "and vaccination.end_time like ?3  " +
            "and vaccine.name like ?4  " +
            "and vaccination.vaccination_type_id = 1 " +
            "and vaccination.description like ?5 " +
            "and vaccination.delete_flag = 0", nativeQuery = true)
    int findTotalPage(String age, String startTime, String endTime, String vaccineName, String description);

    /**KhoaTA
     *get the list for search data with date
     */
    @Query(value = "select vaccination.vaccination_id as vaccinationId, vaccination.date, vaccination.start_time as startTime, vaccination.end_time as endTime, vaccine.name as vaccineName, " +
            "vaccine_type.name as vaccineTypeName, vaccine.age as age, vaccination.description, location.name as location, vaccine.origin as country, vaccine.image as image, " +
            "vaccine.duration, vaccine.times  from vaccination " +
            "join vaccination_type on vaccination.vaccination_type_id = vaccination_type.vaccination_type_id " +
            "join vaccine on vaccination.vaccine_id = vaccine.vaccine_id " +
            "join location on vaccination.location_id = location.location_id " +
            "join vaccine_type on vaccine.vaccine_type_id = vaccine_type.vaccine_type_id " +
            "where vaccine.age like ?1 " +
            "and vaccination.date like ?2  " +
            "and vaccination.start_time like ?3  " +
            "and vaccination.end_time like ?4  " +
            "and vaccine.name like ?5  " +
            "and vaccination.description like ?6 " +
            "and vaccination.vaccination_type_id = 1 " +
            "and vaccination.delete_flag = 0 LIMIT ?7,5", nativeQuery = true)
    List<RegistrablePeriodicalVaccinationDTO> findCustomListWithPageWithDate(String age, String date, String startTime, String endTime, String vaccineName, String description, int offset);

    /**KhoaTA
     *get the list for search data without date
     */
    @Query(value = "select vaccination.vaccination_id as vaccinationId, vaccination.date, vaccination.start_time as startTime, vaccination.end_time as endTime, vaccine.name as vaccineName, " +
            "vaccine_type.name as vaccineTypeName, vaccine.age as age, vaccination.description, location.name as location, vaccine.origin as country, vaccine.image as image, " +
            "vaccine.duration, vaccine.times from vaccination " +
            "join vaccination_type on vaccination.vaccination_type_id = vaccination_type.vaccination_type_id " +
            "join vaccine on vaccination.vaccine_id = vaccine.vaccine_id " +
            "join location on vaccination.location_id = location.location_id " +
            "join vaccine_type on vaccine.vaccine_type_id = vaccine_type.vaccine_type_id " +
            "where vaccine.age like ?1 " +
            "and vaccination.date > now()  " +
            "and vaccination.start_time like ?2  " +
            "and vaccination.end_time like ?3  " +
            "and vaccine.name like ?4  " +
            "and vaccination.description like ?5 " +
            "and vaccination.vaccination_type_id = 1 " +
            "and vaccination.delete_flag = 0 LIMIT ?6,5", nativeQuery = true)
    List<RegistrablePeriodicalVaccinationDTO> findCustomListWithPageWithoutDate(String age, String startTime, String endTime, String vaccineName, String description, int offset);

}
