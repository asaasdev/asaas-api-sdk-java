// This file was generated by liblab | https://liblab.com/

package com.asaas.apisdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Type of documents
 */
@Getter
@AllArgsConstructor
public enum AccountDocumentGroupResponseAccountDocumentType {
  IDENTIFICATION("IDENTIFICATION"),
  SOCIAL_CONTRACT("SOCIAL_CONTRACT"),
  ENTREPRENEUR_REQUIREMENT("ENTREPRENEUR_REQUIREMENT"),
  MINUTES_OF_ELECTION("MINUTES_OF_ELECTION"),
  CUSTOM("CUSTOM");

  @JsonValue
  private final String value;

  @JsonCreator
  public static AccountDocumentGroupResponseAccountDocumentType fromValue(String value) {
    return Arrays.stream(AccountDocumentGroupResponseAccountDocumentType.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
