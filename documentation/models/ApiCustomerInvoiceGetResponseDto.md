# ApiCustomerInvoiceGetResponseDto

**Properties**

| Name                      | Type                                       | Required | Description                                                                                                        |
| :------------------------ | :----------------------------------------- | :------- | :----------------------------------------------------------------------------------------------------------------- |
| object                    | String                                     | ❌       | Object type                                                                                                        |
| id                        | String                                     | ❌       | Unique invoice identifier in Asaas                                                                                 |
| status                    | ApiCustomerInvoiceGetResponseInvoiceStatus | ❌       | Invoice status                                                                                                     |
| customer                  | String                                     | ❌       | Unique customer identifier                                                                                         |
| payment                   | String                                     | ❌       | Unique payment identifier in Asaas                                                                                 |
| installment               | String                                     | ❌       | Unique installment identifier in Asaas                                                                             |
| type                      | ApiCustomerInvoiceGetResponseDtoType       | ❌       | Invoice type                                                                                                       |
| statusDescription         | String                                     | ❌       | Description of the current status of the invoice                                                                   |
| serviceDescription        | String                                     | ❌       | Description of invoice services                                                                                    |
| pdfUrl                    | String                                     | ❌       | Link to pdf file of the invoice issued                                                                             |
| xmlUrl                    | String                                     | ❌       | Link to xml file of the issued invoice                                                                             |
| rpsSerie                  | String                                     | ❌       | Invoice series                                                                                                     |
| rpsNumber                 | String                                     | ❌       | RPS converted to invoice                                                                                           |
| number                    | String                                     | ❌       | Invoice number                                                                                                     |
| validationCode            | String                                     | ❌       | Verification code                                                                                                  |
| value                     | Double                                     | ❌       | Total value                                                                                                        |
| deductions                | Double                                     | ❌       | Deductions. Deductions do not change the total value of the invoice, but they do change the ISS calculation basis. |
| effectiveDate             | String                                     | ❌       | Invoice issuance date                                                                                              |
| observations              | String                                     | ❌       | Additional observations                                                                                            |
| estimatedTaxesDescription | String                                     | ❌       | Estimated tax invoice                                                                                              |
| externalReference         | String                                     | ❌       | Invoice identifier in your system                                                                                  |
| taxes                     | ApiCustomerInvoiceTaxesDto                 | ❌       |                                                                                                                    |
| municipalServiceId        | String                                     | ❌       | Unique municipal service identifier                                                                                |
| municipalServiceCode      | String                                     | ❌       | Municipal Service Code                                                                                             |
| municipalServiceName      | String                                     | ❌       | Name of municipal service                                                                                          |

<!-- This file was generated by liblab | https://liblab.com/ -->
