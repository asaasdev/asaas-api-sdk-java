# PaymentLinkService

A list of all methods in the `PaymentLinkService` service. Click on the method name to view detailed information about that method.

| Methods                                                               | Description |
| :-------------------------------------------------------------------- | :---------- |
| [listPaymentsLinks](#listpaymentslinks)                               |             |
| [createAPaymentsLink](#createapaymentslink)                           |             |
| [retrieveASinglePaymentsLink](#retrieveasinglepaymentslink)           |             |
| [updateAPaymentsLink](#updateapaymentslink)                           |             |
| [removeAPaymentsLink](#removeapaymentslink)                           |             |
| [restoreAPaymentsLink](#restoreapaymentslink)                         |             |
| [listImagesFromAPaymentsLink](#listimagesfromapaymentslink)           |             |
| [addAnImageToAPaymentsLink](#addanimagetoapaymentslink)               |             |
| [retrieveASinglePaymentsLinkImage](#retrieveasinglepaymentslinkimage) |             |
| [removeAnImageFromPaymentsLink](#removeanimagefrompaymentslink)       |             |
| [setPaymentsLinkMainImage](#setpaymentslinkmainimage)                 |             |

## listPaymentsLinks

- HTTP Method: `GET`
- Endpoint: `/v3/paymentLinks`

**Parameters**

| Name              | Type                                                                    | Required | Description               |
| :---------------- | :---------------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [ListPaymentsLinksParameters](../models/ListPaymentsLinksParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ListPaymentsLinksOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ListPaymentsLinksOkResponse;
import com.asaas.sdk.asaasjavasdk.models.ListPaymentsLinksParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListPaymentsLinksParameters requestParameters = ListPaymentsLinksParameters.builder()
      .offset(7L)
      .limit(10L)
      .active(true)
      .includeDeleted(false)
      .name("name")
      .externalReference("externalReference")
      .build();

    ListPaymentsLinksOkResponse response = asaasSdk.paymentLink.listPaymentsLinks(requestParameters);

    System.out.println(response);
  }
}

```

## createAPaymentsLink

- HTTP Method: `POST`
- Endpoint: `/v3/paymentLinks`

**Parameters**

| Name                       | Type                                                                  | Required | Description  |
| :------------------------- | :-------------------------------------------------------------------- | :------- | :----------- |
| createAPaymentsLinkRequest | [CreateAPaymentsLinkRequest](../models/CreateAPaymentsLinkRequest.md) | ❌       | Request Body |

**Return Type**

`ApiPaymentCampaignGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentCallbackRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentCampaignGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentCampaignSaveRequestBillingType;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentCampaignSaveRequestChargeType;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentCampaignSaveRequestCycle;
import com.asaas.sdk.asaasjavasdk.models.CreateAPaymentsLinkRequest;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentCallbackRequestDto apiPaymentCallbackRequestDto = ApiPaymentCallbackRequestDto.builder()
      .successUrl("successUrl")
      .autoRedirect(false)
      .build();

    CreateAPaymentsLinkRequest createAPaymentsLinkRequest = CreateAPaymentsLinkRequest.builder()
      .name("Book sales")
      .description("Any book for just R$: 50.00")
      .endDate("2024-09-05")
      .value(50D)
      .billingType(ApiPaymentCampaignSaveRequestBillingType.UNDEFINED)
      .chargeType(ApiPaymentCampaignSaveRequestChargeType.DETACHED)
      .dueDateLimitDays(10L)
      .subscriptionCycle(ApiPaymentCampaignSaveRequestCycle.WEEKLY)
      .maxInstallmentCount(1L)
      .externalReference("1287")
      .notificationEnabled(true)
      .callback(apiPaymentCallbackRequestDto)
      .isAddressRequired(true)
      .build();

    ApiPaymentCampaignGetResponseDto response = asaasSdk.paymentLink.createAPaymentsLink(createAPaymentsLinkRequest);

    System.out.println(response);
  }
}

```

## retrieveASinglePaymentsLink

- HTTP Method: `GET`
- Endpoint: `/v3/paymentLinks/{id}`

**Parameters**

| Name | Type   | Required | Description                                       |
| :--- | :----- | :------- | :------------------------------------------------ |
| id   | String | ✅       | Unique identifier for your payments link in Asaas |

**Return Type**

`ApiPaymentCampaignGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentCampaignGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentCampaignGetResponseDto response = asaasSdk.paymentLink.retrieveASinglePaymentsLink("725104409743");

    System.out.println(response);
  }
}

```

## updateAPaymentsLink

- HTTP Method: `PUT`
- Endpoint: `/v3/paymentLinks/{id}`

**Parameters**

| Name                       | Type                                                                  | Required | Description                                       |
| :------------------------- | :-------------------------------------------------------------------- | :------- | :------------------------------------------------ |
| id                         | String                                                                | ✅       | Unique identifier for your payments link in Asaas |
| updateAPaymentsLinkRequest | [UpdateAPaymentsLinkRequest](../models/UpdateAPaymentsLinkRequest.md) | ❌       | Request Body                                      |

**Return Type**

`ApiPaymentCampaignGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentCallbackRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentCampaignGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentCampaignUpdateRequestBillingType;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentCampaignUpdateRequestChargeType;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentCampaignUpdateRequestCycle;
import com.asaas.sdk.asaasjavasdk.models.UpdateAPaymentsLinkRequest;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentCallbackRequestDto apiPaymentCallbackRequestDto = ApiPaymentCallbackRequestDto.builder()
      .successUrl("successUrl")
      .autoRedirect(false)
      .build();

    UpdateAPaymentsLinkRequest updateAPaymentsLinkRequest = UpdateAPaymentsLinkRequest.builder()
      .name("Book sales")
      .description("Any book for just R$: 50.00")
      .endDate("2024-09-05")
      .value(50D)
      .active(true)
      .billingType(ApiPaymentCampaignUpdateRequestBillingType.UNDEFINED)
      .chargeType(ApiPaymentCampaignUpdateRequestChargeType.DETACHED)
      .dueDateLimitDays(10L)
      .subscriptionCycle(ApiPaymentCampaignUpdateRequestCycle.WEEKLY)
      .maxInstallmentCount(1L)
      .externalReference("2323")
      .notificationEnabled(false)
      .callback(apiPaymentCallbackRequestDto)
      .build();

    ApiPaymentCampaignGetResponseDto response = asaasSdk.paymentLink.updateAPaymentsLink(
      "725104409743",
      updateAPaymentsLinkRequest
    );

    System.out.println(response);
  }
}

```

## removeAPaymentsLink

- HTTP Method: `DELETE`
- Endpoint: `/v3/paymentLinks/{id}`

**Parameters**

| Name | Type   | Required | Description                                       |
| :--- | :----- | :------- | :------------------------------------------------ |
| id   | String | ✅       | Unique identifier for your payments link in Asaas |

**Return Type**

`RemoveAPaymentsLinkOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.RemoveAPaymentsLinkOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    RemoveAPaymentsLinkOkResponse response = asaasSdk.paymentLink.removeAPaymentsLink("725104409743");

    System.out.println(response);
  }
}

```

## restoreAPaymentsLink

- HTTP Method: `POST`
- Endpoint: `/v3/paymentLinks/{id}/restore`

**Parameters**

| Name  | Type   | Required | Description                                       |
| :---- | :----- | :------- | :------------------------------------------------ |
| id    | String | ✅       | Unique identifier for your payments link in Asaas |
| input | Object | ❌       | Request Body                                      |

**Return Type**

`RestoreAPaymentsLinkOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.RestoreAPaymentsLinkOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    RestoreAPaymentsLinkOkResponse response = asaasSdk.paymentLink.restoreAPaymentsLink("725104409743", new Object());

    System.out.println(response);
  }
}

```

## listImagesFromAPaymentsLink

- HTTP Method: `GET`
- Endpoint: `/v3/paymentLinks/{id}/images`

**Parameters**

| Name | Type   | Required | Description                                       |
| :--- | :----- | :------- | :------------------------------------------------ |
| id   | String | ✅       | Unique identifier for your payments link in Asaas |

**Return Type**

`ListImagesFromAPaymentsLinkOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ListImagesFromAPaymentsLinkOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListImagesFromAPaymentsLinkOkResponse response = asaasSdk.paymentLink.listImagesFromAPaymentsLink("725104409743");

    System.out.println(response);
  }
}

```

## addAnImageToAPaymentsLink

- HTTP Method: `POST`
- Endpoint: `/v3/paymentLinks/{id}/images`

**Parameters**

| Name                             | Type                                                                              | Required | Description                                       |
| :------------------------------- | :-------------------------------------------------------------------------------- | :------- | :------------------------------------------------ |
| id                               | String                                                                            | ✅       | Unique identifier for your payments link in Asaas |
| addAnImageToAPaymentsLinkRequest | [AddAnImageToAPaymentsLinkRequest](../models/AddAnImageToAPaymentsLinkRequest.md) | ❌       | Request Body                                      |

**Return Type**

`ApiPaymentCampaignFileGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.AddAnImageToAPaymentsLinkRequest;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentCampaignFileGetResponseDto;

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

		AddAnImageToAPaymentsLinkRequest addAnImageToAPaymentsLinkRequest = AddAnImageToAPaymentsLinkRequest.builder()
			.main(true)
			.image(laborum ipsum )
			.build();

		ApiPaymentCampaignFileGetResponseDto response = asaasSdk.paymentLink.addAnImageToAPaymentsLink("725104409743", addAnImageToAPaymentsLinkRequest);

		System.out.println(response);
    }
}
```

## retrieveASinglePaymentsLinkImage

- HTTP Method: `GET`
- Endpoint: `/v3/paymentLinks/{paymentLinkId}/images/{imageId}`

**Parameters**

| Name          | Type   | Required | Description                                       |
| :------------ | :----- | :------- | :------------------------------------------------ |
| paymentLinkId | String | ✅       | Unique identifier for your payments link in Asaas |
| imageId       | String | ✅       | Unique payment link image identifier in Asaas     |

**Return Type**

`ApiPaymentCampaignFileGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentCampaignFileGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentCampaignFileGetResponseDto response = asaasSdk.paymentLink.retrieveASinglePaymentsLinkImage(
      "725104409743",
      "417d1fe7-f530-4368-935f-699045f2bf5d"
    );

    System.out.println(response);
  }
}

```

## removeAnImageFromPaymentsLink

- HTTP Method: `DELETE`
- Endpoint: `/v3/paymentLinks/{paymentLinkId}/images/{imageId}`

**Parameters**

| Name          | Type   | Required | Description                                       |
| :------------ | :----- | :------- | :------------------------------------------------ |
| paymentLinkId | String | ✅       | Unique identifier for your payments link in Asaas |
| imageId       | String | ✅       | Unique payment link image identifier in Asaas     |

**Return Type**

`RemoveAnImageFromPaymentsLinkOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.RemoveAnImageFromPaymentsLinkOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    RemoveAnImageFromPaymentsLinkOkResponse response = asaasSdk.paymentLink.removeAnImageFromPaymentsLink(
      "725104409743",
      "417d1fe7-f530-4368-935f-699045f2bf5d"
    );

    System.out.println(response);
  }
}

```

## setPaymentsLinkMainImage

- HTTP Method: `PUT`
- Endpoint: `/v3/paymentLinks/{paymentLinkId}/images/{imageId}/setAsMain`

**Parameters**

| Name          | Type   | Required | Description                                       |
| :------------ | :----- | :------- | :------------------------------------------------ |
| paymentLinkId | String | ✅       | Unique identifier for your payments link in Asaas |
| imageId       | String | ✅       | Unique payment link image identifier in Asaas     |
| input         | Object | ❌       | Request Body                                      |

**Return Type**

`SetPaymentsLinkMainImageOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.SetPaymentsLinkMainImageOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    SetPaymentsLinkMainImageOkResponse response = asaasSdk.paymentLink.setPaymentsLinkMainImage(
      "725104409743",
      "417d1fe7-f530-4368-935f-699045f2bf5d",
      new Object()
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
