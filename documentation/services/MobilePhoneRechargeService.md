# MobilePhoneRechargeService

A list of all methods in the `MobilePhoneRechargeService` service. Click on the method name to view detailed information about that method.

| Methods                                                             | Description                                                                                                                                                      |
| :------------------------------------------------------------------ | :--------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [listMobileRecharges](#listmobilerecharges)                         |                                                                                                                                                                  |
| [requestRecharge](#requestrecharge)                                 |                                                                                                                                                                  |
| [recoverASingleCellphoneRecharge](#recoverasinglecellphonerecharge) |                                                                                                                                                                  |
| [cancelACellphoneRecharge](#cancelacellphonerecharge)               | Allows canceling the cell phone top-up. Use the canBeCancelled property to verify if the top-up can be canceled. When canceled, the top-up will not be executed. |
| [searchForCellPhoneProvider](#searchforcellphoneprovider)           |                                                                                                                                                                  |

## listMobileRecharges

- HTTP Method: `GET`
- Endpoint: `/v3/mobilePhoneRecharges`

**Parameters**

| Name              | Type                                                                        | Required | Description               |
| :---------------- | :-------------------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [ListMobileRechargesParameters](../models/ListMobileRechargesParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ApiMobilePhoneRechargeListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiMobilePhoneRechargeListResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ListMobileRechargesParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListMobileRechargesParameters requestParameters = ListMobileRechargesParameters.builder()
      .offset(2L)
      .limit(10L)
      .build();

    ApiMobilePhoneRechargeListResponseDto response = asaasSdk.mobilePhoneRecharge.listMobileRecharges(
      requestParameters
    );

    System.out.println(response);
  }
}

```

## requestRecharge

- HTTP Method: `POST`
- Endpoint: `/v3/mobilePhoneRecharges`

**Parameters**

| Name                                 | Type                                                                                      | Required | Description  |
| :----------------------------------- | :---------------------------------------------------------------------------------------- | :------- | :----------- |
| apiMobilePhoneRechargeSaveRequestDto | [ApiMobilePhoneRechargeSaveRequestDto](../models/ApiMobilePhoneRechargeSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`ApiMobilePhoneRechargeGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiMobilePhoneRechargeGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiMobilePhoneRechargeSaveRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiMobilePhoneRechargeSaveRequestDto apiMobilePhoneRechargeSaveRequestDto =
      ApiMobilePhoneRechargeSaveRequestDto.builder().value(15D).phoneNumber("63997365512").build();

    ApiMobilePhoneRechargeGetResponseDto response = asaasSdk.mobilePhoneRecharge.requestRecharge(
      apiMobilePhoneRechargeSaveRequestDto
    );

    System.out.println(response);
  }
}

```

## recoverASingleCellphoneRecharge

- HTTP Method: `GET`
- Endpoint: `/v3/mobilePhoneRecharges/{id}`

**Parameters**

| Name | Type   | Required | Description                                        |
| :--- | :----- | :------- | :------------------------------------------------- |
| id   | String | ✅       | Unique identifier for cell phone recharge on Asaas |

**Return Type**

`ApiMobilePhoneRechargeGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiMobilePhoneRechargeGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiMobilePhoneRechargeGetResponseDto response = asaasSdk.mobilePhoneRecharge.recoverASingleCellphoneRecharge(
      "37c22147-4194-11ec-8061-0242ac120002"
    );

    System.out.println(response);
  }
}

```

## cancelACellphoneRecharge

Allows canceling the cell phone top-up. Use the canBeCancelled property to verify if the top-up can be canceled. When canceled, the top-up will not be executed.

- HTTP Method: `POST`
- Endpoint: `/v3/mobilePhoneRecharges/{id}/cancel`

**Parameters**

| Name  | Type   | Required | Description                                        |
| :---- | :----- | :------- | :------------------------------------------------- |
| id    | String | ✅       | Unique identifier for cell phone recharge on Asaas |
| input | Object | ❌       | Request Body                                       |

**Return Type**

`ApiMobilePhoneRechargeGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiMobilePhoneRechargeGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiMobilePhoneRechargeGetResponseDto response = asaasSdk.mobilePhoneRecharge.cancelACellphoneRecharge(
      "37c22147-4194-11ec-8061-0242ac120002",
      new Object()
    );

    System.out.println(response);
  }
}

```

## searchForCellPhoneProvider

- HTTP Method: `GET`
- Endpoint: `/v3/mobilePhoneRecharges/{phoneNumber}/provider`

**Parameters**

| Name        | Type   | Required | Description                               |
| :---------- | :----- | :------- | :---------------------------------------- |
| phoneNumber | String | ✅       | Cell phone number that will be consulted. |

**Return Type**

`ApiMobilePhoneRechargeFindProviderResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiMobilePhoneRechargeFindProviderResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiMobilePhoneRechargeFindProviderResponseDto response = asaasSdk.mobilePhoneRecharge.searchForCellPhoneProvider(
      "63997365512"
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
