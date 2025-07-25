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

`PaymentDocumentListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentDocumentListResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentDocumentListResponseDto response = asaasSdk.paymentDocument.listDocumentsOfAPayment("id");

    System.out.println(response);
  }
}

```

## uploadPaymentDocuments

- HTTP Method: `POST`
- Endpoint: `/v3/payments/{id}/documents`

**Parameters**

| Name                          | Type                                                                        | Required | Description                        |
| :---------------------------- | :-------------------------------------------------------------------------- | :------- | :--------------------------------- |
| id                            | String                                                                      | ✅       | Unique payment identifier in Asaas |
| paymentDocumentSaveRequestDto | [PaymentDocumentSaveRequestDto](../models/PaymentDocumentSaveRequestDto.md) | ❌       | Request Body                       |
| \_filename                    | [String](../models/String.md)                                               | ✅       | Filename for the uploaded file     |

**Return Type**

`PaymentDocumentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentDocumentGetResponseDto;
import com.asaas.apisdk.models.PaymentDocumentSaveRequestDto;
import com.asaas.apisdk.models.PaymentDocumentSaveRequestPaymentDocumentType;

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

		PaymentDocumentSaveRequestDto paymentDocumentSaveRequestDto = PaymentDocumentSaveRequestDto.builder()
			.availableAfterPayment(true)
			.type(PaymentDocumentSaveRequestPaymentDocumentType.INVOICE)
			.file(tempor Ut)
			.build();
		PaymentDocumentSaveRequestDto paymentDocumentSaveRequestDto = PaymentDocumentSaveRequestDto.builder()
			.availableAfterPayment(true)
			.type(PaymentDocumentSaveRequestPaymentDocumentType.INVOICE)
			.file(tempor Ut)
			.build();

		PaymentDocumentGetResponseDto response = asaasSdk.paymentDocument.uploadPaymentDocuments("id", paymentDocumentSaveRequestDto, paymentDocumentSaveRequestDto);

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

`PaymentDocumentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentDocumentGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentDocumentGetResponseDto response = asaasSdk.paymentDocument.retrieveASingleDocumentOfAPayment(
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

| Name                            | Type                                                                            | Required | Description                        |
| :------------------------------ | :------------------------------------------------------------------------------ | :------- | :--------------------------------- |
| id                              | String                                                                          | ✅       | Unique payment identifier in Asaas |
| documentId                      | String                                                                          | ✅       | Unique document identifier         |
| paymentDocumentUpdateRequestDto | [PaymentDocumentUpdateRequestDto](../models/PaymentDocumentUpdateRequestDto.md) | ❌       | Request Body                       |

**Return Type**

`PaymentDocumentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentDocumentGetResponseDto;
import com.asaas.apisdk.models.PaymentDocumentUpdateRequestDto;
import com.asaas.apisdk.models.PaymentDocumentUpdateRequestPaymentDocumentType;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentDocumentUpdateRequestDto paymentDocumentUpdateRequestDto = PaymentDocumentUpdateRequestDto.builder()
      .availableAfterPayment(true)
      .type(PaymentDocumentUpdateRequestPaymentDocumentType.INVOICE)
      .build();

    PaymentDocumentGetResponseDto response = asaasSdk.paymentDocument.updateSettingsOfADocumentOfAPayment(
      "id",
      "documentId",
      paymentDocumentUpdateRequestDto
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

`PaymentDocumentDeleteResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentDocumentDeleteResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentDocumentDeleteResponseDto response = asaasSdk.paymentDocument.deleteDocumentFromAPayment("id", "documentId");

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
