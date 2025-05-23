# RecurringPixService

A list of all methods in the `RecurringPixService` service. Click on the method name to view detailed information about that method.

| Methods                                                 | Description |
| :------------------------------------------------------ | :---------- |
| [listRecurrences](#listrecurrences)                     |             |
| [retrieveASingleRecurrence](#retrieveasinglerecurrence) |             |
| [cancelARecurrence](#cancelarecurrence)                 |             |
| [listRecurrenceItems](#listrecurrenceitems)             |             |
| [cancelARecurrenceItem](#cancelarecurrenceitem)         |             |

## listRecurrences

- HTTP Method: `GET`
- Endpoint: `/v3/pix/transactions/recurrings`

**Parameters**

| Name              | Type                                                                | Required | Description               |
| :---------------- | :------------------------------------------------------------------ | :------- | :------------------------ |
| requestParameters | [ListRecurrencesParameters](../models/ListRecurrencesParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ApiPixTransactionRecurringCheckoutScheduleListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPixTransactionRecurringCheckoutScheduleListRequestRecurringCheckoutScheduleStatus;
import com.asaas.sdk.asaasjavasdk.models.ApiPixTransactionRecurringCheckoutScheduleListResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ListRecurrencesParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListRecurrencesParameters requestParameters = ListRecurrencesParameters.builder()
      .offset(7L)
      .limit(10L)
      .status(
        ApiPixTransactionRecurringCheckoutScheduleListRequestRecurringCheckoutScheduleStatus.AWAITING_CRITICAL_ACTION_AUTHORIZATION
      )
      .value(100D)
      .searchText("searchText")
      .build();

    ApiPixTransactionRecurringCheckoutScheduleListResponseDto response = asaasSdk.recurringPix.listRecurrences(
      requestParameters
    );

    System.out.println(response);
  }
}

```

## retrieveASingleRecurrence

- HTTP Method: `GET`
- Endpoint: `/v3/pix/transactions/recurrings/{id}`

**Parameters**

| Name | Type   | Required | Description                           |
| :--- | :----- | :------- | :------------------------------------ |
| id   | String | ✅       | Unique recurrence identifier in Asaas |

**Return Type**

`ApiPixTransactionRecurringCheckoutScheduleGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPixTransactionRecurringCheckoutScheduleGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPixTransactionRecurringCheckoutScheduleGetResponseDto response = asaasSdk.recurringPix.retrieveASingleRecurrence(
      "35363f6e-93e2-11ec-b9d9-96f4053b1bd4"
    );

    System.out.println(response);
  }
}

```

## cancelARecurrence

- HTTP Method: `POST`
- Endpoint: `/v3/pix/transactions/recurrings/{id}/cancel`

**Parameters**

| Name                                                       | Type                                                                                                                                  | Required | Description                           |
| :--------------------------------------------------------- | :------------------------------------------------------------------------------------------------------------------------------------ | :------- | :------------------------------------ |
| id                                                         | String                                                                                                                                | ✅       | Unique recurrence identifier in Asaas |
| apiPixTransactionRecurringCheckoutSchedulePathIdRequestDto | [ApiPixTransactionRecurringCheckoutSchedulePathIdRequestDto](../models/ApiPixTransactionRecurringCheckoutSchedulePathIdRequestDto.md) | ❌       | Request Body                          |

**Return Type**

`ApiPixTransactionRecurringCheckoutScheduleGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPixTransactionRecurringCheckoutScheduleGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPixTransactionRecurringCheckoutSchedulePathIdRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPixTransactionRecurringCheckoutSchedulePathIdRequestDto apiPixTransactionRecurringCheckoutSchedulePathIdRequestDto =
      ApiPixTransactionRecurringCheckoutSchedulePathIdRequestDto.builder()
        .id("35363f6e-93e2-11ec-b9d9-96f4053b1bd4")
        .build();

    ApiPixTransactionRecurringCheckoutScheduleGetResponseDto response = asaasSdk.recurringPix.cancelARecurrence(
      "35363f6e-93e2-11ec-b9d9-96f4053b1bd4",
      apiPixTransactionRecurringCheckoutSchedulePathIdRequestDto
    );

    System.out.println(response);
  }
}

```

## listRecurrenceItems

- HTTP Method: `GET`
- Endpoint: `/v3/pix/transactions/recurrings/{id}/items`

**Parameters**

| Name              | Type                                                                        | Required | Description                           |
| :---------------- | :-------------------------------------------------------------------------- | :------- | :------------------------------------ |
| id                | String                                                                      | ✅       | Unique recurrence identifier in Asaas |
| requestParameters | [ListRecurrenceItemsParameters](../models/ListRecurrenceItemsParameters.md) | ❌       | Request Parameters Object             |

**Return Type**

`ApiPixTransactionRecurringCheckoutScheduleListItemsResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPixTransactionRecurringCheckoutScheduleListItemsResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ListRecurrenceItemsParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListRecurrenceItemsParameters requestParameters = ListRecurrenceItemsParameters.builder()
      .offset(6L)
      .limit(10L)
      .build();

    ApiPixTransactionRecurringCheckoutScheduleListItemsResponseDto response = asaasSdk.recurringPix.listRecurrenceItems(
      "35363f6e-93e2-11ec-b9d9-96f4053b1bd4",
      requestParameters
    );

    System.out.println(response);
  }
}

```

## cancelARecurrenceItem

- HTTP Method: `POST`
- Endpoint: `/v3/pix/transactions/recurrings/items/{id}/cancel`

**Parameters**

| Name                                                           | Type                                                                                                                                          | Required | Description                                |
| :------------------------------------------------------------- | :-------------------------------------------------------------------------------------------------------------------------------------------- | :------- | :----------------------------------------- |
| id                                                             | String                                                                                                                                        | ✅       | Unique recurrence item identifier in Asaas |
| apiPixTransactionRecurringCheckoutScheduleCancelItemRequestDto | [ApiPixTransactionRecurringCheckoutScheduleCancelItemRequestDto](../models/ApiPixTransactionRecurringCheckoutScheduleCancelItemRequestDto.md) | ❌       | Request Body                               |

**Return Type**

`ApiPixTransactionRecurringCheckoutScheduleGetItemResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPixTransactionRecurringCheckoutScheduleCancelItemRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPixTransactionRecurringCheckoutScheduleGetItemResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPixTransactionRecurringCheckoutScheduleCancelItemRequestDto apiPixTransactionRecurringCheckoutScheduleCancelItemRequestDto =
      ApiPixTransactionRecurringCheckoutScheduleCancelItemRequestDto.builder()
        .id("71ae9d73-468f-4d04-8b87-a541128f9c46")
        .build();

    ApiPixTransactionRecurringCheckoutScheduleGetItemResponseDto response = asaasSdk.recurringPix.cancelARecurrenceItem(
      "71ae9d73-468f-4d04-8b87-a541128f9c46",
      apiPixTransactionRecurringCheckoutScheduleCancelItemRequestDto
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
