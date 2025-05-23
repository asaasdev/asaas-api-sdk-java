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

| Name                               | Type                                                                                  | Required | Description                                                            |
| :--------------------------------- | :------------------------------------------------------------------------------------ | :------- | :--------------------------------------------------------------------- |
| id                                 | String                                                                                | ✅       | Unique identifier of chargeback for which the dispute will be created. |
| apiChargebackSaveDisputeRequestDto | [ApiChargebackSaveDisputeRequestDto](../models/ApiChargebackSaveDisputeRequestDto.md) | ❌       | Request Body                                                           |
| \_filename                         | [String](../models/String.md)                                                         | ❌       | Filename for the uploaded file                                         |

**Return Type**

`ApiChargebackSaveDisputeResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiChargebackSaveDisputeRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiChargebackSaveDisputeResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiChargebackSaveDisputeRequestDto apiChargebackSaveDisputeRequestDto = ApiChargebackSaveDisputeRequestDto.builder()
      .id("8e784c3e-afe8-4844-bb93-6b445763")
      .files(files)
      .build();
    ApiChargebackSaveDisputeRequestDto apiChargebackSaveDisputeRequestDto = ApiChargebackSaveDisputeRequestDto.builder()
      .id("8e784c3e-afe8-4844-bb93-6b445763")
      .files(files)
      .build();

    ApiChargebackSaveDisputeResponseDto response = asaasSdk.chargeback.createAChargebackDispute(
      "8e784c3e-afe8-4844-bb93-6b445763",
      apiChargebackSaveDisputeRequestDto,
      apiChargebackSaveDisputeRequestDto
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

`ApiChargebackListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiChargebackListRequestChargebackStatus;
import com.asaas.sdk.asaasjavasdk.models.ApiChargebackListRequestCreditCardBrand;
import com.asaas.sdk.asaasjavasdk.models.ApiChargebackListResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ListChargebacksParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListChargebacksParameters requestParameters = ListChargebacksParameters.builder()
      .offset(9L)
      .limit(10L)
      .creditCardBrand(ApiChargebackListRequestCreditCardBrand.VISA)
      .originDisputeDateLe("2024-12-05")
      .originDisputeDateGe("2023-11-01")
      .originTransactionDateLe("2024-12-05")
      .originTransactionDateGe("2024-10-10")
      .status(ApiChargebackListRequestChargebackStatus.REQUESTED)
      .build();

    ApiChargebackListResponseDto response = asaasSdk.chargeback.listChargebacks(requestParameters);

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

`ApiPaymentChargebackResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentChargebackResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentChargebackResponseDto response = asaasSdk.chargeback.retrieveASingleChargeback("pay_s02s330x4pox1x0y");

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
