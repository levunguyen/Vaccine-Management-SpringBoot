package com.project.validation;
import com.project.dto.EmployeeDto;
import com.project.service.EmployeeService;
import com.project.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.util.Date;
import java.util.regex.Pattern;
/**
 * LuyenNT code
 **/
@Component
public class EmployeeCreateByRequestDtoValidator implements Validator {
    @Autowired
    private EmployeeService employeeService;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        Date date = new Date();
        String[] dateSplit = employeeDto.getDateOfBirth().split("-");
        dateSplit[0] = String.valueOf(Integer.parseInt(dateSplit[0]) - 1900);
        Date dateOfBirth = new Date(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]) - 1, Integer.parseInt(dateSplit[2]));
        if (employeeDto.getName() == null) {
            errors.rejectValue("name", "name.null", "Tên không được để trống");
        } else if (employeeDto.getName().length() < 6) {
            errors.rejectValue("name", "name.length", "Tên phải lơn hơn 6 ký tự");
        } else if (!Pattern.compile("^[a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+(\\s[a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+)*$").matcher(employeeDto.getName()).find()) {
            errors.rejectValue("name", "name.pattern", "Tên phải đúng định dạng");
        }
        if (employeeDto.getDateOfBirth() == null) {
            errors.rejectValue("dateOfBirth", "dateOfBirth.null", "Ngày sinh không được để trống");
        } else if (((date.getTime()) - (dateOfBirth.getTime())) / 1000 / 60 / 60 / 24 < 6570 || ((date.getTime()) - (dateOfBirth.getTime())) / 1000 / 60 / 60 / 24 > 36525) {
            errors.rejectValue("dateOfBirth", "dateOfBirth.format", "Ngày sinh phải từ 18 tuổi đến 100 tuổi");
        }
        if (employeeDto.getAddress().length() > 200) {
            errors.rejectValue("address", "address.length", "Địa chỉ phải nhỏ hơn 200 ký tự");
        }
        if (employeeDto.getPhone() == null) {
            errors.rejectValue("phone", "phone.null", "Số địa thoại không được để trống");
        } else if (!Pattern.compile("^(090|091|\\(\\+84\\)90|\\(\\+84\\)91)\\d{7}$").matcher(employeeDto.getPhone()).find()) {
            errors.rejectValue("phone", "phone.format", "số địa thoại đúng định dạng 090xxxxxxx or 091xxxxxxx or (84) + 90xxxxxxx or (84) + 91xxxxxxx");
        } else if (employeeService.findByPhone(employeeDto.getPhone()) > 0) {
            errors.rejectValue("phone", "phone.duplicate", "Số điện thoại đã tồn tại");
        }
        if (employeeDto.getIdCard() == null) {
            errors.rejectValue("idCard", "idCard.null", "Số địa thoại không được để trống");
        } else if (employeeService.findByIdCard(employeeDto.getIdCard()) > 0) {
            errors.rejectValue("idCard", "idCard.duplicate", "CMND đã tồn tại");
        }
    }
}
