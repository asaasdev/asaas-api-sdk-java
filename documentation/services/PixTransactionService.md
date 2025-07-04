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

| Name                         | Type                                                                      | Required | Description  |
| :--------------------------- | :------------------------------------------------------------------------ | :------- | :----------- |
| pixTransactionSaveRequestDto | [PixTransactionSaveRequestDto](../models/PixTransactionSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`PixTransactionGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PixTransactionGetResponseDto;
import com.asaas.apisdk.models.PixTransactionQrCodeSaveRequestDto;
import com.asaas.apisdk.models.PixTransactionSaveRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PixTransactionQrCodeSaveRequestDto pixTransactionQrCodeSaveRequestDto = PixTransactionQrCodeSaveRequestDto.builder()
      .payload("payload")
      .changeValue(8.23D)
      .build();

    PixTransactionSaveRequestDto pixTransactionSaveRequestDto = PixTransactionSaveRequestDto.builder()
      .qrCode(pixTransactionQrCodeSaveRequestDto)
      .value(100D)
      .description("Barbecue")
      .scheduleDate("2022-03-15")
      .build();

    PixTransactionGetResponseDto response = asaasSdk.pixTransaction.payAQrcode(pixTransactionSaveRequestDto);

    System.out.println(response);
  }
}

```

## decodeAQrcodeForPayment

- HTTP Method: `POST`
- Endpoint: `/v3/pix/qrCodes/decode`

**Parameters**

| Name                      | Type                                                                | Required | Description  |
| :------------------------ | :------------------------------------------------------------------ | :------- | :----------- |
| pixQrCodeDecodeRequestDto | [PixQrCodeDecodeRequestDto](../models/PixQrCodeDecodeRequestDto.md) | ❌       | Request Body |

**Return Type**

`PixQrCodeDecodeResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PixQrCodeDecodeRequestDto;
import com.asaas.apisdk.models.PixQrCodeDecodeResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PixQrCodeDecodeRequestDto pixQrCodeDecodeRequestDto = PixQrCodeDecodeRequestDto.builder()
      .payload(
        "00020101021226730014br.gov.bcb.pix2551pix-h.asaas.com/pixqrcode/cobv/pay_76575613967995145204000053039865802BR5905ASAAS6009Joinville61088922827162070503***63045E7A"
      )
      .changeValue(7.59D)
      .build();

    PixQrCodeDecodeResponseDto response = asaasSdk.pixTransaction.decodeAQrcodeForPayment(pixQrCodeDecodeRequestDto);

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

`PixTransactionGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PixTransactionGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PixTransactionGetResponseDto response = asaasSdk.pixTransaction.retrieveASingleTransaction(
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

`PixTransactionListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ListTransactionsParameters;
import com.asaas.apisdk.models.PixTransactionListRequestPixTransactionStatus;
import com.asaas.apisdk.models.PixTransactionListRequestPixTransactionType;
import com.asaas.apisdk.models.PixTransactionListResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListTransactionsParameters requestParameters = ListTransactionsParameters.builder()
      .offset(1L)
      .limit(10L)
      .status(PixTransactionListRequestPixTransactionStatus.AWAITING_BALANCE_VALIDATION)
      .type(PixTransactionListRequestPixTransactionType.DEBIT)
      .endToEndIdentifier("endToEndIdentifier")
      .build();

    PixTransactionListResponseDto response = asaasSdk.pixTransaction.listTransactions(requestParameters);

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

`PixTransactionGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PixTransactionGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PixTransactionGetResponseDto response = asaasSdk.pixTransaction.cancelAScheduledTransaction("id", new Object());

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
