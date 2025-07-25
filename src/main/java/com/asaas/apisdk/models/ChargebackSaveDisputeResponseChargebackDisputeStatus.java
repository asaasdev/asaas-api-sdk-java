// This file was generated by liblab | https://liblab.com/

package com.asaas.apisdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Dispute status.
 */
@Getter
@AllArgsConstructor
public enum ChargebackSaveDisputeResponseChargebackDisputeStatus {
  REQUESTED("REQUESTED"),
  ACCEPTED("ACCEPTED"),
  REJECTED("REJECTED");

  @JsonValue
  private final String value;

  @JsonCreator
  public static ChargebackSaveDisputeResponseChargebackDisputeStatus fromValue(String value) {
    return Arrays.stream(ChargebackSaveDisputeResponseChargebackDisputeStatus.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
