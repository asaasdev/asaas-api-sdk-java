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
public class PaymentLinkGetResponseDto {

  /**
   * Unique identifier for your payments link in Asaas
   */
  @JsonProperty("id")
  private JsonNullable<String> id;

  /**
   * Payment link name
   */
  @JsonProperty("name")
  private JsonNullable<String> name;

  /**
   * Value of the payment link, if not informed, the payer can inform how much they want to pay
   */
  @JsonProperty("value")
  private JsonNullable<Double> value;

  /**
   * If the payments link is active
   */
  @JsonProperty("active")
  private JsonNullable<Boolean> active;

  /**
   * Charge type
   */
  @JsonProperty("chargeType")
  private JsonNullable<PaymentLinkGetResponseChargeType> chargeType;

  /**
   * Payments link access link
   */
  @JsonProperty("url")
  private JsonNullable<String> url;

  /**
   * Allowed payment method
   */
  @JsonProperty("billingType")
  private JsonNullable<PaymentLinkGetResponseBillingType> billingType;

  /**
   * Billing frequency, if the chargeType is RECURRENT
   */
  @JsonProperty("subscriptionCycle")
  private JsonNullable<PaymentLinkGetResponseCycle> subscriptionCycle;

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
   * Indicates whether the payment link has been removed
   */
  @JsonProperty("deleted")
  private JsonNullable<Boolean> deleted;

  /**
   * The number of views of your payments link
   */
  @JsonProperty("viewCount")
  private JsonNullable<Long> viewCount;

  /**
   * Maximum number of installments that your customer can pay in installments for the payment link, if it is Installment.
   */
  @JsonProperty("maxInstallmentCount")
  private JsonNullable<Long> maxInstallmentCount;

  /**
   * Number of business days that your customer can pay after the invoice is generated (For payment method such as Boleto)
   */
  @JsonProperty("dueDateLimitDays")
  private JsonNullable<Long> dueDateLimitDays;

  /**
   * Defines whether customers registered via the payments link will have notifications enabled
   */
  @JsonProperty("notificationEnabled")
  private JsonNullable<Boolean> notificationEnabled;

  /**
   * Defines whether filling in the address will be obligatory in the charges.
   */
  @JsonProperty("isAddressRequired")
  private JsonNullable<Boolean> isAddressRequired;

  /**
   * Free search field.
   */
  @JsonProperty("externalReference")
  private JsonNullable<String> externalReference;

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonIgnore
  public Double getValue() {
    return value.orElse(null);
  }

  @JsonIgnore
  public Boolean getActive() {
    return active.orElse(null);
  }

  @JsonIgnore
  public PaymentLinkGetResponseChargeType getChargeType() {
    return chargeType.orElse(null);
  }

  @JsonIgnore
  public String getUrl() {
    return url.orElse(null);
  }

  @JsonIgnore
  public PaymentLinkGetResponseBillingType getBillingType() {
    return billingType.orElse(null);
  }

  @JsonIgnore
  public PaymentLinkGetResponseCycle getSubscriptionCycle() {
    return subscriptionCycle.orElse(null);
  }

  @JsonIgnore
  public String getDescription() {
    return description.orElse(null);
  }

  @JsonIgnore
  public String getEndDate() {
    return endDate.orElse(null);
  }

  @JsonIgnore
  public Boolean getDeleted() {
    return deleted.orElse(null);
  }

  @JsonIgnore
  public Long getViewCount() {
    return viewCount.orElse(null);
  }

  @JsonIgnore
  public Long getMaxInstallmentCount() {
    return maxInstallmentCount.orElse(null);
  }

  @JsonIgnore
  public Long getDueDateLimitDays() {
    return dueDateLimitDays.orElse(null);
  }

  @JsonIgnore
  public Boolean getNotificationEnabled() {
    return notificationEnabled.orElse(null);
  }

  @JsonIgnore
  public Boolean getIsAddressRequired() {
    return isAddressRequired.orElse(null);
  }

  @JsonIgnore
  public String getExternalReference() {
    return externalReference.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class PaymentLinkGetResponseDtoBuilder {

    private JsonNullable<String> id = JsonNullable.undefined();

    @JsonProperty("id")
    public PaymentLinkGetResponseDtoBuilder id(String value) {
      this.id = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> name = JsonNullable.undefined();

    @JsonProperty("name")
    public PaymentLinkGetResponseDtoBuilder name(String value) {
      this.name = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> value = JsonNullable.undefined();

    @JsonProperty("value")
    public PaymentLinkGetResponseDtoBuilder value(Double value) {
      this.value = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> active = JsonNullable.undefined();

    @JsonProperty("active")
    public PaymentLinkGetResponseDtoBuilder active(Boolean value) {
      this.active = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<PaymentLinkGetResponseChargeType> chargeType = JsonNullable.undefined();

    @JsonProperty("chargeType")
    public PaymentLinkGetResponseDtoBuilder chargeType(PaymentLinkGetResponseChargeType value) {
      this.chargeType = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> url = JsonNullable.undefined();

    @JsonProperty("url")
    public PaymentLinkGetResponseDtoBuilder url(String value) {
      this.url = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<PaymentLinkGetResponseBillingType> billingType = JsonNullable.undefined();

    @JsonProperty("billingType")
    public PaymentLinkGetResponseDtoBuilder billingType(PaymentLinkGetResponseBillingType value) {
      this.billingType = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<PaymentLinkGetResponseCycle> subscriptionCycle = JsonNullable.undefined();

    @JsonProperty("subscriptionCycle")
    public PaymentLinkGetResponseDtoBuilder subscriptionCycle(PaymentLinkGetResponseCycle value) {
      this.subscriptionCycle = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> description = JsonNullable.undefined();

    @JsonProperty("description")
    public PaymentLinkGetResponseDtoBuilder description(String value) {
      this.description = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> endDate = JsonNullable.undefined();

    @JsonProperty("endDate")
    public PaymentLinkGetResponseDtoBuilder endDate(String value) {
      this.endDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> deleted = JsonNullable.undefined();

    @JsonProperty("deleted")
    public PaymentLinkGetResponseDtoBuilder deleted(Boolean value) {
      this.deleted = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> viewCount = JsonNullable.undefined();

    @JsonProperty("viewCount")
    public PaymentLinkGetResponseDtoBuilder viewCount(Long value) {
      this.viewCount = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> maxInstallmentCount = JsonNullable.undefined();

    @JsonProperty("maxInstallmentCount")
    public PaymentLinkGetResponseDtoBuilder maxInstallmentCount(Long value) {
      this.maxInstallmentCount = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> dueDateLimitDays = JsonNullable.undefined();

    @JsonProperty("dueDateLimitDays")
    public PaymentLinkGetResponseDtoBuilder dueDateLimitDays(Long value) {
      this.dueDateLimitDays = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> notificationEnabled = JsonNullable.undefined();

    @JsonProperty("notificationEnabled")
    public PaymentLinkGetResponseDtoBuilder notificationEnabled(Boolean value) {
      this.notificationEnabled = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> isAddressRequired = JsonNullable.undefined();

    @JsonProperty("isAddressRequired")
    public PaymentLinkGetResponseDtoBuilder isAddressRequired(Boolean value) {
      this.isAddressRequired = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> externalReference = JsonNullable.undefined();

    @JsonProperty("externalReference")
    public PaymentLinkGetResponseDtoBuilder externalReference(String value) {
      this.externalReference = JsonNullable.of(value);
      return this;
    }
  }
}
