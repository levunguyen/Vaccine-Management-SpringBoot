package com.project.payload.request;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class SignupRequest {

    private Integer bookId;
    private String name;
    private String gender;
    private String dateOfBirth;
    private String guardian;
    private String address;
    private String phone;
    @NotBlank
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "wrong format, should be abc@abc.com ")
    private String email;
    @NotBlank
    @Length(min = 8, max = 32)
    private String password;


    public SignupRequest() {
    }

    public SignupRequest(Integer bookId, String name, String gender, String dateOfBirth, String guardian, String address, String phone, String email, String password) {
        this.bookId = bookId;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.guardian = guardian;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGuardian() {
        return guardian;
    }

    public void setGuardian(String guardian) {
        this.guardian = guardian;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
