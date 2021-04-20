package com.project.service;

import com.project.dto.PeriodicalVaccinationRegisterDTO;
import com.project.dto.PeriodicalVaccinationTempRegisterDTO;
import com.project.dto.RegistrablePeriodicalVaccinationDTO;
import com.project.entity.Account;
import com.project.entity.VaccinationHistory;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;


public interface AccountService {
    /**
     *Nguyen Van Linh
     */
    Account findAccountByUserName(String username);
    /**
     *Nguyen Van Linh
     */
    Integer findIdUserByUserName(String username);
    /**
     *Nguyen Van Linh
     */
    String existsByUserName(String username);
    /**
     *Nguyen Van Linh
     */
    Boolean existsById(Integer bookId);
    /**
     *Nguyen Van Linh
     */
    void addNew(String username, String password, String email) throws MessagingException, UnsupportedEncodingException;
    /**
     *Nguyen Van Linh
     */
    Boolean findAccountByVerificationCode(String code);

    /**
     *Nguyen Van Linh
     */
    Boolean findAccountByVerificationCodeToResetPassword(String code);
    /**
     *Nguyen Van Linh
     */
    void addVerificationCode(String username) throws MessagingException, UnsupportedEncodingException;

    /**
     * Hung DH - hien thi list
     */
    List<Account> getAllAccount();


    /**
     * LuyenNT code
     */
    void addNew(String username, String password);

    /**
     *Nguyen Van Linh
     */
    void saveNewPassword(String password,String code);

    /**
     * KhoaTA
     * Send info email to patient after register for a vaccination
     */
    void sendInfoEmail(PeriodicalVaccinationTempRegisterDTO register, VaccinationHistory vaccinationHistory) throws MessagingException, UnsupportedEncodingException;
}
