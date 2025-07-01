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

`BillListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.BillListResponseDto;
import com.asaas.apisdk.models.ListBillPaymentsParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListBillPaymentsParameters requestParameters = ListBillPaymentsParameters.builder().offset(4L).limit(10L).build();

    BillListResponseDto response = asaasSdk.bill.listBillPayments(requestParameters);

    System.out.println(response);
  }
}

```

## createABillPayment

- HTTP Method: `POST`
- Endpoint: `/v3/bill`

**Parameters**

| Name               | Type                                                  | Required | Description  |
| :----------------- | :---------------------------------------------------- | :------- | :----------- |
| billSaveRequestDto | [BillSaveRequestDto](../models/BillSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`BillGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.BillGetResponseDto;
import com.asaas.apisdk.models.BillSaveRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    BillSaveRequestDto billSaveRequestDto = BillSaveRequestDto.builder()
      .identificationField("03399.77779 29900.000000 04751.101017 1 81510000002990")
      .scheduleDate("2020-03-15")
      .description("Celular 03/12")
      .discount(4.52D)
      .interest(3.73D)
      .fine(0.02D)
      .dueDate("2020-03-30")
      .value(29D)
      .externalReference("056984")
      .build();

    BillGetResponseDto response = asaasSdk.bill.createABillPayment(billSaveRequestDto);

    System.out.println(response);
  }
}

```

## simulateABillPayment

- HTTP Method: `POST`
- Endpoint: `/v3/bill/simulate`

**Parameters**

| Name                   | Type                                                          | Required | Description  |
| :--------------------- | :------------------------------------------------------------ | :------- | :----------- |
| billSimulateRequestDto | [BillSimulateRequestDto](../models/BillSimulateRequestDto.md) | ❌       | Request Body |

**Return Type**

`BillSimulateResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.BillSimulateRequestDto;
import com.asaas.apisdk.models.BillSimulateResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    BillSimulateRequestDto billSimulateRequestDto = BillSimulateRequestDto.builder()
      .identificationField("03399.77779 29900.000000 04751.101017 1 81510000002990")
      .barCode("barCode")
      .build();

    BillSimulateResponseDto response = asaasSdk.bill.simulateABillPayment(billSimulateRequestDto);

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

`BillGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.BillGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    BillGetResponseDto response = asaasSdk.bill.retrieveASingleBillPayment("f1bce822-6f37-4905-8de8-f1af9f2f4bab");

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

`BillGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.BillGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    BillGetResponseDto response = asaasSdk.bill.cancelBillPayment("1bce822-6f37-4905-8de8-f1af9f2f4bab", new Object());

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
