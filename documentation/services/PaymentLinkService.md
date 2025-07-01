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

`PaymentLinkListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ListPaymentsLinksParameters;
import com.asaas.apisdk.models.PaymentLinkListResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListPaymentsLinksParameters requestParameters = ListPaymentsLinksParameters.builder()
      .offset(9L)
      .limit(10L)
      .active(true)
      .includeDeleted(true)
      .name("name")
      .externalReference("externalReference")
      .build();

    PaymentLinkListResponseDto response = asaasSdk.paymentLink.listPaymentsLinks(requestParameters);

    System.out.println(response);
  }
}

```

## createAPaymentsLink

- HTTP Method: `POST`
- Endpoint: `/v3/paymentLinks`

**Parameters**

| Name                      | Type                                                                | Required | Description  |
| :------------------------ | :------------------------------------------------------------------ | :------- | :----------- |
| paymentLinkSaveRequestDto | [PaymentLinkSaveRequestDto](../models/PaymentLinkSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`PaymentLinkGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentCallbackRequestDto;
import com.asaas.apisdk.models.PaymentLinkGetResponseDto;
import com.asaas.apisdk.models.PaymentLinkSaveRequestBillingType;
import com.asaas.apisdk.models.PaymentLinkSaveRequestChargeType;
import com.asaas.apisdk.models.PaymentLinkSaveRequestCycle;
import com.asaas.apisdk.models.PaymentLinkSaveRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentCallbackRequestDto paymentCallbackRequestDto = PaymentCallbackRequestDto.builder()
      .successUrl("successUrl")
      .autoRedirect(true)
      .build();

    PaymentLinkSaveRequestDto paymentLinkSaveRequestDto = PaymentLinkSaveRequestDto.builder()
      .name("Book sales")
      .description("Any book for just R$: 50.00")
      .endDate("2024-09-05")
      .value(50D)
      .billingType(PaymentLinkSaveRequestBillingType.UNDEFINED)
      .chargeType(PaymentLinkSaveRequestChargeType.DETACHED)
      .dueDateLimitDays(10L)
      .subscriptionCycle(PaymentLinkSaveRequestCycle.WEEKLY)
      .maxInstallmentCount(1L)
      .externalReference("1287")
      .notificationEnabled(true)
      .callback(paymentCallbackRequestDto)
      .isAddressRequired(true)
      .build();

    PaymentLinkGetResponseDto response = asaasSdk.paymentLink.createAPaymentsLink(paymentLinkSaveRequestDto);

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

`PaymentLinkGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentLinkGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentLinkGetResponseDto response = asaasSdk.paymentLink.retrieveASinglePaymentsLink("725104409743");

    System.out.println(response);
  }
}

```

## updateAPaymentsLink

- HTTP Method: `PUT`
- Endpoint: `/v3/paymentLinks/{id}`

**Parameters**

| Name                        | Type                                                                    | Required | Description                                       |
| :-------------------------- | :---------------------------------------------------------------------- | :------- | :------------------------------------------------ |
| id                          | String                                                                  | ✅       | Unique identifier for your payments link in Asaas |
| paymentLinkUpdateRequestDto | [PaymentLinkUpdateRequestDto](../models/PaymentLinkUpdateRequestDto.md) | ❌       | Request Body                                      |

**Return Type**

`PaymentLinkGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentCallbackRequestDto;
import com.asaas.apisdk.models.PaymentLinkGetResponseDto;
import com.asaas.apisdk.models.PaymentLinkUpdateRequestBillingType;
import com.asaas.apisdk.models.PaymentLinkUpdateRequestChargeType;
import com.asaas.apisdk.models.PaymentLinkUpdateRequestCycle;
import com.asaas.apisdk.models.PaymentLinkUpdateRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentCallbackRequestDto paymentCallbackRequestDto = PaymentCallbackRequestDto.builder()
      .successUrl("successUrl")
      .autoRedirect(true)
      .build();

    PaymentLinkUpdateRequestDto paymentLinkUpdateRequestDto = PaymentLinkUpdateRequestDto.builder()
      .name("Book sales")
      .description("Any book for just R$: 50.00")
      .endDate("2024-09-05")
      .value(50D)
      .active(true)
      .billingType(PaymentLinkUpdateRequestBillingType.UNDEFINED)
      .chargeType(PaymentLinkUpdateRequestChargeType.DETACHED)
      .dueDateLimitDays(10L)
      .subscriptionCycle(PaymentLinkUpdateRequestCycle.WEEKLY)
      .maxInstallmentCount(1L)
      .externalReference("2323")
      .notificationEnabled(true)
      .callback(paymentCallbackRequestDto)
      .build();

    PaymentLinkGetResponseDto response = asaasSdk.paymentLink.updateAPaymentsLink(
      "725104409743",
      paymentLinkUpdateRequestDto
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

`PaymentLinkDeleteResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentLinkDeleteResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentLinkDeleteResponseDto response = asaasSdk.paymentLink.removeAPaymentsLink("725104409743");

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

`PaymentLinkGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentLinkGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentLinkGetResponseDto response = asaasSdk.paymentLink.restoreAPaymentsLink("725104409743", new Object());

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

`PaymentLinkFileListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentLinkFileListResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentLinkFileListResponseDto response = asaasSdk.paymentLink.listImagesFromAPaymentsLink("725104409743");

    System.out.println(response);
  }
}

```

## addAnImageToAPaymentsLink

- HTTP Method: `POST`
- Endpoint: `/v3/paymentLinks/{id}/images`

**Parameters**

| Name                          | Type                                                                        | Required | Description                                       |
| :---------------------------- | :-------------------------------------------------------------------------- | :------- | :------------------------------------------------ |
| id                            | String                                                                      | ✅       | Unique identifier for your payments link in Asaas |
| paymentLinkFileSaveRequestDto | [PaymentLinkFileSaveRequestDto](../models/PaymentLinkFileSaveRequestDto.md) | ❌       | Request Body                                      |
| \_filename                    | [String](../models/String.md)                                               | ✅       | Filename for the uploaded file                    |

**Return Type**

`PaymentLinkFileGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentLinkFileGetResponseDto;
import com.asaas.apisdk.models.PaymentLinkFileSaveRequestDto;

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

		PaymentLinkFileSaveRequestDto paymentLinkFileSaveRequestDto = PaymentLinkFileSaveRequestDto.builder()
			.main(true)
			.image(dolor laborum)
			.build();
		PaymentLinkFileSaveRequestDto paymentLinkFileSaveRequestDto = PaymentLinkFileSaveRequestDto.builder()
			.main(true)
			.image(dolor laborum)
			.build();

		PaymentLinkFileGetResponseDto response = asaasSdk.paymentLink.addAnImageToAPaymentsLink("725104409743", paymentLinkFileSaveRequestDto, paymentLinkFileSaveRequestDto);

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

`PaymentLinkFileGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentLinkFileGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentLinkFileGetResponseDto response = asaasSdk.paymentLink.retrieveASinglePaymentsLinkImage(
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

`PaymentLinkFileDeleteResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentLinkFileDeleteResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentLinkFileDeleteResponseDto response = asaasSdk.paymentLink.removeAnImageFromPaymentsLink(
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

`PaymentLinkFileGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentLinkFileGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentLinkFileGetResponseDto response = asaasSdk.paymentLink.setPaymentsLinkMainImage(
      "725104409743",
      "417d1fe7-f530-4368-935f-699045f2bf5d",
      new Object()
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
