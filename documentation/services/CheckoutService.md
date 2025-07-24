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

| Name                          | Type                                                                        | Required | Description  |
| :---------------------------- | :-------------------------------------------------------------------------- | :------- | :----------- |
| checkoutSessionSaveRequestDto | [CheckoutSessionSaveRequestDto](../models/CheckoutSessionSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`CheckoutSessionResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.CheckoutSessionCallbackDto;
import com.asaas.apisdk.models.CheckoutSessionCustomerDataDto;
import com.asaas.apisdk.models.CheckoutSessionInstallmentDto;
import com.asaas.apisdk.models.CheckoutSessionItemsDto;
import com.asaas.apisdk.models.CheckoutSessionResponseDto;
import com.asaas.apisdk.models.CheckoutSessionSaveRequestBillingType;
import com.asaas.apisdk.models.CheckoutSessionSaveRequestChargeType;
import com.asaas.apisdk.models.CheckoutSessionSaveRequestDto;
import com.asaas.apisdk.models.CheckoutSessionSplitDto;
import com.asaas.apisdk.models.CheckoutSessionSubscriptionCycle;
import com.asaas.apisdk.models.CheckoutSessionSubscriptionDto;
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

		List<CheckoutSessionSaveRequestBillingType> billingTypesList = Arrays.asList(CheckoutSessionSaveRequestBillingType.CREDIT_CARD);

		List<CheckoutSessionSaveRequestChargeType> chargeTypesList = Arrays.asList(CheckoutSessionSaveRequestChargeType.DETACHED);

		CheckoutSessionCallbackDto checkoutSessionCallbackDto = CheckoutSessionCallbackDto.builder()
			.successUrl("https://example.com/asaas/checkout/success")
			.cancelUrl("https://example.com/asaas/checkout/cancel")
			.expiredUrl("https://example.com/asaas/checkout/expired")
			.build();

		CheckoutSessionItemsDto checkoutSessionItemsDto = CheckoutSessionItemsDto.builder()
			.externalReference("ea28b0ba-4980-44f6-9f44-def89880dca5")
			.description("Camisetas")
			.imageBase64("IMAGE IN BASE64")
			.name("Roupas")
			.quantity(2L)
			.value(100D)
			.build();

		List<CheckoutSessionItemsDto> itemsList = Arrays.asList(checkoutSessionItemsDto);

		CheckoutSessionCustomerDataDto checkoutSessionCustomerDataDto = CheckoutSessionCustomerDataDto.builder()
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

		CheckoutSessionSubscriptionDto checkoutSessionSubscriptionDto = CheckoutSessionSubscriptionDto.builder()
			.cycle(CheckoutSessionSubscriptionCycle.WEEKLY)
			.endDate("2025-01-01")
			.nextDueDate("2025-01-01")
			.build();

		CheckoutSessionInstallmentDto checkoutSessionInstallmentDto = CheckoutSessionInstallmentDto.builder()
			.maxInstallmentCount(1L)
			.build();

		CheckoutSessionSplitDto checkoutSessionSplitDto = CheckoutSessionSplitDto.builder()
			.walletId("7bafd95a-e783-4a62-9be1-23999af742c6")
			.fixedValue(Comissão referente ao serviço utilizadoD)
			.percentageValue(10D)
			.totalFixedValue(15D)
			.build();

		List<CheckoutSessionSplitDto> splitsList = Arrays.asList(checkoutSessionSplitDto);

		CheckoutSessionSaveRequestDto checkoutSessionSaveRequestDto = CheckoutSessionSaveRequestDto.builder()
			.billingTypes(billingTypesList)
			.chargeTypes(chargeTypesList)
			.minutesToExpire(10L)
			.callback(checkoutSessionCallbackDto)
			.items(itemsList)
			.customerData(checkoutSessionCustomerDataDto)
			.subscription(checkoutSessionSubscriptionDto)
			.installment(checkoutSessionInstallmentDto)
			.splits(splitsList)
			.build();

		CheckoutSessionResponseDto response = asaasSdk.checkout.createNewCheckout(checkoutSessionSaveRequestDto);

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

`CheckoutSessionResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.CheckoutSessionResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    CheckoutSessionResponseDto response = asaasSdk.checkout.cancelACheckout(
      "131ca662-56c8-4479-b5b3-fd61a413fce7",
      new Object()
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
