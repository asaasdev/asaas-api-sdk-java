# PixQrCodeSaveRequestDto

**Properties**

| Name                   | Type    | Required | Description                                                                                      |
| :--------------------- | :------ | :------- | :----------------------------------------------------------------------------------------------- |
| addressKey             | String  | ❌       | Key that will receive QrCode payments                                                            |
| description            | String  | ❌       | QrCode Description                                                                               |
| value                  | Double  | ❌       | Value of the QrCode, if not informed, the payer can choose the value                             |
| format                 | Format  | ❌       | QrCode Format                                                                                    |
| expirationDate         | String  | ❌       | QrCode expiration date/time, after this date all payments will be refused.                       |
| expirationSeconds      | Long    | ❌       | Determines the expiration date in seconds.                                                       |
| allowsMultiplePayments | Boolean | ❌       | Defines whether the QrCode can be paid multiple times, if not entered the default value is true. |
| externalReference      | String  | ❌       | Free search field                                                                                |

<!-- This file was generated by liblab | https://liblab.com/ -->
