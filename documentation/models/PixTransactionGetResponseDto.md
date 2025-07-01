# PixTransactionGetResponseDto

**Properties**

| Name                   | Type                                                     | Required | Description                                                                |
| :--------------------- | :------------------------------------------------------- | :------- | :------------------------------------------------------------------------- |
| id                     | String                                                   | ❌       | Unique identifier of the Pix transaction in Asaas                          |
| endToEndIdentifier     | String                                                   | ❌       | Pix transaction identifier at the Central Bank                             |
| finality               | PixTransactionGetResponsePixTransactionCashValueFinality | ❌       | Used to indicate whether it is a Withdrawal or Change                      |
| value                  | Double                                                   | ❌       | Transaction or Withdrawal Value                                            |
| changeValue            | Double                                                   | ❌       | Change value                                                               |
| refundedValue          | Double                                                   | ❌       | Value reversed                                                             |
| effectiveDate          | String                                                   | ❌       | Transaction date                                                           |
| scheduledDate          | String                                                   | ❌       | Schedule date                                                              |
| status                 | PixTransactionGetResponsePixTransactionStatus            | ❌       | Transaction status                                                         |
| type                   | PixTransactionGetResponsePixTransactionType              | ❌       | Transaction type                                                           |
| originType             | PixTransactionGetResponsePixTransactionOriginType        | ❌       | Indicates the origin of the transaction                                    |
| conciliationIdentifier | String                                                   | ❌       | QrCode identifier linked to the transaction                                |
| description            | String                                                   | ❌       | Description about the transaction                                          |
| transactionReceiptUrl  | String                                                   | ❌       | Proof of transaction will be available after the transaction is confirmed. |
| refusalReason          | String                                                   | ❌       | Reason why the transaction was declined                                    |
| canBeCanceled          | Boolean                                                  | ❌       | Indicates whether the transaction can be canceled                          |
| originalTransaction    | PixOriginalTransactionResponseDto                        | ❌       | Original transaction information if a chargeback has occurred              |
| externalAccount        | PixTransactionExternalAccountResponseDto                 | ❌       | Information about the recipient                                            |
| qrCode                 | PixTransactionQrCodeResponseDto                          | ❌       | Information about QrCode                                                   |
| payment                | String                                                   | ❌       | Unique billing identifier                                                  |
| canBeRefunded          | Boolean                                                  | ❌       | Indicates whether the transaction can be refunded                          |
| refundDisabledReason   | String                                                   | ❌       | Reason why the chargeback was disabled                                     |
| chargedFeeValue        | Double                                                   | ❌       | Debit or credit fee for the transaction                                    |
| dateCreated            | String                                                   | ❌       | Transaction creation date                                                  |
| addressKey             | String                                                   | ❌       | Pix key when the transaction is a credit                                   |
| addressKeyType         | PixTransactionGetResponsePixAddressKeyType               | ❌       | Pix key type                                                               |
| transferId             | String                                                   | ❌       | Transfer identifier                                                        |
| externalReference      | String                                                   | ❌       | Free search field                                                          |

<!-- This file was generated by liblab | https://liblab.com/ -->
