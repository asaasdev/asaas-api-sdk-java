# PaymentDunningService

A list of all methods in the `PaymentDunningService` service. Click on the method name to view detailed information about that method.

| Methods                                                                           | Description                                                                                                                                                                                                                                                                                                                          |
| :-------------------------------------------------------------------------------- | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [listPaymentDunnings](#listpaymentdunnings)                                       |                                                                                                                                                                                                                                                                                                                                      |
| [createAPaymentDunning](#createapaymentdunning)                                   |                                                                                                                                                                                                                                                                                                                                      |
| [simulateAPaymentDunning](#simulateapaymentdunning)                               |                                                                                                                                                                                                                                                                                                                                      |
| [recoverASinglePaymentDunning](#recoverasinglepaymentdunning)                     |                                                                                                                                                                                                                                                                                                                                      |
| [eventHistoryLists](#eventhistorylists)                                           | Returns a paginated list of events that have occurred since the charge was denied.                                                                                                                                                                                                                                                   |
| [listPaymentsReceived](#listpaymentsreceived)                                     | Returns a paginated list of payments received through debt renegotiation.                                                                                                                                                                                                                                                            |
| [listPaymentsAvailableForPaymentDunning](#listpaymentsavailableforpaymentdunning) | Returns a paginated list of possible negative charges together with a simulation of values for each type of negative.                                                                                                                                                                                                                |
| [resendDocuments](#resenddocuments)                                               | Use the `isNecessaryResendDocumentation` property returned in the delinquency object to check if documentation resend is required. After resending, your delinquency will return to the `AWAITING_APPROVAL` status.                                                                                                                  |
| [cancelPaymentDunning](#cancelpaymentdunning)                                     | Allows the cancellation of a delinquency. Use the `canBeCancelled` property returned in the delinquency object to check if the delinquency can be canceled. If the delinquency has already been initiated, requesting cancellation will change its status to `AWAITING_CANCELLATION` until it is effectively canceled (`CANCELLED`). |

## listPaymentDunnings

- HTTP Method: `GET`
- Endpoint: `/v3/paymentDunnings`

**Parameters**

| Name              | Type                                                                        | Required | Description               |
| :---------------- | :-------------------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [ListPaymentDunningsParameters](../models/ListPaymentDunningsParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ApiPaymentDunningListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDunningListRequestPaymentDunningStatus;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDunningListRequestPaymentDunningType;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDunningListResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ListPaymentDunningsParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListPaymentDunningsParameters requestParameters = ListPaymentDunningsParameters.builder()
      .offset(6L)
      .limit(10L)
      .status(ApiPaymentDunningListRequestPaymentDunningStatus.PENDING)
      .type(ApiPaymentDunningListRequestPaymentDunningType.CREDIT_BUREAU)
      .payment("payment")
      .requestStartDate("requestStartDate")
      .requestEndDate("requestEndDate")
      .build();

    ApiPaymentDunningListResponseDto response = asaasSdk.paymentDunning.listPaymentDunnings(requestParameters);

    System.out.println(response);
  }
}

```

## createAPaymentDunning

- HTTP Method: `POST`
- Endpoint: `/v3/paymentDunnings`

**Parameters**

| Name                            | Type                                                                            | Required | Description                    |
| :------------------------------ | :------------------------------------------------------------------------------ | :------- | :----------------------------- |
| apiPaymentDunningSaveRequestDto | [ApiPaymentDunningSaveRequestDto](../models/ApiPaymentDunningSaveRequestDto.md) | ❌       | Request Body                   |
| \_filename                      | [String](../models/String.md)                                                   | ✅       | Filename for the uploaded file |

**Return Type**

`ApiPaymentDunningShowResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDunningSaveRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDunningSaveRequestPaymentDunningType;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDunningShowResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentDunningSaveRequestDto apiPaymentDunningSaveRequestDto = ApiPaymentDunningSaveRequestDto.builder()
      .payment("pay_080225913252")
      .type(ApiPaymentDunningSaveRequestPaymentDunningType.CREDIT_BUREAU)
      .description("Duas mesas com 8 cadeiras solicitadas via encomenda no dia 01/05/2018")
      .customerName("John Doe")
      .customerCpfCnpj("378.285.120-07")
      .customerPrimaryPhone("(11) 99999-9999")
      .customerSecondaryPhone("(11) 99999-9999")
      .customerPostalCode("99050-460")
      .customerAddress("Rua Izaías Fontana")
      .customerAddressNumber("123")
      .customerComplement("AP 101")
      .customerProvince("Petrópolis")
      .documents(documents)
      .build();
    ApiPaymentDunningSaveRequestDto apiPaymentDunningSaveRequestDto = ApiPaymentDunningSaveRequestDto.builder()
      .payment("pay_080225913252")
      .type(ApiPaymentDunningSaveRequestPaymentDunningType.CREDIT_BUREAU)
      .description("Duas mesas com 8 cadeiras solicitadas via encomenda no dia 01/05/2018")
      .customerName("John Doe")
      .customerCpfCnpj("378.285.120-07")
      .customerPrimaryPhone("(11) 99999-9999")
      .customerSecondaryPhone("(11) 99999-9999")
      .customerPostalCode("99050-460")
      .customerAddress("Rua Izaías Fontana")
      .customerAddressNumber("123")
      .customerComplement("AP 101")
      .customerProvince("Petrópolis")
      .documents(documents)
      .build();

    ApiPaymentDunningShowResponseDto response = asaasSdk.paymentDunning.createAPaymentDunning(
      apiPaymentDunningSaveRequestDto,
      apiPaymentDunningSaveRequestDto
    );

    System.out.println(response);
  }
}

```

## simulateAPaymentDunning

- HTTP Method: `POST`
- Endpoint: `/v3/paymentDunnings/simulate`

**Parameters**

| Name              | Type                                                                                | Required | Description               |
| :---------------- | :---------------------------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [SimulateAPaymentDunningParameters](../models/SimulateAPaymentDunningParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ApiPaymentDunningSimulateResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDunningSimulateResponseDto;
import com.asaas.sdk.asaasjavasdk.models.SimulateAPaymentDunningParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    SimulateAPaymentDunningParameters requestParameters = SimulateAPaymentDunningParameters.builder()
      .payment("pay_080225913252")
      .requestBody(new Object())
      .build();

    ApiPaymentDunningSimulateResponseDto response = asaasSdk.paymentDunning.simulateAPaymentDunning(requestParameters);

    System.out.println(response);
  }
}

```

## recoverASinglePaymentDunning

- HTTP Method: `GET`
- Endpoint: `/v3/paymentDunnings/{id}`

**Parameters**

| Name | Type   | Required | Description                                       |
| :--- | :----- | :------- | :------------------------------------------------ |
| id   | String | ✅       | Unique identifier of the payment dunning in Asaas |

**Return Type**

`ApiPaymentDunningShowResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDunningShowResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentDunningShowResponseDto response = asaasSdk.paymentDunning.recoverASinglePaymentDunning(
      "ce35702d-0d9f-475a-ba46-e251ad265c91"
    );

    System.out.println(response);
  }
}

```

## eventHistoryLists

Returns a paginated list of events that have occurred since the charge was denied.

- HTTP Method: `GET`
- Endpoint: `/v3/paymentDunnings/{id}/history`

**Parameters**

| Name              | Type                                                                    | Required | Description                                       |
| :---------------- | :---------------------------------------------------------------------- | :------- | :------------------------------------------------ |
| id                | String                                                                  | ✅       | Unique identifier of the payment dunning in Asaas |
| requestParameters | [EventHistoryListsParameters](../models/EventHistoryListsParameters.md) | ❌       | Request Parameters Object                         |

**Return Type**

`ApiPaymentDunningListHistoryResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDunningListHistoryResponseDto;
import com.asaas.sdk.asaasjavasdk.models.EventHistoryListsParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    EventHistoryListsParameters requestParameters = EventHistoryListsParameters.builder().offset(8L).limit(10L).build();

    ApiPaymentDunningListHistoryResponseDto response = asaasSdk.paymentDunning.eventHistoryLists(
      "ce35702d-0d9f-475a-ba46-e251ad265c91",
      requestParameters
    );

    System.out.println(response);
  }
}

```

## listPaymentsReceived

Returns a paginated list of payments received through debt renegotiation.

- HTTP Method: `GET`
- Endpoint: `/v3/paymentDunnings/{id}/partialPayments`

**Parameters**

| Name              | Type                                                                          | Required | Description                                       |
| :---------------- | :---------------------------------------------------------------------------- | :------- | :------------------------------------------------ |
| id                | String                                                                        | ✅       | Unique identifier of the payment dunning in Asaas |
| requestParameters | [ListPaymentsReceivedParameters](../models/ListPaymentsReceivedParameters.md) | ❌       | Request Parameters Object                         |

**Return Type**

`ApiPaymentDunningListPartialPaymentsResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDunningListPartialPaymentsResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ListPaymentsReceivedParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListPaymentsReceivedParameters requestParameters = ListPaymentsReceivedParameters.builder()
      .offset(5L)
      .limit(10L)
      .build();

    ApiPaymentDunningListPartialPaymentsResponseDto response = asaasSdk.paymentDunning.listPaymentsReceived(
      "ce35702d-0d9f-475a-ba46-e251ad265c91",
      requestParameters
    );

    System.out.println(response);
  }
}

```

## listPaymentsAvailableForPaymentDunning

Returns a paginated list of possible negative charges together with a simulation of values for each type of negative.

- HTTP Method: `GET`
- Endpoint: `/v3/paymentDunnings/paymentsAvailableForDunning`

**Parameters**

| Name              | Type                                                                                                              | Required | Description               |
| :---------------- | :---------------------------------------------------------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [ListPaymentsAvailableForPaymentDunningParameters](../models/ListPaymentsAvailableForPaymentDunningParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ApiPaymentDunningPaymentsAvailableForDunningResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDunningPaymentsAvailableForDunningResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ListPaymentsAvailableForPaymentDunningParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListPaymentsAvailableForPaymentDunningParameters requestParameters =
      ListPaymentsAvailableForPaymentDunningParameters.builder().offset(0L).limit(10L).build();

    ApiPaymentDunningPaymentsAvailableForDunningResponseDto response =
      asaasSdk.paymentDunning.listPaymentsAvailableForPaymentDunning(requestParameters);

    System.out.println(response);
  }
}

```

## resendDocuments

Use the `isNecessaryResendDocumentation` property returned in the delinquency object to check if documentation resend is required. After resending, your delinquency will return to the `AWAITING_APPROVAL` status.

- HTTP Method: `POST`
- Endpoint: `/v3/paymentDunnings/{id}/documents`

**Parameters**

| Name                                     | Type                                                                                              | Required | Description                                       |
| :--------------------------------------- | :------------------------------------------------------------------------------------------------ | :------- | :------------------------------------------------ |
| id                                       | String                                                                                            | ✅       | Unique identifier of the payment dunning in Asaas |
| apiPaymentDunningSaveDocumentsRequestDto | [ApiPaymentDunningSaveDocumentsRequestDto](../models/ApiPaymentDunningSaveDocumentsRequestDto.md) | ❌       | Request Body                                      |
| \_filename                               | [String](../models/String.md)                                                                     | ✅       | Filename for the uploaded file                    |

**Return Type**

`ApiPaymentDunningSaveDocumentsResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDunningSaveDocumentsRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDunningSaveDocumentsResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentDunningSaveDocumentsRequestDto apiPaymentDunningSaveDocumentsRequestDto =
      ApiPaymentDunningSaveDocumentsRequestDto.builder().documents(documents).build();
    ApiPaymentDunningSaveDocumentsRequestDto apiPaymentDunningSaveDocumentsRequestDto =
      ApiPaymentDunningSaveDocumentsRequestDto.builder().documents(documents).build();

    ApiPaymentDunningSaveDocumentsResponseDto response = asaasSdk.paymentDunning.resendDocuments(
      "ce35702d-0d9f-475a-ba46-e251ad265c91",
      apiPaymentDunningSaveDocumentsRequestDto,
      apiPaymentDunningSaveDocumentsRequestDto
    );

    System.out.println(response);
  }
}

```

## cancelPaymentDunning

Allows the cancellation of a delinquency. Use the `canBeCancelled` property returned in the delinquency object to check if the delinquency can be canceled. If the delinquency has already been initiated, requesting cancellation will change its status to `AWAITING_CANCELLATION` until it is effectively canceled (`CANCELLED`).

- HTTP Method: `POST`
- Endpoint: `/v3/paymentDunnings/{id}/cancel`

**Parameters**

| Name  | Type   | Required | Description                                               |
| :---- | :----- | :------- | :-------------------------------------------------------- |
| id    | String | ✅       | Unique identifier of the payment dunning to be cancelled. |
| input | Object | ❌       | Request Body                                              |

**Return Type**

`ApiPaymentDunningCancelResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDunningCancelResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentDunningCancelResponseDto response = asaasSdk.paymentDunning.cancelPaymentDunning(
      "ce35702d-0d9f-475a-ba46-e251ad265c91",
      new Object()
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
