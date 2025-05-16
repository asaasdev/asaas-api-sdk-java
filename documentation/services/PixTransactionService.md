# PixTransactionService

A list of all methods in the `PixTransactionService` service. Click on the method name to view detailed information about that method.

| Methods                                                     | Description |
| :---------------------------------------------------------- | :---------- |
| [payAQrcode](#payaqrcode)                                   |             |
| [decodeAQrcodeForPayment](#decodeaqrcodeforpayment)         |             |
| [retrieveASingleTransaction](#retrieveasingletransaction)   |             |
| [listTransactions](#listtransactions)                       |             |
| [cancelAScheduledTransaction](#cancelascheduledtransaction) |             |

## payAQrcode

- HTTP Method: `POST`
- Endpoint: `/v3/pix/qrCodes/pay`

**Parameters**

| Name              | Type                                                | Required | Description  |
| :---------------- | :-------------------------------------------------- | :------- | :----------- |
| payAQrcodeRequest | [PayAQrcodeRequest](../models/PayAQrcodeRequest.md) | ❌       | Request Body |

**Return Type**

`ApiPixTransactionGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPixTransactionGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPixTransactionQrCodeSaveRequestDto;
import com.asaas.sdk.asaasjavasdk.models.PayAQrcodeRequest;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPixTransactionQrCodeSaveRequestDto apiPixTransactionQrCodeSaveRequestDto =
      ApiPixTransactionQrCodeSaveRequestDto.builder().payload("payload").changeValue(7.7D).build();

    PayAQrcodeRequest payAQrcodeRequest = PayAQrcodeRequest.builder()
      .qrCode(apiPixTransactionQrCodeSaveRequestDto)
      .value(100D)
      .description("Barbecue")
      .scheduleDate("2022-03-15")
      .build();

    ApiPixTransactionGetResponseDto response = asaasSdk.pixTransaction.payAQrcode(payAQrcodeRequest);

    System.out.println(response);
  }
}

```

## decodeAQrcodeForPayment

- HTTP Method: `POST`
- Endpoint: `/v3/pix/qrCodes/decode`

**Parameters**

| Name                           | Type                                                                          | Required | Description  |
| :----------------------------- | :---------------------------------------------------------------------------- | :------- | :----------- |
| decodeAQrcodeForPaymentRequest | [DecodeAQrcodeForPaymentRequest](../models/DecodeAQrcodeForPaymentRequest.md) | ❌       | Request Body |

**Return Type**

`DecodeAQrcodeForPaymentOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.DecodeAQrcodeForPaymentOkResponse;
import com.asaas.sdk.asaasjavasdk.models.DecodeAQrcodeForPaymentRequest;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    DecodeAQrcodeForPaymentRequest decodeAQrcodeForPaymentRequest = DecodeAQrcodeForPaymentRequest.builder()
      .payload(
        "00020101021226730014br.gov.bcb.pix2551pix-h.asaas.com/pixqrcode/cobv/pay_76575613967995145204000053039865802BR5905ASAAS6009Joinville61088922827162070503***63045E7A"
      )
      .changeValue(4.16D)
      .build();

    DecodeAQrcodeForPaymentOkResponse response = asaasSdk.pixTransaction.decodeAQrcodeForPayment(
      decodeAQrcodeForPaymentRequest
    );

    System.out.println(response);
  }
}

```

## retrieveASingleTransaction

- HTTP Method: `GET`
- Endpoint: `/v3/pix/transactions/{id}`

**Parameters**

| Name | Type   | Required | Description                                       |
| :--- | :----- | :------- | :------------------------------------------------ |
| id   | String | ✅       | Unique identifier of the Pix transaction in Asaas |

**Return Type**

`ApiPixTransactionGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPixTransactionGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPixTransactionGetResponseDto response = asaasSdk.pixTransaction.retrieveASingleTransaction(
      "35363f6e-93e2-11ec-b9d9-96f4053b1bd4"
    );

    System.out.println(response);
  }
}

```

## listTransactions

- HTTP Method: `GET`
- Endpoint: `/v3/pix/transactions`

**Parameters**

| Name              | Type                                                                  | Required | Description               |
| :---------------- | :-------------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [ListTransactionsParameters](../models/ListTransactionsParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ListTransactionsOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPixTransactionListRequestPixTransactionStatus;
import com.asaas.sdk.asaasjavasdk.models.ApiPixTransactionListRequestPixTransactionType;
import com.asaas.sdk.asaasjavasdk.models.ListTransactionsOkResponse;
import com.asaas.sdk.asaasjavasdk.models.ListTransactionsParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListTransactionsParameters requestParameters = ListTransactionsParameters.builder()
      .offset(10L)
      .limit(10L)
      .status(ApiPixTransactionListRequestPixTransactionStatus.AWAITING_BALANCE_VALIDATION)
      .type(ApiPixTransactionListRequestPixTransactionType.DEBIT)
      .endToEndIdentifier("endToEndIdentifier")
      .build();

    ListTransactionsOkResponse response = asaasSdk.pixTransaction.listTransactions(requestParameters);

    System.out.println(response);
  }
}

```

## cancelAScheduledTransaction

- HTTP Method: `POST`
- Endpoint: `/v3/pix/transactions/{id}/cancel`

**Parameters**

| Name  | Type   | Required | Description                                                        |
| :---- | :----- | :------- | :----------------------------------------------------------------- |
| id    | String | ✅       | Unique identifier of the Pix transaction scheduled to be canceled. |
| input | Object | ❌       | Request Body                                                       |

**Return Type**

`CancelAScheduledTransactionOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.CancelAScheduledTransactionOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    CancelAScheduledTransactionOkResponse response = asaasSdk.pixTransaction.cancelAScheduledTransaction(
      "id",
      new Object()
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
