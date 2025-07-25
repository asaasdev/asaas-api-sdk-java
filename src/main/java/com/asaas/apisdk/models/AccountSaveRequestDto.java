// This file was generated by liblab | https://liblab.com/

package com.asaas.apisdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
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
public class AccountSaveRequestDto {

  /**
   * Subaccount name
   */
  @NonNull
  private String name;

  /**
   * Subaccount email
   */
  @NonNull
  private String email;

  /**
   * CPF or CNPJ of the subaccount owner
   */
  @NonNull
  private String cpfCnpj;

  /**
   * Cellphone
   */
  @NonNull
  private String mobilePhone;

  /**
   * Billing/Monthly income
   */
  @NonNull
  private Double incomeValue;

  /**
   * Public place
   */
  @NonNull
  private String address;

  /**
   * Address number
   */
  @NonNull
  private String addressNumber;

  /**
   * Neighborhood
   */
  @NonNull
  private String province;

  /**
   * Address zip code
   */
  @NonNull
  private String postalCode;

  /**
   * Email for subaccount login, if not provided, the subaccount email will be used
   */
  @JsonProperty("loginEmail")
  private JsonNullable<String> loginEmail;

  /**
   * Date of birth (only for Individuals)
   */
  @JsonProperty("birthDate")
  private JsonNullable<String> birthDate;

  /**
   * Type of company (only when Legal Entity)
   */
  @JsonProperty("companyType")
  private JsonNullable<AccountSaveRequestCompanyType> companyType;

  /**
   * Telephone
   */
  @JsonProperty("phone")
  private JsonNullable<String> phone;

  /**
   * Url reffered to the subaccount
   */
  @JsonProperty("site")
  private JsonNullable<String> site;

  /**
   * Address complement
   */
  @JsonProperty("complement")
  private JsonNullable<String> complement;

  /**
   * Array with desired Webhooks settings
   */
  @JsonProperty("webhooks")
  private JsonNullable<List<WebhookConfigSaveRequestDto>> webhooks;

  @JsonIgnore
  public String getLoginEmail() {
    return loginEmail.orElse(null);
  }

  @JsonIgnore
  public String getBirthDate() {
    return birthDate.orElse(null);
  }

  @JsonIgnore
  public AccountSaveRequestCompanyType getCompanyType() {
    return companyType.orElse(null);
  }

  @JsonIgnore
  public String getPhone() {
    return phone.orElse(null);
  }

  @JsonIgnore
  public String getSite() {
    return site.orElse(null);
  }

  @JsonIgnore
  public String getComplement() {
    return complement.orElse(null);
  }

  @JsonIgnore
  public List<WebhookConfigSaveRequestDto> getWebhooks() {
    return webhooks.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class AccountSaveRequestDtoBuilder {

    private JsonNullable<String> loginEmail = JsonNullable.undefined();

    @JsonProperty("loginEmail")
    public AccountSaveRequestDtoBuilder loginEmail(String value) {
      this.loginEmail = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> birthDate = JsonNullable.undefined();

    @JsonProperty("birthDate")
    public AccountSaveRequestDtoBuilder birthDate(String value) {
      this.birthDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<AccountSaveRequestCompanyType> companyType = JsonNullable.undefined();

    @JsonProperty("companyType")
    public AccountSaveRequestDtoBuilder companyType(AccountSaveRequestCompanyType value) {
      this.companyType = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> phone = JsonNullable.undefined();

    @JsonProperty("phone")
    public AccountSaveRequestDtoBuilder phone(String value) {
      this.phone = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> site = JsonNullable.undefined();

    @JsonProperty("site")
    public AccountSaveRequestDtoBuilder site(String value) {
      this.site = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> complement = JsonNullable.undefined();

    @JsonProperty("complement")
    public AccountSaveRequestDtoBuilder complement(String value) {
      this.complement = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<WebhookConfigSaveRequestDto>> webhooks = JsonNullable.undefined();

    @JsonProperty("webhooks")
    public AccountSaveRequestDtoBuilder webhooks(List<WebhookConfigSaveRequestDto> value) {
      this.webhooks = JsonNullable.of(value);
      return this;
    }
  }
}
