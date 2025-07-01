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

`AccountListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.AccountListResponseDto;
import com.asaas.apisdk.models.ListSubaccountsParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListSubaccountsParameters requestParameters = ListSubaccountsParameters.builder()
      .offset(6L)
      .limit(10L)
      .cpfCnpj("cpfCnpj")
      .email("email")
      .name("name")
      .walletId("walletId")
      .build();

    AccountListResponseDto response = asaasSdk.subaccount.listSubaccounts(requestParameters);

    System.out.println(response);
  }
}

```

## createSubaccount

- HTTP Method: `POST`
- Endpoint: `/v3/accounts`

**Parameters**

| Name                  | Type                                                        | Required | Description  |
| :-------------------- | :---------------------------------------------------------- | :------- | :----------- |
| accountSaveRequestDto | [AccountSaveRequestDto](../models/AccountSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`AccountSaveResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.AccountSaveRequestCompanyType;
import com.asaas.apisdk.models.AccountSaveRequestDto;
import com.asaas.apisdk.models.AccountSaveResponseDto;
import com.asaas.apisdk.models.WebhookConfigSaveRequestDto;
import com.asaas.apisdk.models.WebhookConfigSaveRequestWebhookEvent;
import com.asaas.apisdk.models.WebhookConfigSaveRequestWebhookSendType;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    List<WebhookConfigSaveRequestWebhookEvent> eventsList = Arrays.asList(
      WebhookConfigSaveRequestWebhookEvent.PAYMENT_AUTHORIZED
    );

    WebhookConfigSaveRequestDto webhookConfigSaveRequestDto = WebhookConfigSaveRequestDto.builder()
      .name("Name Example")
      .url("https://www.example.com/webhook/asaas")
      .email("john.doe@asaas.com.br")
      .enabled(true)
      .interrupted(true)
      .apiVersion(3L)
      .authToken("5tLxsL6uoN")
      .sendType(WebhookConfigSaveRequestWebhookSendType.NON_SEQUENTIALLY)
      .events(eventsList)
      .build();

    List<WebhookConfigSaveRequestDto> webhooksList = Arrays.asList(webhookConfigSaveRequestDto);

    AccountSaveRequestDto accountSaveRequestDto = AccountSaveRequestDto.builder()
      .name("John Doe")
      .email("john.doe@asaas.com.br")
      .loginEmail("johndoe@asaas.com.br")
      .cpfCnpj("35381637000150")
      .birthDate("1995-04-12")
      .companyType(AccountSaveRequestCompanyType.MEI)
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

    AccountSaveResponseDto response = asaasSdk.subaccount.createSubaccount(accountSaveRequestDto);

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

`AccountGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.AccountGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    AccountGetResponseDto response = asaasSdk.subaccount.retrieveASingleSubaccount(
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

`AccountPaymentEscrowConfigDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.AccountPaymentEscrowConfigDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    AccountPaymentEscrowConfigDto response = asaasSdk.subaccount.reteriveEscrowAccountConfigurationForSubaccount(
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

| Name                                             | Type                                                                                                              | Required | Description                           |
| :----------------------------------------------- | :---------------------------------------------------------------------------------------------------------------- | :------- | :------------------------------------ |
| id                                               | String                                                                                                            | ✅       | Unique subaccount identifier in Asaas |
| accountSaveOrUpdatePaymentEscrowConfigRequestDto | [AccountSaveOrUpdatePaymentEscrowConfigRequestDto](../models/AccountSaveOrUpdatePaymentEscrowConfigRequestDto.md) | ❌       | Request Body                          |

**Return Type**

`AccountPaymentEscrowConfigDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.AccountPaymentEscrowConfigDto;
import com.asaas.apisdk.models.AccountSaveOrUpdatePaymentEscrowConfigRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    AccountSaveOrUpdatePaymentEscrowConfigRequestDto accountSaveOrUpdatePaymentEscrowConfigRequestDto =
      AccountSaveOrUpdatePaymentEscrowConfigRequestDto.builder()
        .daysToExpire(30L)
        .enabled(true)
        .isFeePayer(false)
        .build();

    AccountPaymentEscrowConfigDto response = asaasSdk.subaccount.saveOrUpdateEscrowAccountConfigurationForSubaccount(
      "4f468235-cec3-482f-b3d0-348af4c7194",
      accountSaveOrUpdatePaymentEscrowConfigRequestDto
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
