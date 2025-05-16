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

`ListWebhooksOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ListWebhooksOkResponse;
import com.asaas.sdk.asaasjavasdk.models.ListWebhooksParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListWebhooksParameters requestParameters = ListWebhooksParameters.builder().offset(8L).limit(10L).build();

    ListWebhooksOkResponse response = asaasSdk.webhook.listWebhooks(requestParameters);

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
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPushNotificationConfigGetResponseDto;
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
        .interrupted(false)
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

`RetrieveASingleWebhookOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.RetrieveASingleWebhookOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    RetrieveASingleWebhookOkResponse response = asaasSdk.webhook.retrieveASingleWebhook(
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

| Name                         | Type                                                                      | Required | Description               |
| :--------------------------- | :------------------------------------------------------------------------ | :------- | :------------------------ |
| id                           | String                                                                    | ✅       | Unique Webhook Identifier |
| updateExistingWebhookRequest | [UpdateExistingWebhookRequest](../models/UpdateExistingWebhookRequest.md) | ❌       | Request Body              |

**Return Type**

`ApiPushNotificationConfigGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPushNotificationConfigGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPushNotificationConfigUpdateRequestPushNotificationSendType;
import com.asaas.sdk.asaasjavasdk.models.UpdateExistingWebhookRequest;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    List<String> eventsList = Arrays.asList("events");

    UpdateExistingWebhookRequest updateExistingWebhookRequest = UpdateExistingWebhookRequest.builder()
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
      updateExistingWebhookRequest
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

`RemoveWebhookOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.RemoveWebhookOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    RemoveWebhookOkResponse response = asaasSdk.webhook.removeWebhook("bbf67496-1379-4b6d-a348-fd5fa229f1c");

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
