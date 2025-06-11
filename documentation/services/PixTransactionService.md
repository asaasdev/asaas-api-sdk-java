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

| Name                            | Type                                                                            | Required | Description  |
| :------------------------------ | :------------------------------------------------------------------------------ | :------- | :----------- |
| apiPixTransactionSaveRequestDto | [ApiPixTransactionSaveRequestDto](../models/ApiPixTransactionSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`ApiPixTransactionGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ApiPixTransactionGetResponseDto;
import com.asaas.apisdk.models.ApiPixTransactionQrCodeSaveRequestDto;
import com.asaas.apisdk.models.ApiPixTransactionSaveRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPixTransactionQrCodeSaveRequestDto apiPixTransactionQrCodeSaveRequestDto =
      ApiPixTransactionQrCodeSaveRequestDto.builder().payload("payload").changeValue(8.23D).build();

    ApiPixTransactionSaveRequestDto apiPixTransactionSaveRequestDto = ApiPixTransactionSaveRequestDto.builder()
      .qrCode(apiPixTransactionQrCodeSaveRequestDto)
      .value(100D)
      .description("Barbecue")
      .scheduleDate("2022-03-15")
      .build();

    ApiPixTransactionGetResponseDto response = asaasSdk.pixTransaction.payAQrcode(apiPixTransactionSaveRequestDto);

    System.out.println(response);
  }
}

```

## decodeAQrcodeForPayment

- HTTP Method: `POST`
- Endpoint: `/v3/pix/qrCodes/decode`

**Parameters**

| Name                         | Type                                                                      | Required | Description  |
| :--------------------------- | :------------------------------------------------------------------------ | :------- | :----------- |
| apiPixQrCodeDecodeRequestDto | [ApiPixQrCodeDecodeRequestDto](../models/ApiPixQrCodeDecodeRequestDto.md) | ❌       | Request Body |

**Return Type**

`ApiPixQrCodeDecodeResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ApiPixQrCodeDecodeRequestDto;
import com.asaas.apisdk.models.ApiPixQrCodeDecodeResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPixQrCodeDecodeRequestDto apiPixQrCodeDecodeRequestDto = ApiPixQrCodeDecodeRequestDto.builder()
      .payload(
        "00020101021226730014br.gov.bcb.pix2551pix-h.asaas.com/pixqrcode/cobv/pay_76575613967995145204000053039865802BR5905ASAAS6009Joinville61088922827162070503***63045E7A"
      )
      .changeValue(7.59D)
      .build();

    ApiPixQrCodeDecodeResponseDto response = asaasSdk.pixTransaction.decodeAQrcodeForPayment(
      apiPixQrCodeDecodeRequestDto
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
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ApiPixTransactionGetResponseDto;

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

`ApiPixTransactionListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ApiPixTransactionListRequestPixTransactionStatus;
import com.asaas.apisdk.models.ApiPixTransactionListRequestPixTransactionType;
import com.asaas.apisdk.models.ApiPixTransactionListResponseDto;
import com.asaas.apisdk.models.ListTransactionsParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListTransactionsParameters requestParameters = ListTransactionsParameters.builder()
      .offset(1L)
      .limit(10L)
      .status(ApiPixTransactionListRequestPixTransactionStatus.AWAITING_BALANCE_VALIDATION)
      .type(ApiPixTransactionListRequestPixTransactionType.DEBIT)
      .endToEndIdentifier("endToEndIdentifier")
      .build();

    ApiPixTransactionListResponseDto response = asaasSdk.pixTransaction.listTransactions(requestParameters);

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

`ApiPixTransactionGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ApiPixTransactionGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPixTransactionGetResponseDto response = asaasSdk.pixTransaction.cancelAScheduledTransaction("id", new Object());

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
