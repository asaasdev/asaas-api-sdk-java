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

/**
 * Refunds information
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class InstallmentRefundResponseDto {

  /**
   * Refund creation date
   */
  @JsonProperty("dateCreated")
  private JsonNullable<String> dateCreated;

  /**
   * Refund status
   */
  @JsonProperty("status")
  private JsonNullable<InstallmentRefundResponsePaymentRefundStatus> status;

  /**
   * Refund value
   */
  @JsonProperty("value")
  private JsonNullable<Double> value;

  /**
   * (Pix only) Unique identifier of the Pix transaction at the Central Bank
   */
  @JsonProperty("endToEndIdentifier")
  private JsonNullable<String> endToEndIdentifier;

  /**
   * Description of the refund
   */
  @JsonProperty("description")
  private JsonNullable<String> description;

  /**
   * (Pix only) Refund effective date
   */
  @JsonProperty("effectiveDate")
  private JsonNullable<String> effectiveDate;

  /**
   * Transaction receipt link
   */
  @JsonProperty("transactionReceiptUrl")
  private JsonNullable<String> transactionReceiptUrl;

  /**
   * Refunded Splits, if any
   */
  @JsonProperty("refundedSplits")
  private JsonNullable<List<PaymentRefundedSplitResponseDto>> refundedSplits;

  /**
   * Unique payment identifier in Asaas
   */
  @JsonProperty("paymentId")
  private JsonNullable<String> paymentId;

  @JsonIgnore
  public String getDateCreated() {
    return dateCreated.orElse(null);
  }

  @JsonIgnore
  public InstallmentRefundResponsePaymentRefundStatus getStatus() {
    return status.orElse(null);
  }

  @JsonIgnore
  public Double getValue() {
    return value.orElse(null);
  }

  @JsonIgnore
  public String getEndToEndIdentifier() {
    return endToEndIdentifier.orElse(null);
  }

  @JsonIgnore
  public String getDescription() {
    return description.orElse(null);
  }

  @JsonIgnore
  public String getEffectiveDate() {
    return effectiveDate.orElse(null);
  }

  @JsonIgnore
  public String getTransactionReceiptUrl() {
    return transactionReceiptUrl.orElse(null);
  }

  @JsonIgnore
  public List<PaymentRefundedSplitResponseDto> getRefundedSplits() {
    return refundedSplits.orElse(null);
  }

  @JsonIgnore
  public String getPaymentId() {
    return paymentId.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class InstallmentRefundResponseDtoBuilder {

    private JsonNullable<String> dateCreated = JsonNullable.undefined();

    @JsonProperty("dateCreated")
    public InstallmentRefundResponseDtoBuilder dateCreated(String value) {
      this.dateCreated = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<InstallmentRefundResponsePaymentRefundStatus> status = JsonNullable.undefined();

    @JsonProperty("status")
    public InstallmentRefundResponseDtoBuilder status(InstallmentRefundResponsePaymentRefundStatus value) {
      this.status = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> value = JsonNullable.undefined();

    @JsonProperty("value")
    public InstallmentRefundResponseDtoBuilder value(Double value) {
      this.value = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> endToEndIdentifier = JsonNullable.undefined();

    @JsonProperty("endToEndIdentifier")
    public InstallmentRefundResponseDtoBuilder endToEndIdentifier(String value) {
      this.endToEndIdentifier = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> description = JsonNullable.undefined();

    @JsonProperty("description")
    public InstallmentRefundResponseDtoBuilder description(String value) {
      this.description = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> effectiveDate = JsonNullable.undefined();

    @JsonProperty("effectiveDate")
    public InstallmentRefundResponseDtoBuilder effectiveDate(String value) {
      this.effectiveDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> transactionReceiptUrl = JsonNullable.undefined();

    @JsonProperty("transactionReceiptUrl")
    public InstallmentRefundResponseDtoBuilder transactionReceiptUrl(String value) {
      this.transactionReceiptUrl = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<PaymentRefundedSplitResponseDto>> refundedSplits = JsonNullable.undefined();

    @JsonProperty("refundedSplits")
    public InstallmentRefundResponseDtoBuilder refundedSplits(List<PaymentRefundedSplitResponseDto> value) {
      this.refundedSplits = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> paymentId = JsonNullable.undefined();

    @JsonProperty("paymentId")
    public InstallmentRefundResponseDtoBuilder paymentId(String value) {
      this.paymentId = JsonNullable.of(value);
      return this;
    }
  }
}
