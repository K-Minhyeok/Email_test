package org.example.email_gmail.repository;

import org.example.email_gmail.domain.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Mail,Long> {

}
