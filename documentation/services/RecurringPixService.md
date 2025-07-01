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

`PixRecurringTransactionListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ListRecurrencesParameters;
import com.asaas.apisdk.models.PixRecurringTransactionListResponseDto;
import com.asaas.apisdk.models.RecurringPixTransactionListRequestPixRecurringTransactionStatus;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListRecurrencesParameters requestParameters = ListRecurrencesParameters.builder()
      .offset(6L)
      .limit(10L)
      .status(RecurringPixTransactionListRequestPixRecurringTransactionStatus.AWAITING_CRITICAL_ACTION_AUTHORIZATION)
      .value(100D)
      .searchText("searchText")
      .build();

    PixRecurringTransactionListResponseDto response = asaasSdk.recurringPix.listRecurrences(requestParameters);

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

`PixRecurringTransactionGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PixRecurringTransactionGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PixRecurringTransactionGetResponseDto response = asaasSdk.recurringPix.retrieveASingleRecurrence(
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

| Name  | Type   | Required | Description                           |
| :---- | :----- | :------- | :------------------------------------ |
| id    | String | ✅       | Unique recurrence identifier in Asaas |
| input | Object | ❌       | Request Body                          |

**Return Type**

`PixRecurringTransactionGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PixRecurringTransactionGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PixRecurringTransactionGetResponseDto response = asaasSdk.recurringPix.cancelARecurrence(
      "35363f6e-93e2-11ec-b9d9-96f4053b1bd4",
      new Object()
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

`RecurringPixTransactionListItemsResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ListRecurrenceItemsParameters;
import com.asaas.apisdk.models.RecurringPixTransactionListItemsResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListRecurrenceItemsParameters requestParameters = ListRecurrenceItemsParameters.builder()
      .offset(3L)
      .limit(10L)
      .build();

    RecurringPixTransactionListItemsResponseDto response = asaasSdk.recurringPix.listRecurrenceItems(
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

| Name  | Type   | Required | Description                                |
| :---- | :----- | :------- | :----------------------------------------- |
| id    | String | ✅       | Unique recurrence item identifier in Asaas |
| input | Object | ❌       | Request Body                               |

**Return Type**

`PixRecurringTransactionGetItemResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PixRecurringTransactionGetItemResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PixRecurringTransactionGetItemResponseDto response = asaasSdk.recurringPix.cancelARecurrenceItem(
      "71ae9d73-468f-4d04-8b87-a541128f9c46",
      new Object()
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
