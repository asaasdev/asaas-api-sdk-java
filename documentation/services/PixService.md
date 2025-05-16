# PixService

A list of all methods in the `PixService` service. Click on the method name to view detailed information about that method.

| Methods                                                 | Description |
| :------------------------------------------------------ | :---------- |
| [listKeys](#listkeys)                                   |             |
| [createAKey](#createakey)                               |             |
| [retrieveASingleKey](#retrieveasinglekey)               |             |
| [removeKey](#removekey)                                 |             |
| [createStaticQrcode](#createstaticqrcode)               |             |
| [deleteStaticQrcode](#deletestaticqrcode)               |             |
| [availableTokenBucketCheck](#availabletokenbucketcheck) |             |

## listKeys

- HTTP Method: `GET`
- Endpoint: `/v3/pix/addressKeys`

**Parameters**

| Name              | Type                                                  | Required | Description               |
| :---------------- | :---------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [ListKeysParameters](../models/ListKeysParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ListKeysOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPixAddressKeyListRequestPixAddressKeyStatus;
import com.asaas.sdk.asaasjavasdk.models.ListKeysOkResponse;
import com.asaas.sdk.asaasjavasdk.models.ListKeysParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListKeysParameters requestParameters = ListKeysParameters.builder()
      .offset(2L)
      .limit(10L)
      .status(ApiPixAddressKeyListRequestPixAddressKeyStatus.AWAITING_ACTIVATION)
      .statusList("statusList")
      .build();

    ListKeysOkResponse response = asaasSdk.pix.listKeys(requestParameters);

    System.out.println(response);
  }
}

```

## createAKey

- HTTP Method: `POST`
- Endpoint: `/v3/pix/addressKeys`

**Parameters**

| Name              | Type                                                | Required | Description  |
| :---------------- | :-------------------------------------------------- | :------- | :----------- |
| createAKeyRequest | [CreateAKeyRequest](../models/CreateAKeyRequest.md) | ❌       | Request Body |

**Return Type**

`ApiPixAddressKeyGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPixAddressKeyGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPixAddressKeySaveRequestPixAddressKeyType;
import com.asaas.sdk.asaasjavasdk.models.CreateAKeyRequest;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    CreateAKeyRequest createAKeyRequest = CreateAKeyRequest.builder()
      .type(ApiPixAddressKeySaveRequestPixAddressKeyType.EVP)
      .build();

    ApiPixAddressKeyGetResponseDto response = asaasSdk.pix.createAKey(createAKeyRequest);

    System.out.println(response);
  }
}

```

## retrieveASingleKey

- HTTP Method: `GET`
- Endpoint: `/v3/pix/addressKeys/{id}`

**Parameters**

| Name | Type   | Required | Description                        |
| :--- | :----- | :------- | :--------------------------------- |
| id   | String | ✅       | Unique Pix key identifier in Asaas |

**Return Type**

`RetrieveASingleKeyOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.RetrieveASingleKeyOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    RetrieveASingleKeyOkResponse response = asaasSdk.pix.retrieveASingleKey("a33047b1-fb19-4b68-9373-a7ba8a8162aa");

    System.out.println(response);
  }
}

```

## removeKey

- HTTP Method: `DELETE`
- Endpoint: `/v3/pix/addressKeys/{id}`

**Parameters**

| Name | Type   | Required | Description                        |
| :--- | :----- | :------- | :--------------------------------- |
| id   | String | ✅       | Unique Pix key identifier in Asaas |

**Return Type**

`ApiPixAddressKeyGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPixAddressKeyGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPixAddressKeyGetResponseDto response = asaasSdk.pix.removeKey("a33047b1-fb19-4b68-9373-a7ba8a8162aa");

    System.out.println(response);
  }
}

```

## createStaticQrcode

- HTTP Method: `POST`
- Endpoint: `/v3/pix/qrCodes/static`

**Parameters**

| Name                      | Type                                                                | Required | Description  |
| :------------------------ | :------------------------------------------------------------------ | :------- | :----------- |
| createStaticQrcodeRequest | [CreateStaticQrcodeRequest](../models/CreateStaticQrcodeRequest.md) | ❌       | Request Body |

**Return Type**

`CreateStaticQrcodeOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.CreateStaticQrcodeOkResponse;
import com.asaas.sdk.asaasjavasdk.models.CreateStaticQrcodeRequest;
import com.asaas.sdk.asaasjavasdk.models.Format;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    CreateStaticQrcodeRequest createStaticQrcodeRequest = CreateStaticQrcodeRequest.builder()
      .addressKey("b6295ee1-f054-47d1-9e90-ee57b74f60d9")
      .description("Barbecue")
      .value(50D)
      .format(Format.ALL)
      .expirationDate("2023-05-05 14:20:50")
      .expirationSeconds(2L)
      .allowsMultiplePayments(true)
      .externalReference("externalReference")
      .build();

    CreateStaticQrcodeOkResponse response = asaasSdk.pix.createStaticQrcode(createStaticQrcodeRequest);

    System.out.println(response);
  }
}

```

## deleteStaticQrcode

- HTTP Method: `DELETE`
- Endpoint: `/v3/pix/qrCodes/static/{id}`

**Parameters**

| Name | Type   | Required | Description                                     |
| :--- | :----- | :------- | :---------------------------------------------- |
| id   | String | ✅       | Identifier of the QR Code that will be deleted. |

**Return Type**

`DeleteStaticQrcodeOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.DeleteStaticQrcodeOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    DeleteStaticQrcodeOkResponse response = asaasSdk.pix.deleteStaticQrcode("ASAAS00000000000000383ASA");

    System.out.println(response);
  }
}

```

## availableTokenBucketCheck

- HTTP Method: `GET`
- Endpoint: `/v3/pix/tokenBucket/addressKey`

**Return Type**

`AvailableTokenBucketCheckOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.AvailableTokenBucketCheckOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    AvailableTokenBucketCheckOkResponse response = asaasSdk.pix.availableTokenBucketCheck();

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
