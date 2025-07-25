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
 * File object
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class PaymentDocumentFileResponseDto {

  /**
   * Unique document identifier
   */
  @JsonProperty("publicId")
  private JsonNullable<String> publicId;

  /**
   * Original document name
   */
  @JsonProperty("originalName")
  private JsonNullable<String> originalName;

  /**
   * File size
   */
  @JsonProperty("size")
  private JsonNullable<Long> size;

  /**
   * File extension
   */
  @JsonProperty("extension")
  private JsonNullable<String> extension;

  /**
   * Link to download the file preview
   */
  @JsonProperty("previewUrl")
  private JsonNullable<String> previewUrl;

  /**
   * Link to download the file
   */
  @JsonProperty("downloadUrl")
  private JsonNullable<String> downloadUrl;

  @JsonIgnore
  public String getPublicId() {
    return publicId.orElse(null);
  }

  @JsonIgnore
  public String getOriginalName() {
    return originalName.orElse(null);
  }

  @JsonIgnore
  public Long getSize() {
    return size.orElse(null);
  }

  @JsonIgnore
  public String getExtension() {
    return extension.orElse(null);
  }

  @JsonIgnore
  public String getPreviewUrl() {
    return previewUrl.orElse(null);
  }

  @JsonIgnore
  public String getDownloadUrl() {
    return downloadUrl.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class PaymentDocumentFileResponseDtoBuilder {

    private JsonNullable<String> publicId = JsonNullable.undefined();

    @JsonProperty("publicId")
    public PaymentDocumentFileResponseDtoBuilder publicId(String value) {
      this.publicId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> originalName = JsonNullable.undefined();

    @JsonProperty("originalName")
    public PaymentDocumentFileResponseDtoBuilder originalName(String value) {
      this.originalName = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> size = JsonNullable.undefined();

    @JsonProperty("size")
    public PaymentDocumentFileResponseDtoBuilder size(Long value) {
      this.size = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> extension = JsonNullable.undefined();

    @JsonProperty("extension")
    public PaymentDocumentFileResponseDtoBuilder extension(String value) {
      this.extension = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> previewUrl = JsonNullable.undefined();

    @JsonProperty("previewUrl")
    public PaymentDocumentFileResponseDtoBuilder previewUrl(String value) {
      this.previewUrl = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> downloadUrl = JsonNullable.undefined();

    @JsonProperty("downloadUrl")
    public PaymentDocumentFileResponseDtoBuilder downloadUrl(String value) {
      this.downloadUrl = JsonNullable.of(value);
      return this;
    }
  }
}
