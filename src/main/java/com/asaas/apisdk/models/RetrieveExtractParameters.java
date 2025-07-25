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
public class RetrieveExtractParameters {

  /**
   * List starting element
   */
  @JsonProperty("offset")
  private JsonNullable<Long> offset;

  /**
   * Number of list elements (max: 100)
   */
  @JsonProperty("limit")
  private JsonNullable<Long> limit;

  /**
   * List start date
   */
  @JsonProperty("startDate")
  private JsonNullable<String> startDate;

  /**
   * List end date
   */
  @JsonProperty("finishDate")
  private JsonNullable<String> finishDate;

  /**
   * Result ordering
   */
  @JsonProperty("order")
  private JsonNullable<String> order;

  @JsonIgnore
  public Long getOffset() {
    return offset.orElse(null);
  }

  @JsonIgnore
  public Long getLimit() {
    return limit.orElse(null);
  }

  @JsonIgnore
  public String getStartDate() {
    return startDate.orElse(null);
  }

  @JsonIgnore
  public String getFinishDate() {
    return finishDate.orElse(null);
  }

  @JsonIgnore
  public String getOrder() {
    return order.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class RetrieveExtractParametersBuilder {

    private JsonNullable<Long> offset = JsonNullable.undefined();

    @JsonProperty("offset")
    public RetrieveExtractParametersBuilder offset(Long value) {
      if (value == null) {
        throw new IllegalStateException("offset cannot be null");
      }
      this.offset = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> limit = JsonNullable.undefined();

    @JsonProperty("limit")
    public RetrieveExtractParametersBuilder limit(Long value) {
      if (value == null) {
        throw new IllegalStateException("limit cannot be null");
      }
      this.limit = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> startDate = JsonNullable.undefined();

    @JsonProperty("startDate")
    public RetrieveExtractParametersBuilder startDate(String value) {
      if (value == null) {
        throw new IllegalStateException("startDate cannot be null");
      }
      this.startDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> finishDate = JsonNullable.undefined();

    @JsonProperty("finishDate")
    public RetrieveExtractParametersBuilder finishDate(String value) {
      if (value == null) {
        throw new IllegalStateException("finishDate cannot be null");
      }
      this.finishDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> order = JsonNullable.undefined();

    @JsonProperty("order")
    public RetrieveExtractParametersBuilder order(String value) {
      if (value == null) {
        throw new IllegalStateException("order cannot be null");
      }
      this.order = JsonNullable.of(value);
      return this;
    }
  }
}
