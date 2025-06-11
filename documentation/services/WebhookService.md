# WebhookService

A list of all methods in the `WebhookService` service. Click on the method name to view detailed information about that method.

| Methods                                           | Description                                                                  |
| :------------------------------------------------ | :--------------------------------------------------------------------------- |
| [listWebhooks](#listwebhooks)                     | Endpoint to list all Webhooks registered in your account.                    |
| [createNewWebhook](#createnewwebhook)             |                                                                              |
| [retrieveASingleWebhook](#retrieveasinglewebhook) | This endpoint retrieves a single webhook according to the provided ID.       |
| [updateExistingWebhook](#updateexistingwebhook)   | Use this endpoint to update information about an already registered webhook. |
| [removeWebhook](#removewebhook)                   | This endpoint removes a webhook.                                             |

## listWebhooks

Endpoint to list all Webhooks registered in your account.

- HTTP Method: `GET`
- Endpoint: `/v3/webhooks`

**Parameters**

| Name              | Type                                                          | Required | Description               |
| :---------------- | :------------------------------------------------------------ | :------- | :------------------------ |
| requestParameters | [ListWebhooksParameters](../models/ListWebhooksParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ApiPushNotificationConfigListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ApiPushNotificationConfigListResponseDto;
import com.asaas.apisdk.models.ListWebhooksParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListWebhooksParameters requestParameters = ListWebhooksParameters.builder().offset(5L).limit(10L).build();

    ApiPushNotificationConfigListResponseDto response = asaasSdk.webhook.listWebhooks(requestParameters);

    System.out.println(response);
  }
}

```

## createNewWebhook

- HTTP Method: `POST`
- Endpoint: `/v3/webhooks`

**Parameters**

| Name                                    | Type                                                                                            | Required | Description  |
| :-------------------------------------- | :---------------------------------------------------------------------------------------------- | :------- | :----------- |
| apiPushNotificationConfigSaveRequestDto | [ApiPushNotificationConfigSaveRequestDto](../models/ApiPushNotificationConfigSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`ApiPushNotificationConfigGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ApiPushNotificationConfigGetResponseDto;
import com.asaas.apisdk.models.ApiPushNotificationConfigSaveRequestDto;
import com.asaas.apisdk.models.ApiPushNotificationConfigSaveRequestPushNotificationSendType;
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

    ApiPushNotificationConfigGetResponseDto response = asaasSdk.webhook.createNewWebhook(
      apiPushNotificationConfigSaveRequestDto
    );

    System.out.println(response);
  }
}

```

## retrieveASingleWebhook

This endpoint retrieves a single webhook according to the provided ID.

- HTTP Method: `GET`
- Endpoint: `/v3/webhooks/{id}`

**Parameters**

| Name | Type   | Required | Description               |
| :--- | :----- | :------- | :------------------------ |
| id   | String | ✅       | Unique Webhook Identifier |

**Return Type**

`ApiPushNotificationConfigGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ApiPushNotificationConfigGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPushNotificationConfigGetResponseDto response = asaasSdk.webhook.retrieveASingleWebhook(
      "bbf67496-1379-4b6d-a348-fd5fa229f1c"
    );

    System.out.println(response);
  }
}

```

## updateExistingWebhook

Use this endpoint to update information about an already registered webhook.

- HTTP Method: `PUT`
- Endpoint: `/v3/webhooks/{id}`

**Parameters**

| Name                                      | Type                                                                                                | Required | Description               |
| :---------------------------------------- | :-------------------------------------------------------------------------------------------------- | :------- | :------------------------ |
| id                                        | String                                                                                              | ✅       | Unique Webhook Identifier |
| apiPushNotificationConfigUpdateRequestDto | [ApiPushNotificationConfigUpdateRequestDto](../models/ApiPushNotificationConfigUpdateRequestDto.md) | ❌       | Request Body              |

**Return Type**

`ApiPushNotificationConfigGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ApiPushNotificationConfigGetResponseDto;
import com.asaas.apisdk.models.ApiPushNotificationConfigUpdateRequestDto;
import com.asaas.apisdk.models.ApiPushNotificationConfigUpdateRequestPushNotificationSendType;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    List<String> eventsList = Arrays.asList("events");

    ApiPushNotificationConfigUpdateRequestDto apiPushNotificationConfigUpdateRequestDto =
      ApiPushNotificationConfigUpdateRequestDto.builder()
        .name("Name Example")
        .url("https://www.example.com/webhook/asaas")
        .sendType(ApiPushNotificationConfigUpdateRequestPushNotificationSendType.NON_SEQUENTIALLY)
        .enabled(true)
        .interrupted(true)
        .authToken("5tLxsL6uoN")
        .events(eventsList)
        .build();

    ApiPushNotificationConfigGetResponseDto response = asaasSdk.webhook.updateExistingWebhook(
      "bbf67496-1379-4b6d-a348-fd5fa229f1c",
      apiPushNotificationConfigUpdateRequestDto
    );

    System.out.println(response);
  }
}

```

## removeWebhook

This endpoint removes a webhook.

- HTTP Method: `DELETE`
- Endpoint: `/v3/webhooks/{id}`

**Parameters**

| Name | Type   | Required | Description               |
| :--- | :----- | :------- | :------------------------ |
| id   | String | ✅       | Unique Webhook Identifier |

**Return Type**

`ApiPushNotificationConfigDeleteResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ApiPushNotificationConfigDeleteResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPushNotificationConfigDeleteResponseDto response = asaasSdk.webhook.removeWebhook(
      "bbf67496-1379-4b6d-a348-fd5fa229f1c"
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
