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

/**
 * Enter your account details if it is a transfer to a bank account
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class TransferBankAccountSaveRequestDto {

  /**
   * Name of bank account owner
   */
  @NonNull
  private String ownerName;

  /**
   * CPF or CNPJ of the bank account owner
   */
  @NonNull
  private String cpfCnpj;

  /**
   * Non-digit agency number
   */
  @NonNull
  private String agency;

  /**
   * Non-digit bank account number
   */
  @NonNull
  private String account;

  /**
   * Bank account digit
   */
  @NonNull
  private String accountDigit;

  /**
   * Details of the bank account to which the transfer will be made
   */
  @JsonProperty("bank")
  private JsonNullable<TransferBankSaveRequestDto> bank;

  /**
   * Bank account name
   */
  @JsonProperty("accountName")
  private JsonNullable<String> accountName;

  /**
   * Account owner's date of birth. Only when the bank account does not belong to the same CPF or CNPJ as the Asaas account.
   */
  @JsonProperty("ownerBirthDate")
  private JsonNullable<String> ownerBirthDate;

  /**
   * Account type
   */
  @JsonProperty("bankAccountType")
  private JsonNullable<TransferBankAccountSaveRequestBankAccountType> bankAccountType;

  /**
   * Identifier in the Brazilian Payment System
   */
  @JsonProperty("ispb")
  private JsonNullable<String> ispb;

  @JsonIgnore
  public TransferBankSaveRequestDto getBank() {
    return bank.orElse(null);
  }

  @JsonIgnore
  public String getAccountName() {
    return accountName.orElse(null);
  }

  @JsonIgnore
  public String getOwnerBirthDate() {
    return ownerBirthDate.orElse(null);
  }

  @JsonIgnore
  public TransferBankAccountSaveRequestBankAccountType getBankAccountType() {
    return bankAccountType.orElse(null);
  }

  @JsonIgnore
  public String getIspb() {
    return ispb.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class TransferBankAccountSaveRequestDtoBuilder {

    private JsonNullable<TransferBankSaveRequestDto> bank = JsonNullable.undefined();

    @JsonProperty("bank")
    public TransferBankAccountSaveRequestDtoBuilder bank(TransferBankSaveRequestDto value) {
      this.bank = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> accountName = JsonNullable.undefined();

    @JsonProperty("accountName")
    public TransferBankAccountSaveRequestDtoBuilder accountName(String value) {
      this.accountName = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> ownerBirthDate = JsonNullable.undefined();

    @JsonProperty("ownerBirthDate")
    public TransferBankAccountSaveRequestDtoBuilder ownerBirthDate(String value) {
      this.ownerBirthDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<TransferBankAccountSaveRequestBankAccountType> bankAccountType = JsonNullable.undefined();

    @JsonProperty("bankAccountType")
    public TransferBankAccountSaveRequestDtoBuilder bankAccountType(
      TransferBankAccountSaveRequestBankAccountType value
    ) {
      this.bankAccountType = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> ispb = JsonNullable.undefined();

    @JsonProperty("ispb")
    public TransferBankAccountSaveRequestDtoBuilder ispb(String value) {
      this.ispb = JsonNullable.of(value);
      return this;
    }
  }
}
