// This file was generated by liblab | https://liblab.com/

package com.asaas.apisdk.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class CreditCardTokenizeRequestDto {

  /**
   * Unique customer identifier in Asaas
   */
  @NonNull
  private String customer;

  /**
   * Credit card information
   */
  @NonNull
  private CreditCardRequestDto creditCard;

  /**
   * Credit card holder information
   */
  @NonNull
  private CreditCardHolderInfoRequestDto creditCardHolderInfo;

  /**
   * IP from where the customer is making the purchase. Your server's IP must not be entered.
   */
  @NonNull
  private String remoteIp;
}
