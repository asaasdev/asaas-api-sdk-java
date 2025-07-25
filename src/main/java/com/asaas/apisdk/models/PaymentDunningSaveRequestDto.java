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
public class PaymentDunningSaveRequestDto {

  /**
   * Unique identifier of the payment to be recovered in Asaas
   */
  @NonNull
  private String payment;

  /**
   * Type of payment dunning
   */
  @NonNull
  private PaymentDunningSaveRequestPaymentDunningType type;

  /**
   * Client name
   */
  @NonNull
  private String customerName;

  /**
   * Customer CPF or CNPJ
   */
  @NonNull
  private String customerCpfCnpj;

  /**
   * Customer main telephone number
   */
  @NonNull
  private String customerPrimaryPhone;

  /**
   * Customer address zip code
   */
  @NonNull
  private String customerPostalCode;

  /**
   * Customer public address
   */
  @NonNull
  private String customerAddress;

  /**
   * Customer address number
   */
  @NonNull
  private String customerAddressNumber;

  /**
   * Customer neighborhood
   */
  @NonNull
  private String customerProvince;

  /**
   * Description of the product or service provided
   */
  @JsonProperty("description")
  private JsonNullable<String> description;

  /**
   * Secondary customer phone number
   */
  @JsonProperty("customerSecondaryPhone")
  private JsonNullable<String> customerSecondaryPhone;

  /**
   * Customer address complement
   */
  @JsonProperty("customerComplement")
  private JsonNullable<String> customerComplement;

  /**
   * Invoice and/or contract notarized
   */
  @JsonProperty("documents")
  private JsonNullable<byte[]> documents;

  @JsonIgnore
  public String getDescription() {
    return description.orElse(null);
  }

  @JsonIgnore
  public String getCustomerSecondaryPhone() {
    return customerSecondaryPhone.orElse(null);
  }

  @JsonIgnore
  public String getCustomerComplement() {
    return customerComplement.orElse(null);
  }

  @JsonIgnore
  public byte[] getDocuments() {
    return documents.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class PaymentDunningSaveRequestDtoBuilder {

    private JsonNullable<String> description = JsonNullable.undefined();

    @JsonProperty("description")
    public PaymentDunningSaveRequestDtoBuilder description(String value) {
      this.description = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> customerSecondaryPhone = JsonNullable.undefined();

    @JsonProperty("customerSecondaryPhone")
    public PaymentDunningSaveRequestDtoBuilder customerSecondaryPhone(String value) {
      this.customerSecondaryPhone = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> customerComplement = JsonNullable.undefined();

    @JsonProperty("customerComplement")
    public PaymentDunningSaveRequestDtoBuilder customerComplement(String value) {
      this.customerComplement = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<byte[]> documents = JsonNullable.undefined();

    @JsonProperty("documents")
    public PaymentDunningSaveRequestDtoBuilder documents(byte[] value) {
      this.documents = JsonNullable.of(value);
      return this;
    }
  }
}
