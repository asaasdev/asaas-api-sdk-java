# CancelAScheduledTransactionOkResponse

**Properties**

| Name                   | Type                                                        | Required | Description                                                                |
| :--------------------- | :---------------------------------------------------------- | :------- | :------------------------------------------------------------------------- |
| id                     | String                                                      | ❌       | Unique identifier of the Pix transaction in Asaas                          |
| endToEndIdentifier     | String                                                      | ❌       | Pix transaction identifier at the Central Bank                             |
| finality               | ApiPixTransactionGetResponsePixTransactionCashValueFinality | ❌       | Used to indicate whether it is a Withdrawal or Change                      |
| value                  | Double                                                      | ❌       | Transaction or Withdrawal Value                                            |
| changeValue            | Double                                                      | ❌       | Change value                                                               |
| refundedValue          | Double                                                      | ❌       | Value reversed                                                             |
| effectiveDate          | String                                                      | ❌       | Transaction date                                                           |
| scheduledDate          | String                                                      | ❌       | Schedule date                                                              |
| status                 | ApiPixTransactionGetResponsePixTransactionStatus            | ❌       | Transaction status                                                         |
| type                   | ApiPixTransactionGetResponsePixTransactionType              | ❌       | Transaction type                                                           |
| originType             | ApiPixTransactionGetResponsePixTransactionOriginType        | ❌       | Indicates the origin of the transaction                                    |
| conciliationIdentifier | String                                                      | ❌       | QrCode identifier linked to the transaction                                |
| description            | String                                                      | ❌       | Description about the transaction                                          |
| transactionReceiptUrl  | String                                                      | ❌       | Proof of transaction will be available after the transaction is confirmed. |
| refusalReason          | String                                                      | ❌       | Reason why the transaction was declined                                    |
| canBeCanceled          | Boolean                                                     | ❌       | Indicates whether the transaction can be canceled                          |
| originalTransaction    | ApiPixOriginalTransactionResponseDto                        | ❌       | Original transaction information if a chargeback has occurred              |
| externalAccount        | ApiPixTransactionExternalAccountResponseDto                 | ❌       | Information about the recipient                                            |
| qrCode                 | ApiPixTransactionQrCodeResponseDto                          | ❌       | Information about QrCode                                                   |
| payment                | String                                                      | ❌       | Unique billing identifier                                                  |
| canBeRefunded          | Boolean                                                     | ❌       | Indicates whether the transaction can be refunded                          |
| refundDisabledReason   | String                                                      | ❌       | Reason why the chargeback was disabled                                     |
| chargedFeeValue        | Double                                                      | ❌       | Debit or credit fee for the transaction                                    |
| dateCreated            | String                                                      | ❌       | Transaction creation date                                                  |
| addressKey             | String                                                      | ❌       | Pix key when the transaction is a credit                                   |
| addressKeyType         | ApiPixTransactionGetResponsePixAddressKeyType               | ❌       | Pix key type                                                               |
| transferId             | String                                                      | ❌       | Transfer identifier                                                        |
| externalReference      | String                                                      | ❌       | Free search field                                                          |

<!-- This file was generated by liblab | https://liblab.com/ -->
