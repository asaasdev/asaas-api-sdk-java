// This file was generated by liblab | https://liblab.com/

package com.asaas.apisdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Billing frequency
 */
@Getter
@AllArgsConstructor
public enum SubscriptionSaveRequestCycle {
  WEEKLY("WEEKLY"),
  BIWEEKLY("BIWEEKLY"),
  MONTHLY("MONTHLY"),
  BIMONTHLY("BIMONTHLY"),
  QUARTERLY("QUARTERLY"),
  SEMIANNUALLY("SEMIANNUALLY"),
  YEARLY("YEARLY");

  @JsonValue
  private final String value;

  @JsonCreator
  public static SubscriptionSaveRequestCycle fromValue(String value) {
    return Arrays.stream(SubscriptionSaveRequestCycle.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
