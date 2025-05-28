# CheckoutService

A list of all methods in the `CheckoutService` service. Click on the method name to view detailed information about that method.

| Methods                                 | Description |
| :-------------------------------------- | :---------- |
| [createNewCheckout](#createnewcheckout) |             |
| [cancelACheckout](#cancelacheckout)     |             |

## createNewCheckout

- HTTP Method: `POST`
- Endpoint: `/v3/checkouts`

**Parameters**

| Name                             | Type                                                                              | Required | Description  |
| :------------------------------- | :-------------------------------------------------------------------------------- | :------- | :----------- |
| apiCheckoutSessionSaveRequestDto | [ApiCheckoutSessionSaveRequestDto](../models/ApiCheckoutSessionSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`ApiCheckoutSessionResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCheckoutSessionCallbackDto;
import com.asaas.sdk.asaasjavasdk.models.ApiCheckoutSessionCustomerDataDto;
import com.asaas.sdk.asaasjavasdk.models.ApiCheckoutSessionInstallmentDto;
import com.asaas.sdk.asaasjavasdk.models.ApiCheckoutSessionItemsDto;
import com.asaas.sdk.asaasjavasdk.models.ApiCheckoutSessionResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiCheckoutSessionSaveRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiCheckoutSessionSplitDto;
import com.asaas.sdk.asaasjavasdk.models.ApiCheckoutSessionSubscriptionCycle;
import com.asaas.sdk.asaasjavasdk.models.ApiCheckoutSessionSubscriptionDto;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
		AsaasSdkConfig config = AsaasSdkConfig.builder()
			.apiKeyAuthConfig(
				ApiKeyAuthConfig.builder()
					.apiKey("YOUR_API_KEY")
					.build()
			)
			.build();

		AsaasSdk asaasSdk = new AsaasSdk(config);

		List<String> billingTypesList = Arrays.asList("billingTypes");

		List<String> chargeTypesList = Arrays.asList("chargeTypes");

		ApiCheckoutSessionCallbackDto apiCheckoutSessionCallbackDto = ApiCheckoutSessionCallbackDto.builder()
			.successUrl("https://example.com/asaas/checkout/success")
			.cancelUrl("https://example.com/asaas/checkout/cancel")
			.expiredUrl("https://example.com/asaas/checkout/expired")
			.build();

		ApiCheckoutSessionItemsDto apiCheckoutSessionItemsDto = ApiCheckoutSessionItemsDto.builder()
			.description("Camisetas")
			.imageBase64("IMAGE IN BASE64")
			.name("Roupas")
			.quantity(2L)
			.value(100D)
			.build();

		List<ApiCheckoutSessionItemsDto> itemsList = Arrays.asList(apiCheckoutSessionItemsDto);

		ApiCheckoutSessionCustomerDataDto apiCheckoutSessionCustomerDataDto = ApiCheckoutSessionCustomerDataDto.builder()
			.name("John Doe")
			.cpfCnpj("24971563792")
			.email("john.doe@asaas.com.br")
			.phone("4738010919")
			.address("Av. Paulista")
			.addressNumber(150L)
			.complement("Sala 201")
			.province("Centro")
			.postalCode("01310-000")
			.city(12987382L)
			.build();

		ApiCheckoutSessionSubscriptionDto apiCheckoutSessionSubscriptionDto = ApiCheckoutSessionSubscriptionDto.builder()
			.cycle(ApiCheckoutSessionSubscriptionCycle.WEEKLY)
			.endDate("2025-01-01")
			.nextDueDate("2025-01-01")
			.build();

		ApiCheckoutSessionInstallmentDto apiCheckoutSessionInstallmentDto = ApiCheckoutSessionInstallmentDto.builder()
			.maxInstallmentCount(1L)
			.build();

		ApiCheckoutSessionSplitDto apiCheckoutSessionSplitDto = ApiCheckoutSessionSplitDto.builder()
			.walletId("7bafd95a-e783-4a62-9be1-23999af742c6")
			.fixedValue(Comissão referente ao serviço utilizadoD)
			.percentageValue(10D)
			.totalFixedValue(15D)
			.build();

		List<ApiCheckoutSessionSplitDto> splitList = Arrays.asList(apiCheckoutSessionSplitDto);

		ApiCheckoutSessionSaveRequestDto apiCheckoutSessionSaveRequestDto = ApiCheckoutSessionSaveRequestDto.builder()
			.billingTypes(billingTypesList)
			.chargeTypes(chargeTypesList)
			.minutesToExpire(10L)
			.callback(apiCheckoutSessionCallbackDto)
			.items(itemsList)
			.customerData(apiCheckoutSessionCustomerDataDto)
			.subscription(apiCheckoutSessionSubscriptionDto)
			.installment(apiCheckoutSessionInstallmentDto)
			.split(splitList)
			.build();

		ApiCheckoutSessionResponseDto response = asaasSdk.checkout.createNewCheckout(apiCheckoutSessionSaveRequestDto);

		System.out.println(response);
    }
}
```

## cancelACheckout

- HTTP Method: `POST`
- Endpoint: `/v3/checkouts/{id}/cancel`

**Parameters**

| Name  | Type   | Required | Description                            |
| :---- | :----- | :------- | :------------------------------------- |
| id    | String | ✅       | Unique identifier of checkout in Asaas |
| input | Object | ❌       | Request Body                           |

**Return Type**

`ApiCheckoutSessionResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCheckoutSessionResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiCheckoutSessionResponseDto response = asaasSdk.checkout.cancelACheckout(
      "131ca662-56c8-4479-b5b3-fd61a413fce7",
      new Object()
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
