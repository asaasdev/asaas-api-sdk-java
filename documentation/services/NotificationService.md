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

| Name                         | Type                                                                      | Required | Description                                         |
| :--------------------------- | :------------------------------------------------------------------------ | :------- | :-------------------------------------------------- |
| id                           | String                                                                    | ✅       | Unique identifier of the notification to be updated |
| notificationUpdateRequestDto | [NotificationUpdateRequestDto](../models/NotificationUpdateRequestDto.md) | ❌       | Request Body                                        |

**Return Type**

`NotificationGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.NotificationGetResponseDto;
import com.asaas.apisdk.models.NotificationUpdateRequestDto;
import com.asaas.apisdk.models.NotificationUpdateRequestDtoScheduleOffset;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    NotificationUpdateRequestDto notificationUpdateRequestDto = NotificationUpdateRequestDto.builder()
      .enabled(true)
      .emailEnabledForProvider(true)
      .smsEnabledForProvider(true)
      .emailEnabledForCustomer(true)
      .smsEnabledForCustomer(true)
      .phoneCallEnabledForCustomer(true)
      .whatsappEnabledForCustomer(false)
      .scheduleOffset(NotificationUpdateRequestDtoScheduleOffset._0)
      .build();

    NotificationGetResponseDto response = asaasSdk.notification.updateExistingNotification(
      "not_wuGp97JeCr7G",
      notificationUpdateRequestDto
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

| Name                              | Type                                                                                | Required | Description  |
| :-------------------------------- | :---------------------------------------------------------------------------------- | :------- | :----------- |
| notificationBatchUpdateRequestDto | [NotificationBatchUpdateRequestDto](../models/NotificationBatchUpdateRequestDto.md) | ❌       | Request Body |

**Return Type**

`NotificationBatchUpdateResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.NotificationBatchUpdateRequestDto;
import com.asaas.apisdk.models.NotificationBatchUpdateResponseDto;
import com.asaas.apisdk.models.NotificationUpdateRequestDto;
import com.asaas.apisdk.models.NotificationUpdateRequestDtoScheduleOffset;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    NotificationUpdateRequestDto notificationUpdateRequestDto = NotificationUpdateRequestDto.builder()
      .enabled(true)
      .emailEnabledForProvider(true)
      .smsEnabledForProvider(true)
      .emailEnabledForCustomer(true)
      .smsEnabledForCustomer(true)
      .phoneCallEnabledForCustomer(true)
      .whatsappEnabledForCustomer(false)
      .scheduleOffset(NotificationUpdateRequestDtoScheduleOffset._0)
      .build();

    List<NotificationUpdateRequestDto> notificationsList = Arrays.asList(notificationUpdateRequestDto);

    NotificationBatchUpdateRequestDto notificationBatchUpdateRequestDto = NotificationBatchUpdateRequestDto.builder()
      .customer("cus_000005401844")
      .notifications(notificationsList)
      .build();

    NotificationBatchUpdateResponseDto response = asaasSdk.notification.updateExistingNotificationsInBatch(
      notificationBatchUpdateRequestDto
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
