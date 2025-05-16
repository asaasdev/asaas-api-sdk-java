# AccountDocumentService

A list of all methods in the `AccountDocumentService` service. Click on the method name to view detailed information about that method.

| Methods                                         | Description |
| :---------------------------------------------- | :---------- |
| [checkPendingDocuments](#checkpendingdocuments) |             |
| [sendDocumentsViaApi](#senddocumentsviaapi)     |             |
| [viewDocumentSent](#viewdocumentsent)           |             |
| [updateSentDocument](#updatesentdocument)       |             |
| [removeSentDocument](#removesentdocument)       |             |

## checkPendingDocuments

- HTTP Method: `GET`
- Endpoint: `/v3/myAccount/documents`

**Return Type**

`CheckPendingDocumentsOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.CheckPendingDocumentsOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    CheckPendingDocumentsOkResponse response = asaasSdk.accountDocument.checkPendingDocuments();

    System.out.println(response);
  }
}

```

## sendDocumentsViaApi

- HTTP Method: `POST`
- Endpoint: `/v3/myAccount/documents/{id}`

**Parameters**

| Name                       | Type                                                                  | Required | Description                         |
| :------------------------- | :-------------------------------------------------------------------- | :------- | :---------------------------------- |
| id                         | String                                                                | ✅       | Unique document identifier in Asaas |
| sendDocumentsViaApiRequest | [SendDocumentsViaApiRequest](../models/SendDocumentsViaApiRequest.md) | ❌       | Request Body                        |

**Return Type**

`ApiAccountDocumentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiAccountDocumentGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiAccountDocumentSaveRequestCustomerDocumentType;
import com.asaas.sdk.asaasjavasdk.models.SendDocumentsViaApiRequest;

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

		SendDocumentsViaApiRequest sendDocumentsViaApiRequest = SendDocumentsViaApiRequest.builder()
			.documentFile(ea tempor con)
			.type(ApiAccountDocumentSaveRequestCustomerDocumentType.IDENTIFICATION)
			.build();

		ApiAccountDocumentGetResponseDto response = asaasSdk.accountDocument.sendDocumentsViaApi("8d257732-2220-11ec-b695-b6af4a64184d", sendDocumentsViaApiRequest);

		System.out.println(response);
    }
}
```

## viewDocumentSent

- HTTP Method: `GET`
- Endpoint: `/v3/myAccount/documents/files/{id}`

**Parameters**

| Name | Type   | Required | Description                         |
| :--- | :----- | :------- | :---------------------------------- |
| id   | String | ✅       | Unique document identifier in Asaas |

**Return Type**

`ApiAccountDocumentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiAccountDocumentGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiAccountDocumentGetResponseDto response = asaasSdk.accountDocument.viewDocumentSent(
      "8d257732-2220-11ec-b695-b6af4a64184d"
    );

    System.out.println(response);
  }
}

```

## updateSentDocument

- HTTP Method: `POST`
- Endpoint: `/v3/myAccount/documents/files/{id}`

**Parameters**

| Name                      | Type                                                                | Required | Description                         |
| :------------------------ | :------------------------------------------------------------------ | :------- | :---------------------------------- |
| id                        | String                                                              | ✅       | Unique document identifier in Asaas |
| updateSentDocumentRequest | [UpdateSentDocumentRequest](../models/UpdateSentDocumentRequest.md) | ❌       | Request Body                        |

**Return Type**

`UpdateSentDocumentOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.UpdateSentDocumentOkResponse;
import com.asaas.sdk.asaasjavasdk.models.UpdateSentDocumentRequest;

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

		UpdateSentDocumentRequest updateSentDocumentRequest = UpdateSentDocumentRequest.builder()
			.documentFile(utex laboris)
			.build();

		UpdateSentDocumentOkResponse response = asaasSdk.accountDocument.updateSentDocument("8d257732-2220-11ec-b695-b6af4a64184d", updateSentDocumentRequest);

		System.out.println(response);
    }
}
```

## removeSentDocument

- HTTP Method: `DELETE`
- Endpoint: `/v3/myAccount/documents/files/{id}`

**Parameters**

| Name | Type   | Required | Description                         |
| :--- | :----- | :------- | :---------------------------------- |
| id   | String | ✅       | Unique document identifier in Asaas |

**Return Type**

`RemoveSentDocumentOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.RemoveSentDocumentOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    RemoveSentDocumentOkResponse response = asaasSdk.accountDocument.removeSentDocument(
      "8d257732-2220-11ec-b695-b6af4a64184d"
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
