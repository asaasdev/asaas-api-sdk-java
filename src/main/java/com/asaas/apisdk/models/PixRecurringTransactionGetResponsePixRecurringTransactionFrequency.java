// This file was generated by liblab | https://liblab.com/

package com.asaas.apisdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Recurrence frequency
 */
@Getter
@AllArgsConstructor
public enum PixRecurringTransactionGetResponsePixRecurringTransactionFrequency {
  WEEKLY("WEEKLY"),
  MONTHLY("MONTHLY");

  @JsonValue
  private final String value;

  @JsonCreator
  public static PixRecurringTransactionGetResponsePixRecurringTransactionFrequency fromValue(String value) {
    return Arrays.stream(PixRecurringTransactionGetResponsePixRecurringTransactionFrequency.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
