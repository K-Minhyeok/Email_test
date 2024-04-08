package org.example.email_gmail.dto;

import lombok.Builder;
import lombok.Getter;
import org.example.email_gmail.request.EmailRequest;

@Getter
@Builder
public class EmailDto {

    private String receiver;
    private String subject;
    private String message;

    public static EmailDto of(EmailRequest request){

        return EmailDto.builder()
                .receiver(request.getReceiver())
                .subject(request.getSubject())
                .message(request.getMessage())
                .build();
    }

}
