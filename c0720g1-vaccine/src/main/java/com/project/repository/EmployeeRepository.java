package com.project.repository;
import com.project.dto.EmployeeFindIdDTO;
import com.project.dto.EmployeeListDTO;
import org.springframework.data.jpa.repository.Modifying;
import com.project.entity.Account;
import com.project.entity.Employee;
import com.project.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;

@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    /*
    * Hung DH - hien thi list Employee va ten quyen truy cap cua tung nhan vien
     */
    @Query(value = "select employee.employee_id as employeeId, employee.name, employee.date_of_birth as dateOfBirth,\n" +
            "employee.id_card as idCard, employee.address, employee.phone, position.name as position, role.name\n" +
            "as account from employee \n" +
            "join position on position.position_id = employee.position_id \n" +
            "join account on account.account_id = employee.account_id \n" +
            "join account_role on account_role.account_id = account.account_id \n" +
            "join role on role.role_id = account_role.role_id where employee.delete_flag = 0", nativeQuery = true)
    List<EmployeeListDTO> getAllEmployee();

//    @Query(value = "select * from employee", nativeQuery = true)
//    Page<Employee> findAllByNameContainingAndDateOfBirthContainingAndIdCardContaining(String name, String dateOfBirth, String idCard, Pageable pageable);

    /*
     * Hung DH - tim kiem nhan vien theo id, ten, chuc vu
     */
    @Query(value = "select employee.employee_id as employeeId, employee.name, employee.date_of_birth as dateOfBirth, \n" +
            "employee.id_card as idCard, employee.address, employee.phone, position.name as position, role.name \n" +
            "as account from employee \n" +
            "join position on position.position_id = employee.position_id \n" +
            "join account on account.account_id = employee.account_id \n" +
            "join account_role on account_role.account_id = account.account_id \n" +
            "join role on role.role_id = account_role.role_id where employee.name like ?1 and employee.employee_id like ?2 and employee.position_id like ?3 and employee.delete_flag = false", nativeQuery = true)
    List<EmployeeListDTO> findEmployeeByIdAndNameAndPosition(String nameSearch, String idEmpSearch, String positionSearch);

    /*
     * Hung DH - tim kiem id nhan vien theo id
     */
    @Query(value = "select employee.employee_id as employeeId, employee.name, employee.date_of_birth as dateOfBirth, \n" +
            "employee.id_card as idCard, employee.address, employee.phone, position.position_id as position, account.account_id as account, role.role_id as role from employee \n" +
            "join position on position.position_id = employee.position_id \n" +
            "join account on account.account_id = employee.account_id \n" +
            "join account_role on account_role.account_id = account.account_id \n" +
            "join role on role.role_id = account_role.role_id where employee.employee_id = ?1", nativeQuery = true)
    EmployeeFindIdDTO findById(int id);
    /*
     * Hung DH - chinh sua thong tin nhan vien
     */
    @Transactional
    @Modifying
    @Query(value = "update employee as e set e.name = ?1, e.date_of_birth = ?2, e.id_card = ?3, e.address = ?4, " +
            "e.phone = ?5, e.position_id = ?6, e.account_id = ?7 where e.employee_id = ?8", nativeQuery = true)
    void editEmployee(String name, String dateOfBirth, String idCard, String address, String phone, Integer positionId, Integer accountId, Integer id);
    /*
     * Hung DH - chinh sua id_role voi id account = ? va truyen vao ham eidtEmployee
     */
    @Transactional
    @Modifying
    @Query(value = "update account_role as ar set ar.role_id = ?1 where ar.account_id = ?2", nativeQuery = true)
    void editAccountRole(int roleId, int accountId);
    /*
     * Hung DH
     */
    @Transactional
    @Modifying
    @Query(value = "update employee set employee.delete_flag = 1 where employee.employee_id = ?1", nativeQuery = true)
    void deleteEmployee(int id);

    /** LuyenNT code
     * @param name
     * @param dateOfBirth
     * @param idCard
     * @param address
     * @param phone
     * @param position
     * @param account
     * @param delete_flag
     */
    @Modifying
    @Query(value = "insert into employee(name,date_of_birth,id_card," +
            "address,phone,position_id,account_id,delete_flag) values (?1,?2,?3,?4,?5,?6,?7,?8)", nativeQuery = true)
    void createNewEmployee(String name, String dateOfBirth, String idCard,
                           String address, String phone, Integer position, Integer account,Boolean delete_flag);

    /** LuyenNT code
     * @param phone
     * @return
     */
    @Query(value = "select count(phone) from employee where phone = ?", nativeQuery = true)
    Integer findByPhone(String phone);

    /** LuyenNT code
     * @param idCard
     * @return
     */
    @Query(value = "select count(id_card) from employee where id_card = ?", nativeQuery = true)
    Integer finByIdCard(String idCard);
}
