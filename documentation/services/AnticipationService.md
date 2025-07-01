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

`AnticipationGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.AnticipationGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    AnticipationGetResponseDto response = asaasSdk.anticipation.retrieveASingleAnticipation("id");

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

`AnticipationListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.AnticipationListRequestAnticipationStatus;
import com.asaas.apisdk.models.AnticipationListResponseDto;
import com.asaas.apisdk.models.ListAnticipationsParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListAnticipationsParameters requestParameters = ListAnticipationsParameters.builder()
      .offset(0L)
      .limit(10L)
      .payment("payment")
      .installment("installment")
      .status(AnticipationListRequestAnticipationStatus.PENDING)
      .build();

    AnticipationListResponseDto response = asaasSdk.anticipation.listAnticipations(requestParameters);

    System.out.println(response);
  }
}

```

## requestAnticipation

- HTTP Method: `POST`
- Endpoint: `/v3/anticipations`

**Parameters**

| Name                       | Type                                                                  | Required | Description                    |
| :------------------------- | :-------------------------------------------------------------------- | :------- | :----------------------------- |
| anticipationSaveRequestDto | [AnticipationSaveRequestDto](../models/AnticipationSaveRequestDto.md) | ❌       | Request Body                   |
| \_filename                 | [String](../models/String.md)                                         | ✅       | Filename for the uploaded file |

**Return Type**

`AnticipationGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.AnticipationGetResponseDto;
import com.asaas.apisdk.models.AnticipationSaveRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    AnticipationSaveRequestDto anticipationSaveRequestDto = AnticipationSaveRequestDto.builder()
      .installment("installment")
      .payment("pay_626366773834")
      .documents(offic)
      .build();
    AnticipationSaveRequestDto anticipationSaveRequestDto = AnticipationSaveRequestDto.builder()
      .installment("installment")
      .payment("pay_626366773834")
      .documents(offic)
      .build();

    AnticipationGetResponseDto response = asaasSdk.anticipation.requestAnticipation(
      anticipationSaveRequestDto,
      anticipationSaveRequestDto
    );

    System.out.println(response);
  }
}

```

## simulateAnticipation

- HTTP Method: `POST`
- Endpoint: `/v3/anticipations/simulate`

**Parameters**

| Name                           | Type                                                                          | Required | Description  |
| :----------------------------- | :---------------------------------------------------------------------------- | :------- | :----------- |
| anticipationSimulateRequestDto | [AnticipationSimulateRequestDto](../models/AnticipationSimulateRequestDto.md) | ❌       | Request Body |

**Return Type**

`AnticipationSimulateResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.AnticipationSimulateRequestDto;
import com.asaas.apisdk.models.AnticipationSimulateResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    AnticipationSimulateRequestDto anticipationSimulateRequestDto = AnticipationSimulateRequestDto.builder()
      .installment("installment")
      .payment("pay_626366773834")
      .build();

    AnticipationSimulateResponseDto response = asaasSdk.anticipation.simulateAnticipation(
      anticipationSimulateRequestDto
    );

    System.out.println(response);
  }
}

```

## retrieveStatusOfAutomaticAnticipation

- HTTP Method: `GET`
- Endpoint: `/v3/anticipations/configurations`

**Return Type**

`AnticipationConfigurationGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.AnticipationConfigurationGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    AnticipationConfigurationGetResponseDto response = asaasSdk.anticipation.retrieveStatusOfAutomaticAnticipation();

    System.out.println(response);
  }
}

```

## updateStatusOfAutomaticAnticipation

- HTTP Method: `PUT`
- Endpoint: `/v3/anticipations/configurations`

**Parameters**

| Name                                      | Type                                                                                                | Required | Description  |
| :---------------------------------------- | :-------------------------------------------------------------------------------------------------- | :------- | :----------- |
| anticipationConfigurationUpdateRequestDto | [AnticipationConfigurationUpdateRequestDto](../models/AnticipationConfigurationUpdateRequestDto.md) | ❌       | Request Body |

**Return Type**

`AnticipationConfigurationGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.AnticipationConfigurationGetResponseDto;
import com.asaas.apisdk.models.AnticipationConfigurationUpdateRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    AnticipationConfigurationUpdateRequestDto anticipationConfigurationUpdateRequestDto =
      AnticipationConfigurationUpdateRequestDto.builder().creditCardAutomaticEnabled(true).build();

    AnticipationConfigurationGetResponseDto response = asaasSdk.anticipation.updateStatusOfAutomaticAnticipation(
      anticipationConfigurationUpdateRequestDto
    );

    System.out.println(response);
  }
}

```

## retrieveAnticipationLimits

- HTTP Method: `GET`
- Endpoint: `/v3/anticipations/limits`

**Return Type**

`AnticipationLimitsResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.AnticipationLimitsResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    AnticipationLimitsResponseDto response = asaasSdk.anticipation.retrieveAnticipationLimits();

    System.out.println(response);
  }
}

```

## cancelAnticipation

- HTTP Method: `POST`
- Endpoint: `/v3/anticipations/{id}/cancel`

**Parameters**

| Name  | Type   | Required | Description                                |
| :---- | :----- | :------- | :----------------------------------------- |
| id    | String | ✅       | Unique identifier of anticipation in Asaas |
| input | Object | ❌       | Request Body                               |

**Return Type**

`AnticipationGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.AnticipationGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    AnticipationGetResponseDto response = asaasSdk.anticipation.cancelAnticipation("id", new Object());

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
