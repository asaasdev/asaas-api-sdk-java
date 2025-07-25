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

/**
 * Installment details. If informed, it will be mandatory to include the `INSTALLMENT` chargeType
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class CheckoutSessionInstallmentDto {

  /**
   * Maximum number of installments
   */
  @JsonProperty("maxInstallmentCount")
  private JsonNullable<Long> maxInstallmentCount;

  @JsonIgnore
  public Long getMaxInstallmentCount() {
    return maxInstallmentCount.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class CheckoutSessionInstallmentDtoBuilder {

    private JsonNullable<Long> maxInstallmentCount = JsonNullable.undefined();

    @JsonProperty("maxInstallmentCount")
    public CheckoutSessionInstallmentDtoBuilder maxInstallmentCount(Long value) {
      this.maxInstallmentCount = JsonNullable.of(value);
      return this;
    }
  }
}
