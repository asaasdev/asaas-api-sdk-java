# CreditCardService

A list of all methods in the `CreditCardService` service. Click on the method name to view detailed information about that method.

| Methods                                           | Description |
| :------------------------------------------------ | :---------- |
| [creditCardTokenization](#creditcardtokenization) |             |

## creditCardTokenization

- HTTP Method: `POST`
- Endpoint: `/v3/creditCard/tokenizeCreditCard`

**Parameters**

| Name                         | Type                                                                      | Required | Description  |
| :--------------------------- | :------------------------------------------------------------------------ | :------- | :----------- |
| creditCardTokenizeRequestDto | [CreditCardTokenizeRequestDto](../models/CreditCardTokenizeRequestDto.md) | ❌       | Request Body |

**Return Type**

`CreditCardTokenizeResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.CreditCardHolderInfoRequestDto;
import com.asaas.apisdk.models.CreditCardRequestDto;
import com.asaas.apisdk.models.CreditCardTokenizeRequestDto;
import com.asaas.apisdk.models.CreditCardTokenizeResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    CreditCardRequestDto creditCardRequestDto = CreditCardRequestDto.builder()
      .holderName("John Doe")
      .number("1234567890123456")
      .expiryMonth("7")
      .expiryYear("2025")
      .ccv("123")
      .build();

    CreditCardHolderInfoRequestDto creditCardHolderInfoRequestDto = CreditCardHolderInfoRequestDto.builder()
      .name("John Doe")
      .email("john.doe@asaas.com")
      .cpfCnpj("12345678901")
      .postalCode("12345678")
      .addressNumber("123")
      .addressComplement("addressComplement")
      .phone("phone")
      .mobilePhone("mobilePhone")
      .build();

    CreditCardTokenizeRequestDto creditCardTokenizeRequestDto = CreditCardTokenizeRequestDto.builder()
      .customer("cus_G7Dvo4iphUNk")
      .creditCard(creditCardRequestDto)
      .creditCardHolderInfo(creditCardHolderInfoRequestDto)
      .remoteIp("116.213.42.532")
      .build();

    CreditCardTokenizeResponseDto response = asaasSdk.creditCard.creditCardTokenization(creditCardTokenizeRequestDto);

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
