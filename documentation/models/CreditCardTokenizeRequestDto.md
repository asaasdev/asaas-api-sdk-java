# CreditCardTokenizeRequestDto

**Properties**

| Name                 | Type                           | Required | Description                                                                              |
| :------------------- | :----------------------------- | :------- | :--------------------------------------------------------------------------------------- |
| customer             | String                         | ✅       | Unique customer identifier in Asaas                                                      |
| creditCard           | CreditCardRequestDto           | ✅       | Credit card information                                                                  |
| creditCardHolderInfo | CreditCardHolderInfoRequestDto | ✅       | Credit card holder information                                                           |
| remoteIp             | String                         | ✅       | IP from where the customer is making the purchase. Your server's IP must not be entered. |

<!-- This file was generated by liblab | https://liblab.com/ -->
