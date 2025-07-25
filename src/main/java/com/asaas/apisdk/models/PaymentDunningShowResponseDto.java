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
public class PaymentDunningShowResponseDto {

  /**
   * Unique identifier of the payment dunning in Asaas
   */
  @JsonProperty("id")
  private JsonNullable<String> id;

  /**
   * Payment dunning number
   */
  @JsonProperty("dunningNumber")
  private JsonNullable<Long> dunningNumber;

  /**
   * Payment dunning status
   */
  @JsonProperty("status")
  private JsonNullable<PaymentDunningShowResponsePaymentDunningStatus> status;

  /**
   * Type of payment dunning
   */
  @JsonProperty("type")
  private JsonNullable<PaymentDunningShowResponsePaymentDunningType> type;

  /**
   * Request date
   */
  @JsonProperty("requestDate")
  private JsonNullable<String> requestDate;

  /**
   * Description of the payment dunning
   */
  @JsonProperty("description")
  private JsonNullable<String> description;

  /**
   * Payment amount
   */
  @JsonProperty("value")
  private JsonNullable<Double> value;

  /**
   * Cost and/or payment dunning fee
   */
  @JsonProperty("feeValue")
  private JsonNullable<Double> feeValue;

  /**
   * Net amount to be recovered
   */
  @JsonProperty("netValue")
  private JsonNullable<Double> netValue;

  /**
   * Cash receipt fee
   */
  @JsonProperty("receivedInCashFeeValue")
  private JsonNullable<Double> receivedInCashFeeValue;

  /**
   * Reason for denial of payment dunning
   */
  @JsonProperty("denialReason")
  private JsonNullable<String> denialReason;

  /**
   * Fee charged in case of cancellation
   */
  @JsonProperty("cancellationFeeValue")
  private JsonNullable<Double> cancellationFeeValue;

  /**
   * Whether the payment dunning can be canceled
   */
  @JsonProperty("canBeCancelled")
  private JsonNullable<Boolean> canBeCancelled;

  /**
   * Reason for not being able to request cancellation
   */
  @JsonProperty("cannotBeCancelledReason")
  private JsonNullable<String> cannotBeCancelledReason;

  /**
   * Determine whether documentation needs to be resubmitted
   */
  @JsonProperty("isNecessaryResendDocumentation")
  private JsonNullable<Boolean> isNecessaryResendDocumentation;

  /**
   * Unique identifier of the payment to be recovered in Asaas
   */
  @JsonProperty("payment")
  private JsonNullable<String> payment;

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonIgnore
  public Long getDunningNumber() {
    return dunningNumber.orElse(null);
  }

  @JsonIgnore
  public PaymentDunningShowResponsePaymentDunningStatus getStatus() {
    return status.orElse(null);
  }

  @JsonIgnore
  public PaymentDunningShowResponsePaymentDunningType getType() {
    return type.orElse(null);
  }

  @JsonIgnore
  public String getRequestDate() {
    return requestDate.orElse(null);
  }

  @JsonIgnore
  public String getDescription() {
    return description.orElse(null);
  }

  @JsonIgnore
  public Double getValue() {
    return value.orElse(null);
  }

  @JsonIgnore
  public Double getFeeValue() {
    return feeValue.orElse(null);
  }

  @JsonIgnore
  public Double getNetValue() {
    return netValue.orElse(null);
  }

  @JsonIgnore
  public Double getReceivedInCashFeeValue() {
    return receivedInCashFeeValue.orElse(null);
  }

  @JsonIgnore
  public String getDenialReason() {
    return denialReason.orElse(null);
  }

  @JsonIgnore
  public Double getCancellationFeeValue() {
    return cancellationFeeValue.orElse(null);
  }

  @JsonIgnore
  public Boolean getCanBeCancelled() {
    return canBeCancelled.orElse(null);
  }

  @JsonIgnore
  public String getCannotBeCancelledReason() {
    return cannotBeCancelledReason.orElse(null);
  }

  @JsonIgnore
  public Boolean getIsNecessaryResendDocumentation() {
    return isNecessaryResendDocumentation.orElse(null);
  }

  @JsonIgnore
  public String getPayment() {
    return payment.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class PaymentDunningShowResponseDtoBuilder {

    private JsonNullable<String> id = JsonNullable.undefined();

    @JsonProperty("id")
    public PaymentDunningShowResponseDtoBuilder id(String value) {
      this.id = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> dunningNumber = JsonNullable.undefined();

    @JsonProperty("dunningNumber")
    public PaymentDunningShowResponseDtoBuilder dunningNumber(Long value) {
      this.dunningNumber = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<PaymentDunningShowResponsePaymentDunningStatus> status = JsonNullable.undefined();

    @JsonProperty("status")
    public PaymentDunningShowResponseDtoBuilder status(PaymentDunningShowResponsePaymentDunningStatus value) {
      this.status = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<PaymentDunningShowResponsePaymentDunningType> type = JsonNullable.undefined();

    @JsonProperty("type")
    public PaymentDunningShowResponseDtoBuilder type(PaymentDunningShowResponsePaymentDunningType value) {
      this.type = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> requestDate = JsonNullable.undefined();

    @JsonProperty("requestDate")
    public PaymentDunningShowResponseDtoBuilder requestDate(String value) {
      this.requestDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> description = JsonNullable.undefined();

    @JsonProperty("description")
    public PaymentDunningShowResponseDtoBuilder description(String value) {
      this.description = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> value = JsonNullable.undefined();

    @JsonProperty("value")
    public PaymentDunningShowResponseDtoBuilder value(Double value) {
      this.value = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> feeValue = JsonNullable.undefined();

    @JsonProperty("feeValue")
    public PaymentDunningShowResponseDtoBuilder feeValue(Double value) {
      this.feeValue = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> netValue = JsonNullable.undefined();

    @JsonProperty("netValue")
    public PaymentDunningShowResponseDtoBuilder netValue(Double value) {
      this.netValue = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> receivedInCashFeeValue = JsonNullable.undefined();

    @JsonProperty("receivedInCashFeeValue")
    public PaymentDunningShowResponseDtoBuilder receivedInCashFeeValue(Double value) {
      this.receivedInCashFeeValue = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> denialReason = JsonNullable.undefined();

    @JsonProperty("denialReason")
    public PaymentDunningShowResponseDtoBuilder denialReason(String value) {
      this.denialReason = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> cancellationFeeValue = JsonNullable.undefined();

    @JsonProperty("cancellationFeeValue")
    public PaymentDunningShowResponseDtoBuilder cancellationFeeValue(Double value) {
      this.cancellationFeeValue = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> canBeCancelled = JsonNullable.of(true);

    @JsonProperty("canBeCancelled")
    public PaymentDunningShowResponseDtoBuilder canBeCancelled(Boolean value) {
      this.canBeCancelled = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> cannotBeCancelledReason = JsonNullable.undefined();

    @JsonProperty("cannotBeCancelledReason")
    public PaymentDunningShowResponseDtoBuilder cannotBeCancelledReason(String value) {
      this.cannotBeCancelledReason = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> isNecessaryResendDocumentation = JsonNullable.undefined();

    @JsonProperty("isNecessaryResendDocumentation")
    public PaymentDunningShowResponseDtoBuilder isNecessaryResendDocumentation(Boolean value) {
      this.isNecessaryResendDocumentation = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> payment = JsonNullable.undefined();

    @JsonProperty("payment")
    public PaymentDunningShowResponseDtoBuilder payment(String value) {
      this.payment = JsonNullable.of(value);
      return this;
    }
  }
}
