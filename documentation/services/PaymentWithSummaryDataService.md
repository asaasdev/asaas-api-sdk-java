# PaymentWithSummaryDataService

A list of all methods in the `PaymentWithSummaryDataService` service. Click on the method name to view detailed information about that method.

| Methods                                                                                                                     | Description |
| :-------------------------------------------------------------------------------------------------------------------------- | :---------- |
| [listPaymentsWithSummaryData](#listpaymentswithsummarydata)                                                                 |             |
| [createNewPaymentWithSummaryDataInResponse](#createnewpaymentwithsummarydatainresponse)                                     |             |
| [createNewPaymentWithCreditCardWithSummaryDataInResponse](#createnewpaymentwithcreditcardwithsummarydatainresponse)         |             |
| [capturePaymentWithPreAuthorizationWithSummaryDataInResponse](#capturepaymentwithpreauthorizationwithsummarydatainresponse) |             |
| [retrieveASinglePaymentWithSummaryData](#retrieveasinglepaymentwithsummarydata)                                             |             |
| [updateExistingPaymentWithSummaryDataInResponse](#updateexistingpaymentwithsummarydatainresponse)                           |             |
| [deletePaymentWithSummaryData](#deletepaymentwithsummarydata)                                                               |             |
| [restoreRemovedPaymentWithSummaryDataInResponse](#restoreremovedpaymentwithsummarydatainresponse)                           |             |
| [refundPaymentWithSummaryDataInResponse](#refundpaymentwithsummarydatainresponse)                                           |             |
| [confirmCashReceiptWithSummaryDataInResponse](#confirmcashreceiptwithsummarydatainresponse)                                 |             |
| [undoCashReceiptConfirmationWithSummaryDataInResponse](#undocashreceiptconfirmationwithsummarydatainresponse)               |             |

## listPaymentsWithSummaryData

- HTTP Method: `GET`
- Endpoint: `/v3/lean/payments`

**Parameters**

| Name              | Type                                                                                        | Required | Description               |
| :---------------- | :------------------------------------------------------------------------------------------ | :------- | :------------------------ |
| requestParameters | [ListPaymentsWithSummaryDataParameters](../models/ListPaymentsWithSummaryDataParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ApiPaymentLeanListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentLeanListResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentListRequestBillingType;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentListRequestInvoiceStatus;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentListRequestPaymentStatus;
import com.asaas.sdk.asaasjavasdk.models.ListPaymentsWithSummaryDataParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListPaymentsWithSummaryDataParameters requestParameters = ListPaymentsWithSummaryDataParameters.builder()
      .offset(1L)
      .limit(10L)
      .customer("customer")
      .customerGroupName("customerGroupName")
      .billingType(ApiPaymentListRequestBillingType.UNDEFINED)
      .status(ApiPaymentListRequestPaymentStatus.PENDING)
      .subscription("subscription")
      .installment("installment")
      .externalReference("externalReference")
      .paymentDate("paymentDate")
      .invoiceStatus(ApiPaymentListRequestInvoiceStatus.SCHEDULED)
      .estimatedCreditDate("estimatedCreditDate")
      .pixQrCodeId("pixQrCodeId")
      .anticipated(true)
      .anticipable(true)
      .dateCreatedGe("dateCreated[ge]")
      .dateCreatedLe("dateCreated[le]")
      .paymentDateGe("paymentDate[ge]")
      .paymentDateLe("paymentDate[le]")
      .estimatedCreditDateGe("estimatedCreditDate[ge]")
      .estimatedCreditDateLe("estimatedCreditDate[le]")
      .dueDateGe("dueDate[ge]")
      .dueDateLe("dueDate[le]")
      .user("user")
      .build();

    ApiPaymentLeanListResponseDto response = asaasSdk.paymentWithSummaryData.listPaymentsWithSummaryData(
      requestParameters
    );

    System.out.println(response);
  }
}

```

## createNewPaymentWithSummaryDataInResponse

- HTTP Method: `POST`
- Endpoint: `/v3/lean/payments`

**Parameters**

| Name                     | Type                                                              | Required | Description  |
| :----------------------- | :---------------------------------------------------------------- | :------- | :----------- |
| apiPaymentSaveRequestDto | [ApiPaymentSaveRequestDto](../models/ApiPaymentSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`ApiPaymentLeanGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentCallbackRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDiscountDiscountType;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDiscountDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentFineRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentFineRequestFineType;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentInterestRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentLeanGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentSaveRequestBillingType;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentSaveRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentSplitRequestDto;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentDiscountDto apiPaymentDiscountDto = ApiPaymentDiscountDto.builder()
      .value(10D)
      .dueDateLimitDays(1L)
      .type(ApiPaymentDiscountDiscountType.FIXED)
      .build();

    ApiPaymentInterestRequestDto apiPaymentInterestRequestDto = ApiPaymentInterestRequestDto.builder()
      .value(4.68D)
      .build();

    ApiPaymentFineRequestDto apiPaymentFineRequestDto = ApiPaymentFineRequestDto.builder()
      .value(8.99D)
      .type(ApiPaymentFineRequestFineType.FIXED)
      .build();

    ApiPaymentSplitRequestDto apiPaymentSplitRequestDto = ApiPaymentSplitRequestDto.builder()
      .walletId("walletId")
      .fixedValue(6.62D)
      .percentualValue(6.01D)
      .totalFixedValue(7.98D)
      .externalReference("externalReference")
      .description("description")
      .build();

    List<ApiPaymentSplitRequestDto> splitList = Arrays.asList(apiPaymentSplitRequestDto);

    ApiPaymentCallbackRequestDto apiPaymentCallbackRequestDto = ApiPaymentCallbackRequestDto.builder()
      .successUrl("successUrl")
      .autoRedirect(true)
      .build();

    ApiPaymentSaveRequestDto apiPaymentSaveRequestDto = ApiPaymentSaveRequestDto.builder()
      .customer("cus_G7Dvo4iphUNk")
      .billingType(ApiPaymentSaveRequestBillingType.UNDEFINED)
      .value(129.9D)
      .dueDate("2017-06-10")
      .description("Pedido 056984")
      .daysAfterDueDateToRegistrationCancellation(1L)
      .externalReference("056984")
      .installmentCount(7L)
      .totalValue(7.91D)
      .installmentValue(8.76D)
      .discount(apiPaymentDiscountDto)
      .interest(apiPaymentInterestRequestDto)
      .fine(apiPaymentFineRequestDto)
      .postalService(true)
      .split(splitList)
      .callback(apiPaymentCallbackRequestDto)
      .build();

    ApiPaymentLeanGetResponseDto response = asaasSdk.paymentWithSummaryData.createNewPaymentWithSummaryDataInResponse(
      apiPaymentSaveRequestDto
    );

    System.out.println(response);
  }
}

```

## createNewPaymentWithCreditCardWithSummaryDataInResponse

- HTTP Method: `POST`
- Endpoint: `/v3/lean/payments/`

**Parameters**

| Name                                   | Type                                                                                          | Required | Description  |
| :------------------------------------- | :-------------------------------------------------------------------------------------------- | :------- | :----------- |
| apiPaymentSaveWithCreditCardRequestDto | [ApiPaymentSaveWithCreditCardRequestDto](../models/ApiPaymentSaveWithCreditCardRequestDto.md) | ❌       | Request Body |

**Return Type**

`ApiPaymentLeanSaveWithCreditCardResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCreditCardHolderInfoRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiCreditCardRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentCallbackRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDiscountDiscountType;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDiscountDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentFineRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentFineRequestFineType;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentInterestRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentLeanSaveWithCreditCardResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentSaveWithCreditCardRequestBillingType;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentSaveWithCreditCardRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentSplitRequestDto;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentDiscountDto apiPaymentDiscountDto = ApiPaymentDiscountDto.builder()
      .value(10D)
      .dueDateLimitDays(1L)
      .type(ApiPaymentDiscountDiscountType.FIXED)
      .build();

    ApiPaymentInterestRequestDto apiPaymentInterestRequestDto = ApiPaymentInterestRequestDto.builder()
      .value(4.68D)
      .build();

    ApiPaymentFineRequestDto apiPaymentFineRequestDto = ApiPaymentFineRequestDto.builder()
      .value(8.99D)
      .type(ApiPaymentFineRequestFineType.FIXED)
      .build();

    ApiPaymentSplitRequestDto apiPaymentSplitRequestDto = ApiPaymentSplitRequestDto.builder()
      .walletId("walletId")
      .fixedValue(6.62D)
      .percentualValue(6.01D)
      .totalFixedValue(7.98D)
      .externalReference("externalReference")
      .description("description")
      .build();

    List<ApiPaymentSplitRequestDto> splitList = Arrays.asList(apiPaymentSplitRequestDto);

    ApiPaymentCallbackRequestDto apiPaymentCallbackRequestDto = ApiPaymentCallbackRequestDto.builder()
      .successUrl("successUrl")
      .autoRedirect(true)
      .build();

    ApiCreditCardRequestDto apiCreditCardRequestDto = ApiCreditCardRequestDto.builder()
      .holderName("John Doe")
      .number("1234567890123456")
      .expiryMonth("5")
      .expiryYear("2025")
      .ccv("123")
      .build();

    ApiCreditCardHolderInfoRequestDto apiCreditCardHolderInfoRequestDto = ApiCreditCardHolderInfoRequestDto.builder()
      .name("John Doe")
      .email("john.doe@asaas.com")
      .cpfCnpj("12345678901")
      .postalCode("12345678")
      .addressNumber("123")
      .addressComplement("addressComplement")
      .phone("phone")
      .mobilePhone("mobilePhone")
      .build();

    ApiPaymentSaveWithCreditCardRequestDto apiPaymentSaveWithCreditCardRequestDto =
      ApiPaymentSaveWithCreditCardRequestDto.builder()
        .customer("cus_G7Dvo4iphUNk")
        .billingType(ApiPaymentSaveWithCreditCardRequestBillingType.UNDEFINED)
        .value(129.9D)
        .dueDate("2017-06-10")
        .description("Pedido 056984")
        .daysAfterDueDateToRegistrationCancellation(1L)
        .externalReference("056984")
        .installmentCount(6L)
        .totalValue(3.41D)
        .installmentValue(8.68D)
        .discount(apiPaymentDiscountDto)
        .interest(apiPaymentInterestRequestDto)
        .fine(apiPaymentFineRequestDto)
        .postalService(true)
        .split(splitList)
        .callback(apiPaymentCallbackRequestDto)
        .creditCard(apiCreditCardRequestDto)
        .creditCardHolderInfo(apiCreditCardHolderInfoRequestDto)
        .creditCardToken("creditCardToken")
        .authorizeOnly(false)
        .remoteIp("remoteIp")
        .build();

    ApiPaymentLeanSaveWithCreditCardResponseDto response =
      asaasSdk.paymentWithSummaryData.createNewPaymentWithCreditCardWithSummaryDataInResponse(
        apiPaymentSaveWithCreditCardRequestDto
      );

    System.out.println(response);
  }
}

```

## capturePaymentWithPreAuthorizationWithSummaryDataInResponse

- HTTP Method: `POST`
- Endpoint: `/v3/lean/payments/{id}/captureAuthorizedPayment`

**Parameters**

| Name  | Type   | Required | Description                        |
| :---- | :----- | :------- | :--------------------------------- |
| id    | String | ✅       | Unique payment identifier in Asaas |
| input | Object | ❌       | Request Body                       |

**Return Type**

`ApiPaymentLeanGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentLeanGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentLeanGetResponseDto response =
      asaasSdk.paymentWithSummaryData.capturePaymentWithPreAuthorizationWithSummaryDataInResponse("id", new Object());

    System.out.println(response);
  }
}

```

## retrieveASinglePaymentWithSummaryData

- HTTP Method: `GET`
- Endpoint: `/v3/lean/payments/{id}`

**Parameters**

| Name | Type   | Required | Description                        |
| :--- | :----- | :------- | :--------------------------------- |
| id   | String | ✅       | Unique payment identifier in Asaas |

**Return Type**

`ApiPaymentLeanGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentLeanGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentLeanGetResponseDto response = asaasSdk.paymentWithSummaryData.retrieveASinglePaymentWithSummaryData("id");

    System.out.println(response);
  }
}

```

## updateExistingPaymentWithSummaryDataInResponse

- HTTP Method: `PUT`
- Endpoint: `/v3/lean/payments/{id}`

**Parameters**

| Name  | Type   | Required | Description                        |
| :---- | :----- | :------- | :--------------------------------- |
| id    | String | ✅       | Unique payment identifier in Asaas |
| input | Object | ❌       | Request Body                       |

**Return Type**

`ApiPaymentLeanGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentLeanGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentLeanGetResponseDto response =
      asaasSdk.paymentWithSummaryData.updateExistingPaymentWithSummaryDataInResponse("id", new Object());

    System.out.println(response);
  }
}

```

## deletePaymentWithSummaryData

- HTTP Method: `DELETE`
- Endpoint: `/v3/lean/payments/{id}`

**Parameters**

| Name | Type   | Required | Description                        |
| :--- | :----- | :------- | :--------------------------------- |
| id   | String | ✅       | Unique payment identifier in Asaas |

**Return Type**

`ApiPaymentDeleteResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDeleteResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentDeleteResponseDto response = asaasSdk.paymentWithSummaryData.deletePaymentWithSummaryData("id");

    System.out.println(response);
  }
}

```

## restoreRemovedPaymentWithSummaryDataInResponse

- HTTP Method: `POST`
- Endpoint: `/v3/lean/payments/{id}/restore`

**Parameters**

| Name  | Type   | Required | Description                        |
| :---- | :----- | :------- | :--------------------------------- |
| id    | String | ✅       | Unique payment identifier in Asaas |
| input | Object | ❌       | Request Body                       |

**Return Type**

`ApiPaymentLeanGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentLeanGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentLeanGetResponseDto response =
      asaasSdk.paymentWithSummaryData.restoreRemovedPaymentWithSummaryDataInResponse("id", new Object());

    System.out.println(response);
  }
}

```

## refundPaymentWithSummaryDataInResponse

- HTTP Method: `POST`
- Endpoint: `/v3/lean/payments/{id}/refund`

**Parameters**

| Name                       | Type                                                                  | Required | Description                        |
| :------------------------- | :-------------------------------------------------------------------- | :------- | :--------------------------------- |
| id                         | String                                                                | ✅       | Unique payment identifier in Asaas |
| apiPaymentRefundRequestDto | [ApiPaymentRefundRequestDto](../models/ApiPaymentRefundRequestDto.md) | ❌       | Request Body                       |

**Return Type**

`ApiPaymentLeanGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentLeanGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentRefundRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentRefundRequestDto apiPaymentRefundRequestDto = ApiPaymentRefundRequestDto.builder()
      .value(5D)
      .description("Valor a mais")
      .build();

    ApiPaymentLeanGetResponseDto response = asaasSdk.paymentWithSummaryData.refundPaymentWithSummaryDataInResponse(
      "id",
      apiPaymentRefundRequestDto
    );

    System.out.println(response);
  }
}

```

## confirmCashReceiptWithSummaryDataInResponse

- HTTP Method: `POST`
- Endpoint: `/v3/lean/payments/{id}/receiveInCash`

**Parameters**

| Name                              | Type                                                                                | Required | Description                        |
| :-------------------------------- | :---------------------------------------------------------------------------------- | :------- | :--------------------------------- |
| id                                | String                                                                              | ✅       | Unique payment identifier in Asaas |
| apiPaymentReceiveInCashRequestDto | [ApiPaymentReceiveInCashRequestDto](../models/ApiPaymentReceiveInCashRequestDto.md) | ❌       | Request Body                       |

**Return Type**

`ApiPaymentLeanGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentLeanGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentReceiveInCashRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentReceiveInCashRequestDto apiPaymentReceiveInCashRequestDto = ApiPaymentReceiveInCashRequestDto.builder()
      .paymentDate("28/05/2025")
      .value(129.9D)
      .notifyCustomer(true)
      .build();

    ApiPaymentLeanGetResponseDto response = asaasSdk.paymentWithSummaryData.confirmCashReceiptWithSummaryDataInResponse(
      "id",
      apiPaymentReceiveInCashRequestDto
    );

    System.out.println(response);
  }
}

```

## undoCashReceiptConfirmationWithSummaryDataInResponse

- HTTP Method: `POST`
- Endpoint: `/v3/lean/payments/{id}/undoReceivedInCash`

**Parameters**

| Name  | Type   | Required | Description                        |
| :---- | :----- | :------- | :--------------------------------- |
| id    | String | ✅       | Unique payment identifier in Asaas |
| input | Object | ❌       | Request Body                       |

**Return Type**

`ApiPaymentLeanGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentLeanGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentLeanGetResponseDto response =
      asaasSdk.paymentWithSummaryData.undoCashReceiptConfirmationWithSummaryDataInResponse("id", new Object());

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
