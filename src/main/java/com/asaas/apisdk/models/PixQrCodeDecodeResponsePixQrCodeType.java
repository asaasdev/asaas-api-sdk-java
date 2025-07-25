// This file was generated by liblab | https://liblab.com/

package com.asaas.apisdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * QRCode Type
 */
@Getter
@AllArgsConstructor
public enum PixQrCodeDecodeResponsePixQrCodeType {
  STATIC_("STATIC"),
  DYNAMIC("DYNAMIC"),
  DYNAMIC_WITH_ASAAS_ADDRESS_KEY("DYNAMIC_WITH_ASAAS_ADDRESS_KEY"),
  COMPOSITE("COMPOSITE");

  @JsonValue
  private final String value;

  @JsonCreator
  public static PixQrCodeDecodeResponsePixQrCodeType fromValue(String value) {
    return Arrays.stream(PixQrCodeDecodeResponsePixQrCodeType.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
