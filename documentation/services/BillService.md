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

`ApiBillListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiBillListResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ListBillPaymentsParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListBillPaymentsParameters requestParameters = ListBillPaymentsParameters.builder().offset(4L).limit(10L).build();

    ApiBillListResponseDto response = asaasSdk.bill.listBillPayments(requestParameters);

    System.out.println(response);
  }
}

```

## createABillPayment

- HTTP Method: `POST`
- Endpoint: `/v3/bill`

**Parameters**

| Name                  | Type                                                        | Required | Description  |
| :-------------------- | :---------------------------------------------------------- | :------- | :----------- |
| apiBillSaveRequestDto | [ApiBillSaveRequestDto](../models/ApiBillSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`ApiBillGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiBillGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiBillSaveRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiBillSaveRequestDto apiBillSaveRequestDto = ApiBillSaveRequestDto.builder()
      .identificationField("03399.77779 29900.000000 04751.101017 1 81510000002990")
      .scheduleDate("2020-03-15")
      .description("Celular 03/12")
      .discount(2.88D)
      .interest(4.04D)
      .fine(0.74D)
      .dueDate("2020-03-30")
      .value(29D)
      .externalReference("056984")
      .build();

    ApiBillGetResponseDto response = asaasSdk.bill.createABillPayment(apiBillSaveRequestDto);

    System.out.println(response);
  }
}

```

## simulateABillPayment

- HTTP Method: `POST`
- Endpoint: `/v3/bill/simulate`

**Parameters**

| Name                      | Type                                                                | Required | Description  |
| :------------------------ | :------------------------------------------------------------------ | :------- | :----------- |
| apiBillSimulateRequestDto | [ApiBillSimulateRequestDto](../models/ApiBillSimulateRequestDto.md) | ❌       | Request Body |

**Return Type**

`ApiBillSimulateResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiBillSimulateRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiBillSimulateResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiBillSimulateRequestDto apiBillSimulateRequestDto = ApiBillSimulateRequestDto.builder()
      .identificationField("03399.77779 29900.000000 04751.101017 1 81510000002990")
      .barCode("barCode")
      .build();

    ApiBillSimulateResponseDto response = asaasSdk.bill.simulateABillPayment(apiBillSimulateRequestDto);

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

    ApiBillGetResponseDto response = asaasSdk.bill.cancelBillPayment(
      "1bce822-6f37-4905-8de8-f1af9f2f4bab",
      new Object()
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
