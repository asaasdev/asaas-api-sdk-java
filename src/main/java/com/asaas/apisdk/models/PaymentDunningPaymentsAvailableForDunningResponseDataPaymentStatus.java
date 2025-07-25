// This file was generated by liblab | https://liblab.com/

package com.asaas.apisdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Billing status
 */
@Getter
@AllArgsConstructor
public enum PaymentDunningPaymentsAvailableForDunningResponseDataPaymentStatus {
  PENDING("PENDING"),
  RECEIVED("RECEIVED"),
  CONFIRMED("CONFIRMED"),
  OVERDUE("OVERDUE");

  @JsonValue
  private final String value;

  @JsonCreator
  public static PaymentDunningPaymentsAvailableForDunningResponseDataPaymentStatus fromValue(String value) {
    return Arrays.stream(PaymentDunningPaymentsAvailableForDunningResponseDataPaymentStatus.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
