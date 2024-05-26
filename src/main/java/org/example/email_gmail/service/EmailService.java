package org.example.email_gmail.service;


import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.example.email_gmail.domain.Mail;
import org.example.email_gmail.dto.EmailDto;
import org.example.email_gmail.repository.EmailRepository;
import org.example.email_gmail.request.EmailRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {

    private JavaMailSender mailSender;
    private final EmailRepository emailRepository;
    private static final String FROM_ADDRESS = "gurdl2384@gmail.com";

    public void mailSend(EmailRequest request) {

        MimeMessage message = mailSender.createMimeMessage();

        EmailDto dto = EmailDto.of(request);
        String html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "  <title>학우님의 24-1학기 휴학신청이 완료되었습니다.</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "  <img src=\"https://hisnet.handong.edu/2012_images/intro/loginmain.jpg\">\n" +
                "  <h1> 24 - 1학기 휴학 신청이 완료되었습니다.</h1>\n" +
                "  <p>학우님의 앞날을 응원합니다. </p>\n" +
                "  <p>학생지원팀 김민혁 </p>\n" +
                "  <p>01085492384 </p>\n" +
                "  <a href=\"https://github.com/K-Minhyeok/Email_test\">GitHub 링크</a>\n" +
                "</body>\n" +
                "</html>";

        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
            messageHelper.setSubject(dto.getSubject());
            messageHelper.setTo(dto.getReceiver());
            messageHelper.setFrom("gurdl2384@naver.com", "한동대학교 학생지원팀");
            messageHelper.setText(html,true);
            mailSender.send(message);
        }catch(Exception e){
            e.printStackTrace();
        }

        emailRepository.save(Mail.of(dto));



    }


}
