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
public class AnticipationSaveRequestDto {

  /**
   * ID of the installment to be anticipated
   */
  @JsonProperty("installment")
  private JsonNullable<String> installment;

  /**
   * ID of the payment to be anticipated
   */
  @JsonProperty("payment")
  private JsonNullable<String> payment;

  /**
   * File
   */
  @JsonProperty("documents")
  private JsonNullable<byte[]> documents;

  @JsonIgnore
  public String getInstallment() {
    return installment.orElse(null);
  }

  @JsonIgnore
  public String getPayment() {
    return payment.orElse(null);
  }

  @JsonIgnore
  public byte[] getDocuments() {
    return documents.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AnticipationSaveRequestDtoBuilder {

    private JsonNullable<String> installment = JsonNullable.undefined();

    @JsonProperty("installment")
    public AnticipationSaveRequestDtoBuilder installment(String value) {
      this.installment = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> payment = JsonNullable.undefined();

    @JsonProperty("payment")
    public AnticipationSaveRequestDtoBuilder payment(String value) {
      this.payment = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<byte[]> documents = JsonNullable.undefined();

    @JsonProperty("documents")
    public AnticipationSaveRequestDtoBuilder documents(byte[] value) {
      if (value == null) {
        throw new IllegalStateException("documents cannot be null");
      }
      this.documents = JsonNullable.of(value);
      return this;
    }
  }
}
