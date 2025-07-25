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
 * Fees for TED transfers
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class MyAccountGetAccountFeesTransferTedDto {

  /**
   * Transfer fee via TED
   */
  @JsonProperty("feeValue")
  private JsonNullable<Double> feeValue;

  /**
   * Indicates whether the number of monthly free transactions considers TED
   */
  @JsonProperty("consideredInMonthlyTransfersWithoutFee")
  private JsonNullable<Boolean> consideredInMonthlyTransfersWithoutFee;

  @JsonIgnore
  public Double getFeeValue() {
    return feeValue.orElse(null);
  }

  @JsonIgnore
  public Boolean getConsideredInMonthlyTransfersWithoutFee() {
    return consideredInMonthlyTransfersWithoutFee.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class MyAccountGetAccountFeesTransferTedDtoBuilder {

    private JsonNullable<Double> feeValue = JsonNullable.undefined();

    @JsonProperty("feeValue")
    public MyAccountGetAccountFeesTransferTedDtoBuilder feeValue(Double value) {
      this.feeValue = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> consideredInMonthlyTransfersWithoutFee = JsonNullable.undefined();

    @JsonProperty("consideredInMonthlyTransfersWithoutFee")
    public MyAccountGetAccountFeesTransferTedDtoBuilder consideredInMonthlyTransfersWithoutFee(Boolean value) {
      this.consideredInMonthlyTransfersWithoutFee = JsonNullable.of(value);
      return this;
    }
  }
}
