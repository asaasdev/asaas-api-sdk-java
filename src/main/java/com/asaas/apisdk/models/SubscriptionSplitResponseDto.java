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
 * Split information
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class SubscriptionSplitResponseDto {

  /**
   * Asaas wallet identifier that will be transferred
   */
  @JsonProperty("walletId")
  private JsonNullable<String> walletId;

  /**
   * Fixed amount to be transferred to the account when the payment is received
   */
  @JsonProperty("fixedValue")
  private JsonNullable<Double> fixedValue;

  /**
   * Percentage of the net value of the charge to be transferred when received
   */
  @JsonProperty("percentualValue")
  private JsonNullable<Double> percentualValue;

  /**
   * Split identifier in your system
   */
  @JsonProperty("externalReference")
  private JsonNullable<String> externalReference;

  /**
   * Split description
   */
  @JsonProperty("description")
  private JsonNullable<String> description;

  /**
   * Subscription split status
   */
  @JsonProperty("status")
  private JsonNullable<SubscriptionSplitResponseSubscriptionSplitStatus> status;

  /**
   * Reason why subscription split was disabled
   */
  @JsonProperty("disabledReason")
  private JsonNullable<SubscriptionSplitResponseSubscriptionSplitDisabledReason> disabledReason;

  @JsonIgnore
  public String getWalletId() {
    return walletId.orElse(null);
  }

  @JsonIgnore
  public Double getFixedValue() {
    return fixedValue.orElse(null);
  }

  @JsonIgnore
  public Double getPercentualValue() {
    return percentualValue.orElse(null);
  }

  @JsonIgnore
  public String getExternalReference() {
    return externalReference.orElse(null);
  }

  @JsonIgnore
  public String getDescription() {
    return description.orElse(null);
  }

  @JsonIgnore
  public SubscriptionSplitResponseSubscriptionSplitStatus getStatus() {
    return status.orElse(null);
  }

  @JsonIgnore
  public SubscriptionSplitResponseSubscriptionSplitDisabledReason getDisabledReason() {
    return disabledReason.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class SubscriptionSplitResponseDtoBuilder {

    private JsonNullable<String> walletId = JsonNullable.undefined();

    @JsonProperty("walletId")
    public SubscriptionSplitResponseDtoBuilder walletId(String value) {
      this.walletId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> fixedValue = JsonNullable.undefined();

    @JsonProperty("fixedValue")
    public SubscriptionSplitResponseDtoBuilder fixedValue(Double value) {
      this.fixedValue = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> percentualValue = JsonNullable.undefined();

    @JsonProperty("percentualValue")
    public SubscriptionSplitResponseDtoBuilder percentualValue(Double value) {
      this.percentualValue = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> externalReference = JsonNullable.undefined();

    @JsonProperty("externalReference")
    public SubscriptionSplitResponseDtoBuilder externalReference(String value) {
      this.externalReference = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> description = JsonNullable.undefined();

    @JsonProperty("description")
    public SubscriptionSplitResponseDtoBuilder description(String value) {
      this.description = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<SubscriptionSplitResponseSubscriptionSplitStatus> status = JsonNullable.undefined();

    @JsonProperty("status")
    public SubscriptionSplitResponseDtoBuilder status(SubscriptionSplitResponseSubscriptionSplitStatus value) {
      this.status = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<SubscriptionSplitResponseSubscriptionSplitDisabledReason> disabledReason =
      JsonNullable.undefined();

    @JsonProperty("disabledReason")
    public SubscriptionSplitResponseDtoBuilder disabledReason(
      SubscriptionSplitResponseSubscriptionSplitDisabledReason value
    ) {
      this.disabledReason = JsonNullable.of(value);
      return this;
    }
  }
}
