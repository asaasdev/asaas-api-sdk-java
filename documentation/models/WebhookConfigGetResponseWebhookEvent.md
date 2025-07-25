# WebhookConfigGetResponseWebhookEvent

List of events this Webhook will observe

**Properties**

| Name                                               | Type   | Required | Description                                          |
| :------------------------------------------------- | :----- | :------- | :--------------------------------------------------- |
| PAYMENT_AUTHORIZED                                 | String | ✅       | "PAYMENT_AUTHORIZED"                                 |
| PAYMENT_AWAITING_RISK_ANALYSIS                     | String | ✅       | "PAYMENT_AWAITING_RISK_ANALYSIS"                     |
| PAYMENT_APPROVED_BY_RISK_ANALYSIS                  | String | ✅       | "PAYMENT_APPROVED_BY_RISK_ANALYSIS"                  |
| PAYMENT_REPROVED_BY_RISK_ANALYSIS                  | String | ✅       | "PAYMENT_REPROVED_BY_RISK_ANALYSIS"                  |
| PAYMENT_CREATED                                    | String | ✅       | "PAYMENT_CREATED"                                    |
| PAYMENT_UPDATED                                    | String | ✅       | "PAYMENT_UPDATED"                                    |
| PAYMENT_CONFIRMED                                  | String | ✅       | "PAYMENT_CONFIRMED"                                  |
| PAYMENT_RECEIVED                                   | String | ✅       | "PAYMENT_RECEIVED"                                   |
| PAYMENT_ANTICIPATED                                | String | ✅       | "PAYMENT_ANTICIPATED"                                |
| PAYMENT_OVERDUE                                    | String | ✅       | "PAYMENT_OVERDUE"                                    |
| PAYMENT_DELETED                                    | String | ✅       | "PAYMENT_DELETED"                                    |
| PAYMENT_RESTORED                                   | String | ✅       | "PAYMENT_RESTORED"                                   |
| PAYMENT_REFUNDED                                   | String | ✅       | "PAYMENT_REFUNDED"                                   |
| PAYMENT_REFUND_IN_PROGRESS                         | String | ✅       | "PAYMENT_REFUND_IN_PROGRESS"                         |
| PAYMENT_REFUND_DENIED                              | String | ✅       | "PAYMENT_REFUND_DENIED"                              |
| PAYMENT_RECEIVED_IN_CASH_UNDONE                    | String | ✅       | "PAYMENT_RECEIVED_IN_CASH_UNDONE"                    |
| PAYMENT_CHARGEBACK_REQUESTED                       | String | ✅       | "PAYMENT_CHARGEBACK_REQUESTED"                       |
| PAYMENT_CHARGEBACK_DISPUTE                         | String | ✅       | "PAYMENT_CHARGEBACK_DISPUTE"                         |
| PAYMENT_AWAITING_CHARGEBACK_REVERSAL               | String | ✅       | "PAYMENT_AWAITING_CHARGEBACK_REVERSAL"               |
| PAYMENT_DUNNING_RECEIVED                           | String | ✅       | "PAYMENT_DUNNING_RECEIVED"                           |
| PAYMENT_DUNNING_REQUESTED                          | String | ✅       | "PAYMENT_DUNNING_REQUESTED"                          |
| PAYMENT_BANK_SLIP_VIEWED                           | String | ✅       | "PAYMENT_BANK_SLIP_VIEWED"                           |
| PAYMENT_CHECKOUT_VIEWED                            | String | ✅       | "PAYMENT_CHECKOUT_VIEWED"                            |
| PAYMENT_CREDIT_CARD_CAPTURE_REFUSED                | String | ✅       | "PAYMENT_CREDIT_CARD_CAPTURE_REFUSED"                |
| PAYMENT_PARTIALLY_REFUNDED                         | String | ✅       | "PAYMENT_PARTIALLY_REFUNDED"                         |
| PAYMENT_SPLIT_CANCELLED                            | String | ✅       | "PAYMENT_SPLIT_CANCELLED"                            |
| PAYMENT_SPLIT_DIVERGENCE_BLOCK                     | String | ✅       | "PAYMENT_SPLIT_DIVERGENCE_BLOCK"                     |
| PAYMENT_SPLIT_DIVERGENCE_BLOCK_FINISHED            | String | ✅       | "PAYMENT_SPLIT_DIVERGENCE_BLOCK_FINISHED"            |
| INVOICE_CREATED                                    | String | ✅       | "INVOICE_CREATED"                                    |
| INVOICE_UPDATED                                    | String | ✅       | "INVOICE_UPDATED"                                    |
| INVOICE_SYNCHRONIZED                               | String | ✅       | "INVOICE_SYNCHRONIZED"                               |
| INVOICE_AUTHORIZED                                 | String | ✅       | "INVOICE_AUTHORIZED"                                 |
| INVOICE_PROCESSING_CANCELLATION                    | String | ✅       | "INVOICE_PROCESSING_CANCELLATION"                    |
| INVOICE_CANCELED                                   | String | ✅       | "INVOICE_CANCELED"                                   |
| INVOICE_CANCELLATION_DENIED                        | String | ✅       | "INVOICE_CANCELLATION_DENIED"                        |
| INVOICE_ERROR                                      | String | ✅       | "INVOICE_ERROR"                                      |
| TRANSFER_CREATED                                   | String | ✅       | "TRANSFER_CREATED"                                   |
| TRANSFER_PENDING                                   | String | ✅       | "TRANSFER_PENDING"                                   |
| TRANSFER_IN_BANK_PROCESSING                        | String | ✅       | "TRANSFER_IN_BANK_PROCESSING"                        |
| TRANSFER_BLOCKED                                   | String | ✅       | "TRANSFER_BLOCKED"                                   |
| TRANSFER_DONE                                      | String | ✅       | "TRANSFER_DONE"                                      |
| TRANSFER_FAILED                                    | String | ✅       | "TRANSFER_FAILED"                                    |
| TRANSFER_CANCELLED                                 | String | ✅       | "TRANSFER_CANCELLED"                                 |
| BILL_CREATED                                       | String | ✅       | "BILL_CREATED"                                       |
| BILL_PENDING                                       | String | ✅       | "BILL_PENDING"                                       |
| BILL_BANK_PROCESSING                               | String | ✅       | "BILL_BANK_PROCESSING"                               |
| BILL_PAID                                          | String | ✅       | "BILL_PAID"                                          |
| BILL_CANCELLED                                     | String | ✅       | "BILL_CANCELLED"                                     |
| BILL_FAILED                                        | String | ✅       | "BILL_FAILED"                                        |
| BILL_REFUNDED                                      | String | ✅       | "BILL_REFUNDED"                                      |
| RECEIVABLE_ANTICIPATION_CANCELLED                  | String | ✅       | "RECEIVABLE_ANTICIPATION_CANCELLED"                  |
| RECEIVABLE_ANTICIPATION_SCHEDULED                  | String | ✅       | "RECEIVABLE_ANTICIPATION_SCHEDULED"                  |
| RECEIVABLE_ANTICIPATION_PENDING                    | String | ✅       | "RECEIVABLE_ANTICIPATION_PENDING"                    |
| RECEIVABLE_ANTICIPATION_CREDITED                   | String | ✅       | "RECEIVABLE_ANTICIPATION_CREDITED"                   |
| RECEIVABLE_ANTICIPATION_DEBITED                    | String | ✅       | "RECEIVABLE_ANTICIPATION_DEBITED"                    |
| RECEIVABLE_ANTICIPATION_DENIED                     | String | ✅       | "RECEIVABLE_ANTICIPATION_DENIED"                     |
| RECEIVABLE_ANTICIPATION_OVERDUE                    | String | ✅       | "RECEIVABLE_ANTICIPATION_OVERDUE"                    |
| MOBILE_PHONE_RECHARGE_PENDING                      | String | ✅       | "MOBILE_PHONE_RECHARGE_PENDING"                      |
| MOBILE_PHONE_RECHARGE_CANCELLED                    | String | ✅       | "MOBILE_PHONE_RECHARGE_CANCELLED"                    |
| MOBILE_PHONE_RECHARGE_CONFIRMED                    | String | ✅       | "MOBILE_PHONE_RECHARGE_CONFIRMED"                    |
| MOBILE_PHONE_RECHARGE_REFUNDED                     | String | ✅       | "MOBILE_PHONE_RECHARGE_REFUNDED"                     |
| ACCOUNT_STATUS_BANK_ACCOUNT_INFO_APPROVED          | String | ✅       | "ACCOUNT_STATUS_BANK_ACCOUNT_INFO_APPROVED"          |
| ACCOUNT_STATUS_BANK_ACCOUNT_INFO_AWAITING_APPROVAL | String | ✅       | "ACCOUNT_STATUS_BANK_ACCOUNT_INFO_AWAITING_APPROVAL" |
| ACCOUNT_STATUS_BANK_ACCOUNT_INFO_PENDING           | String | ✅       | "ACCOUNT_STATUS_BANK_ACCOUNT_INFO_PENDING"           |
| ACCOUNT_STATUS_BANK_ACCOUNT_INFO_REJECTED          | String | ✅       | "ACCOUNT_STATUS_BANK_ACCOUNT_INFO_REJECTED"          |
| ACCOUNT_STATUS_COMMERCIAL_INFO_APPROVED            | String | ✅       | "ACCOUNT_STATUS_COMMERCIAL_INFO_APPROVED"            |
| ACCOUNT_STATUS_COMMERCIAL_INFO_AWAITING_APPROVAL   | String | ✅       | "ACCOUNT_STATUS_COMMERCIAL_INFO_AWAITING_APPROVAL"   |
| ACCOUNT_STATUS_COMMERCIAL_INFO_EXPIRED             | String | ✅       | "ACCOUNT_STATUS_COMMERCIAL_INFO_EXPIRED"             |
| ACCOUNT_STATUS_COMMERCIAL_INFO_EXPIRING_SOON       | String | ✅       | "ACCOUNT_STATUS_COMMERCIAL_INFO_EXPIRING_SOON"       |
| ACCOUNT_STATUS_COMMERCIAL_INFO_PENDING             | String | ✅       | "ACCOUNT_STATUS_COMMERCIAL_INFO_PENDING"             |
| ACCOUNT_STATUS_COMMERCIAL_INFO_REJECTED            | String | ✅       | "ACCOUNT_STATUS_COMMERCIAL_INFO_REJECTED"            |
| ACCOUNT_STATUS_DOCUMENT_APPROVED                   | String | ✅       | "ACCOUNT_STATUS_DOCUMENT_APPROVED"                   |
| ACCOUNT_STATUS_DOCUMENT_AWAITING_APPROVAL          | String | ✅       | "ACCOUNT_STATUS_DOCUMENT_AWAITING_APPROVAL"          |
| ACCOUNT_STATUS_DOCUMENT_PENDING                    | String | ✅       | "ACCOUNT_STATUS_DOCUMENT_PENDING"                    |
| ACCOUNT_STATUS_DOCUMENT_REJECTED                   | String | ✅       | "ACCOUNT_STATUS_DOCUMENT_REJECTED"                   |
| ACCOUNT_STATUS_GENERAL_APPROVAL_APPROVED           | String | ✅       | "ACCOUNT_STATUS_GENERAL_APPROVAL_APPROVED"           |
| ACCOUNT_STATUS_GENERAL_APPROVAL_AWAITING_APPROVAL  | String | ✅       | "ACCOUNT_STATUS_GENERAL_APPROVAL_AWAITING_APPROVAL"  |
| ACCOUNT_STATUS_GENERAL_APPROVAL_PENDING            | String | ✅       | "ACCOUNT_STATUS_GENERAL_APPROVAL_PENDING"            |
| ACCOUNT_STATUS_GENERAL_APPROVAL_REJECTED           | String | ✅       | "ACCOUNT_STATUS_GENERAL_APPROVAL_REJECTED"           |
| SUBSCRIPTION_CREATED                               | String | ✅       | "SUBSCRIPTION_CREATED"                               |
| SUBSCRIPTION_UPDATED                               | String | ✅       | "SUBSCRIPTION_UPDATED"                               |
| SUBSCRIPTION_INACTIVATED                           | String | ✅       | "SUBSCRIPTION_INACTIVATED"                           |
| SUBSCRIPTION_DELETED                               | String | ✅       | "SUBSCRIPTION_DELETED"                               |
| SUBSCRIPTION_SPLIT_DISABLED                        | String | ✅       | "SUBSCRIPTION_SPLIT_DISABLED"                        |
| SUBSCRIPTION_SPLIT_DIVERGENCE_BLOCK                | String | ✅       | "SUBSCRIPTION_SPLIT_DIVERGENCE_BLOCK"                |
| SUBSCRIPTION_SPLIT_DIVERGENCE_BLOCK_FINISHED       | String | ✅       | "SUBSCRIPTION_SPLIT_DIVERGENCE_BLOCK_FINISHED"       |
| CHECKOUT_CREATED                                   | String | ✅       | "CHECKOUT_CREATED"                                   |
| CHECKOUT_CANCELED                                  | String | ✅       | "CHECKOUT_CANCELED"                                  |
| CHECKOUT_EXPIRED                                   | String | ✅       | "CHECKOUT_EXPIRED"                                   |
| CHECKOUT_PAID                                      | String | ✅       | "CHECKOUT_PAID"                                      |

<!-- This file was generated by liblab | https://liblab.com/ -->
