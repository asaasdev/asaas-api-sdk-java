# BillService

A list of all methods in the `BillService` service. Click on the method name to view detailed information about that method.

| Methods                                                   | Description                                                                                                                                                                             |
| :-------------------------------------------------------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [listBillPayments](#listbillpayments)                     |                                                                                                                                                                                         |
| [createABillPayment](#createabillpayment)                 |                                                                                                                                                                                         |
| [simulateABillPayment](#simulateabillpayment)             |                                                                                                                                                                                         |
| [retrieveASingleBillPayment](#retrieveasinglebillpayment) |                                                                                                                                                                                         |
| [cancelBillPayment](#cancelbillpayment)                   | Allows canceling the bill payment. Use the `canBeCancelled` property of the `bill` to verify if the bill payment can be canceled. When canceled, the bill payment will not be executed. |

## listBillPayments

- HTTP Method: `GET`
- Endpoint: `/v3/bill`

**Parameters**

| Name              | Type                                                                  | Required | Description               |
| :---------------- | :-------------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [ListBillPaymentsParameters](../models/ListBillPaymentsParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ListBillPaymentsOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ListBillPaymentsOkResponse;
import com.asaas.sdk.asaasjavasdk.models.ListBillPaymentsParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListBillPaymentsParameters requestParameters = ListBillPaymentsParameters.builder().offset(7L).limit(10L).build();

    ListBillPaymentsOkResponse response = asaasSdk.bill.listBillPayments(requestParameters);

    System.out.println(response);
  }
}

```

## createABillPayment

- HTTP Method: `POST`
- Endpoint: `/v3/bill`

**Parameters**

| Name                      | Type                                                                | Required | Description  |
| :------------------------ | :------------------------------------------------------------------ | :------- | :----------- |
| createABillPaymentRequest | [CreateABillPaymentRequest](../models/CreateABillPaymentRequest.md) | ❌       | Request Body |

**Return Type**

`ApiBillGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiBillGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.CreateABillPaymentRequest;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    CreateABillPaymentRequest createABillPaymentRequest = CreateABillPaymentRequest.builder()
      .identificationField("03399.77779 29900.000000 04751.101017 1 81510000002990")
      .scheduleDate("2020-03-15")
      .description("Celular 03/12")
      .discount(6.29D)
      .interest(8.98D)
      .fine(1.11D)
      .dueDate("2020-03-30")
      .value(29D)
      .externalReference("056984")
      .build();

    ApiBillGetResponseDto response = asaasSdk.bill.createABillPayment(createABillPaymentRequest);

    System.out.println(response);
  }
}

```

## simulateABillPayment

- HTTP Method: `POST`
- Endpoint: `/v3/bill/simulate`

**Parameters**

| Name                        | Type                                                                    | Required | Description  |
| :-------------------------- | :---------------------------------------------------------------------- | :------- | :----------- |
| simulateABillPaymentRequest | [SimulateABillPaymentRequest](../models/SimulateABillPaymentRequest.md) | ❌       | Request Body |

**Return Type**

`SimulateABillPaymentOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.SimulateABillPaymentOkResponse;
import com.asaas.sdk.asaasjavasdk.models.SimulateABillPaymentRequest;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    SimulateABillPaymentRequest simulateABillPaymentRequest = SimulateABillPaymentRequest.builder()
      .identificationField("03399.77779 29900.000000 04751.101017 1 81510000002990")
      .barCode("barCode")
      .build();

    SimulateABillPaymentOkResponse response = asaasSdk.bill.simulateABillPayment(simulateABillPaymentRequest);

    System.out.println(response);
  }
}

```

## retrieveASingleBillPayment

- HTTP Method: `GET`
- Endpoint: `/v3/bill/{id}`

**Parameters**

| Name | Type   | Required | Description                             |
| :--- | :----- | :------- | :-------------------------------------- |
| id   | String | ✅       | Unique bill payment identifier in Asaas |

**Return Type**

`ApiBillGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiBillGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiBillGetResponseDto response = asaasSdk.bill.retrieveASingleBillPayment("f1bce822-6f37-4905-8de8-f1af9f2f4bab");

    System.out.println(response);
  }
}

```

## cancelBillPayment

Allows canceling the bill payment. Use the `canBeCancelled` property of the `bill` to verify if the bill payment can be canceled. When canceled, the bill payment will not be executed.

- HTTP Method: `POST`
- Endpoint: `/v3/bill/{id}/cancel`

**Parameters**

| Name  | Type   | Required | Description                                           |
| :---- | :----- | :------- | :---------------------------------------------------- |
| id    | String | ✅       | Unique identifier of the bill payment to be cancelled |
| input | Object | ❌       | Request Body                                          |

**Return Type**

`CancelBillPaymentOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.CancelBillPaymentOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    CancelBillPaymentOkResponse response = asaasSdk.bill.cancelBillPayment(
      "1bce822-6f37-4905-8de8-f1af9f2f4bab",
      new Object()
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
