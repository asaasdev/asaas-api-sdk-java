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

`WebhookConfigListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ListWebhooksParameters;
import com.asaas.apisdk.models.WebhookConfigListResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListWebhooksParameters requestParameters = ListWebhooksParameters.builder().offset(5L).limit(10L).build();

    WebhookConfigListResponseDto response = asaasSdk.webhook.listWebhooks(requestParameters);

    System.out.println(response);
  }
}

```

## createNewWebhook

- HTTP Method: `POST`
- Endpoint: `/v3/webhooks`

**Parameters**

| Name                        | Type                                                                    | Required | Description  |
| :-------------------------- | :---------------------------------------------------------------------- | :------- | :----------- |
| webhookConfigSaveRequestDto | [WebhookConfigSaveRequestDto](../models/WebhookConfigSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`WebhookConfigGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.WebhookConfigGetResponseDto;
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

    WebhookConfigGetResponseDto response = asaasSdk.webhook.createNewWebhook(webhookConfigSaveRequestDto);

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

`WebhookConfigGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.WebhookConfigGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    WebhookConfigGetResponseDto response = asaasSdk.webhook.retrieveASingleWebhook(
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

| Name                          | Type                                                                        | Required | Description               |
| :---------------------------- | :-------------------------------------------------------------------------- | :------- | :------------------------ |
| id                            | String                                                                      | ✅       | Unique Webhook Identifier |
| webhookConfigUpdateRequestDto | [WebhookConfigUpdateRequestDto](../models/WebhookConfigUpdateRequestDto.md) | ❌       | Request Body              |

**Return Type**

`WebhookConfigGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.WebhookConfigGetResponseDto;
import com.asaas.apisdk.models.WebhookConfigUpdateRequestDto;
import com.asaas.apisdk.models.WebhookConfigUpdateRequestWebhookEvent;
import com.asaas.apisdk.models.WebhookConfigUpdateRequestWebhookSendType;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    List<WebhookConfigUpdateRequestWebhookEvent> eventsList = Arrays.asList(
      WebhookConfigUpdateRequestWebhookEvent.PAYMENT_AUTHORIZED
    );

    WebhookConfigUpdateRequestDto webhookConfigUpdateRequestDto = WebhookConfigUpdateRequestDto.builder()
      .name("Name Example")
      .url("https://www.example.com/webhook/asaas")
      .sendType(WebhookConfigUpdateRequestWebhookSendType.NON_SEQUENTIALLY)
      .enabled(true)
      .interrupted(true)
      .authToken("5tLxsL6uoN")
      .events(eventsList)
      .build();

    WebhookConfigGetResponseDto response = asaasSdk.webhook.updateExistingWebhook(
      "bbf67496-1379-4b6d-a348-fd5fa229f1c",
      webhookConfigUpdateRequestDto
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

`WebhookConfigDeleteResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.WebhookConfigDeleteResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    WebhookConfigDeleteResponseDto response = asaasSdk.webhook.removeWebhook("bbf67496-1379-4b6d-a348-fd5fa229f1c");

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
