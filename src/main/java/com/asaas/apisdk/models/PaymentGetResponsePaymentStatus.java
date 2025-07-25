// This file was generated by liblab | https://liblab.com/

package com.asaas.apisdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Payment status
 */
@Getter
@AllArgsConstructor
public enum PaymentGetResponsePaymentStatus {
  PENDING("PENDING"),
  RECEIVED("RECEIVED"),
  CONFIRMED("CONFIRMED"),
  OVERDUE("OVERDUE"),
  REFUNDED("REFUNDED"),
  RECEIVED_IN_CASH("RECEIVED_IN_CASH"),
  REFUND_REQUESTED("REFUND_REQUESTED"),
  REFUND_IN_PROGRESS("REFUND_IN_PROGRESS"),
  CHARGEBACK_REQUESTED("CHARGEBACK_REQUESTED"),
  CHARGEBACK_DISPUTE("CHARGEBACK_DISPUTE"),
  AWAITING_CHARGEBACK_REVERSAL("AWAITING_CHARGEBACK_REVERSAL"),
  DUNNING_REQUESTED("DUNNING_REQUESTED"),
  DUNNING_RECEIVED("DUNNING_RECEIVED"),
  AWAITING_RISK_ANALYSIS("AWAITING_RISK_ANALYSIS");

  @JsonValue
  private final String value;

  @JsonCreator
  public static PaymentGetResponsePaymentStatus fromValue(String value) {
    return Arrays.stream(PaymentGetResponsePaymentStatus.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
