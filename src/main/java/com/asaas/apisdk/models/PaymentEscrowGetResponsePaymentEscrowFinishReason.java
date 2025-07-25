// This file was generated by liblab | https://liblab.com/

package com.asaas.apisdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Payment escrow finish reason
 */
@Getter
@AllArgsConstructor
public enum PaymentEscrowGetResponsePaymentEscrowFinishReason {
  CHARGEBACK("CHARGEBACK"),
  EXPIRED("EXPIRED"),
  INSUFFICIENT_BALANCE("INSUFFICIENT_BALANCE"),
  PAYMENT_REFUNDED("PAYMENT_REFUNDED"),
  REQUESTED_BY_CUSTOMER("REQUESTED_BY_CUSTOMER"),
  CUSTOMER_CONFIG_DISABLED("CUSTOMER_CONFIG_DISABLED");

  @JsonValue
  private final String value;

  @JsonCreator
  public static PaymentEscrowGetResponsePaymentEscrowFinishReason fromValue(String value) {
    return Arrays.stream(PaymentEscrowGetResponsePaymentEscrowFinishReason.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
