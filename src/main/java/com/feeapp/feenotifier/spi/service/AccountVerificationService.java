package com.feeapp.feenotifier.spi.service;

import java.util.concurrent.ThreadLocalRandom;
import javax.mail.MessagingException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class AccountVerificationService {
  @Autowired private NotificationService notificationService;

  public String sendOtpToEmail(String email) throws MessagingException, InterruptedException {
    String otp = Integer.toString(ThreadLocalRandom.current().nextInt(100000, 1000001));
    notificationService.sendMail(
        email, "Account Verification", "Otp for you account verification is: " + otp);
    return otp;
  }
}
