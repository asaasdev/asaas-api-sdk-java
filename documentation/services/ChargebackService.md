# ChargebackService

A list of all methods in the `ChargebackService` service. Click on the method name to view detailed information about that method.

| Methods                                                 | Description                                                                           |
| :------------------------------------------------------ | :------------------------------------------------------------------------------------ |
| [createAChargebackDispute](#createachargebackdispute)   |                                                                                       |
| [listChargebacks](#listchargebacks)                     | This method returns a paginated list of all chargebacks for the specified filter.     |
| [retrieveASingleChargeback](#retrieveasinglechargeback) | This endpoint retrieves a specific chargeback based on the payment or installment ID. |

## createAChargebackDispute

- HTTP Method: `POST`
- Endpoint: `/v3/chargebacks/{id}/dispute`

**Parameters**

| Name                            | Type                                                                            | Required | Description                                                            |
| :------------------------------ | :------------------------------------------------------------------------------ | :------- | :--------------------------------------------------------------------- |
| id                              | String                                                                          | ✅       | Unique identifier of chargeback for which the dispute will be created. |
| chargebackSaveDisputeRequestDto | [ChargebackSaveDisputeRequestDto](../models/ChargebackSaveDisputeRequestDto.md) | ❌       | Request Body                                                           |
| \_filename                      | [String](../models/String.md)                                                   | ✅       | Filename for the uploaded file                                         |

**Return Type**

`ChargebackSaveDisputeResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ChargebackSaveDisputeRequestDto;
import com.asaas.apisdk.models.ChargebackSaveDisputeResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ChargebackSaveDisputeRequestDto chargebackSaveDisputeRequestDto = ChargebackSaveDisputeRequestDto.builder()
      .files(files)
      .build();
    ChargebackSaveDisputeRequestDto chargebackSaveDisputeRequestDto = ChargebackSaveDisputeRequestDto.builder()
      .files(files)
      .build();

    ChargebackSaveDisputeResponseDto response = asaasSdk.chargeback.createAChargebackDispute(
      "8e784c3e-afe8-4844-bb93-6b445763",
      chargebackSaveDisputeRequestDto,
      chargebackSaveDisputeRequestDto
    );

    System.out.println(response);
  }
}

```

## listChargebacks

This method returns a paginated list of all chargebacks for the specified filter.

- HTTP Method: `GET`
- Endpoint: `/v3/chargebacks/`

**Parameters**

| Name              | Type                                                                | Required | Description               |
| :---------------- | :------------------------------------------------------------------ | :------- | :------------------------ |
| requestParameters | [ListChargebacksParameters](../models/ListChargebacksParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ChargebackListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ChargebackListRequestChargebackStatus;
import com.asaas.apisdk.models.ChargebackListRequestCreditCardBrand;
import com.asaas.apisdk.models.ChargebackListResponseDto;
import com.asaas.apisdk.models.ListChargebacksParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListChargebacksParameters requestParameters = ListChargebacksParameters.builder()
      .offset(4L)
      .limit(10L)
      .creditCardBrand(ChargebackListRequestCreditCardBrand.VISA)
      .originDisputeDateLe("2024-12-05")
      .originDisputeDateGe("2023-11-01")
      .originTransactionDateLe("2024-12-05")
      .originTransactionDateGe("2024-10-10")
      .status(ChargebackListRequestChargebackStatus.REQUESTED)
      .build();

    ChargebackListResponseDto response = asaasSdk.chargeback.listChargebacks(requestParameters);

    System.out.println(response);
  }
}

```

## retrieveASingleChargeback

This endpoint retrieves a specific chargeback based on the payment or installment ID.

- HTTP Method: `GET`
- Endpoint: `/v3/payments/{id}/chargeback`

**Parameters**

| Name | Type   | Required | Description                                                                                 |
| :--- | :----- | :------- | :------------------------------------------------------------------------------------------ |
| id   | String | ✅       | Unique identifier of the payment or installment for which the chargeback will be retrieved. |

**Return Type**

`PaymentChargebackResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentChargebackResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentChargebackResponseDto response = asaasSdk.chargeback.retrieveASingleChargeback("pay_s02s330x4pox1x0y");

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
