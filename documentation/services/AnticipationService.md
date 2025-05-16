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

`ListAnticipationsOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiReceivableAnticipationListRequestReceivableAnticipationStatus;
import com.asaas.sdk.asaasjavasdk.models.ListAnticipationsOkResponse;
import com.asaas.sdk.asaasjavasdk.models.ListAnticipationsParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListAnticipationsParameters requestParameters = ListAnticipationsParameters.builder()
      .offset(10L)
      .limit(10L)
      .payment("payment")
      .installment("installment")
      .status(ApiReceivableAnticipationListRequestReceivableAnticipationStatus.PENDING)
      .build();

    ListAnticipationsOkResponse response = asaasSdk.anticipation.listAnticipations(requestParameters);

    System.out.println(response);
  }
}

```

## requestAnticipation

- HTTP Method: `POST`
- Endpoint: `/v3/anticipations`

**Parameters**

| Name                       | Type                                                                  | Required | Description  |
| :------------------------- | :-------------------------------------------------------------------- | :------- | :----------- |
| requestAnticipationRequest | [RequestAnticipationRequest](../models/RequestAnticipationRequest.md) | ❌       | Request Body |

**Return Type**

`ApiReceivableAnticipationGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiReceivableAnticipationGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.RequestAnticipationRequest;

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

		RequestAnticipationRequest requestAnticipationRequest = RequestAnticipationRequest.builder()
			.installment("installment")
			.payment("pay_626366773834")
			.documents(occaecat i)
			.build();

		ApiReceivableAnticipationGetResponseDto response = asaasSdk.anticipation.requestAnticipation(requestAnticipationRequest);

		System.out.println(response);
    }
}
```

## simulateAnticipation

- HTTP Method: `POST`
- Endpoint: `/v3/anticipations/simulate`

**Parameters**

| Name                        | Type                                                                    | Required | Description  |
| :-------------------------- | :---------------------------------------------------------------------- | :------- | :----------- |
| simulateAnticipationRequest | [SimulateAnticipationRequest](../models/SimulateAnticipationRequest.md) | ❌       | Request Body |

**Return Type**

`SimulateAnticipationOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.SimulateAnticipationOkResponse;
import com.asaas.sdk.asaasjavasdk.models.SimulateAnticipationRequest;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    SimulateAnticipationRequest simulateAnticipationRequest = SimulateAnticipationRequest.builder()
      .installment("installment")
      .payment("pay_626366773834")
      .build();

    SimulateAnticipationOkResponse response = asaasSdk.anticipation.simulateAnticipation(simulateAnticipationRequest);

    System.out.println(response);
  }
}

```

## retrieveStatusOfAutomaticAnticipation

- HTTP Method: `GET`
- Endpoint: `/v3/anticipations/configurations`

**Return Type**

`RetrieveStatusOfAutomaticAnticipationOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.RetrieveStatusOfAutomaticAnticipationOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    RetrieveStatusOfAutomaticAnticipationOkResponse response =
      asaasSdk.anticipation.retrieveStatusOfAutomaticAnticipation();

    System.out.println(response);
  }
}

```

## updateStatusOfAutomaticAnticipation

- HTTP Method: `PUT`
- Endpoint: `/v3/anticipations/configurations`

**Parameters**

| Name                                       | Type                                                                                                  | Required | Description  |
| :----------------------------------------- | :---------------------------------------------------------------------------------------------------- | :------- | :----------- |
| updateStatusOfAutomaticAnticipationRequest | [UpdateStatusOfAutomaticAnticipationRequest](../models/UpdateStatusOfAutomaticAnticipationRequest.md) | ❌       | Request Body |

**Return Type**

`ApiReceivableAnticipationConfigurationGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiReceivableAnticipationConfigurationGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.UpdateStatusOfAutomaticAnticipationRequest;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    UpdateStatusOfAutomaticAnticipationRequest updateStatusOfAutomaticAnticipationRequest =
      UpdateStatusOfAutomaticAnticipationRequest.builder().creditCardAutomaticEnabled(false).build();

    ApiReceivableAnticipationConfigurationGetResponseDto response =
      asaasSdk.anticipation.updateStatusOfAutomaticAnticipation(updateStatusOfAutomaticAnticipationRequest);

    System.out.println(response);
  }
}

```

## retrieveAnticipationLimits

- HTTP Method: `GET`
- Endpoint: `/v3/anticipations/limits`

**Return Type**

`RetrieveAnticipationLimitsOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.RetrieveAnticipationLimitsOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    RetrieveAnticipationLimitsOkResponse response = asaasSdk.anticipation.retrieveAnticipationLimits();

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

`CancelAnticipationOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.CancelAnticipationOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    CancelAnticipationOkResponse response = asaasSdk.anticipation.cancelAnticipation("id", new Object());

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
