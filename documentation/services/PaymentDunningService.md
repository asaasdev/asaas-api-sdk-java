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

`PaymentDunningListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ListPaymentDunningsParameters;
import com.asaas.apisdk.models.PaymentDunningListRequestPaymentDunningStatus;
import com.asaas.apisdk.models.PaymentDunningListRequestPaymentDunningType;
import com.asaas.apisdk.models.PaymentDunningListResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListPaymentDunningsParameters requestParameters = ListPaymentDunningsParameters.builder()
      .offset(4L)
      .limit(10L)
      .status(PaymentDunningListRequestPaymentDunningStatus.PENDING)
      .type(PaymentDunningListRequestPaymentDunningType.CREDIT_BUREAU)
      .payment("payment")
      .requestStartDate("requestStartDate")
      .requestEndDate("requestEndDate")
      .build();

    PaymentDunningListResponseDto response = asaasSdk.paymentDunning.listPaymentDunnings(requestParameters);

    System.out.println(response);
  }
}

```

## createAPaymentDunning

- HTTP Method: `POST`
- Endpoint: `/v3/paymentDunnings`

**Parameters**

| Name                         | Type                                                                      | Required | Description                    |
| :--------------------------- | :------------------------------------------------------------------------ | :------- | :----------------------------- |
| paymentDunningSaveRequestDto | [PaymentDunningSaveRequestDto](../models/PaymentDunningSaveRequestDto.md) | ❌       | Request Body                   |
| \_filename                   | [String](../models/String.md)                                             | ✅       | Filename for the uploaded file |

**Return Type**

`PaymentDunningShowResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentDunningSaveRequestDto;
import com.asaas.apisdk.models.PaymentDunningSaveRequestPaymentDunningType;
import com.asaas.apisdk.models.PaymentDunningShowResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentDunningSaveRequestDto paymentDunningSaveRequestDto = PaymentDunningSaveRequestDto.builder()
      .payment("pay_080225913252")
      .type(PaymentDunningSaveRequestPaymentDunningType.CREDIT_BUREAU)
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
    PaymentDunningSaveRequestDto paymentDunningSaveRequestDto = PaymentDunningSaveRequestDto.builder()
      .payment("pay_080225913252")
      .type(PaymentDunningSaveRequestPaymentDunningType.CREDIT_BUREAU)
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

    PaymentDunningShowResponseDto response = asaasSdk.paymentDunning.createAPaymentDunning(
      paymentDunningSaveRequestDto,
      paymentDunningSaveRequestDto
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

`PaymentDunningSimulateResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentDunningSimulateResponseDto;
import com.asaas.apisdk.models.SimulateAPaymentDunningParameters;

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

    PaymentDunningSimulateResponseDto response = asaasSdk.paymentDunning.simulateAPaymentDunning(requestParameters);

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

`PaymentDunningShowResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentDunningShowResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentDunningShowResponseDto response = asaasSdk.paymentDunning.recoverASinglePaymentDunning(
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

`PaymentDunningListHistoryResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.EventHistoryListsParameters;
import com.asaas.apisdk.models.PaymentDunningListHistoryResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    EventHistoryListsParameters requestParameters = EventHistoryListsParameters.builder().offset(2L).limit(10L).build();

    PaymentDunningListHistoryResponseDto response = asaasSdk.paymentDunning.eventHistoryLists(
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

`PaymentDunningListPartialPaymentsResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ListPaymentsReceivedParameters;
import com.asaas.apisdk.models.PaymentDunningListPartialPaymentsResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListPaymentsReceivedParameters requestParameters = ListPaymentsReceivedParameters.builder()
      .offset(1L)
      .limit(10L)
      .build();

    PaymentDunningListPartialPaymentsResponseDto response = asaasSdk.paymentDunning.listPaymentsReceived(
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

`PaymentDunningPaymentsAvailableForDunningResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ListPaymentsAvailableForPaymentDunningParameters;
import com.asaas.apisdk.models.PaymentDunningPaymentsAvailableForDunningResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListPaymentsAvailableForPaymentDunningParameters requestParameters =
      ListPaymentsAvailableForPaymentDunningParameters.builder().offset(4L).limit(10L).build();

    PaymentDunningPaymentsAvailableForDunningResponseDto response =
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

| Name                                  | Type                                                                                        | Required | Description                                       |
| :------------------------------------ | :------------------------------------------------------------------------------------------ | :------- | :------------------------------------------------ |
| id                                    | String                                                                                      | ✅       | Unique identifier of the payment dunning in Asaas |
| paymentDunningSaveDocumentsRequestDto | [PaymentDunningSaveDocumentsRequestDto](../models/PaymentDunningSaveDocumentsRequestDto.md) | ❌       | Request Body                                      |
| \_filename                            | [String](../models/String.md)                                                               | ✅       | Filename for the uploaded file                    |

**Return Type**

`PaymentDunningSaveDocumentsResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentDunningSaveDocumentsRequestDto;
import com.asaas.apisdk.models.PaymentDunningSaveDocumentsResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentDunningSaveDocumentsRequestDto paymentDunningSaveDocumentsRequestDto =
      PaymentDunningSaveDocumentsRequestDto.builder().documents(documents).build();
    PaymentDunningSaveDocumentsRequestDto paymentDunningSaveDocumentsRequestDto =
      PaymentDunningSaveDocumentsRequestDto.builder().documents(documents).build();

    PaymentDunningSaveDocumentsResponseDto response = asaasSdk.paymentDunning.resendDocuments(
      "ce35702d-0d9f-475a-ba46-e251ad265c91",
      paymentDunningSaveDocumentsRequestDto,
      paymentDunningSaveDocumentsRequestDto
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

`PaymentDunningCancelResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentDunningCancelResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentDunningCancelResponseDto response = asaasSdk.paymentDunning.cancelPaymentDunning(
      "ce35702d-0d9f-475a-ba46-e251ad265c91",
      new Object()
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
