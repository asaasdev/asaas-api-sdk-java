# ApiPaymentGetResponseDto

**Properties**

| Name                                       | Type                                      | Required | Description                                                                          |
| :----------------------------------------- | :---------------------------------------- | :------- | :----------------------------------------------------------------------------------- |
| object                                     | String                                    | ❌       | Object type                                                                          |
| id                                         | String                                    | ❌       | Unique payment identifier in Asaas                                                   |
| dateCreated                                | String                                    | ❌       | Payment creation date                                                                |
| customer                                   | String                                    | ❌       | Unique identifier of the customer to whom the payment belongs                        |
| subscription                               | String                                    | ❌       | Unique subscription identifier (when recurring billing)                              |
| installment                                | String                                    | ❌       | Unique installment identifier (when billing in installments)                         |
| checkoutSession                            | String                                    | ❌       | Unique checkout identifier                                                           |
| paymentLink                                | String                                    | ❌       | Unique identifier of the payments link to which the payment belongs                  |
| value                                      | Double                                    | ❌       | Payment amount                                                                       |
| netValue                                   | Double                                    | ❌       | Net value of the charge after discounting the Asaas fee                              |
| originalValue                              | Double                                    | ❌       | Original amount of charge (filled when paid with interest and fine)                  |
| interestValue                              | Double                                    | ❌       | Calculated amount of interest and fine that must be paid after the charge is due     |
| description                                | String                                    | ❌       | Description of the payment                                                           |
| billingType                                | ApiPaymentGetResponseBillingType          | ❌       | Payment billing type                                                                 |
| creditCard                                 | ApiPaymentSaveWithCreditCardCreditCardDto | ❌       |                                                                                      |
| canBePaidAfterDueDate                      | Boolean                                   | ❌       | Informs whether the charge can be paid after the due date (Only for bank slip)       |
| pixTransaction                             | String                                    | ❌       | Unique identifier of the Pix transaction to which the payment belongs                |
| pixQrCodeId                                | String                                    | ❌       | Unique identifier of the static QrCode generated for a given Pix key                 |
| status                                     | ApiPaymentGetResponsePaymentStatus        | ❌       | Payment status                                                                       |
| dueDate                                    | String                                    | ❌       | Payment due date                                                                     |
| originalDueDate                            | String                                    | ❌       | Original due date upon creation of the payment                                       |
| paymentDate                                | String                                    | ❌       | Payment date on Asaas                                                                |
| clientPaymentDate                          | String                                    | ❌       | Date on which the customer paid the bank slip                                        |
| installmentNumber                          | Long                                      | ❌       | Parcel number                                                                        |
| invoiceUrl                                 | String                                    | ❌       | Invoice URL                                                                          |
| invoiceNumber                              | String                                    | ❌       | Bill number                                                                          |
| externalReference                          | String                                    | ❌       | Free search field                                                                    |
| deleted                                    | Boolean                                   | ❌       | Determines if the payment has been removed                                           |
| anticipated                                | Boolean                                   | ❌       | Defines whether the charge was anticipated or is in the process of being anticipated |
| anticipable                                | Boolean                                   | ❌       | Determines whether the charge is anticipated                                         |
| creditDate                                 | String                                    | ❌       | Date when the credit became available                                                |
| estimatedCreditDate                        | String                                    | ❌       | Estimated date when the credit will be available                                     |
| transactionReceiptUrl                      | String                                    | ❌       | URL of proof of confirmation, receipt, reversal or removal                           |
| nossoNumero                                | String                                    | ❌       | Unique identification of the bank slip                                               |
| bankSlipUrl                                | String                                    | ❌       | URL to download the bank slip                                                        |
| discount                                   | ApiPaymentDiscountDto                     | ❌       |                                                                                      |
| fine                                       | ApiPaymentFineResponseDto                 | ❌       |                                                                                      |
| interest                                   | ApiPaymentInterestResponseDto             | ❌       |                                                                                      |
| split                                      | List\<ApiPaymentSplitGetResponseDto\>     | ❌       | Split Settings                                                                       |
| postalService                              | Boolean                                   | ❌       | Define whether the payment will be sent via post                                     |
| daysAfterDueDateToRegistrationCancellation | Long                                      | ❌       | Days after registration cancellation deadline (only for bank slip)                   |
| chargeback                                 | ApiPaymentChargebackResponseDto           | ❌       |                                                                                      |
| escrow                                     | ApiPaymentCustodyGetResponseDto           | ❌       |                                                                                      |
| refunds                                    | List\<ApiPaymentRefundGetResponseDto\>    | ❌       | Refunds information                                                                  |

<!-- This file was generated by liblab | https://liblab.com/ -->
