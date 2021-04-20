package com.project.validation;

import com.project.dto.VaccinationByRequestDTO;
import com.project.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Phuoc
 **/

@Component
public class VaccinationByRequestDTOValidator implements Validator {

    @Autowired
    private PatientService patientService;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        VaccinationByRequestDTO vaccination = (VaccinationByRequestDTO) target;

        LocalDate dateNow = LocalDate.now();
        LocalDate vaccinationDate = LocalDate.parse(vaccination.getDateVaccination());

        Date date = new Date();
        String[] dateSplit = vaccination.getDateOfBirth().split("-");

        dateSplit[0] = String.valueOf(Integer.parseInt(dateSplit[0]) - 1900);

        Date dateOfBirth = new Date(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]) - 1, Integer.parseInt(dateSplit[2]));


        if (vaccination.getName() == null) {
            errors.rejectValue("name", "name.null", "Tên không được để trống");
        } else if (vaccination.getName().length() < 6) {
            errors.rejectValue("name", "name.length", "Tên phải lơn hơn 6 ký tự");
        } else if (!Pattern.compile("^[a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+(\\s[a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+)*$").matcher(vaccination.getName()).find()) {
            errors.rejectValue("name", "name.pattern", "Tên phải đúng định dạng");
        }

        if (vaccination.getGender() == null) {
            errors.rejectValue("gender", "gender.null", "Giới tính không được để trống");
        } else if (!vaccination.getGender().equals("Nam")) {
            if (!vaccination.getGender().equals("Nữ")) {
                errors.rejectValue("gender", "gender.format", "Giới tính không đúng định dạng");
            }
        }

        if (vaccination.getDateOfBirth() == null) {
            errors.rejectValue("dateOfBirth", "dateOfBirth.null", "Ngày sinh không được để trống");
        } else if (((date.getTime()) - (dateOfBirth.getTime())) / 1000 / 60 / 60 / 24 < 90 || ((date.getTime()) - (dateOfBirth.getTime())) / 1000 / 60 / 60 / 24 > 36525) {
            errors.rejectValue("dateOfBirth", "dateOfBirth.format", "Ngày sinh phải từ 90 ngày tuổi đến 100 tuổi");
        }

//
//        if (vaccination.getAddress() == null) {
//            errors.rejectValue("address", "address.null", "Địa chỉ không được để trống");
//        }
//
//        if (vaccination.getGuardian() == null) {
//            errors.rejectValue("guardian", "guardian.null", "Người bảo hộ không được để trống");
//        }

        if (vaccination.getEmail() == null) {
            errors.rejectValue("email", "email.null", "Email không được để trống");
        } else if (!Pattern.compile("^\\w{5,}.?\\w+(@\\w{3,8})(.\\w{3,8})+$").matcher(vaccination.getEmail()).find()) {
            errors.rejectValue("email", "email.format", "Email không đúng định dạng");
        }
//        else if (patientService.findByEmail(vaccination.getEmail()) > 0) {
//            errors.rejectValue("email", "email.duplicate", "Email đã tồn tại");
//        }


        if (vaccination.getPhone() == null) {
            errors.rejectValue("phone", "phone.null", "Số điện thoại không được để trống");
        } else if (!Pattern.compile("^(0|\\(\\+84\\))\\d{9}$").matcher(vaccination.getPhone()).find()) {
            errors.rejectValue("phone", "phone.format", "Số điện thoại không đúng định dạng");
        }
//        else if (patientService.findByPhone(vaccination.getPhone()) > 0) {
//            errors.rejectValue("phone","phone.duplicate","Số điện thoại đã tồn tại");
//        }

        if (vaccination.getDateVaccination() == null) {
            errors.rejectValue("dateVaccination", "dateVaccination.null", "Ngày tiêm không được để trống");
        } else if (vaccinationDate.compareTo(dateNow) < 0) {
            errors.rejectValue("vaccinationDate", "Ngày tiêm phải lơn hơn hoặc bằng ngày hiện tại");
        }
    }
}
