# PaymentSplitService

A list of all methods in the `PaymentSplitService` service. Click on the method name to view detailed information about that method.

| Methods                                                       | Description |
| :------------------------------------------------------------ | :---------- |
| [retrieveASinglePaidSplit](#retrieveasinglepaidsplit)         |             |
| [listPaidSplits](#listpaidsplits)                             |             |
| [retrieveASingleReceivedSplit](#retrieveasinglereceivedsplit) |             |
| [listReceivedSplits](#listreceivedsplits)                     |             |

## retrieveASinglePaidSplit

- HTTP Method: `GET`
- Endpoint: `/v3/payments/splits/paid/{id}`

**Parameters**

| Name | Type   | Required | Description                      |
| :--- | :----- | :------- | :------------------------------- |
| id   | String | ✅       | Unique split identifier in Asaas |

**Return Type**

`PaymentSplitGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentSplitGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentSplitGetResponseDto response = asaasSdk.paymentSplit.retrieveASinglePaidSplit("id");

    System.out.println(response);
  }
}

```

## listPaidSplits

- HTTP Method: `GET`
- Endpoint: `/v3/payments/splits/paid`

**Parameters**

| Name              | Type                                                              | Required | Description               |
| :---------------- | :---------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [ListPaidSplitsParameters](../models/ListPaidSplitsParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`PaymentSplitListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ListPaidSplitsParameters;
import com.asaas.apisdk.models.PaymentSplitListPaidRequestPaymentSplitStatus;
import com.asaas.apisdk.models.PaymentSplitListResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListPaidSplitsParameters requestParameters = ListPaidSplitsParameters.builder()
      .offset(5L)
      .limit(10L)
      .paymentId("paymentId")
      .status(PaymentSplitListPaidRequestPaymentSplitStatus.PENDING)
      .paymentConfirmedDateGe("paymentConfirmedDate[ge]")
      .paymentConfirmedDateLe("paymentConfirmedDate[le]")
      .creditDateGe("creditDate[ge]")
      .creditDateLe("creditDate[le]")
      .build();

    PaymentSplitListResponseDto response = asaasSdk.paymentSplit.listPaidSplits(requestParameters);

    System.out.println(response);
  }
}

```

## retrieveASingleReceivedSplit

- HTTP Method: `GET`
- Endpoint: `/v3/payments/splits/received/{id}`

**Parameters**

| Name | Type   | Required | Description                      |
| :--- | :----- | :------- | :------------------------------- |
| id   | String | ✅       | Unique split identifier in Asaas |

**Return Type**

`PaymentSplitGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentSplitGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentSplitGetResponseDto response = asaasSdk.paymentSplit.retrieveASingleReceivedSplit("id");

    System.out.println(response);
  }
}

```

## listReceivedSplits

- HTTP Method: `GET`
- Endpoint: `/v3/payments/splits/received`

**Parameters**

| Name              | Type                                                                      | Required | Description               |
| :---------------- | :------------------------------------------------------------------------ | :------- | :------------------------ |
| requestParameters | [ListReceivedSplitsParameters](../models/ListReceivedSplitsParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`PaymentSplitListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ListReceivedSplitsParameters;
import com.asaas.apisdk.models.PaymentSplitListReceivedRequestPaymentSplitStatus;
import com.asaas.apisdk.models.PaymentSplitListResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListReceivedSplitsParameters requestParameters = ListReceivedSplitsParameters.builder()
      .offset(6L)
      .limit(10L)
      .paymentId("paymentId")
      .status(PaymentSplitListReceivedRequestPaymentSplitStatus.PENDING)
      .paymentConfirmedDateGe("paymentConfirmedDate[ge]")
      .paymentConfirmedDateLe("paymentConfirmedDate[le]")
      .creditDateGe("creditDate[ge]")
      .creditDateLe("creditDate[le]")
      .build();

    PaymentSplitListResponseDto response = asaasSdk.paymentSplit.listReceivedSplits(requestParameters);

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
