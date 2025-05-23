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

`ApiAccountDocumentShowResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiAccountDocumentShowResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiAccountDocumentShowResponseDto response = asaasSdk.accountDocument.checkPendingDocuments();

    System.out.println(response);
  }
}

```

## sendDocumentsViaApi

- HTTP Method: `POST`
- Endpoint: `/v3/myAccount/documents/{id}`

**Parameters**

| Name                             | Type                                                                              | Required | Description                         |
| :------------------------------- | :-------------------------------------------------------------------------------- | :------- | :---------------------------------- |
| id                               | String                                                                            | ✅       | Unique document identifier in Asaas |
| apiAccountDocumentSaveRequestDto | [ApiAccountDocumentSaveRequestDto](../models/ApiAccountDocumentSaveRequestDto.md) | ❌       | Request Body                        |
| \_filename                       | [String](../models/String.md)                                                     | ❌       | Filename for the uploaded file      |

**Return Type**

`ApiAccountDocumentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiAccountDocumentGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiAccountDocumentSaveRequestCustomerDocumentType;
import com.asaas.sdk.asaasjavasdk.models.ApiAccountDocumentSaveRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiAccountDocumentSaveRequestDto apiAccountDocumentSaveRequestDto = ApiAccountDocumentSaveRequestDto.builder()
      .id("8d257732-2220-11ec-b695-b6af4a64184d")
      .documentFile(animsint)
      .type(ApiAccountDocumentSaveRequestCustomerDocumentType.IDENTIFICATION)
      .build();
    ApiAccountDocumentSaveRequestDto apiAccountDocumentSaveRequestDto = ApiAccountDocumentSaveRequestDto.builder()
      .id("8d257732-2220-11ec-b695-b6af4a64184d")
      .documentFile(animsint)
      .type(ApiAccountDocumentSaveRequestCustomerDocumentType.IDENTIFICATION)
      .build();

    ApiAccountDocumentGetResponseDto response = asaasSdk.accountDocument.sendDocumentsViaApi(
      "8d257732-2220-11ec-b695-b6af4a64184d",
      apiAccountDocumentSaveRequestDto,
      apiAccountDocumentSaveRequestDto
    );

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

| Name                               | Type                                                                                  | Required | Description                         |
| :--------------------------------- | :------------------------------------------------------------------------------------ | :------- | :---------------------------------- |
| id                                 | String                                                                                | ✅       | Unique document identifier in Asaas |
| apiAccountDocumentUpdateRequestDto | [ApiAccountDocumentUpdateRequestDto](../models/ApiAccountDocumentUpdateRequestDto.md) | ❌       | Request Body                        |
| \_filename                         | [String](../models/String.md)                                                         | ❌       | Filename for the uploaded file      |

**Return Type**

`ApiAccountDocumentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiAccountDocumentGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiAccountDocumentUpdateRequestDto;

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

		ApiAccountDocumentUpdateRequestDto apiAccountDocumentUpdateRequestDto = ApiAccountDocumentUpdateRequestDto.builder()
			.id("8d257732-2220-11ec-b695-b6af4a64184d")
			.documentFile(qui adip)
			.build();
		ApiAccountDocumentUpdateRequestDto apiAccountDocumentUpdateRequestDto = ApiAccountDocumentUpdateRequestDto.builder()
			.id("8d257732-2220-11ec-b695-b6af4a64184d")
			.documentFile(qui adip)
			.build();

		ApiAccountDocumentGetResponseDto response = asaasSdk.accountDocument.updateSentDocument("8d257732-2220-11ec-b695-b6af4a64184d", apiAccountDocumentUpdateRequestDto, apiAccountDocumentUpdateRequestDto);

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

`ApiAccountDocumentDeleteResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiAccountDocumentDeleteResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiAccountDocumentDeleteResponseDto response = asaasSdk.accountDocument.removeSentDocument(
      "8d257732-2220-11ec-b695-b6af4a64184d"
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
