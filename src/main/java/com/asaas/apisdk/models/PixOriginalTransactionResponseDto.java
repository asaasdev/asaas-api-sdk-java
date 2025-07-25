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
 * Original transaction information if a chargeback has occurred
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class PixOriginalTransactionResponseDto {

  /**
   * Unique transaction identifier
   */
  @JsonProperty("id")
  private JsonNullable<String> id;

  /**
   * Unique identifier of the Pix transaction at the Central Bank
   */
  @JsonProperty("endToEndIdentifier")
  private JsonNullable<String> endToEndIdentifier;

  /**
   * Original transaction value
   */
  @JsonProperty("value")
  private JsonNullable<Double> value;

  /**
   * Transaction date
   */
  @JsonProperty("effectiveDate")
  private JsonNullable<String> effectiveDate;

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonIgnore
  public String getEndToEndIdentifier() {
    return endToEndIdentifier.orElse(null);
  }

  @JsonIgnore
  public Double getValue() {
    return value.orElse(null);
  }

  @JsonIgnore
  public String getEffectiveDate() {
    return effectiveDate.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class PixOriginalTransactionResponseDtoBuilder {

    private JsonNullable<String> id = JsonNullable.undefined();

    @JsonProperty("id")
    public PixOriginalTransactionResponseDtoBuilder id(String value) {
      this.id = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> endToEndIdentifier = JsonNullable.undefined();

    @JsonProperty("endToEndIdentifier")
    public PixOriginalTransactionResponseDtoBuilder endToEndIdentifier(String value) {
      this.endToEndIdentifier = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> value = JsonNullable.undefined();

    @JsonProperty("value")
    public PixOriginalTransactionResponseDtoBuilder value(Double value) {
      this.value = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> effectiveDate = JsonNullable.undefined();

    @JsonProperty("effectiveDate")
    public PixOriginalTransactionResponseDtoBuilder effectiveDate(String value) {
      this.effectiveDate = JsonNullable.of(value);
      return this;
    }
  }
}
