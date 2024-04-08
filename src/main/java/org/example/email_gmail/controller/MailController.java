package org.example.email_gmail.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.email_gmail.dto.EmailDto;
import org.example.email_gmail.request.EmailRequest;
import org.example.email_gmail.service.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MailController {

    private final EmailService emailService;

    @PostMapping("/mail")
    public String execMail(@RequestBody EmailRequest request) {

        emailService.mailSend(request);
        System.out.println("보냈음.");

        return "good";
    }

}
