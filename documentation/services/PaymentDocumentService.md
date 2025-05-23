# PaymentDocumentService

A list of all methods in the `PaymentDocumentService` service. Click on the method name to view detailed information about that method.

| Methods                                                                     | Description |
| :-------------------------------------------------------------------------- | :---------- |
| [listDocumentsOfAPayment](#listdocumentsofapayment)                         |             |
| [uploadPaymentDocuments](#uploadpaymentdocuments)                           |             |
| [retrieveASingleDocumentOfAPayment](#retrieveasingledocumentofapayment)     |             |
| [updateSettingsOfADocumentOfAPayment](#updatesettingsofadocumentofapayment) |             |
| [deleteDocumentFromAPayment](#deletedocumentfromapayment)                   |             |

## listDocumentsOfAPayment

- HTTP Method: `GET`
- Endpoint: `/v3/payments/{id}/documents`

**Parameters**

| Name | Type   | Required | Description                        |
| :--- | :----- | :------- | :--------------------------------- |
| id   | String | ✅       | Unique payment identifier in Asaas |

**Return Type**

`ApiPaymentDocumentListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDocumentListResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentDocumentListResponseDto response = asaasSdk.paymentDocument.listDocumentsOfAPayment("id");

    System.out.println(response);
  }
}

```

## uploadPaymentDocuments

- HTTP Method: `POST`
- Endpoint: `/v3/payments/{id}/documents`

**Parameters**

| Name                             | Type                                                                              | Required | Description                        |
| :------------------------------- | :-------------------------------------------------------------------------------- | :------- | :--------------------------------- |
| id                               | String                                                                            | ✅       | Unique payment identifier in Asaas |
| apiPaymentDocumentSaveRequestDto | [ApiPaymentDocumentSaveRequestDto](../models/ApiPaymentDocumentSaveRequestDto.md) | ❌       | Request Body                       |
| \_filename                       | [String](../models/String.md)                                                     | ❌       | Filename for the uploaded file     |

**Return Type**

`ApiPaymentDocumentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDocumentGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDocumentSaveRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDocumentSaveRequestPaymentDocumentType;

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

		ApiPaymentDocumentSaveRequestDto apiPaymentDocumentSaveRequestDto = ApiPaymentDocumentSaveRequestDto.builder()
			.id("id")
			.availableAfterPayment(true)
			.type(ApiPaymentDocumentSaveRequestPaymentDocumentType.INVOICE)
			.file(tempor Ut)
			.build();
		ApiPaymentDocumentSaveRequestDto apiPaymentDocumentSaveRequestDto = ApiPaymentDocumentSaveRequestDto.builder()
			.id("id")
			.availableAfterPayment(true)
			.type(ApiPaymentDocumentSaveRequestPaymentDocumentType.INVOICE)
			.file(tempor Ut)
			.build();

		ApiPaymentDocumentGetResponseDto response = asaasSdk.paymentDocument.uploadPaymentDocuments("id", apiPaymentDocumentSaveRequestDto, apiPaymentDocumentSaveRequestDto);

		System.out.println(response);
    }
}
```

## retrieveASingleDocumentOfAPayment

- HTTP Method: `GET`
- Endpoint: `/v3/payments/{id}/documents/{documentId}`

**Parameters**

| Name       | Type   | Required | Description                        |
| :--------- | :----- | :------- | :--------------------------------- |
| id         | String | ✅       | Unique payment identifier in Asaas |
| documentId | String | ✅       | Unique document identifier         |

**Return Type**

`ApiPaymentDocumentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDocumentGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentDocumentGetResponseDto response = asaasSdk.paymentDocument.retrieveASingleDocumentOfAPayment(
      "id",
      "documentId"
    );

    System.out.println(response);
  }
}

```

## updateSettingsOfADocumentOfAPayment

- HTTP Method: `PUT`
- Endpoint: `/v3/payments/{id}/documents/{documentId}`

**Parameters**

| Name                               | Type                                                                                  | Required | Description                        |
| :--------------------------------- | :------------------------------------------------------------------------------------ | :------- | :--------------------------------- |
| id                                 | String                                                                                | ✅       | Unique payment identifier in Asaas |
| documentId                         | String                                                                                | ✅       | Unique document identifier         |
| apiPaymentDocumentUpdateRequestDto | [ApiPaymentDocumentUpdateRequestDto](../models/ApiPaymentDocumentUpdateRequestDto.md) | ❌       | Request Body                       |

**Return Type**

`ApiPaymentDocumentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDocumentGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDocumentUpdateRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDocumentUpdateRequestPaymentDocumentType;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentDocumentUpdateRequestDto apiPaymentDocumentUpdateRequestDto = ApiPaymentDocumentUpdateRequestDto.builder()
      .id("id")
      .documentId("documentId")
      .availableAfterPayment(true)
      .type(ApiPaymentDocumentUpdateRequestPaymentDocumentType.INVOICE)
      .build();

    ApiPaymentDocumentGetResponseDto response = asaasSdk.paymentDocument.updateSettingsOfADocumentOfAPayment(
      "id",
      "documentId",
      apiPaymentDocumentUpdateRequestDto
    );

    System.out.println(response);
  }
}

```

## deleteDocumentFromAPayment

- HTTP Method: `DELETE`
- Endpoint: `/v3/payments/{id}/documents/{documentId}`

**Parameters**

| Name       | Type   | Required | Description                        |
| :--------- | :----- | :------- | :--------------------------------- |
| id         | String | ✅       | Unique payment identifier in Asaas |
| documentId | String | ✅       | Unique document identifier         |

**Return Type**

`ApiPaymentDocumentDeleteResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDocumentDeleteResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentDocumentDeleteResponseDto response = asaasSdk.paymentDocument.deleteDocumentFromAPayment(
      "id",
      "documentId"
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
