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
public class AccountGetResponseDto {

  /**
   * Object type
   */
  @JsonProperty("object")
  private JsonNullable<String> object;

  /**
   * Unique subaccount identifier in Asaas
   */
  @JsonProperty("id")
  private JsonNullable<String> id;

  /**
   * Subaccount name
   */
  @JsonProperty("name")
  private JsonNullable<String> name;

  /**
   * Subaccount email
   */
  @JsonProperty("email")
  private JsonNullable<String> email;

  /**
   * Email for subaccount login, if not provided, the subaccount email will be used
   */
  @JsonProperty("loginEmail")
  private JsonNullable<String> loginEmail;

  /**
   * Telephone
   */
  @JsonProperty("phone")
  private JsonNullable<String> phone;

  /**
   * Cellphone
   */
  @JsonProperty("mobilePhone")
  private JsonNullable<String> mobilePhone;

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
   * Address zip code
   */
  @JsonProperty("postalCode")
  private JsonNullable<String> postalCode;

  /**
   * CPF or CNPJ of the subaccount owner
   */
  @JsonProperty("cpfCnpj")
  private JsonNullable<String> cpfCnpj;

  /**
   * Date of birth (only for Individuals)
   */
  @JsonProperty("birthDate")
  private JsonNullable<String> birthDate;

  /**
   * Kind of person
   */
  @JsonProperty("personType")
  private JsonNullable<AccountGetResponsePersonType> personType;

  /**
   * Type of company (only when Legal Entity)
   */
  @JsonProperty("companyType")
  private JsonNullable<AccountGetResponseCompanyType> companyType;

  /**
   * Unique city identifier in Asaas
   */
  @JsonProperty("city")
  private JsonNullable<Long> city;

  /**
   * State abbreviation (SP, RJ, SC, ...)
   */
  @JsonProperty("state")
  private JsonNullable<String> state;

  /**
   * Country (Fixed Brazil)
   */
  @JsonProperty("country")
  private JsonNullable<String> country;

  /**
   * Display name (auto-populated)
   */
  @JsonProperty("tradingName")
  private JsonNullable<String> tradingName;

  /**
   * Url reffered to the subaccount
   */
  @JsonProperty("site")
  private JsonNullable<String> site;

  /**
   * Unique wallet identifier to split charges or transfer between Asaas accounts
   */
  @JsonProperty("walletId")
  private JsonNullable<String> walletId;

  /**
   * Subaccount number in Asaas
   */
  @JsonProperty("accountNumber")
  private JsonNullable<AccountNumberDto> accountNumber;

  /**
   * Information about the expiration of commercial data
   */
  @JsonProperty("commercialInfoExpiration")
  private JsonNullable<AccountInfoCommercialInfoExpirationResponseDto> commercialInfoExpiration;

  @JsonIgnore
  public String getObject() {
    return object.orElse(null);
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonIgnore
  public String getEmail() {
    return email.orElse(null);
  }

  @JsonIgnore
  public String getLoginEmail() {
    return loginEmail.orElse(null);
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
  public String getPostalCode() {
    return postalCode.orElse(null);
  }

  @JsonIgnore
  public String getCpfCnpj() {
    return cpfCnpj.orElse(null);
  }

  @JsonIgnore
  public String getBirthDate() {
    return birthDate.orElse(null);
  }

  @JsonIgnore
  public AccountGetResponsePersonType getPersonType() {
    return personType.orElse(null);
  }

  @JsonIgnore
  public AccountGetResponseCompanyType getCompanyType() {
    return companyType.orElse(null);
  }

  @JsonIgnore
  public Long getCity() {
    return city.orElse(null);
  }

  @JsonIgnore
  public String getState() {
    return state.orElse(null);
  }

  @JsonIgnore
  public String getCountry() {
    return country.orElse(null);
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
  public String getWalletId() {
    return walletId.orElse(null);
  }

  @JsonIgnore
  public AccountNumberDto getAccountNumber() {
    return accountNumber.orElse(null);
  }

  @JsonIgnore
  public AccountInfoCommercialInfoExpirationResponseDto getCommercialInfoExpiration() {
    return commercialInfoExpiration.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AccountGetResponseDtoBuilder {

    private JsonNullable<String> object = JsonNullable.undefined();

    @JsonProperty("object")
    public AccountGetResponseDtoBuilder object(String value) {
      this.object = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> id = JsonNullable.undefined();

    @JsonProperty("id")
    public AccountGetResponseDtoBuilder id(String value) {
      this.id = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> name = JsonNullable.undefined();

    @JsonProperty("name")
    public AccountGetResponseDtoBuilder name(String value) {
      this.name = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> email = JsonNullable.undefined();

    @JsonProperty("email")
    public AccountGetResponseDtoBuilder email(String value) {
      this.email = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> loginEmail = JsonNullable.undefined();

    @JsonProperty("loginEmail")
    public AccountGetResponseDtoBuilder loginEmail(String value) {
      this.loginEmail = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> phone = JsonNullable.undefined();

    @JsonProperty("phone")
    public AccountGetResponseDtoBuilder phone(String value) {
      this.phone = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> mobilePhone = JsonNullable.undefined();

    @JsonProperty("mobilePhone")
    public AccountGetResponseDtoBuilder mobilePhone(String value) {
      this.mobilePhone = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> address = JsonNullable.undefined();

    @JsonProperty("address")
    public AccountGetResponseDtoBuilder address(String value) {
      this.address = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> addressNumber = JsonNullable.undefined();

    @JsonProperty("addressNumber")
    public AccountGetResponseDtoBuilder addressNumber(String value) {
      this.addressNumber = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> complement = JsonNullable.undefined();

    @JsonProperty("complement")
    public AccountGetResponseDtoBuilder complement(String value) {
      this.complement = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> province = JsonNullable.undefined();

    @JsonProperty("province")
    public AccountGetResponseDtoBuilder province(String value) {
      this.province = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> postalCode = JsonNullable.undefined();

    @JsonProperty("postalCode")
    public AccountGetResponseDtoBuilder postalCode(String value) {
      this.postalCode = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> cpfCnpj = JsonNullable.undefined();

    @JsonProperty("cpfCnpj")
    public AccountGetResponseDtoBuilder cpfCnpj(String value) {
      this.cpfCnpj = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> birthDate = JsonNullable.undefined();

    @JsonProperty("birthDate")
    public AccountGetResponseDtoBuilder birthDate(String value) {
      this.birthDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AccountGetResponsePersonType> personType = JsonNullable.undefined();

    @JsonProperty("personType")
    public AccountGetResponseDtoBuilder personType(AccountGetResponsePersonType value) {
      this.personType = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AccountGetResponseCompanyType> companyType = JsonNullable.undefined();

    @JsonProperty("companyType")
    public AccountGetResponseDtoBuilder companyType(AccountGetResponseCompanyType value) {
      this.companyType = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> city = JsonNullable.undefined();

    @JsonProperty("city")
    public AccountGetResponseDtoBuilder city(Long value) {
      this.city = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> state = JsonNullable.undefined();

    @JsonProperty("state")
    public AccountGetResponseDtoBuilder state(String value) {
      this.state = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> country = JsonNullable.undefined();

    @JsonProperty("country")
    public AccountGetResponseDtoBuilder country(String value) {
      this.country = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> tradingName = JsonNullable.undefined();

    @JsonProperty("tradingName")
    public AccountGetResponseDtoBuilder tradingName(String value) {
      this.tradingName = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> site = JsonNullable.undefined();

    @JsonProperty("site")
    public AccountGetResponseDtoBuilder site(String value) {
      this.site = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> walletId = JsonNullable.undefined();

    @JsonProperty("walletId")
    public AccountGetResponseDtoBuilder walletId(String value) {
      this.walletId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AccountNumberDto> accountNumber = JsonNullable.undefined();

    @JsonProperty("accountNumber")
    public AccountGetResponseDtoBuilder accountNumber(AccountNumberDto value) {
      this.accountNumber = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AccountInfoCommercialInfoExpirationResponseDto> commercialInfoExpiration =
      JsonNullable.undefined();

    @JsonProperty("commercialInfoExpiration")
    public AccountGetResponseDtoBuilder commercialInfoExpiration(AccountInfoCommercialInfoExpirationResponseDto value) {
      this.commercialInfoExpiration = JsonNullable.of(value);
      return this;
    }
  }
}
