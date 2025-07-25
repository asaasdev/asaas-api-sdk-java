// This file was generated by liblab | https://liblab.com/

package com.asaas.apisdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class PaymentLimitsResponseDto {

  /**
   * Breeding limits
   */
  @JsonProperty("creation")
  private JsonNullable<PaymentLimitsResponseCreationDto> creation;

  @JsonIgnore
  public PaymentLimitsResponseCreationDto getCreation() {
    return creation.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class PaymentLimitsResponseDtoBuilder {

    private JsonNullable<PaymentLimitsResponseCreationDto> creation = JsonNullable.undefined();

    @JsonProperty("creation")
    public PaymentLimitsResponseDtoBuilder creation(PaymentLimitsResponseCreationDto value) {
      this.creation = JsonNullable.of(value);
      return this;
    }
  }
}
