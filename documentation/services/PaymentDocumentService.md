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

`ListDocumentsOfAPaymentOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ListDocumentsOfAPaymentOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListDocumentsOfAPaymentOkResponse response = asaasSdk.paymentDocument.listDocumentsOfAPayment("id");

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
| uploadPaymentDocumentsRequest | [UploadPaymentDocumentsRequest](../models/UploadPaymentDocumentsRequest.md) | ❌       | Request Body                       |

**Return Type**

`UploadPaymentDocumentsOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDocumentSaveRequestPaymentDocumentType;
import com.asaas.sdk.asaasjavasdk.models.UploadPaymentDocumentsOkResponse;
import com.asaas.sdk.asaasjavasdk.models.UploadPaymentDocumentsRequest;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    UploadPaymentDocumentsRequest uploadPaymentDocumentsRequest = UploadPaymentDocumentsRequest.builder()
      .availableAfterPayment(true)
      .type(ApiPaymentDocumentSaveRequestPaymentDocumentType.INVOICE)
      .file(nulla)
      .build();

    UploadPaymentDocumentsOkResponse response = asaasSdk.paymentDocument.uploadPaymentDocuments(
      "id",
      uploadPaymentDocumentsRequest
    );

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

| Name                                       | Type                                                                                                  | Required | Description                        |
| :----------------------------------------- | :---------------------------------------------------------------------------------------------------- | :------- | :--------------------------------- |
| id                                         | String                                                                                                | ✅       | Unique payment identifier in Asaas |
| documentId                                 | String                                                                                                | ✅       | Unique document identifier         |
| updateSettingsOfADocumentOfAPaymentRequest | [UpdateSettingsOfADocumentOfAPaymentRequest](../models/UpdateSettingsOfADocumentOfAPaymentRequest.md) | ❌       | Request Body                       |

**Return Type**

`ApiPaymentDocumentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDocumentGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDocumentUpdateRequestPaymentDocumentType;
import com.asaas.sdk.asaasjavasdk.models.UpdateSettingsOfADocumentOfAPaymentRequest;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    UpdateSettingsOfADocumentOfAPaymentRequest updateSettingsOfADocumentOfAPaymentRequest =
      UpdateSettingsOfADocumentOfAPaymentRequest.builder()
        .availableAfterPayment(true)
        .type(ApiPaymentDocumentUpdateRequestPaymentDocumentType.INVOICE)
        .build();

    ApiPaymentDocumentGetResponseDto response = asaasSdk.paymentDocument.updateSettingsOfADocumentOfAPayment(
      "id",
      "documentId",
      updateSettingsOfADocumentOfAPaymentRequest
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

`DeleteDocumentFromAPaymentOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.DeleteDocumentFromAPaymentOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    DeleteDocumentFromAPaymentOkResponse response = asaasSdk.paymentDocument.deleteDocumentFromAPayment(
      "id",
      "documentId"
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
