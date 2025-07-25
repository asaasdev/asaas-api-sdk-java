// This file was generated by liblab | https://liblab.com/

package com.asaas.apisdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Transfer method
 */
@Getter
@AllArgsConstructor
public enum TransferGetResponseTransferType {
  PIX("PIX"),
  TED("TED"),
  INTERNAL("INTERNAL");

  @JsonValue
  private final String value;

  @JsonCreator
  public static TransferGetResponseTransferType fromValue(String value) {
    return Arrays.stream(TransferGetResponseTransferType.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
