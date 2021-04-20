package com.project.validation;
import com.project.dto.PatientDTO;
import com.project.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;
import java.util.regex.Pattern;

@Component
public class PatientByRequestDTOValidator implements Validator {
    @Autowired
    private PatientService patientService;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }



    @Override
    public void validate(Object target, Errors errors) {
        PatientDTO patientDTO = (PatientDTO) target;

        Date date = new Date();
        String[] dateSplit = patientDTO.getDateOfBirth().split("-");
        dateSplit[0] = String.valueOf(Integer.parseInt(dateSplit[0]) - 1900);
        Date dateOfBirth = new Date(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]) - 1, Integer.parseInt(dateSplit[2]));
        if (patientDTO.getDateOfBirth() == null) {
            errors.rejectValue("dateOfBirth", "dateOfBirth.null", "Ngày sinh không được để trống");
        } else if (((date.getTime()) - (dateOfBirth.getTime())) / 1000 / 60 / 60 / 24 < 90 || ((date.getTime()) - (dateOfBirth.getTime())) / 1000 / 60 / 60 / 24 > 36525) {
            errors.rejectValue("dateOfBirth", "dateOfBirth.format", "Ngày sinh phải từ 90 ngày tuổi đến 100 tuổi");
        }
        if (patientDTO.getName() == null) {
            errors.rejectValue("name", "name.null", "Tên không được để trống");
        } else if (patientDTO.getName().length() < 6) {
            errors.rejectValue("name", "name.length", "Tên phải lơn hơn 6 ký tự");
        } else if (!Pattern.compile("^[a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+(\\s[a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+)*$").matcher(patientDTO.getName()).find()) {
            errors.rejectValue("name", "name.pattern", "Tên phải đúng định dạng");
        }
        if (patientDTO.getGender() == null) {
            errors.rejectValue("gender", "gender.null", "Giới tính không được để trống");
        } else if (!patientDTO.getGender().equals("Nam")) {
            if (!patientDTO.getGender().equals("Nữ")) {
                errors.rejectValue("gender", "gender.format", "Giới tính không đúng định dạng");
            }
        }

        if (patientDTO.getAddress().length() > 200) {
            errors.rejectValue("address", "address.length", "Địa chỉ phải nhỏ hơn 200 ký tự");
        }
        if (patientDTO.getEmail() == null) {
            errors.rejectValue("email", "email.null", "Email không được để trống");
        } else if (!Pattern.compile("^\\w{5,}.?\\w+(@\\w{3,8})(.\\w{3,8})+$").matcher(patientDTO.getEmail()).find()) {
            errors.rejectValue("email", "email.format", "Email không đúng định dạng");
        }
        if (patientDTO.getPhone() == null) {
            errors.rejectValue("phone", "phone.null", "Số điện thoại không được để trống");
        } else if (!Pattern.compile("^(0|\\(\\+84\\))\\d{9}$").matcher(patientDTO.getPhone()).find()) {
            errors.rejectValue("phone", "phone.format", "Số điện thoại không đúng định dạng");
        }
    }



}
