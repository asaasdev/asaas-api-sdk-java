# AccountDocumentService

A list of all methods in the `AccountDocumentService` service. Click on the method name to view detailed information about that method.

| Methods                                         | Description |
| :---------------------------------------------- | :---------- |
| [checkPendingDocuments](#checkpendingdocuments) |             |
| [sendDocuments](#senddocuments)                 |             |
| [viewDocumentSent](#viewdocumentsent)           |             |
| [updateSentDocument](#updatesentdocument)       |             |
| [removeSentDocument](#removesentdocument)       |             |

## checkPendingDocuments

- HTTP Method: `GET`
- Endpoint: `/v3/myAccount/documents`

**Return Type**

`AccountDocumentShowResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.AccountDocumentShowResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    AccountDocumentShowResponseDto response = asaasSdk.accountDocument.checkPendingDocuments();

    System.out.println(response);
  }
}

```

## sendDocuments

- HTTP Method: `POST`
- Endpoint: `/v3/myAccount/documents/{id}`

**Parameters**

| Name                          | Type                                                                        | Required | Description                         |
| :---------------------------- | :-------------------------------------------------------------------------- | :------- | :---------------------------------- |
| id                            | String                                                                      | ✅       | Unique document identifier in Asaas |
| accountDocumentSaveRequestDto | [AccountDocumentSaveRequestDto](../models/AccountDocumentSaveRequestDto.md) | ❌       | Request Body                        |
| \_filename                    | [String](../models/String.md)                                               | ✅       | Filename for the uploaded file      |

**Return Type**

`AccountDocumentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.AccountDocumentGetResponseDto;
import com.asaas.apisdk.models.AccountDocumentSaveRequestAccountDocumentType;
import com.asaas.apisdk.models.AccountDocumentSaveRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    AccountDocumentSaveRequestDto accountDocumentSaveRequestDto = AccountDocumentSaveRequestDto.builder()
      .documentFile(sintl)
      .type(AccountDocumentSaveRequestAccountDocumentType.IDENTIFICATION)
      .build();
    AccountDocumentSaveRequestDto accountDocumentSaveRequestDto = AccountDocumentSaveRequestDto.builder()
      .documentFile(sintl)
      .type(AccountDocumentSaveRequestAccountDocumentType.IDENTIFICATION)
      .build();

    AccountDocumentGetResponseDto response = asaasSdk.accountDocument.sendDocuments(
      "8d257732-2220-11ec-b695-b6af4a64184d",
      accountDocumentSaveRequestDto,
      accountDocumentSaveRequestDto
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

`AccountDocumentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.AccountDocumentGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    AccountDocumentGetResponseDto response = asaasSdk.accountDocument.viewDocumentSent(
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

| Name                            | Type                                                                            | Required | Description                         |
| :------------------------------ | :------------------------------------------------------------------------------ | :------- | :---------------------------------- |
| id                              | String                                                                          | ✅       | Unique document identifier in Asaas |
| accountDocumentUpdateRequestDto | [AccountDocumentUpdateRequestDto](../models/AccountDocumentUpdateRequestDto.md) | ❌       | Request Body                        |
| \_filename                      | [String](../models/String.md)                                                   | ✅       | Filename for the uploaded file      |

**Return Type**

`AccountDocumentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.AccountDocumentGetResponseDto;
import com.asaas.apisdk.models.AccountDocumentUpdateRequestDto;

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

		AccountDocumentUpdateRequestDto accountDocumentUpdateRequestDto = AccountDocumentUpdateRequestDto.builder()
			.documentFile(dolor cul)
			.build();
		AccountDocumentUpdateRequestDto accountDocumentUpdateRequestDto = AccountDocumentUpdateRequestDto.builder()
			.documentFile(dolor cul)
			.build();

		AccountDocumentGetResponseDto response = asaasSdk.accountDocument.updateSentDocument("8d257732-2220-11ec-b695-b6af4a64184d", accountDocumentUpdateRequestDto, accountDocumentUpdateRequestDto);

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

`AccountDocumentDeleteResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.AccountDocumentDeleteResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    AccountDocumentDeleteResponseDto response = asaasSdk.accountDocument.removeSentDocument(
      "8d257732-2220-11ec-b695-b6af4a64184d"
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
