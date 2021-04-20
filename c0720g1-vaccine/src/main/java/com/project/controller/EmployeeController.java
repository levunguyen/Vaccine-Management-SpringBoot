package com.project.controller;

import com.project.dto.EmployeeEditDTO;
import com.project.dto.EmployeeFindIdDTO;
import com.project.dto.EmployeeListDTO;
import com.project.entity.Account;
import com.project.entity.Employee;
import com.project.entity.Position;
import com.project.entity.Role;
import com.project.service.AccountService;
import com.project.service.EmployeeService;
import com.project.service.PositionService;
import com.project.service.RoleService;
import com.project.validation.EmployeeCreateByRequestDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.dto.EmployeeDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/public")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private EmployeeCreateByRequestDtoValidator employeeCreateByRequestDtoValidator;

    /*
     * HungDH - Hien thi danh sach nhan vien
     */
    @GetMapping("/list-employee")
    public ResponseEntity<List<EmployeeListDTO>> getAllEmployee(
                                                                @RequestParam(defaultValue = "") String nameSearch,
                                                                @RequestParam(defaultValue = "") String idEmpSearch,
                                                                @RequestParam(defaultValue = "") String positionSearch
    ) {
        List<EmployeeListDTO> employeeList;
        if (!nameSearch.equals("") || !idEmpSearch.equals("") || !positionSearch.equals("")) {
            return new ResponseEntity<List<EmployeeListDTO>>(employeeService.findEmployeeByIdAndNameAndPosition
                    ("%" + nameSearch + "%", "%" + idEmpSearch + "%", "%" + positionSearch + "%"), (HttpStatus.OK));
        } else {
            employeeList = employeeService.getAllEmployee();
        }
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<EmployeeListDTO>>(employeeList, HttpStatus.OK);
    }


    /*
     * Hung DH - hien thi position list
     */
    @GetMapping("/position")
    public ResponseEntity<List<Position>> getAllPosition() {
        List<Position> positionList = positionService.getAllPosition();
        if (positionList.isEmpty()) {
            return new ResponseEntity<List<Position>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Position>>(positionList, HttpStatus.OK);
    }

    /**
     * Hung DH - hien thi account list
     */
    @GetMapping("/account")
    public ResponseEntity<List<Account>> getAllAccount() {
        List<Account> accountList = accountService.getAllAccount();
        if (accountList.isEmpty()) {
            return new ResponseEntity<List<Account>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Account>>(accountList, HttpStatus.OK);
    }

    /*
     * Hung DH - hien thi role list
     */
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public ResponseEntity<List<Role>> getAllRole() {
        List<Role> roleList = this.roleService.findAllRole();
        if (roleList.isEmpty()) {
            return new ResponseEntity<List<Role>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Role>>(roleList, HttpStatus.OK);
    }

    /*
     * Hung DH - chinh sua thong tin nhan vien
     */
    @PutMapping("/edit-employee")
    public ResponseEntity<?> editEmployee(@RequestBody EmployeeEditDTO employeeEditDTO) {
        employeeService.editEmployee(employeeEditDTO, Integer.parseInt(employeeEditDTO.getRole()), Integer.parseInt(employeeEditDTO.getAccount()));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
     * Hung DH - xoa nhan vien theo id
     */
    @PatchMapping("/delete-employee/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
     * Hung DH - tim kiem nhan vien theo id
     */
    @GetMapping("/find-id/{id}")
    public ResponseEntity<EmployeeFindIdDTO> findById(@PathVariable Integer id) {
        System.out.println(id);
        EmployeeFindIdDTO employee = employeeService.findById(id);
        if (employee == null) {
            return new ResponseEntity<EmployeeFindIdDTO>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<EmployeeFindIdDTO>(employee, HttpStatus.OK);
    }

    /**
     * LuyenNT code
     *
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> createVaccinations(@Valid @RequestBody EmployeeDto employeeDto, BindingResult
            bindingResult) throws MessagingException {
        employeeCreateByRequestDtoValidator.validate(employeeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.OK);
        }
        employeeService.createNewEmployee(employeeDto);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    /**
     * LuyenNT code
     *
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ResponseEntity<List<Object>> createVaccinations() {
        List<Position> positionList = positionService.getAllPosition();
        List<Role> roleList = roleService.getAllRoles();
        List<Object> list = Arrays.asList(positionList, roleList);
        return new ResponseEntity<List<Object>>(list, HttpStatus.OK);
    }
}
