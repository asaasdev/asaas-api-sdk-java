// This file was generated by liblab | https://liblab.com/

package com.asaas.apisdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Charge types
 */
@Getter
@AllArgsConstructor
public enum CheckoutSessionResponseChargeType {
  DETACHED("DETACHED"),
  RECURRENT("RECURRENT"),
  INSTALLMENT("INSTALLMENT");

  @JsonValue
  private final String value;

  @JsonCreator
  public static CheckoutSessionResponseChargeType fromValue(String value) {
    return Arrays.stream(CheckoutSessionResponseChargeType.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
