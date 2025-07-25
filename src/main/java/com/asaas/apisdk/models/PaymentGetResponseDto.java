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
public class PaymentGetResponseDto {

  /**
   * Object type
   */
  @JsonProperty("object")
  private JsonNullable<String> object;

  /**
   * Unique payment identifier in Asaas
   */
  @JsonProperty("id")
  private JsonNullable<String> id;

  /**
   * Payment creation date
   */
  @JsonProperty("dateCreated")
  private JsonNullable<String> dateCreated;

  /**
   * Unique identifier of the customer to whom the payment belongs
   */
  @JsonProperty("customer")
  private JsonNullable<String> customer;

  /**
   * Unique subscription identifier (when recurring billing)
   */
  @JsonProperty("subscription")
  private JsonNullable<String> subscription;

  /**
   * Unique installment identifier (when billing in installments)
   */
  @JsonProperty("installment")
  private JsonNullable<String> installment;

  /**
   * Unique checkout identifier
   */
  @JsonProperty("checkoutSession")
  private JsonNullable<String> checkoutSession;

  /**
   * Unique identifier of the payments link to which the payment belongs
   */
  @JsonProperty("paymentLink")
  private JsonNullable<String> paymentLink;

  /**
   * Payment amount
   */
  @JsonProperty("value")
  private JsonNullable<Double> value;

  /**
   * Net value of the charge after discounting the Asaas fee
   */
  @JsonProperty("netValue")
  private JsonNullable<Double> netValue;

  /**
   * Original amount of charge (filled when paid with interest and fine)
   */
  @JsonProperty("originalValue")
  private JsonNullable<Double> originalValue;

  /**
   * Calculated amount of interest and fine that must be paid after the charge is due
   */
  @JsonProperty("interestValue")
  private JsonNullable<Double> interestValue;

  /**
   * Description of the payment
   */
  @JsonProperty("description")
  private JsonNullable<String> description;

  /**
   * Payment billing type
   */
  @JsonProperty("billingType")
  private JsonNullable<PaymentGetResponseBillingType> billingType;

  /**
   * Credit card information
   */
  @JsonProperty("creditCard")
  private JsonNullable<PaymentSaveWithCreditCardCreditCardDto> creditCard;

  /**
   * Informs whether the charge can be paid after the due date (Only for bank slip)
   */
  @JsonProperty("canBePaidAfterDueDate")
  private JsonNullable<Boolean> canBePaidAfterDueDate;

  /**
   * Unique identifier of the Pix transaction to which the payment belongs
   */
  @JsonProperty("pixTransaction")
  private JsonNullable<String> pixTransaction;

  /**
   * Unique identifier of the static QrCode generated for a given Pix key
   */
  @JsonProperty("pixQrCodeId")
  private JsonNullable<String> pixQrCodeId;

  /**
   * Payment status
   */
  @JsonProperty("status")
  private JsonNullable<PaymentGetResponsePaymentStatus> status;

  /**
   * Payment due date
   */
  @JsonProperty("dueDate")
  private JsonNullable<String> dueDate;

  /**
   * Original due date upon creation of the payment
   */
  @JsonProperty("originalDueDate")
  private JsonNullable<String> originalDueDate;

  /**
   * Payment date on Asaas
   */
  @JsonProperty("paymentDate")
  private JsonNullable<String> paymentDate;

  /**
   * Date on which the customer paid the bank slip
   */
  @JsonProperty("clientPaymentDate")
  private JsonNullable<String> clientPaymentDate;

  /**
   * Parcel number
   */
  @JsonProperty("installmentNumber")
  private JsonNullable<Long> installmentNumber;

  /**
   * Invoice URL
   */
  @JsonProperty("invoiceUrl")
  private JsonNullable<String> invoiceUrl;

  /**
   * Bill number
   */
  @JsonProperty("invoiceNumber")
  private JsonNullable<String> invoiceNumber;

  /**
   * Free search field
   */
  @JsonProperty("externalReference")
  private JsonNullable<String> externalReference;

  /**
   * Determines if the payment has been removed
   */
  @JsonProperty("deleted")
  private JsonNullable<Boolean> deleted;

  /**
   * Defines whether the charge was anticipated or is in the process of being anticipated
   */
  @JsonProperty("anticipated")
  private JsonNullable<Boolean> anticipated;

  /**
   * Determines whether the charge is anticipated
   */
  @JsonProperty("anticipable")
  private JsonNullable<Boolean> anticipable;

  /**
   * Date when the credit became available
   */
  @JsonProperty("creditDate")
  private JsonNullable<String> creditDate;

  /**
   * Estimated date when the credit will be available
   */
  @JsonProperty("estimatedCreditDate")
  private JsonNullable<String> estimatedCreditDate;

  /**
   * URL of proof of confirmation, receipt, reversal or removal
   */
  @JsonProperty("transactionReceiptUrl")
  private JsonNullable<String> transactionReceiptUrl;

  /**
   * Unique identification of the bank slip
   */
  @JsonProperty("nossoNumero")
  private JsonNullable<String> nossoNumero;

  /**
   * URL to download the bank slip
   */
  @JsonProperty("bankSlipUrl")
  private JsonNullable<String> bankSlipUrl;

  /**
   * Discount information
   */
  @JsonProperty("discount")
  private JsonNullable<PaymentDiscountDto> discount;

  /**
   * Fine information for payment after due date
   */
  @JsonProperty("fine")
  private JsonNullable<PaymentFineResponseDto> fine;

  /**
   * Interest information for payment after due date
   */
  @JsonProperty("interest")
  private JsonNullable<PaymentInterestResponseDto> interest;

  /**
   * Split Settings
   */
  @JsonProperty("split")
  private JsonNullable<List<PaymentSplitGetResponseDto>> split;

  /**
   * Define whether the payment will be sent via post
   */
  @JsonProperty("postalService")
  private JsonNullable<Boolean> postalService;

  /**
   * Days after registration cancellation deadline (only for bank slip)
   */
  @JsonProperty("daysAfterDueDateToRegistrationCancellation")
  private JsonNullable<Long> daysAfterDueDateToRegistrationCancellation;

  @JsonProperty("chargeback")
  private JsonNullable<PaymentChargebackResponseDto> chargeback;

  /**
   * Payment escrow in the Escrow Account information
   */
  @JsonProperty("escrow")
  private JsonNullable<PaymentEscrowGetResponseDto> escrow;

  /**
   * Refunds information
   */
  @JsonProperty("refunds")
  private JsonNullable<List<PaymentRefundGetResponseDto>> refunds;

  @JsonIgnore
  public String getObject() {
    return object.orElse(null);
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonIgnore
  public String getDateCreated() {
    return dateCreated.orElse(null);
  }

  @JsonIgnore
  public String getCustomer() {
    return customer.orElse(null);
  }

  @JsonIgnore
  public String getSubscription() {
    return subscription.orElse(null);
  }

  @JsonIgnore
  public String getInstallment() {
    return installment.orElse(null);
  }

  @JsonIgnore
  public String getCheckoutSession() {
    return checkoutSession.orElse(null);
  }

  @JsonIgnore
  public String getPaymentLink() {
    return paymentLink.orElse(null);
  }

  @JsonIgnore
  public Double getValue() {
    return value.orElse(null);
  }

  @JsonIgnore
  public Double getNetValue() {
    return netValue.orElse(null);
  }

  @JsonIgnore
  public Double getOriginalValue() {
    return originalValue.orElse(null);
  }

  @JsonIgnore
  public Double getInterestValue() {
    return interestValue.orElse(null);
  }

  @JsonIgnore
  public String getDescription() {
    return description.orElse(null);
  }

  @JsonIgnore
  public PaymentGetResponseBillingType getBillingType() {
    return billingType.orElse(null);
  }

  @JsonIgnore
  public PaymentSaveWithCreditCardCreditCardDto getCreditCard() {
    return creditCard.orElse(null);
  }

  @JsonIgnore
  public Boolean getCanBePaidAfterDueDate() {
    return canBePaidAfterDueDate.orElse(null);
  }

  @JsonIgnore
  public String getPixTransaction() {
    return pixTransaction.orElse(null);
  }

  @JsonIgnore
  public String getPixQrCodeId() {
    return pixQrCodeId.orElse(null);
  }

  @JsonIgnore
  public PaymentGetResponsePaymentStatus getStatus() {
    return status.orElse(null);
  }

  @JsonIgnore
  public String getDueDate() {
    return dueDate.orElse(null);
  }

  @JsonIgnore
  public String getOriginalDueDate() {
    return originalDueDate.orElse(null);
  }

  @JsonIgnore
  public String getPaymentDate() {
    return paymentDate.orElse(null);
  }

  @JsonIgnore
  public String getClientPaymentDate() {
    return clientPaymentDate.orElse(null);
  }

  @JsonIgnore
  public Long getInstallmentNumber() {
    return installmentNumber.orElse(null);
  }

  @JsonIgnore
  public String getInvoiceUrl() {
    return invoiceUrl.orElse(null);
  }

  @JsonIgnore
  public String getInvoiceNumber() {
    return invoiceNumber.orElse(null);
  }

  @JsonIgnore
  public String getExternalReference() {
    return externalReference.orElse(null);
  }

  @JsonIgnore
  public Boolean getDeleted() {
    return deleted.orElse(null);
  }

  @JsonIgnore
  public Boolean getAnticipated() {
    return anticipated.orElse(null);
  }

  @JsonIgnore
  public Boolean getAnticipable() {
    return anticipable.orElse(null);
  }

  @JsonIgnore
  public String getCreditDate() {
    return creditDate.orElse(null);
  }

  @JsonIgnore
  public String getEstimatedCreditDate() {
    return estimatedCreditDate.orElse(null);
  }

  @JsonIgnore
  public String getTransactionReceiptUrl() {
    return transactionReceiptUrl.orElse(null);
  }

  @JsonIgnore
  public String getNossoNumero() {
    return nossoNumero.orElse(null);
  }

  @JsonIgnore
  public String getBankSlipUrl() {
    return bankSlipUrl.orElse(null);
  }

  @JsonIgnore
  public PaymentDiscountDto getDiscount() {
    return discount.orElse(null);
  }

  @JsonIgnore
  public PaymentFineResponseDto getFine() {
    return fine.orElse(null);
  }

  @JsonIgnore
  public PaymentInterestResponseDto getInterest() {
    return interest.orElse(null);
  }

  @JsonIgnore
  public List<PaymentSplitGetResponseDto> getSplit() {
    return split.orElse(null);
  }

  @JsonIgnore
  public Boolean getPostalService() {
    return postalService.orElse(null);
  }

  @JsonIgnore
  public Long getDaysAfterDueDateToRegistrationCancellation() {
    return daysAfterDueDateToRegistrationCancellation.orElse(null);
  }

  @JsonIgnore
  public PaymentChargebackResponseDto getChargeback() {
    return chargeback.orElse(null);
  }

  @JsonIgnore
  public PaymentEscrowGetResponseDto getEscrow() {
    return escrow.orElse(null);
  }

  @JsonIgnore
  public List<PaymentRefundGetResponseDto> getRefunds() {
    return refunds.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class PaymentGetResponseDtoBuilder {

    private JsonNullable<String> object = JsonNullable.undefined();

    @JsonProperty("object")
    public PaymentGetResponseDtoBuilder object(String value) {
      this.object = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> id = JsonNullable.undefined();

    @JsonProperty("id")
    public PaymentGetResponseDtoBuilder id(String value) {
      this.id = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> dateCreated = JsonNullable.undefined();

    @JsonProperty("dateCreated")
    public PaymentGetResponseDtoBuilder dateCreated(String value) {
      this.dateCreated = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> customer = JsonNullable.undefined();

    @JsonProperty("customer")
    public PaymentGetResponseDtoBuilder customer(String value) {
      this.customer = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> subscription = JsonNullable.undefined();

    @JsonProperty("subscription")
    public PaymentGetResponseDtoBuilder subscription(String value) {
      this.subscription = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> installment = JsonNullable.undefined();

    @JsonProperty("installment")
    public PaymentGetResponseDtoBuilder installment(String value) {
      this.installment = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> checkoutSession = JsonNullable.undefined();

    @JsonProperty("checkoutSession")
    public PaymentGetResponseDtoBuilder checkoutSession(String value) {
      this.checkoutSession = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> paymentLink = JsonNullable.undefined();

    @JsonProperty("paymentLink")
    public PaymentGetResponseDtoBuilder paymentLink(String value) {
      this.paymentLink = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> value = JsonNullable.undefined();

    @JsonProperty("value")
    public PaymentGetResponseDtoBuilder value(Double value) {
      this.value = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> netValue = JsonNullable.undefined();

    @JsonProperty("netValue")
    public PaymentGetResponseDtoBuilder netValue(Double value) {
      this.netValue = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> originalValue = JsonNullable.undefined();

    @JsonProperty("originalValue")
    public PaymentGetResponseDtoBuilder originalValue(Double value) {
      this.originalValue = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> interestValue = JsonNullable.undefined();

    @JsonProperty("interestValue")
    public PaymentGetResponseDtoBuilder interestValue(Double value) {
      this.interestValue = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> description = JsonNullable.undefined();

    @JsonProperty("description")
    public PaymentGetResponseDtoBuilder description(String value) {
      this.description = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<PaymentGetResponseBillingType> billingType = JsonNullable.undefined();

    @JsonProperty("billingType")
    public PaymentGetResponseDtoBuilder billingType(PaymentGetResponseBillingType value) {
      this.billingType = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<PaymentSaveWithCreditCardCreditCardDto> creditCard = JsonNullable.undefined();

    @JsonProperty("creditCard")
    public PaymentGetResponseDtoBuilder creditCard(PaymentSaveWithCreditCardCreditCardDto value) {
      this.creditCard = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> canBePaidAfterDueDate = JsonNullable.undefined();

    @JsonProperty("canBePaidAfterDueDate")
    public PaymentGetResponseDtoBuilder canBePaidAfterDueDate(Boolean value) {
      this.canBePaidAfterDueDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> pixTransaction = JsonNullable.undefined();

    @JsonProperty("pixTransaction")
    public PaymentGetResponseDtoBuilder pixTransaction(String value) {
      this.pixTransaction = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> pixQrCodeId = JsonNullable.undefined();

    @JsonProperty("pixQrCodeId")
    public PaymentGetResponseDtoBuilder pixQrCodeId(String value) {
      this.pixQrCodeId = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<PaymentGetResponsePaymentStatus> status = JsonNullable.undefined();

    @JsonProperty("status")
    public PaymentGetResponseDtoBuilder status(PaymentGetResponsePaymentStatus value) {
      this.status = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> dueDate = JsonNullable.undefined();

    @JsonProperty("dueDate")
    public PaymentGetResponseDtoBuilder dueDate(String value) {
      this.dueDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> originalDueDate = JsonNullable.undefined();

    @JsonProperty("originalDueDate")
    public PaymentGetResponseDtoBuilder originalDueDate(String value) {
      this.originalDueDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> paymentDate = JsonNullable.undefined();

    @JsonProperty("paymentDate")
    public PaymentGetResponseDtoBuilder paymentDate(String value) {
      this.paymentDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> clientPaymentDate = JsonNullable.undefined();

    @JsonProperty("clientPaymentDate")
    public PaymentGetResponseDtoBuilder clientPaymentDate(String value) {
      this.clientPaymentDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> installmentNumber = JsonNullable.undefined();

    @JsonProperty("installmentNumber")
    public PaymentGetResponseDtoBuilder installmentNumber(Long value) {
      this.installmentNumber = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> invoiceUrl = JsonNullable.undefined();

    @JsonProperty("invoiceUrl")
    public PaymentGetResponseDtoBuilder invoiceUrl(String value) {
      this.invoiceUrl = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> invoiceNumber = JsonNullable.undefined();

    @JsonProperty("invoiceNumber")
    public PaymentGetResponseDtoBuilder invoiceNumber(String value) {
      this.invoiceNumber = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> externalReference = JsonNullable.undefined();

    @JsonProperty("externalReference")
    public PaymentGetResponseDtoBuilder externalReference(String value) {
      this.externalReference = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> deleted = JsonNullable.undefined();

    @JsonProperty("deleted")
    public PaymentGetResponseDtoBuilder deleted(Boolean value) {
      this.deleted = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> anticipated = JsonNullable.undefined();

    @JsonProperty("anticipated")
    public PaymentGetResponseDtoBuilder anticipated(Boolean value) {
      this.anticipated = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> anticipable = JsonNullable.undefined();

    @JsonProperty("anticipable")
    public PaymentGetResponseDtoBuilder anticipable(Boolean value) {
      this.anticipable = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> creditDate = JsonNullable.undefined();

    @JsonProperty("creditDate")
    public PaymentGetResponseDtoBuilder creditDate(String value) {
      this.creditDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> estimatedCreditDate = JsonNullable.undefined();

    @JsonProperty("estimatedCreditDate")
    public PaymentGetResponseDtoBuilder estimatedCreditDate(String value) {
      this.estimatedCreditDate = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> transactionReceiptUrl = JsonNullable.undefined();

    @JsonProperty("transactionReceiptUrl")
    public PaymentGetResponseDtoBuilder transactionReceiptUrl(String value) {
      this.transactionReceiptUrl = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> nossoNumero = JsonNullable.undefined();

    @JsonProperty("nossoNumero")
    public PaymentGetResponseDtoBuilder nossoNumero(String value) {
      this.nossoNumero = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> bankSlipUrl = JsonNullable.undefined();

    @JsonProperty("bankSlipUrl")
    public PaymentGetResponseDtoBuilder bankSlipUrl(String value) {
      this.bankSlipUrl = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<PaymentDiscountDto> discount = JsonNullable.undefined();

    @JsonProperty("discount")
    public PaymentGetResponseDtoBuilder discount(PaymentDiscountDto value) {
      this.discount = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<PaymentFineResponseDto> fine = JsonNullable.undefined();

    @JsonProperty("fine")
    public PaymentGetResponseDtoBuilder fine(PaymentFineResponseDto value) {
      this.fine = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<PaymentInterestResponseDto> interest = JsonNullable.undefined();

    @JsonProperty("interest")
    public PaymentGetResponseDtoBuilder interest(PaymentInterestResponseDto value) {
      this.interest = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<PaymentSplitGetResponseDto>> split = JsonNullable.undefined();

    @JsonProperty("split")
    public PaymentGetResponseDtoBuilder split(List<PaymentSplitGetResponseDto> value) {
      this.split = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Boolean> postalService = JsonNullable.undefined();

    @JsonProperty("postalService")
    public PaymentGetResponseDtoBuilder postalService(Boolean value) {
      this.postalService = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Long> daysAfterDueDateToRegistrationCancellation = JsonNullable.undefined();

    @JsonProperty("daysAfterDueDateToRegistrationCancellation")
    public PaymentGetResponseDtoBuilder daysAfterDueDateToRegistrationCancellation(Long value) {
      this.daysAfterDueDateToRegistrationCancellation = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<PaymentChargebackResponseDto> chargeback = JsonNullable.undefined();

    @JsonProperty("chargeback")
    public PaymentGetResponseDtoBuilder chargeback(PaymentChargebackResponseDto value) {
      this.chargeback = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<PaymentEscrowGetResponseDto> escrow = JsonNullable.undefined();

    @JsonProperty("escrow")
    public PaymentGetResponseDtoBuilder escrow(PaymentEscrowGetResponseDto value) {
      this.escrow = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<List<PaymentRefundGetResponseDto>> refunds = JsonNullable.undefined();

    @JsonProperty("refunds")
    public PaymentGetResponseDtoBuilder refunds(List<PaymentRefundGetResponseDto> value) {
      this.refunds = JsonNullable.of(value);
      return this;
    }
  }
}
