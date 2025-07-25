// This file was generated by liblab | https://liblab.com/

package com.asaas.apisdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Filter by type of payment dunning
 */
@Getter
@AllArgsConstructor
public enum PaymentDunningListRequestPaymentDunningType {
  CREDIT_BUREAU("CREDIT_BUREAU"),
  DEBT_RECOVERY_ASSISTANCE("DEBT_RECOVERY_ASSISTANCE");

  @JsonValue
  private final String value;

  @JsonCreator
  public static PaymentDunningListRequestPaymentDunningType fromValue(String value) {
    return Arrays.stream(PaymentDunningListRequestPaymentDunningType.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
