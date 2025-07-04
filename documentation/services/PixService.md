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

`PixAddressKeyListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ListKeysParameters;
import com.asaas.apisdk.models.PixAddressKeyListRequestPixAddressKeyStatus;
import com.asaas.apisdk.models.PixAddressKeyListResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListKeysParameters requestParameters = ListKeysParameters.builder()
      .offset(7L)
      .limit(10L)
      .status(PixAddressKeyListRequestPixAddressKeyStatus.AWAITING_ACTIVATION)
      .statusList("statusList")
      .build();

    PixAddressKeyListResponseDto response = asaasSdk.pix.listKeys(requestParameters);

    System.out.println(response);
  }
}

```

## createAKey

- HTTP Method: `POST`
- Endpoint: `/v3/pix/addressKeys`

**Parameters**

| Name                        | Type                                                                    | Required | Description  |
| :-------------------------- | :---------------------------------------------------------------------- | :------- | :----------- |
| pixAddressKeySaveRequestDto | [PixAddressKeySaveRequestDto](../models/PixAddressKeySaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`PixAddressKeyGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PixAddressKeyGetResponseDto;
import com.asaas.apisdk.models.PixAddressKeySaveRequestDto;
import com.asaas.apisdk.models.PixAddressKeySaveRequestPixAddressKeyType;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PixAddressKeySaveRequestDto pixAddressKeySaveRequestDto = PixAddressKeySaveRequestDto.builder()
      .type(PixAddressKeySaveRequestPixAddressKeyType.EVP)
      .build();

    PixAddressKeyGetResponseDto response = asaasSdk.pix.createAKey(pixAddressKeySaveRequestDto);

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

`PixAddressKeyGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PixAddressKeyGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PixAddressKeyGetResponseDto response = asaasSdk.pix.retrieveASingleKey("a33047b1-fb19-4b68-9373-a7ba8a8162aa");

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

`PixAddressKeyGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PixAddressKeyGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PixAddressKeyGetResponseDto response = asaasSdk.pix.removeKey("a33047b1-fb19-4b68-9373-a7ba8a8162aa");

    System.out.println(response);
  }
}

```

## createStaticQrcode

- HTTP Method: `POST`
- Endpoint: `/v3/pix/qrCodes/static`

**Parameters**

| Name                    | Type                                                            | Required | Description  |
| :---------------------- | :-------------------------------------------------------------- | :------- | :----------- |
| pixQrCodeSaveRequestDto | [PixQrCodeSaveRequestDto](../models/PixQrCodeSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`PixQrCodeSaveResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.Format;
import com.asaas.apisdk.models.PixQrCodeSaveRequestDto;
import com.asaas.apisdk.models.PixQrCodeSaveResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PixQrCodeSaveRequestDto pixQrCodeSaveRequestDto = PixQrCodeSaveRequestDto.builder()
      .addressKey("b6295ee1-f054-47d1-9e90-ee57b74f60d9")
      .description("Barbecue")
      .value(50D)
      .format(Format.ALL)
      .expirationDate("2023-05-05 14:20:50")
      .expirationSeconds(6L)
      .allowsMultiplePayments(true)
      .externalReference("externalReference")
      .build();

    PixQrCodeSaveResponseDto response = asaasSdk.pix.createStaticQrcode(pixQrCodeSaveRequestDto);

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

`PixQrCodeDeleteResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PixQrCodeDeleteResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PixQrCodeDeleteResponseDto response = asaasSdk.pix.deleteStaticQrcode("ASAAS00000000000000383ASA");

    System.out.println(response);
  }
}

```

## availableTokenBucketCheck

- HTTP Method: `GET`
- Endpoint: `/v3/pix/tokenBucket/addressKey`

**Return Type**

`PixTokenBucketGetAddressKeyResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PixTokenBucketGetAddressKeyResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PixTokenBucketGetAddressKeyResponseDto response = asaasSdk.pix.availableTokenBucketCheck();

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
