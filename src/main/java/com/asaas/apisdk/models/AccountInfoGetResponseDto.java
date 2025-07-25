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

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class AccountInfoGetResponseDto {

  /**
   * Account status
   */
  @JsonProperty("status")
  private JsonNullable<AccountInfoGetResponseStatus> status;

  /**
   * Person Type
   */
  @JsonProperty("personType")
  private JsonNullable<AccountInfoGetResponsePersonType> personType;

  /**
   * CPF or CNPJ of the account owner
   */
  @JsonProperty("cpfCnpj")
  private JsonNullable<String> cpfCnpj;

  /**
   * Account owner name
   */
  @JsonProperty("name")
  private JsonNullable<String> name;

  /**
   * Birthday (Required if the information is from an individual)
   */
  @JsonProperty("birthDate")
  private JsonNullable<String> birthDate;

  /**
   * Company Name
   */
  @JsonProperty("companyName")
  private JsonNullable<String> companyName;

  /**
   * Type of company (only when Legal Entity)
   */
  @JsonProperty("companyType")
  private JsonNullable<AccountInfoGetResponseCompanyType> companyType;

  /**
   * Billing/Monthly income
   */
  @JsonProperty("incomeValue")
  private JsonNullable<Double> incomeValue;

  /**
   * Account's email
   */
  @JsonProperty("email")
  private JsonNullable<String> email;

  /**
   * Telephone
   */
  @JsonProperty("phone")
  private JsonNullable<String> phone;

  /**
   * Cell phone
   */
  @JsonProperty("mobilePhone")
  private JsonNullable<String> mobilePhone;

  /**
   * Address zip code
   */
  @JsonProperty("postalCode")
  private JsonNullable<String> postalCode;

  /**
   * Public place
   */
  @JsonProperty("address")
  private JsonNullable<String> address;

  /**
   * Address number
   */
  @JsonProperty("addressNumber")
  private JsonNullable<String> addressNumber;

  /**
   * Address complement
   */
  @JsonProperty("complement")
  private JsonNullable<String> complement;

  /**
   * Neighborhood
   */
  @JsonProperty("province")
  private JsonNullable<String> province;

  /**
   * City information registered in your account
   */
  @JsonProperty("city")
  private JsonNullable<AccountInfoCityDto> city;

  /**
   * Reason why it is necessary to resend the information
   */
  @JsonProperty("denialReason")
  private JsonNullable<String> denialReason;

  /**
   * Display name (auto-populated)
   */
  @JsonProperty("tradingName")
  private JsonNullable<String> tradingName;

  /**
   * Web site
   */
  @JsonProperty("site")
  private JsonNullable<String> site;

  /**
   * Company names available. Only filled in for Legal Entity type accounts.
   */
  @JsonProperty("availableCompanyNames")
  private JsonNullable<List<String>> availableCompanyNames;

  /**
   * Information about the expiration of commercial data
   */
  @JsonProperty("commercialInfoExpiration")
  private JsonNullable<AccountInfoCommercialInfoExpirationResponseDto> commercialInfoExpiration;

  @JsonIgnore
  public AccountInfoGetResponseStatus getStatus() {
    return status.orElse(null);
  }

  @JsonIgnore
  public AccountInfoGetResponsePersonType getPersonType() {
    return personType.orElse(null);
  }

  @JsonIgnore
  public String getCpfCnpj() {
    return cpfCnpj.orElse(null);
  }

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonIgnore
  public String getBirthDate() {
    return birthDate.orElse(null);
  }

  @JsonIgnore
  public String getCompanyName() {
    return companyName.orElse(null);
  }

  @JsonIgnore
  public AccountInfoGetResponseCompanyType getCompanyType() {
    return companyType.orElse(null);
  }

  @JsonIgnore
  public Double getIncomeValue() {
    return incomeValue.orElse(null);
  }

  @JsonIgnore
  public String getEmail() {
    return email.orElse(null);
  }

  @JsonIgnore
  public String getPhone() {
    return phone.orElse(null);
  }

  @JsonIgnore
  public String getMobilePhone() {
    return mobilePhone.orElse(null);
  }

  @JsonIgnore
  public String getPostalCode() {
    return postalCode.orElse(null);
  }

  @JsonIgnore
  public String getAddress() {
    return address.orElse(null);
  }

  @JsonIgnore
  public String getAddressNumber() {
    return addressNumber.orElse(null);
  }

  @JsonIgnore
  public String getComplement() {
    return complement.orElse(null);
  }

  @JsonIgnore
  public String getProvince() {
    return province.orElse(null);
  }

  @JsonIgnore
  public AccountInfoCityDto getCity() {
    return city.orElse(null);
  }

  @JsonIgnore
  public String getDenialReason() {
    return denialReason.orElse(null);
  }

  @JsonIgnore
  public String getTradingName() {
    return tradingName.orElse(null);
  }

  @JsonIgnore
  public String getSite() {
    return site.orElse(null);
  }

  @JsonIgnore
  public List<String> getAvailableCompanyNames() {
    return availableCompanyNames.orElse(null);
  }

  @JsonIgnore
  public AccountInfoCommercialInfoExpirationResponseDto getCommercialInfoExpiration() {
    return commercialInfoExpiration.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AccountInfoGetResponseDtoBuilder {

    private JsonNullable<AccountInfoGetResponseStatus> status = JsonNullable.undefined();

    @JsonProperty("status")
    public AccountInfoGetResponseDtoBuilder status(AccountInfoGetResponseStatus value) {
      this.status = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AccountInfoGetResponsePersonType> personType = JsonNullable.undefined();

    @JsonProperty("personType")
    public AccountInfoGetResponseDtoBuilder personType(AccountInfoGetResponsePersonType value) {
      this.personType = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> cpfCnpj = JsonNullable.undefined();

    @JsonProperty("cpfCnpj")
    public AccountInfoGetResponseDtoBuilder cpfCnpj(String value) {
      this.cpfCnpj = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> name = JsonNullable.undefined();

    @JsonProperty("name")
    public AccountInfoGetResponseDtoBuilder name(String value) {
      this.name = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> birthDate = JsonNullable.undefined();

    @JsonProperty("birthDate")
    public AccountInfoGetResponseDtoBuilder birthDate(String value) {
      this.birthDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> companyName = JsonNullable.undefined();

    @JsonProperty("companyName")
    public AccountInfoGetResponseDtoBuilder companyName(String value) {
      this.companyName = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AccountInfoGetResponseCompanyType> companyType = JsonNullable.undefined();

    @JsonProperty("companyType")
    public AccountInfoGetResponseDtoBuilder companyType(AccountInfoGetResponseCompanyType value) {
      this.companyType = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> incomeValue = JsonNullable.undefined();

    @JsonProperty("incomeValue")
    public AccountInfoGetResponseDtoBuilder incomeValue(Double value) {
      this.incomeValue = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> email = JsonNullable.undefined();

    @JsonProperty("email")
    public AccountInfoGetResponseDtoBuilder email(String value) {
      this.email = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> phone = JsonNullable.undefined();

    @JsonProperty("phone")
    public AccountInfoGetResponseDtoBuilder phone(String value) {
      this.phone = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> mobilePhone = JsonNullable.undefined();

    @JsonProperty("mobilePhone")
    public AccountInfoGetResponseDtoBuilder mobilePhone(String value) {
      this.mobilePhone = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> postalCode = JsonNullable.undefined();

    @JsonProperty("postalCode")
    public AccountInfoGetResponseDtoBuilder postalCode(String value) {
      this.postalCode = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> address = JsonNullable.undefined();

    @JsonProperty("address")
    public AccountInfoGetResponseDtoBuilder address(String value) {
      this.address = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> addressNumber = JsonNullable.undefined();

    @JsonProperty("addressNumber")
    public AccountInfoGetResponseDtoBuilder addressNumber(String value) {
      this.addressNumber = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> complement = JsonNullable.undefined();

    @JsonProperty("complement")
    public AccountInfoGetResponseDtoBuilder complement(String value) {
      this.complement = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> province = JsonNullable.undefined();

    @JsonProperty("province")
    public AccountInfoGetResponseDtoBuilder province(String value) {
      this.province = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AccountInfoCityDto> city = JsonNullable.undefined();

    @JsonProperty("city")
    public AccountInfoGetResponseDtoBuilder city(AccountInfoCityDto value) {
      this.city = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> denialReason = JsonNullable.undefined();

    @JsonProperty("denialReason")
    public AccountInfoGetResponseDtoBuilder denialReason(String value) {
      this.denialReason = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> tradingName = JsonNullable.undefined();

    @JsonProperty("tradingName")
    public AccountInfoGetResponseDtoBuilder tradingName(String value) {
      this.tradingName = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> site = JsonNullable.undefined();

    @JsonProperty("site")
    public AccountInfoGetResponseDtoBuilder site(String value) {
      this.site = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<String>> availableCompanyNames = JsonNullable.undefined();

    @JsonProperty("availableCompanyNames")
    public AccountInfoGetResponseDtoBuilder availableCompanyNames(List<String> value) {
      this.availableCompanyNames = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AccountInfoCommercialInfoExpirationResponseDto> commercialInfoExpiration =
      JsonNullable.undefined();

    @JsonProperty("commercialInfoExpiration")
    public AccountInfoGetResponseDtoBuilder commercialInfoExpiration(
      AccountInfoCommercialInfoExpirationResponseDto value
    ) {
      this.commercialInfoExpiration = JsonNullable.of(value);
      return this;
    }
  }
}
