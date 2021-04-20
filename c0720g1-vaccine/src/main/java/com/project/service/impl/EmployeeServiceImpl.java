package com.project.service.impl;

import com.project.dto.EmployeeDto;
import com.project.dto.EmployeeEditDTO;
import com.project.dto.EmployeeFindIdDTO;
import com.project.dto.EmployeeListDTO;
import com.project.entity.Account;
import com.project.entity.Employee;
import com.project.entity.Position;
import com.project.repository.EmployeeRepository;
import com.project.service.AccountService;
import com.project.service.EmployeeService;
import com.project.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private AccountService accountService;
    @Autowired
    private RoleService roleService;

    @Override
    public List<EmployeeListDTO> getAllEmployee() {
        return employeeRepository.getAllEmployee();
    }

    @Override
    public EmployeeFindIdDTO findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void editEmployee(EmployeeEditDTO employeeEditDTO, int roleId, int accountId) {
        employeeRepository.editAccountRole(roleId, accountId);
        employeeRepository.editEmployee(employeeEditDTO.getName(), employeeEditDTO.getDateOfBirth(), employeeEditDTO.getIdCard(), employeeEditDTO.getAddress(),
                employeeEditDTO.getPhone(), Integer.parseInt(employeeEditDTO.getPosition()), Integer.parseInt(employeeEditDTO.getAccount()), employeeEditDTO.getEmployeeId());
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteEmployee(id);
    }

    @Override
    public List<EmployeeListDTO> findEmployeeByIdAndNameAndPosition(String nameSearch, String idEmpSearch, String positionSearch) {
        return employeeRepository.findEmployeeByIdAndNameAndPosition(nameSearch, idEmpSearch, positionSearch);
    }

    @Override
    public void createNewEmployee(EmployeeDto employeeDto) throws MessagingException {

        employeeRepository.createNewEmployee(employeeDto.getName(), employeeDto.getDateOfBirth(), employeeDto.getIdCard(), employeeDto.getAddress(), employeeDto.getPhone(), employeeDto.getPosition(), employeeDto.getAccount(), false);
        Account account = new Account();
        account.setUserName(employeeDto.getIdCard());
        account.setEncryptPw(encoder.encode("123"));
        account.setEnabled(true);
        accountService.addNew(employeeDto.getIdCard(), encoder.encode("123"));
        int id = accountService.findIdUserByUserName(employeeDto.getIdCard());
        roleService.setDefaultRole(id, employeeDto.getAccount());
    }

    @Override
    public Integer findByPhone(String phone) {
        return employeeRepository.findByPhone(phone);
    }

    @Override
    public Integer findByIdCard(String idCard) {
        return employeeRepository.finByIdCard(idCard);
    }
}
