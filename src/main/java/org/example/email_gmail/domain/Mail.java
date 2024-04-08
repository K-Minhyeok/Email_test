package org.example.email_gmail.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.example.email_gmail.dto.EmailDto;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Mail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String receiver;
    private String subject;
    private String message;



    public static Mail of(EmailDto dto){
        return Mail.builder()
                .receiver(dto.getReceiver())
                .subject(dto.getSubject())
                .message(dto.getMessage())
                .build();
    }



}
