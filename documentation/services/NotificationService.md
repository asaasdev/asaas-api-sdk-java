# NotificationService

A list of all methods in the `NotificationService` service. Click on the method name to view detailed information about that method.

| Methods                                                                   | Description                                                                                                                                                                                                                                                  |
| :------------------------------------------------------------------------ | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [updateExistingNotification](#updateexistingnotification)                 |                                                                                                                                                                                                                                                              |
| [updateExistingNotificationsInBatch](#updateexistingnotificationsinbatch) | It is possible to customize various notifications, regardless of the communication channel used (email, SMS, and voice) and who should receive the notification (you and/or your customer) by sending the customer's ID and the notifications to be updated. |

## updateExistingNotification

- HTTP Method: `PUT`
- Endpoint: `/v3/notifications/{id}`

**Parameters**

| Name                            | Type                                                                            | Required | Description                                         |
| :------------------------------ | :------------------------------------------------------------------------------ | :------- | :-------------------------------------------------- |
| id                              | String                                                                          | ✅       | Unique identifier of the notification to be updated |
| apiNotificationUpdateRequestDto | [ApiNotificationUpdateRequestDto](../models/ApiNotificationUpdateRequestDto.md) | ❌       | Request Body                                        |

**Return Type**

`ApiNotificationGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiNotificationGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiNotificationUpdateRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiNotificationUpdateRequestDtoScheduleOffset;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiNotificationUpdateRequestDto apiNotificationUpdateRequestDto = ApiNotificationUpdateRequestDto.builder()
      .enabled(true)
      .emailEnabledForProvider(true)
      .smsEnabledForProvider(true)
      .emailEnabledForCustomer(true)
      .smsEnabledForCustomer(true)
      .phoneCallEnabledForCustomer(true)
      .whatsappEnabledForCustomer(false)
      .scheduleOffset(ApiNotificationUpdateRequestDtoScheduleOffset._0)
      .build();

    ApiNotificationGetResponseDto response = asaasSdk.notification.updateExistingNotification(
      "not_wuGp97JeCr7G",
      apiNotificationUpdateRequestDto
    );

    System.out.println(response);
  }
}

```

## updateExistingNotificationsInBatch

It is possible to customize various notifications, regardless of the communication channel used (email, SMS, and voice) and who should receive the notification (you and/or your customer) by sending the customer's ID and the notifications to be updated.

- HTTP Method: `PUT`
- Endpoint: `/v3/notifications/batch`

**Parameters**

| Name                                 | Type                                                                                      | Required | Description  |
| :----------------------------------- | :---------------------------------------------------------------------------------------- | :------- | :----------- |
| apiNotificationBatchUpdateRequestDto | [ApiNotificationBatchUpdateRequestDto](../models/ApiNotificationBatchUpdateRequestDto.md) | ❌       | Request Body |

**Return Type**

`ApiNotificationBatchUpdateResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiNotificationBatchUpdateRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiNotificationBatchUpdateResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiNotificationUpdateRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiNotificationUpdateRequestDtoScheduleOffset;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiNotificationUpdateRequestDto apiNotificationUpdateRequestDto = ApiNotificationUpdateRequestDto.builder()
      .enabled(true)
      .emailEnabledForProvider(true)
      .smsEnabledForProvider(true)
      .emailEnabledForCustomer(true)
      .smsEnabledForCustomer(true)
      .phoneCallEnabledForCustomer(true)
      .whatsappEnabledForCustomer(false)
      .scheduleOffset(ApiNotificationUpdateRequestDtoScheduleOffset._0)
      .build();

    List<ApiNotificationUpdateRequestDto> notificationsList = Arrays.asList(apiNotificationUpdateRequestDto);

    ApiNotificationBatchUpdateRequestDto apiNotificationBatchUpdateRequestDto =
      ApiNotificationBatchUpdateRequestDto.builder()
        .customer("cus_000005401844")
        .notifications(notificationsList)
        .build();

    ApiNotificationBatchUpdateResponseDto response = asaasSdk.notification.updateExistingNotificationsInBatch(
      apiNotificationBatchUpdateRequestDto
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
