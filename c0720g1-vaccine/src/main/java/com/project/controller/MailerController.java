package com.project.controller;

import com.project.service.VaccinationHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@EnableScheduling
public class MailerController {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private VaccinationHistoryService vaccinationHistoryService;

    @Scheduled(cron = "0 45 9 * * ?")
    public void sendEmail() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        LocalDate dayPlusAWeek = LocalDate.now().plusDays(1);
        String day = formatter.format(dayPlusAWeek);

        List<String> listEmailOneTime = vaccinationHistoryService.getAllEmailToSend();
        List<String> listEmailOneMoreTime = vaccinationHistoryService.getEmailToSendOfVaccinationMore();
        Set<String> listEmail = new HashSet<>();
        listEmail.addAll(listEmailOneTime);
        listEmail.addAll(listEmailOneMoreTime);

        if (!(listEmail.size() == 0)) {
            String[] array = listEmail.toArray(new String[0]);
            // Create a Simple MailMessage.
            SimpleMailMessage message = new SimpleMailMessage();

            message.setTo(array);
            message.setSubject("Nhắc nhở lịch tiêm chủng ");
            message.setText("Chào bạn \n"
                    + "TRUNG TÂM Y TẾ DỰ PHÒNG ĐÀ NẴNG xin thông báo, vào ngày " + day + " trung tâm tổ chức tiêm chủng mở rộng "
                    + "\ntại TRUNG TÂM Y TẾ DỰ PHÒNG ĐÀ NẴNG, địa chỉ: 103 Hùng Vương, Hải Châu 1, Hải Châu, Đà Nẵng 550000, Việt Nam" +
                    "\n Giờ mở cửa:  Sáng: 07:30–11:00, Chiều: 13:30–16:30");

            // Send Message!
            this.emailSender.send(message);
        } else {
            System.out.println(day + " Have not email to send!");
        }
    }
}
