// This file was generated by liblab | https://liblab.com/

package com.asaas.apisdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Chargeback reason
 */
@Getter
@AllArgsConstructor
public enum PaymentChargebackResponseChargebackReason {
  ABSENCE_OF_PRINT("ABSENCE_OF_PRINT"),
  ABSENT_CARD_FRAUD("ABSENT_CARD_FRAUD"),
  CARD_ACTIVATED_PHONE_TRANSACTION("CARD_ACTIVATED_PHONE_TRANSACTION"),
  CARD_FRAUD("CARD_FRAUD"),
  CARD_RECOVERY_BULLETIN("CARD_RECOVERY_BULLETIN"),
  COMMERCIAL_DISAGREEMENT("COMMERCIAL_DISAGREEMENT"),
  COPY_NOT_RECEIVED("COPY_NOT_RECEIVED"),
  CREDIT_OR_DEBIT_PRESENTATION_ERROR("CREDIT_OR_DEBIT_PRESENTATION_ERROR"),
  DIFFERENT_PAY_METHOD("DIFFERENT_PAY_METHOD"),
  FRAUD("FRAUD"),
  INCORRECT_TRANSACTION_VALUE("INCORRECT_TRANSACTION_VALUE"),
  INVALID_CURRENCY("INVALID_CURRENCY"),
  INVALID_DATA("INVALID_DATA"),
  LATE_PRESENTATION("LATE_PRESENTATION"),
  LOCAL_REGULATORY_OR_LEGAL_DISPUTE("LOCAL_REGULATORY_OR_LEGAL_DISPUTE"),
  MULTIPLE_ROCS("MULTIPLE_ROCS"),
  ORIGINAL_CREDIT_TRANSACTION_NOT_ACCEPTED("ORIGINAL_CREDIT_TRANSACTION_NOT_ACCEPTED"),
  OTHER_ABSENT_CARD_FRAUD("OTHER_ABSENT_CARD_FRAUD"),
  PROCESS_ERROR("PROCESS_ERROR"),
  RECEIVED_COPY_ILLEGIBLE_OR_INCOMPLETE("RECEIVED_COPY_ILLEGIBLE_OR_INCOMPLETE"),
  RECURRENCE_CANCELED("RECURRENCE_CANCELED"),
  REQUIRED_AUTHORIZATION_NOT_GRANTED("REQUIRED_AUTHORIZATION_NOT_GRANTED"),
  RIGHT_OF_FULL_RECOURSE_FOR_FRAUD("RIGHT_OF_FULL_RECOURSE_FOR_FRAUD"),
  SALE_CANCELED("SALE_CANCELED"),
  SERVICE_DISAGREEMENT_OR_DEFECTIVE_PRODUCT("SERVICE_DISAGREEMENT_OR_DEFECTIVE_PRODUCT"),
  SERVICE_NOT_RECEIVED("SERVICE_NOT_RECEIVED"),
  SPLIT_SALE("SPLIT_SALE"),
  TRANSFERS_OF_DIVERSE_RESPONSIBILITIES("TRANSFERS_OF_DIVERSE_RESPONSIBILITIES"),
  UNQUALIFIED_CAR_RENTAL_DEBIT("UNQUALIFIED_CAR_RENTAL_DEBIT"),
  USA_CARDHOLDER_DISPUTE("USA_CARDHOLDER_DISPUTE"),
  VISA_FRAUD_MONITORING_PROGRAM("VISA_FRAUD_MONITORING_PROGRAM"),
  WARNING_BULLETIN_FILE("WARNING_BULLETIN_FILE");

  @JsonValue
  private final String value;

  @JsonCreator
  public static PaymentChargebackResponseChargebackReason fromValue(String value) {
    return Arrays.stream(PaymentChargebackResponseChargebackReason.values())
      .filter(item -> item.value.equals(value))
      .findFirst()
      .orElse(null);
  }
}
