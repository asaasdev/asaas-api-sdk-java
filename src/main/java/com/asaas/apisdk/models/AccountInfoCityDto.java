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
 * City information registered in your account
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class AccountInfoCityDto {

  /**
   * Object type
   */
  @JsonProperty("object")
  private JsonNullable<String> object;

  /**
   * Unique city identifier in Asaas
   */
  @JsonProperty("id")
  private JsonNullable<Long> id;

  /**
   * IBGE Code
   */
  @JsonProperty("ibgeCode")
  private JsonNullable<String> ibgeCode;

  /**
   * City's name
   */
  @JsonProperty("name")
  private JsonNullable<String> name;

  /**
   * District code
   */
  @JsonProperty("districtCode")
  private JsonNullable<String> districtCode;

  /**
   * District name
   */
  @JsonProperty("district")
  private JsonNullable<String> district;

  /**
   * State abbreviation (SP, RJ, SC, ...)
   */
  @JsonProperty("state")
  private JsonNullable<AccountInfoCityState> state;

  @JsonIgnore
  public String getObject() {
    return object.orElse(null);
  }

  @JsonIgnore
  public Long getId() {
    return id.orElse(null);
  }

  @JsonIgnore
  public String getIbgeCode() {
    return ibgeCode.orElse(null);
  }

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonIgnore
  public String getDistrictCode() {
    return districtCode.orElse(null);
  }

  @JsonIgnore
  public String getDistrict() {
    return district.orElse(null);
  }

  @JsonIgnore
  public AccountInfoCityState getState() {
    return state.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AccountInfoCityDtoBuilder {

    private JsonNullable<String> object = JsonNullable.undefined();

    @JsonProperty("object")
    public AccountInfoCityDtoBuilder object(String value) {
      this.object = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> id = JsonNullable.undefined();

    @JsonProperty("id")
    public AccountInfoCityDtoBuilder id(Long value) {
      this.id = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> ibgeCode = JsonNullable.undefined();

    @JsonProperty("ibgeCode")
    public AccountInfoCityDtoBuilder ibgeCode(String value) {
      this.ibgeCode = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> name = JsonNullable.undefined();

    @JsonProperty("name")
    public AccountInfoCityDtoBuilder name(String value) {
      this.name = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> districtCode = JsonNullable.undefined();

    @JsonProperty("districtCode")
    public AccountInfoCityDtoBuilder districtCode(String value) {
      this.districtCode = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> district = JsonNullable.undefined();

    @JsonProperty("district")
    public AccountInfoCityDtoBuilder district(String value) {
      this.district = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AccountInfoCityState> state = JsonNullable.undefined();

    @JsonProperty("state")
    public AccountInfoCityDtoBuilder state(AccountInfoCityState value) {
      this.state = JsonNullable.of(value);
      return this;
    }
  }
}
