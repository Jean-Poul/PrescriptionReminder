package cph.databases.assignment;

import cph.databases.assignment.email.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@SpringBootApplication
public class PrescriptionReminderApplication {
    @Autowired
    private EmailSenderService senderService;
    public static void main(String[] args) {
        SpringApplication.run(PrescriptionReminderApplication.class, args);
    }
	@EventListener(ApplicationReadyEvent.class)
    public void sendMail() {
        senderService.sendEmail("debug000333@gmail.com",
                "TO JP",
                "This is the very first email sent from spring boot application");
    }


}
