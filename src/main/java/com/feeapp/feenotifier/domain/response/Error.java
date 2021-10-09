package com.feeapp.feenotifier.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Error {
  private int code;
  private String message;

  public Error(String message) {
    this.message = message;
  }
}
