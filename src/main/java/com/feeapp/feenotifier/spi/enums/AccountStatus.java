package com.feeapp.feenotifier.spi.enums;

public enum AccountStatus {
  ACTIVE("ACTIVE"),
  BLOCKED("BLOCKED"),
  PROCESSING("PROCESSING"),
  EXPIRED("EXPIRED");

  private String status;

  AccountStatus(String status) {
    this.status = status;
  }

  public String getStatus() {
    return this.status;
  }
}
