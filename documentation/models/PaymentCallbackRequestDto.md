# PaymentCallbackRequestDto

Automatic redirection information after the payment of the link payment

**Properties**

| Name         | Type    | Required | Description                                                                                                                                                                               |
| :----------- | :------ | :------- | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| successUrl   | String  | ✅       | URL that the customer will be redirected to after successful payment of the invoice or payment link                                                                                       |
| autoRedirect | Boolean | ❌       | Define whether the customer will be automatically redirected or will just be informed with a button to return to the website. The default is true, if you want to disable it, enter false |

<!-- This file was generated by liblab | https://liblab.com/ -->
