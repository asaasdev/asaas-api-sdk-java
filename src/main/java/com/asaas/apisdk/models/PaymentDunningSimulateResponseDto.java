// This file was generated by liblab | https://liblab.com/

package com.asaas.apisdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
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
public class PaymentDunningSimulateResponseDto {

  /**
   * Unique identifier of the payment to be recovered in Asaas
   */
  @JsonProperty("payment")
  private JsonNullable<String> payment;

  /**
   * Payment amount
   */
  @JsonProperty("value")
  private JsonNullable<Double> value;

  /**
   * Simulation of denial request for each type of denial available
   */
  @JsonProperty("typeSimulations")
  private JsonNullable<List<PaymentDunningSimulateResponseTypeSimulationItemDto>> typeSimulations;

  @JsonIgnore
  public String getPayment() {
    return payment.orElse(null);
  }

  @JsonIgnore
  public Double getValue() {
    return value.orElse(null);
  }

  @JsonIgnore
  public List<PaymentDunningSimulateResponseTypeSimulationItemDto> getTypeSimulations() {
    return typeSimulations.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class PaymentDunningSimulateResponseDtoBuilder {

    private JsonNullable<String> payment = JsonNullable.undefined();

    @JsonProperty("payment")
    public PaymentDunningSimulateResponseDtoBuilder payment(String value) {
      this.payment = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> value = JsonNullable.undefined();

    @JsonProperty("value")
    public PaymentDunningSimulateResponseDtoBuilder value(Double value) {
      this.value = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<PaymentDunningSimulateResponseTypeSimulationItemDto>> typeSimulations =
      JsonNullable.undefined();

    @JsonProperty("typeSimulations")
    public PaymentDunningSimulateResponseDtoBuilder typeSimulations(
      List<PaymentDunningSimulateResponseTypeSimulationItemDto> value
    ) {
      this.typeSimulations = JsonNullable.of(value);
      return this;
    }
  }
}
