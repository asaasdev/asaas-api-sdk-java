# PaymentSimulateResponseDto

**Properties**

| Name       | Type                                 | Required | Description                         |
| :--------- | :----------------------------------- | :------- | :---------------------------------- |
| value      | Double                               | ❌       | Total installment or billing amount |
| creditCard | PaymentSimulateCreditCardResponseDto | ❌       | Card fees                           |
| bankSlip   | PaymentSimulateBankSlipResponseDto   | ❌       | Boleto fees                         |
| pix        | PaymentSimulatePixResponseDto        | ❌       | PIX fees                            |

<!-- This file was generated by liblab | https://liblab.com/ -->
