# NotificationGetResponseDto

List of notification information

**Properties**

| Name                        | Type                                     | Required | Description                                                                                                                                          |
| :-------------------------- | :--------------------------------------- | :------- | :--------------------------------------------------------------------------------------------------------------------------------------------------- |
| object                      | String                                   | ❌       | Object type                                                                                                                                          |
| id                          | String                                   | ❌       | Unique notification identifier                                                                                                                       |
| customer                    | String                                   | ❌       | Unique customer identifier                                                                                                                           |
| enabled                     | Boolean                                  | ❌       | Indicates whether notification is enabled                                                                                                            |
| emailEnabledForProvider     | Boolean                                  | ❌       | Indicates whether the email sent to you is enabled or disabled                                                                                       |
| smsEnabledForProvider       | Boolean                                  | ❌       | Indicates whether the SMS sent to you is enabled or disabled                                                                                         |
| emailEnabledForCustomer     | Boolean                                  | ❌       | Indicates whether the email sent to the customer is enabled or disabled                                                                              |
| smsEnabledForCustomer       | Boolean                                  | ❌       | Indicates whether the SMS sent to the customer is enabled or disabled                                                                                |
| phoneCallEnabledForCustomer | Boolean                                  | ❌       | Indicates whether voice notification to the customer is enabled or disabled                                                                          |
| whatsappEnabledForCustomer  | Boolean                                  | ❌       | Indicates whether the WhatsApp notification sent to the customer is enabled or disabled                                                              |
| event                       | NotificationGetResponseNotificationEvent | ❌       | Kind of event                                                                                                                                        |
| scheduleOffset              | NotificationGetResponseDtoScheduleOffset | ❌       | Specifies how many days before the due date the notification must be sent. Valid only for the `PAYMENT_DUEDATE_WARNING` and `PAYMENT_OVERDUE` events |
| deleted                     | Boolean                                  | ❌       | Indicates whether the notification was deleted                                                                                                       |

<!-- This file was generated by liblab | https://liblab.com/ -->
