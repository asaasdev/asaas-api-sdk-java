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

`PaymentLeanListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ListPaymentsWithSummaryDataParameters;
import com.asaas.apisdk.models.PaymentLeanListResponseDto;
import com.asaas.apisdk.models.PaymentListRequestBillingType;
import com.asaas.apisdk.models.PaymentListRequestInvoiceStatus;
import com.asaas.apisdk.models.PaymentListRequestPaymentStatus;

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
      .billingType(PaymentListRequestBillingType.UNDEFINED)
      .status(PaymentListRequestPaymentStatus.PENDING)
      .subscription("subscription")
      .installment("installment")
      .externalReference("externalReference")
      .paymentDate("paymentDate")
      .invoiceStatus(PaymentListRequestInvoiceStatus.SCHEDULED)
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

    PaymentLeanListResponseDto response = asaasSdk.paymentWithSummaryData.listPaymentsWithSummaryData(
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

| Name                  | Type                                                        | Required | Description  |
| :-------------------- | :---------------------------------------------------------- | :------- | :----------- |
| paymentSaveRequestDto | [PaymentSaveRequestDto](../models/PaymentSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`PaymentLeanGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentCallbackRequestDto;
import com.asaas.apisdk.models.PaymentDiscountDiscountType;
import com.asaas.apisdk.models.PaymentDiscountDto;
import com.asaas.apisdk.models.PaymentFineRequestDto;
import com.asaas.apisdk.models.PaymentFineRequestFineType;
import com.asaas.apisdk.models.PaymentInterestRequestDto;
import com.asaas.apisdk.models.PaymentLeanGetResponseDto;
import com.asaas.apisdk.models.PaymentSaveRequestBillingType;
import com.asaas.apisdk.models.PaymentSaveRequestDto;
import com.asaas.apisdk.models.PaymentSplitRequestDto;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentDiscountDto paymentDiscountDto = PaymentDiscountDto.builder()
      .value(10D)
      .dueDateLimitDays(1L)
      .type(PaymentDiscountDiscountType.FIXED)
      .build();

    PaymentInterestRequestDto paymentInterestRequestDto = PaymentInterestRequestDto.builder().value(4.68D).build();

    PaymentFineRequestDto paymentFineRequestDto = PaymentFineRequestDto.builder()
      .value(8.99D)
      .type(PaymentFineRequestFineType.FIXED)
      .build();

    PaymentSplitRequestDto paymentSplitRequestDto = PaymentSplitRequestDto.builder()
      .walletId("walletId")
      .fixedValue(6.62D)
      .percentualValue(6.01D)
      .totalFixedValue(7.98D)
      .externalReference("externalReference")
      .description("description")
      .build();

    List<PaymentSplitRequestDto> splitList = Arrays.asList(paymentSplitRequestDto);

    PaymentCallbackRequestDto paymentCallbackRequestDto = PaymentCallbackRequestDto.builder()
      .successUrl("successUrl")
      .autoRedirect(true)
      .build();

    PaymentSaveRequestDto paymentSaveRequestDto = PaymentSaveRequestDto.builder()
      .customer("cus_G7Dvo4iphUNk")
      .billingType(PaymentSaveRequestBillingType.UNDEFINED)
      .value(129.9D)
      .dueDate("2017-06-10")
      .description("Pedido 056984")
      .daysAfterDueDateToRegistrationCancellation(1L)
      .externalReference("056984")
      .installmentCount(7L)
      .totalValue(7.91D)
      .installmentValue(8.76D)
      .discount(paymentDiscountDto)
      .interest(paymentInterestRequestDto)
      .fine(paymentFineRequestDto)
      .postalService(true)
      .split(splitList)
      .callback(paymentCallbackRequestDto)
      .build();

    PaymentLeanGetResponseDto response = asaasSdk.paymentWithSummaryData.createNewPaymentWithSummaryDataInResponse(
      paymentSaveRequestDto
    );

    System.out.println(response);
  }
}

```

## createNewPaymentWithCreditCardWithSummaryDataInResponse

- HTTP Method: `POST`
- Endpoint: `/v3/lean/payments/`

**Parameters**

| Name                                | Type                                                                                    | Required | Description  |
| :---------------------------------- | :-------------------------------------------------------------------------------------- | :------- | :----------- |
| paymentSaveWithCreditCardRequestDto | [PaymentSaveWithCreditCardRequestDto](../models/PaymentSaveWithCreditCardRequestDto.md) | ❌       | Request Body |

**Return Type**

`PaymentLeanSaveWithCreditCardResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.CreditCardHolderInfoRequestDto;
import com.asaas.apisdk.models.CreditCardRequestDto;
import com.asaas.apisdk.models.PaymentCallbackRequestDto;
import com.asaas.apisdk.models.PaymentDiscountDiscountType;
import com.asaas.apisdk.models.PaymentDiscountDto;
import com.asaas.apisdk.models.PaymentFineRequestDto;
import com.asaas.apisdk.models.PaymentFineRequestFineType;
import com.asaas.apisdk.models.PaymentInterestRequestDto;
import com.asaas.apisdk.models.PaymentLeanSaveWithCreditCardResponseDto;
import com.asaas.apisdk.models.PaymentSaveWithCreditCardRequestBillingType;
import com.asaas.apisdk.models.PaymentSaveWithCreditCardRequestDto;
import com.asaas.apisdk.models.PaymentSplitRequestDto;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentDiscountDto paymentDiscountDto = PaymentDiscountDto.builder()
      .value(10D)
      .dueDateLimitDays(1L)
      .type(PaymentDiscountDiscountType.FIXED)
      .build();

    PaymentInterestRequestDto paymentInterestRequestDto = PaymentInterestRequestDto.builder().value(4.68D).build();

    PaymentFineRequestDto paymentFineRequestDto = PaymentFineRequestDto.builder()
      .value(8.99D)
      .type(PaymentFineRequestFineType.FIXED)
      .build();

    PaymentSplitRequestDto paymentSplitRequestDto = PaymentSplitRequestDto.builder()
      .walletId("walletId")
      .fixedValue(6.62D)
      .percentualValue(6.01D)
      .totalFixedValue(7.98D)
      .externalReference("externalReference")
      .description("description")
      .build();

    List<PaymentSplitRequestDto> splitList = Arrays.asList(paymentSplitRequestDto);

    PaymentCallbackRequestDto paymentCallbackRequestDto = PaymentCallbackRequestDto.builder()
      .successUrl("successUrl")
      .autoRedirect(true)
      .build();

    CreditCardRequestDto creditCardRequestDto = CreditCardRequestDto.builder()
      .holderName("John Doe")
      .number("1234567890123456")
      .expiryMonth("7")
      .expiryYear("2025")
      .ccv("123")
      .build();

    CreditCardHolderInfoRequestDto creditCardHolderInfoRequestDto = CreditCardHolderInfoRequestDto.builder()
      .name("John Doe")
      .email("john.doe@asaas.com")
      .cpfCnpj("12345678901")
      .postalCode("12345678")
      .addressNumber("123")
      .addressComplement("addressComplement")
      .phone("phone")
      .mobilePhone("mobilePhone")
      .build();

    PaymentSaveWithCreditCardRequestDto paymentSaveWithCreditCardRequestDto =
      PaymentSaveWithCreditCardRequestDto.builder()
        .customer("cus_G7Dvo4iphUNk")
        .billingType(PaymentSaveWithCreditCardRequestBillingType.UNDEFINED)
        .value(129.9D)
        .dueDate("2017-06-10")
        .description("Pedido 056984")
        .daysAfterDueDateToRegistrationCancellation(1L)
        .externalReference("056984")
        .installmentCount(6L)
        .totalValue(3.41D)
        .installmentValue(8.68D)
        .discount(paymentDiscountDto)
        .interest(paymentInterestRequestDto)
        .fine(paymentFineRequestDto)
        .postalService(true)
        .split(splitList)
        .callback(paymentCallbackRequestDto)
        .creditCard(creditCardRequestDto)
        .creditCardHolderInfo(creditCardHolderInfoRequestDto)
        .creditCardToken("creditCardToken")
        .authorizeOnly(false)
        .remoteIp("remoteIp")
        .build();

    PaymentLeanSaveWithCreditCardResponseDto response =
      asaasSdk.paymentWithSummaryData.createNewPaymentWithCreditCardWithSummaryDataInResponse(
        paymentSaveWithCreditCardRequestDto
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

`PaymentLeanGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentLeanGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentLeanGetResponseDto response =
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

`PaymentLeanGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentLeanGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentLeanGetResponseDto response = asaasSdk.paymentWithSummaryData.retrieveASinglePaymentWithSummaryData("id");

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

`PaymentLeanGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentLeanGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentLeanGetResponseDto response = asaasSdk.paymentWithSummaryData.updateExistingPaymentWithSummaryDataInResponse(
      "id",
      new Object()
    );

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

`PaymentDeleteResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentDeleteResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentDeleteResponseDto response = asaasSdk.paymentWithSummaryData.deletePaymentWithSummaryData("id");

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

`PaymentLeanGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentLeanGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentLeanGetResponseDto response = asaasSdk.paymentWithSummaryData.restoreRemovedPaymentWithSummaryDataInResponse(
      "id",
      new Object()
    );

    System.out.println(response);
  }
}

```

## refundPaymentWithSummaryDataInResponse

- HTTP Method: `POST`
- Endpoint: `/v3/lean/payments/{id}/refund`

**Parameters**

| Name                    | Type                                                            | Required | Description                        |
| :---------------------- | :-------------------------------------------------------------- | :------- | :--------------------------------- |
| id                      | String                                                          | ✅       | Unique payment identifier in Asaas |
| paymentRefundRequestDto | [PaymentRefundRequestDto](../models/PaymentRefundRequestDto.md) | ❌       | Request Body                       |

**Return Type**

`PaymentLeanGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentLeanGetResponseDto;
import com.asaas.apisdk.models.PaymentRefundRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentRefundRequestDto paymentRefundRequestDto = PaymentRefundRequestDto.builder()
      .value(5D)
      .description("Valor a mais")
      .build();

    PaymentLeanGetResponseDto response = asaasSdk.paymentWithSummaryData.refundPaymentWithSummaryDataInResponse(
      "id",
      paymentRefundRequestDto
    );

    System.out.println(response);
  }
}

```

## confirmCashReceiptWithSummaryDataInResponse

- HTTP Method: `POST`
- Endpoint: `/v3/lean/payments/{id}/receiveInCash`

**Parameters**

| Name                           | Type                                                                          | Required | Description                        |
| :----------------------------- | :---------------------------------------------------------------------------- | :------- | :--------------------------------- |
| id                             | String                                                                        | ✅       | Unique payment identifier in Asaas |
| paymentReceiveInCashRequestDto | [PaymentReceiveInCashRequestDto](../models/PaymentReceiveInCashRequestDto.md) | ❌       | Request Body                       |

**Return Type**

`PaymentLeanGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentLeanGetResponseDto;
import com.asaas.apisdk.models.PaymentReceiveInCashRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentReceiveInCashRequestDto paymentReceiveInCashRequestDto = PaymentReceiveInCashRequestDto.builder()
      .paymentDate("2025-05-30")
      .value(129.9D)
      .notifyCustomer(true)
      .build();

    PaymentLeanGetResponseDto response = asaasSdk.paymentWithSummaryData.confirmCashReceiptWithSummaryDataInResponse(
      "id",
      paymentReceiveInCashRequestDto
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

`PaymentLeanGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentLeanGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentLeanGetResponseDto response =
      asaasSdk.paymentWithSummaryData.undoCashReceiptConfirmationWithSummaryDataInResponse("id", new Object());

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
