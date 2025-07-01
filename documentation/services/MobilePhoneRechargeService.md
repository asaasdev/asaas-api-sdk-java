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

`MobilePhoneRechargeListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ListMobileRechargesParameters;
import com.asaas.apisdk.models.MobilePhoneRechargeListResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListMobileRechargesParameters requestParameters = ListMobileRechargesParameters.builder()
      .offset(8L)
      .limit(10L)
      .build();

    MobilePhoneRechargeListResponseDto response = asaasSdk.mobilePhoneRecharge.listMobileRecharges(requestParameters);

    System.out.println(response);
  }
}

```

## requestRecharge

- HTTP Method: `POST`
- Endpoint: `/v3/mobilePhoneRecharges`

**Parameters**

| Name                              | Type                                                                                | Required | Description  |
| :-------------------------------- | :---------------------------------------------------------------------------------- | :------- | :----------- |
| mobilePhoneRechargeSaveRequestDto | [MobilePhoneRechargeSaveRequestDto](../models/MobilePhoneRechargeSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`MobilePhoneRechargeGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.MobilePhoneRechargeGetResponseDto;
import com.asaas.apisdk.models.MobilePhoneRechargeSaveRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    MobilePhoneRechargeSaveRequestDto mobilePhoneRechargeSaveRequestDto = MobilePhoneRechargeSaveRequestDto.builder()
      .value(15D)
      .phoneNumber("63997365512")
      .build();

    MobilePhoneRechargeGetResponseDto response = asaasSdk.mobilePhoneRecharge.requestRecharge(
      mobilePhoneRechargeSaveRequestDto
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

`MobilePhoneRechargeGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.MobilePhoneRechargeGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    MobilePhoneRechargeGetResponseDto response = asaasSdk.mobilePhoneRecharge.recoverASingleCellphoneRecharge(
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

`MobilePhoneRechargeGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.MobilePhoneRechargeGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    MobilePhoneRechargeGetResponseDto response = asaasSdk.mobilePhoneRecharge.cancelACellphoneRecharge(
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

`MobilePhoneRechargeFindProviderResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.MobilePhoneRechargeFindProviderResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    MobilePhoneRechargeFindProviderResponseDto response = asaasSdk.mobilePhoneRecharge.searchForCellPhoneProvider(
      "63997365512"
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
