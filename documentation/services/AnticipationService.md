# AnticipationService

A list of all methods in the `AnticipationService` service. Click on the method name to view detailed information about that method.

| Methods                                                                         | Description |
| :------------------------------------------------------------------------------ | :---------- |
| [retrieveASingleAnticipation](#retrieveasingleanticipation)                     |             |
| [listAnticipations](#listanticipations)                                         |             |
| [requestAnticipation](#requestanticipation)                                     |             |
| [simulateAnticipation](#simulateanticipation)                                   |             |
| [retrieveStatusOfAutomaticAnticipation](#retrievestatusofautomaticanticipation) |             |
| [updateStatusOfAutomaticAnticipation](#updatestatusofautomaticanticipation)     |             |
| [retrieveAnticipationLimits](#retrieveanticipationlimits)                       |             |
| [cancelAnticipation](#cancelanticipation)                                       |             |

## retrieveASingleAnticipation

- HTTP Method: `GET`
- Endpoint: `/v3/anticipations/{id}`

**Parameters**

| Name | Type   | Required | Description                                |
| :--- | :----- | :------- | :----------------------------------------- |
| id   | String | ✅       | Unique identifier of anticipation in Asaas |

**Return Type**

`ApiReceivableAnticipationGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiReceivableAnticipationGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiReceivableAnticipationGetResponseDto response = asaasSdk.anticipation.retrieveASingleAnticipation("id");

    System.out.println(response);
  }
}

```

## listAnticipations

- HTTP Method: `GET`
- Endpoint: `/v3/anticipations`

**Parameters**

| Name              | Type                                                                    | Required | Description               |
| :---------------- | :---------------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [ListAnticipationsParameters](../models/ListAnticipationsParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ApiReceivableAnticipationListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiReceivableAnticipationListRequestReceivableAnticipationStatus;
import com.asaas.sdk.asaasjavasdk.models.ApiReceivableAnticipationListResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ListAnticipationsParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListAnticipationsParameters requestParameters = ListAnticipationsParameters.builder()
      .offset(6L)
      .limit(10L)
      .payment("payment")
      .installment("installment")
      .status(ApiReceivableAnticipationListRequestReceivableAnticipationStatus.PENDING)
      .build();

    ApiReceivableAnticipationListResponseDto response = asaasSdk.anticipation.listAnticipations(requestParameters);

    System.out.println(response);
  }
}

```

## requestAnticipation

- HTTP Method: `POST`
- Endpoint: `/v3/anticipations`

**Parameters**

| Name                                    | Type                                                                                            | Required | Description                    |
| :-------------------------------------- | :---------------------------------------------------------------------------------------------- | :------- | :----------------------------- |
| apiReceivableAnticipationSaveRequestDto | [ApiReceivableAnticipationSaveRequestDto](../models/ApiReceivableAnticipationSaveRequestDto.md) | ❌       | Request Body                   |
| \_filename                              | [String](../models/String.md)                                                                   | ❌       | Filename for the uploaded file |

**Return Type**

`ApiReceivableAnticipationGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiReceivableAnticipationGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiReceivableAnticipationSaveRequestDto;

public class Main {
    public static void main(String[] args) {
		AsaasSdkConfig config = AsaasSdkConfig.builder()
			.apiKeyAuthConfig(
				ApiKeyAuthConfig.builder()
					.apiKey("YOUR_API_KEY")
					.build()
			)
			.build();

		AsaasSdk asaasSdk = new AsaasSdk(config);

		ApiReceivableAnticipationSaveRequestDto apiReceivableAnticipationSaveRequestDto = ApiReceivableAnticipationSaveRequestDto.builder()
			.installment("installment")
			.payment("pay_626366773834")
			.documents(veniam in)
			.build();
		ApiReceivableAnticipationSaveRequestDto apiReceivableAnticipationSaveRequestDto = ApiReceivableAnticipationSaveRequestDto.builder()
			.installment("installment")
			.payment("pay_626366773834")
			.documents(veniam in)
			.build();

		ApiReceivableAnticipationGetResponseDto response = asaasSdk.anticipation.requestAnticipation(apiReceivableAnticipationSaveRequestDto, apiReceivableAnticipationSaveRequestDto);

		System.out.println(response);
    }
}
```

## simulateAnticipation

- HTTP Method: `POST`
- Endpoint: `/v3/anticipations/simulate`

**Parameters**

| Name                                        | Type                                                                                                    | Required | Description  |
| :------------------------------------------ | :------------------------------------------------------------------------------------------------------ | :------- | :----------- |
| apiReceivableAnticipationSimulateRequestDto | [ApiReceivableAnticipationSimulateRequestDto](../models/ApiReceivableAnticipationSimulateRequestDto.md) | ❌       | Request Body |

**Return Type**

`ApiReceivableAnticipationSimulateResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiReceivableAnticipationSimulateRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiReceivableAnticipationSimulateResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiReceivableAnticipationSimulateRequestDto apiReceivableAnticipationSimulateRequestDto =
      ApiReceivableAnticipationSimulateRequestDto.builder()
        .installment("installment")
        .payment("pay_626366773834")
        .build();

    ApiReceivableAnticipationSimulateResponseDto response = asaasSdk.anticipation.simulateAnticipation(
      apiReceivableAnticipationSimulateRequestDto
    );

    System.out.println(response);
  }
}

```

## retrieveStatusOfAutomaticAnticipation

- HTTP Method: `GET`
- Endpoint: `/v3/anticipations/configurations`

**Return Type**

`ApiReceivableAnticipationConfigurationGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiReceivableAnticipationConfigurationGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiReceivableAnticipationConfigurationGetResponseDto response =
      asaasSdk.anticipation.retrieveStatusOfAutomaticAnticipation();

    System.out.println(response);
  }
}

```

## updateStatusOfAutomaticAnticipation

- HTTP Method: `PUT`
- Endpoint: `/v3/anticipations/configurations`

**Parameters**

| Name                                                   | Type                                                                                                                          | Required | Description  |
| :----------------------------------------------------- | :---------------------------------------------------------------------------------------------------------------------------- | :------- | :----------- |
| apiReceivableAnticipationConfigurationUpdateRequestDto | [ApiReceivableAnticipationConfigurationUpdateRequestDto](../models/ApiReceivableAnticipationConfigurationUpdateRequestDto.md) | ❌       | Request Body |

**Return Type**

`ApiReceivableAnticipationConfigurationGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiReceivableAnticipationConfigurationGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiReceivableAnticipationConfigurationUpdateRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiReceivableAnticipationConfigurationUpdateRequestDto apiReceivableAnticipationConfigurationUpdateRequestDto =
      ApiReceivableAnticipationConfigurationUpdateRequestDto.builder().creditCardAutomaticEnabled(true).build();

    ApiReceivableAnticipationConfigurationGetResponseDto response =
      asaasSdk.anticipation.updateStatusOfAutomaticAnticipation(apiReceivableAnticipationConfigurationUpdateRequestDto);

    System.out.println(response);
  }
}

```

## retrieveAnticipationLimits

- HTTP Method: `GET`
- Endpoint: `/v3/anticipations/limits`

**Return Type**

`ApiReceivableAnticipationLimitsResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiReceivableAnticipationLimitsResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiReceivableAnticipationLimitsResponseDto response = asaasSdk.anticipation.retrieveAnticipationLimits();

    System.out.println(response);
  }
}

```

## cancelAnticipation

- HTTP Method: `POST`
- Endpoint: `/v3/anticipations/{id}/cancel`

**Parameters**

| Name                                      | Type                                                                                                | Required | Description                                |
| :---------------------------------------- | :-------------------------------------------------------------------------------------------------- | :------- | :----------------------------------------- |
| id                                        | String                                                                                              | ✅       | Unique identifier of anticipation in Asaas |
| apiReceivableAnticipationPathIdRequestDto | [ApiReceivableAnticipationPathIdRequestDto](../models/ApiReceivableAnticipationPathIdRequestDto.md) | ❌       | Request Body                               |

**Return Type**

`ApiReceivableAnticipationGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiReceivableAnticipationGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiReceivableAnticipationPathIdRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiReceivableAnticipationPathIdRequestDto apiReceivableAnticipationPathIdRequestDto =
      ApiReceivableAnticipationPathIdRequestDto.builder().id("id").build();

    ApiReceivableAnticipationGetResponseDto response = asaasSdk.anticipation.cancelAnticipation(
      "id",
      apiReceivableAnticipationPathIdRequestDto
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
