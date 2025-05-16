# ConfirmCashReceiptWithSummaryDataInResponseOkResponse

**Properties**

| Name                  | Type                                   | Required | Description                                                                          |
| :-------------------- | :------------------------------------- | :------- | :----------------------------------------------------------------------------------- |
| object                | String                                 | ❌       | Object type                                                                          |
| id                    | String                                 | ❌       | Unique payment identifier in Asaas                                                   |
| dateCreated           | String                                 | ❌       | Payment creation date                                                                |
| customerId            | String                                 | ❌       | Unique identifier of the customer to whom the payment belongs                        |
| subscriptionId        | String                                 | ❌       | Unique subscription identifier (when recurring billing)                              |
| installmentId         | String                                 | ❌       | Unique installment identifier (when billing in installments)                         |
| paymentLinkId         | String                                 | ❌       | Unique identifier of the payments link to which the payment belongs                  |
| value                 | Double                                 | ❌       | Payment amount                                                                       |
| netValue              | Double                                 | ❌       | Net value of the charge after discounting the Asaas fee                              |
| originalValue         | Double                                 | ❌       | Original amount of charge (filled when paid with interest and fine)                  |
| interestValue         | Double                                 | ❌       | Calculated amount of interest and fine that must be paid after the charge is due     |
| description           | String                                 | ❌       | Description of the payment                                                           |
| billingType           | ApiPaymentLeanGetResponseBillingType   | ❌       | Payment billing type                                                                 |
| canBePaidAfterDueDate | Boolean                                | ❌       | Informs whether the charge can be paid after the due date (Only for bank slip)       |
| confirmedDate         | String                                 | ❌       | Billing confirmation date                                                            |
| pixTransactionId      | String                                 | ❌       | Unique identifier of the Pix transaction to which the payment belongs                |
| status                | ApiPaymentLeanGetResponsePaymentStatus | ❌       | Payment status                                                                       |
| dueDate               | String                                 | ❌       | Payment due date                                                                     |
| originalDueDate       | String                                 | ❌       | Original due date upon creation of the payment                                       |
| paymentDate           | String                                 | ❌       | Payment date on Asaas                                                                |
| customerPaymentDate   | String                                 | ❌       | Date on which the customer paid the bank slip                                        |
| installmentNumber     | Long                                   | ❌       | Parcel number                                                                        |
| externalReference     | String                                 | ❌       | Free search field                                                                    |
| deleted               | Boolean                                | ❌       | Determines if the payment has been removed                                           |
| anticipated           | Boolean                                | ❌       | Defines whether the charge was anticipated or is in the process of being anticipated |
| anticipable           | Boolean                                | ❌       | Determines whether the charge is anticipated                                         |
| creditDate            | String                                 | ❌       | Billing Credit date                                                                  |
| transactionReceiptUrl | String                                 | ❌       | URL of proof of confirmation, receipt, reversal or removal                           |
| duplicatedPaymentId   | String                                 | ❌       | Duplicate billing identifier (if true)                                               |
| discount              | ApiPaymentDiscountDto                  | ❌       | Discount information                                                                 |
| fine                  | ApiPaymentFineResponseDto              | ❌       | Fine information for payment after due date                                          |
| interest              | ApiPaymentInterestResponseDto          | ❌       | Interest information for payment after due date                                      |
| postalService         | Boolean                                | ❌       | Define whether the payment will be sent via post                                     |

<!-- This file was generated by liblab | https://liblab.com/ -->
