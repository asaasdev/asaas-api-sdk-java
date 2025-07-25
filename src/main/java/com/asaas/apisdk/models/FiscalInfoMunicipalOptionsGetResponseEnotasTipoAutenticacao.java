// This file was generated by liblab | https://liblab.com/

package com.asaas.apisdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Type of authentication required at city hall
 */
@Getter
@AllArgsConstructor
public enum FiscalInfoMunicipalOptionsGetResponseEnotasTipoAutenticacao {
  CERTIFICATE("CERTIFICATE"),
  TOKEN("TOKEN"),
  USER_AND_PASSWORD("USER_AND_PASSWORD");

  @JsonValue
  private final String value;

  @JsonCreator
  public static FiscalInfoMunicipalOptionsGetResponseEnotasTipoAutenticacao fromValue(String value) {
    return Arrays.stream(FiscalInfoMunicipalOptionsGetResponseEnotasTipoAutenticacao.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
