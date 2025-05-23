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

`ApiPaymentSplitGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentSplitGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentSplitGetResponseDto response = asaasSdk.paymentSplit.retrieveASinglePaidSplit("id");

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

`ApiPaymentSplitListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentSplitListPaidRequestPaymentSplitStatus;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentSplitListResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ListPaidSplitsParameters;

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
      .status(ApiPaymentSplitListPaidRequestPaymentSplitStatus.PENDING)
      .paymentConfirmedDateGe("paymentConfirmedDate[ge]")
      .paymentConfirmedDateLe("paymentConfirmedDate[le]")
      .creditDateGe("creditDate[ge]")
      .creditDateLe("creditDate[le]")
      .build();

    ApiPaymentSplitListResponseDto response = asaasSdk.paymentSplit.listPaidSplits(requestParameters);

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

`ApiPaymentSplitGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentSplitGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentSplitGetResponseDto response = asaasSdk.paymentSplit.retrieveASingleReceivedSplit("id");

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

`ApiPaymentSplitListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentSplitListReceivedRequestPaymentSplitStatus;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentSplitListResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ListReceivedSplitsParameters;

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
      .status(ApiPaymentSplitListReceivedRequestPaymentSplitStatus.PENDING)
      .paymentConfirmedDateGe("paymentConfirmedDate[ge]")
      .paymentConfirmedDateLe("paymentConfirmedDate[le]")
      .creditDateGe("creditDate[ge]")
      .creditDateLe("creditDate[le]")
      .build();

    ApiPaymentSplitListResponseDto response = asaasSdk.paymentSplit.listReceivedSplits(requestParameters);

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
