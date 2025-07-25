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
public class PaymentBankSlipRefundResponseDto {

  /**
   * Link to report refund details
   */
  @JsonProperty("requestUrl")
  private JsonNullable<String> requestUrl;

  @JsonIgnore
  public String getRequestUrl() {
    return requestUrl.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class PaymentBankSlipRefundResponseDtoBuilder {

    private JsonNullable<String> requestUrl = JsonNullable.undefined();

    @JsonProperty("requestUrl")
    public PaymentBankSlipRefundResponseDtoBuilder requestUrl(String value) {
      this.requestUrl = JsonNullable.of(value);
      return this;
    }
  }
}
