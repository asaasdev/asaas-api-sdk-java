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

`ApiPixAddressKeyListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ApiPixAddressKeyListRequestPixAddressKeyStatus;
import com.asaas.apisdk.models.ApiPixAddressKeyListResponseDto;
import com.asaas.apisdk.models.ListKeysParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListKeysParameters requestParameters = ListKeysParameters.builder()
      .offset(7L)
      .limit(10L)
      .status(ApiPixAddressKeyListRequestPixAddressKeyStatus.AWAITING_ACTIVATION)
      .statusList("statusList")
      .build();

    ApiPixAddressKeyListResponseDto response = asaasSdk.pix.listKeys(requestParameters);

    System.out.println(response);
  }
}

```

## createAKey

- HTTP Method: `POST`
- Endpoint: `/v3/pix/addressKeys`

**Parameters**

| Name                           | Type                                                                          | Required | Description  |
| :----------------------------- | :---------------------------------------------------------------------------- | :------- | :----------- |
| apiPixAddressKeySaveRequestDto | [ApiPixAddressKeySaveRequestDto](../models/ApiPixAddressKeySaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`ApiPixAddressKeyGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ApiPixAddressKeyGetResponseDto;
import com.asaas.apisdk.models.ApiPixAddressKeySaveRequestDto;
import com.asaas.apisdk.models.ApiPixAddressKeySaveRequestPixAddressKeyType;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPixAddressKeySaveRequestDto apiPixAddressKeySaveRequestDto = ApiPixAddressKeySaveRequestDto.builder()
      .type(ApiPixAddressKeySaveRequestPixAddressKeyType.EVP)
      .build();

    ApiPixAddressKeyGetResponseDto response = asaasSdk.pix.createAKey(apiPixAddressKeySaveRequestDto);

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

`ApiPixAddressKeyGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ApiPixAddressKeyGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPixAddressKeyGetResponseDto response = asaasSdk.pix.retrieveASingleKey("a33047b1-fb19-4b68-9373-a7ba8a8162aa");

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
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ApiPixAddressKeyGetResponseDto;

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

| Name                       | Type                                                                  | Required | Description  |
| :------------------------- | :-------------------------------------------------------------------- | :------- | :----------- |
| apiPixQrCodeSaveRequestDto | [ApiPixQrCodeSaveRequestDto](../models/ApiPixQrCodeSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`ApiPixQrCodeSaveResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ApiPixQrCodeSaveRequestDto;
import com.asaas.apisdk.models.ApiPixQrCodeSaveResponseDto;
import com.asaas.apisdk.models.Format;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPixQrCodeSaveRequestDto apiPixQrCodeSaveRequestDto = ApiPixQrCodeSaveRequestDto.builder()
      .addressKey("b6295ee1-f054-47d1-9e90-ee57b74f60d9")
      .description("Barbecue")
      .value(50D)
      .format(Format.ALL)
      .expirationDate("2023-05-05 14:20:50")
      .expirationSeconds(6L)
      .allowsMultiplePayments(true)
      .externalReference("externalReference")
      .build();

    ApiPixQrCodeSaveResponseDto response = asaasSdk.pix.createStaticQrcode(apiPixQrCodeSaveRequestDto);

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

`ApiPixQrCodeDeleteResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ApiPixQrCodeDeleteResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPixQrCodeDeleteResponseDto response = asaasSdk.pix.deleteStaticQrcode("ASAAS00000000000000383ASA");

    System.out.println(response);
  }
}

```

## availableTokenBucketCheck

- HTTP Method: `GET`
- Endpoint: `/v3/pix/tokenBucket/addressKey`

**Return Type**

`ApiPixTokenBucketGetAddressKeyResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ApiPixTokenBucketGetAddressKeyResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPixTokenBucketGetAddressKeyResponseDto response = asaasSdk.pix.availableTokenBucketCheck();

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
