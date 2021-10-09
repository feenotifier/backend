package com.feeapp.feenotifier.spi.rest;

import com.feeapp.feenotifier.spi.service.AccountVerificationService;
import javax.mail.MessagingException;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping(path = "/account/verification")
public class AccountVerification {
  private final AccountVerificationService accountVerificationService;

  public AccountVerification(AccountVerificationService accountVerificationService) {
    this.accountVerificationService = accountVerificationService;
  }

  @GetMapping(path = "/sendOtp")
  public String sendOtp(@RequestParam String email)
      throws MessagingException, InterruptedException {
    return accountVerificationService.sendOtpToEmail(email);
  }
}
