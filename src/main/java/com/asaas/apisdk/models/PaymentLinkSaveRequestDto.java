// This file was generated by liblab | https://liblab.com/

package com.asaas.apisdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
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
public class PaymentLinkSaveRequestDto {

  /**
   * Payment link name
   */
  @NonNull
  private String name;

  /**
   * Allowed payment method
   */
  @NonNull
  private PaymentLinkSaveRequestBillingType billingType;

  /**
   * Charge type
   */
  @NonNull
  private PaymentLinkSaveRequestChargeType chargeType;

  /**
   * Payments link description
   */
  @JsonProperty("description")
  private JsonNullable<String> description;

  /**
   * End date
   */
  @JsonProperty("endDate")
  private JsonNullable<String> endDate;

  /**
   * Value of the payment link, if not informed, the payer can inform how much they want to pay
   */
  @JsonProperty("value")
  private JsonNullable<Double> value;

  /**
   * Number of business days that your customer can pay after the invoice is generated (For payment method such as Boleto)
   */
  @JsonProperty("dueDateLimitDays")
  private JsonNullable<Long> dueDateLimitDays;

  /**
   * Billing frequency, if the chargeType is RECURRENT
   */
  @JsonProperty("subscriptionCycle")
  private JsonNullable<PaymentLinkSaveRequestCycle> subscriptionCycle;

  /**
   * Maximum number of installments that your customer can pay in installments for the payment link if the billing method selected is Installments. If not informed, the default value will be 1 installment
   */
  @JsonProperty("maxInstallmentCount")
  private JsonNullable<Long> maxInstallmentCount;

  /**
   * Free search field.
   */
  @JsonProperty("externalReference")
  private JsonNullable<String> externalReference;

  /**
   * Defines whether customers registered via the payments link will have notifications enabled. If not informed, the default value will be true
   */
  @JsonProperty("notificationEnabled")
  private JsonNullable<Boolean> notificationEnabled;

  /**
   * Automatic redirection information after the payment of the link payment
   */
  @JsonProperty("callback")
  private JsonNullable<PaymentCallbackRequestDto> callback;

  /**
   * True to make it mandatory to fill in address data at checkout.
   */
  @JsonProperty("isAddressRequired")
  private JsonNullable<Boolean> isAddressRequired;

  @JsonIgnore
  public String getDescription() {
    return description.orElse(null);
  }

  @JsonIgnore
  public String getEndDate() {
    return endDate.orElse(null);
  }

  @JsonIgnore
  public Double getValue() {
    return value.orElse(null);
  }

  @JsonIgnore
  public Long getDueDateLimitDays() {
    return dueDateLimitDays.orElse(null);
  }

  @JsonIgnore
  public PaymentLinkSaveRequestCycle getSubscriptionCycle() {
    return subscriptionCycle.orElse(null);
  }

  @JsonIgnore
  public Long getMaxInstallmentCount() {
    return maxInstallmentCount.orElse(null);
  }

  @JsonIgnore
  public String getExternalReference() {
    return externalReference.orElse(null);
  }

  @JsonIgnore
  public Boolean getNotificationEnabled() {
    return notificationEnabled.orElse(null);
  }

  @JsonIgnore
  public PaymentCallbackRequestDto getCallback() {
    return callback.orElse(null);
  }

  @JsonIgnore
  public Boolean getIsAddressRequired() {
    return isAddressRequired.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class PaymentLinkSaveRequestDtoBuilder {

    private JsonNullable<String> description = JsonNullable.undefined();

    @JsonProperty("description")
    public PaymentLinkSaveRequestDtoBuilder description(String value) {
      this.description = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> endDate = JsonNullable.undefined();

    @JsonProperty("endDate")
    public PaymentLinkSaveRequestDtoBuilder endDate(String value) {
      this.endDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> value = JsonNullable.undefined();

    @JsonProperty("value")
    public PaymentLinkSaveRequestDtoBuilder value(Double value) {
      this.value = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> dueDateLimitDays = JsonNullable.undefined();

    @JsonProperty("dueDateLimitDays")
    public PaymentLinkSaveRequestDtoBuilder dueDateLimitDays(Long value) {
      this.dueDateLimitDays = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<PaymentLinkSaveRequestCycle> subscriptionCycle = JsonNullable.undefined();

    @JsonProperty("subscriptionCycle")
    public PaymentLinkSaveRequestDtoBuilder subscriptionCycle(PaymentLinkSaveRequestCycle value) {
      this.subscriptionCycle = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> maxInstallmentCount = JsonNullable.of(1L);

    @JsonProperty("maxInstallmentCount")
    public PaymentLinkSaveRequestDtoBuilder maxInstallmentCount(Long value) {
      this.maxInstallmentCount = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> externalReference = JsonNullable.undefined();

    @JsonProperty("externalReference")
    public PaymentLinkSaveRequestDtoBuilder externalReference(String value) {
      this.externalReference = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> notificationEnabled = JsonNullable.of(true);

    @JsonProperty("notificationEnabled")
    public PaymentLinkSaveRequestDtoBuilder notificationEnabled(Boolean value) {
      this.notificationEnabled = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<PaymentCallbackRequestDto> callback = JsonNullable.undefined();

    @JsonProperty("callback")
    public PaymentLinkSaveRequestDtoBuilder callback(PaymentCallbackRequestDto value) {
      this.callback = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> isAddressRequired = JsonNullable.undefined();

    @JsonProperty("isAddressRequired")
    public PaymentLinkSaveRequestDtoBuilder isAddressRequired(Boolean value) {
      this.isAddressRequired = JsonNullable.of(value);
      return this;
    }
  }
}
