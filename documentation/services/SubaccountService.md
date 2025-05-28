# SubaccountService

A list of all methods in the `SubaccountService` service. Click on the method name to view detailed information about that method.

| Methods                                                                                                     | Description |
| :---------------------------------------------------------------------------------------------------------- | :---------- |
| [listSubaccounts](#listsubaccounts)                                                                         |             |
| [createSubaccount](#createsubaccount)                                                                       |             |
| [retrieveASingleSubaccount](#retrieveasinglesubaccount)                                                     |             |
| [reteriveEscrowAccountConfigurationForSubaccount](#reteriveescrowaccountconfigurationforsubaccount)         |             |
| [saveOrUpdateEscrowAccountConfigurationForSubaccount](#saveorupdateescrowaccountconfigurationforsubaccount) |             |

## listSubaccounts

- HTTP Method: `GET`
- Endpoint: `/v3/accounts`

**Parameters**

| Name              | Type                                                                | Required | Description               |
| :---------------- | :------------------------------------------------------------------ | :------- | :------------------------ |
| requestParameters | [ListSubaccountsParameters](../models/ListSubaccountsParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ApiCustomerListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerListResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ListSubaccountsParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListSubaccountsParameters requestParameters = ListSubaccountsParameters.builder()
      .offset(0L)
      .limit(10L)
      .cpfCnpj("cpfCnpj")
      .email("email")
      .name("name")
      .walletId("walletId")
      .build();

    ApiCustomerListResponseDto response = asaasSdk.subaccount.listSubaccounts(requestParameters);

    System.out.println(response);
  }
}

```

## createSubaccount

- HTTP Method: `POST`
- Endpoint: `/v3/accounts`

**Parameters**

| Name                      | Type                                                                | Required | Description  |
| :------------------------ | :------------------------------------------------------------------ | :------- | :----------- |
| apiCustomerSaveRequestDto | [ApiCustomerSaveRequestDto](../models/ApiCustomerSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`ApiCustomerSaveResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerSaveRequestCompanyType;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerSaveRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerSaveResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPushNotificationConfigSaveRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPushNotificationConfigSaveRequestPushNotificationSendType;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    List<String> eventsList = Arrays.asList("events");

    ApiPushNotificationConfigSaveRequestDto apiPushNotificationConfigSaveRequestDto =
      ApiPushNotificationConfigSaveRequestDto.builder()
        .name("Name Example")
        .url("https://www.example.com/webhook/asaas")
        .email("john.doe@asaas.com.br")
        .enabled(true)
        .interrupted(true)
        .apiVersion(3L)
        .authToken("5tLxsL6uoN")
        .sendType(ApiPushNotificationConfigSaveRequestPushNotificationSendType.NON_SEQUENTIALLY)
        .events(eventsList)
        .build();

    List<ApiPushNotificationConfigSaveRequestDto> webhooksList = Arrays.asList(apiPushNotificationConfigSaveRequestDto);

    ApiCustomerSaveRequestDto apiCustomerSaveRequestDto = ApiCustomerSaveRequestDto.builder()
      .name("John Doe")
      .email("john.doe@asaas.com.br")
      .loginEmail("johndoe@asaas.com.br")
      .cpfCnpj("35381637000150")
      .birthDate("1995-04-12")
      .companyType(ApiCustomerSaveRequestCompanyType.MEI)
      .phone("phone")
      .mobilePhone("mobilePhone")
      .site("https://www.example.com")
      .incomeValue(25000D)
      .address("Rua Fernando Orlandi")
      .addressNumber("544")
      .complement("complement")
      .province("Jardim Pedra Branca")
      .postalCode("14079-452")
      .webhooks(webhooksList)
      .build();

    ApiCustomerSaveResponseDto response = asaasSdk.subaccount.createSubaccount(apiCustomerSaveRequestDto);

    System.out.println(response);
  }
}

```

## retrieveASingleSubaccount

- HTTP Method: `GET`
- Endpoint: `/v3/accounts/{id}`

**Parameters**

| Name | Type   | Required | Description                           |
| :--- | :----- | :------- | :------------------------------------ |
| id   | String | ✅       | Unique subaccount identifier in Asaas |

**Return Type**

`ApiCustomerGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiCustomerGetResponseDto response = asaasSdk.subaccount.retrieveASingleSubaccount(
      "4f468235-cec3-482f-b3d0-348af4c7194"
    );

    System.out.println(response);
  }
}

```

## reteriveEscrowAccountConfigurationForSubaccount

- HTTP Method: `GET`
- Endpoint: `/v3/accounts/{id}/escrow`

**Parameters**

| Name | Type   | Required | Description                           |
| :--- | :----- | :------- | :------------------------------------ |
| id   | String | ✅       | Unique subaccount identifier in Asaas |

**Return Type**

`ApiCustomerPaymentCustodyConfigDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerPaymentCustodyConfigDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiCustomerPaymentCustodyConfigDto response = asaasSdk.subaccount.reteriveEscrowAccountConfigurationForSubaccount(
      "4f468235-cec3-482f-b3d0-348af4c7194"
    );

    System.out.println(response);
  }
}

```

## saveOrUpdateEscrowAccountConfigurationForSubaccount

- HTTP Method: `POST`
- Endpoint: `/v3/accounts/{id}/escrow`

**Parameters**

| Name                                                  | Type                                                                                                                        | Required | Description                           |
| :---------------------------------------------------- | :-------------------------------------------------------------------------------------------------------------------------- | :------- | :------------------------------------ |
| id                                                    | String                                                                                                                      | ✅       | Unique subaccount identifier in Asaas |
| apiCustomerSaveOrUpdatePaymentCustodyConfigRequestDto | [ApiCustomerSaveOrUpdatePaymentCustodyConfigRequestDto](../models/ApiCustomerSaveOrUpdatePaymentCustodyConfigRequestDto.md) | ❌       | Request Body                          |

**Return Type**

`ApiCustomerPaymentCustodyConfigDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerPaymentCustodyConfigDto;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerSaveOrUpdatePaymentCustodyConfigRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiCustomerSaveOrUpdatePaymentCustodyConfigRequestDto apiCustomerSaveOrUpdatePaymentCustodyConfigRequestDto =
      ApiCustomerSaveOrUpdatePaymentCustodyConfigRequestDto.builder()
        .daysToExpire(30L)
        .enabled(true)
        .isFeePayer(false)
        .build();

    ApiCustomerPaymentCustodyConfigDto response =
      asaasSdk.subaccount.saveOrUpdateEscrowAccountConfigurationForSubaccount(
        "4f468235-cec3-482f-b3d0-348af4c7194",
        apiCustomerSaveOrUpdatePaymentCustodyConfigRequestDto
      );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
