package org.example.email_gmail.service;


import lombok.AllArgsConstructor;
import org.example.email_gmail.domain.Mail;
import org.example.email_gmail.dto.EmailDto;
import org.example.email_gmail.repository.EmailRepository;
import org.example.email_gmail.request.EmailRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final EmailRepository emailRepository;
    private static final String FROM_ADDRESS = "gurdl2384@gmail.com";

    public void mailSend(EmailRequest request) {

        EmailDto dto = EmailDto.of(request);

        SimpleMailMessage msg = new SimpleMailMessage();

        System.out.println("받는 사람 : "+dto.getReceiver());
        msg.setTo(dto.getReceiver());

        System.out.println("제목 : "+dto.getSubject());
        msg.setSubject(dto.getSubject());


        System.out.println("내용 :"+dto.getMessage());
        msg.setText(dto.getMessage());

        javaMailSender.send(msg);
        emailRepository.save(Mail.of(dto));

    }


}
