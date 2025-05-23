# PaymentService

A list of all methods in the `PaymentService` service. Click on the method name to view detailed information about that method.

| Methods                                                                             | Description |
| :---------------------------------------------------------------------------------- | :---------- |
| [listPayments](#listpayments)                                                       |             |
| [createNewPayment](#createnewpayment)                                               |             |
| [createNewPaymentWithCreditCard](#createnewpaymentwithcreditcard)                   |             |
| [capturePaymentWithPreAuthorization](#capturepaymentwithpreauthorization)           |             |
| [payAChargeWithCreditCard](#payachargewithcreditcard)                               |             |
| [retrievePaymentBillingInformation](#retrievepaymentbillinginformation)             |             |
| [paymentViewingInformation](#paymentviewinginformation)                             |             |
| [retrieveASinglePayment](#retrieveasinglepayment)                                   |             |
| [updateExistingPayment](#updateexistingpayment)                                     |             |
| [deletePayment](#deletepayment)                                                     |             |
| [restoreRemovedPayment](#restoreremovedpayment)                                     |             |
| [retrieveStatusOfAPayment](#retrievestatusofapayment)                               |             |
| [refundPayment](#refundpayment)                                                     |             |
| [getDigitableBillLine](#getdigitablebillline)                                       |             |
| [getQrCodeForPixPayments](#getqrcodeforpixpayments)                                 |             |
| [confirmCashReceipt](#confirmcashreceipt)                                           |             |
| [undoCashReceiptConfirmation](#undocashreceiptconfirmation)                         |             |
| [salesSimulator](#salessimulator)                                                   |             |
| [retrievePaymentEscrowInTheEscrowAccount](#retrievepaymentescrowintheescrowaccount) |             |
| [recoveringPaymentLimits](#recoveringpaymentlimits)                                 |             |

## listPayments

- HTTP Method: `GET`
- Endpoint: `/v3/payments`

**Parameters**

| Name              | Type                                                          | Required | Description               |
| :---------------- | :------------------------------------------------------------ | :------- | :------------------------ |
| requestParameters | [ListPaymentsParameters](../models/ListPaymentsParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ApiPaymentListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentListRequestBillingType;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentListRequestInvoiceStatus;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentListRequestPaymentStatus;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentListResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ListPaymentsParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListPaymentsParameters requestParameters = ListPaymentsParameters.builder()
      .installment("installment")
      .offset(8L)
      .limit(10L)
      .customer("customer")
      .customerGroupName("customerGroupName")
      .billingType(ApiPaymentListRequestBillingType.UNDEFINED)
      .status(ApiPaymentListRequestPaymentStatus.PENDING)
      .subscription("subscription")
      .externalReference("externalReference")
      .paymentDate("paymentDate")
      .invoiceStatus(ApiPaymentListRequestInvoiceStatus.SCHEDULED)
      .estimatedCreditDate("estimatedCreditDate")
      .pixQrCodeId("pixQrCodeId")
      .anticipated(false)
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

    ApiPaymentListResponseDto response = asaasSdk.payment.listPayments(requestParameters);

    System.out.println(response);
  }
}

```

## createNewPayment

- HTTP Method: `POST`
- Endpoint: `/v3/payments`

**Parameters**

| Name                     | Type                                                              | Required | Description  |
| :----------------------- | :---------------------------------------------------------------- | :------- | :----------- |
| apiPaymentSaveRequestDto | [ApiPaymentSaveRequestDto](../models/ApiPaymentSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`ApiPaymentGetResponseDto`

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
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentInterestRequestDto;
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

    ApiPaymentGetResponseDto response = asaasSdk.payment.createNewPayment(apiPaymentSaveRequestDto);

    System.out.println(response);
  }
}

```

## createNewPaymentWithCreditCard

- HTTP Method: `POST`
- Endpoint: `/v3/payments/`

**Parameters**

| Name                                   | Type                                                                                          | Required | Description  |
| :------------------------------------- | :-------------------------------------------------------------------------------------------- | :------- | :----------- |
| apiPaymentSaveWithCreditCardRequestDto | [ApiPaymentSaveWithCreditCardRequestDto](../models/ApiPaymentSaveWithCreditCardRequestDto.md) | ❌       | Request Body |

**Return Type**

`ApiPaymentGetResponseDto`

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
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentInterestRequestDto;
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

    ApiPaymentGetResponseDto response = asaasSdk.payment.createNewPaymentWithCreditCard(
      apiPaymentSaveWithCreditCardRequestDto
    );

    System.out.println(response);
  }
}

```

## capturePaymentWithPreAuthorization

- HTTP Method: `POST`
- Endpoint: `/v3/payments/{id}/captureAuthorizedPayment`

**Parameters**

| Name                       | Type                                                                  | Required | Description                        |
| :------------------------- | :-------------------------------------------------------------------- | :------- | :--------------------------------- |
| id                         | String                                                                | ✅       | Unique payment identifier in Asaas |
| apiPaymentPathIdRequestDto | [ApiPaymentPathIdRequestDto](../models/ApiPaymentPathIdRequestDto.md) | ❌       | Request Body                       |

**Return Type**

`ApiPaymentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentPathIdRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentPathIdRequestDto apiPaymentPathIdRequestDto = ApiPaymentPathIdRequestDto.builder().id("id").build();

    ApiPaymentGetResponseDto response = asaasSdk.payment.capturePaymentWithPreAuthorization(
      "id",
      apiPaymentPathIdRequestDto
    );

    System.out.println(response);
  }
}

```

## payAChargeWithCreditCard

- HTTP Method: `POST`
- Endpoint: `/v3/payments/{id}/payWithCreditCard`

**Parameters**

| Name                                  | Type                                                                                        | Required | Description                        |
| :------------------------------------ | :------------------------------------------------------------------------------------------ | :------- | :--------------------------------- |
| id                                    | String                                                                                      | ✅       | Unique payment identifier in Asaas |
| apiPaymentPayWithCreditCardRequestDto | [ApiPaymentPayWithCreditCardRequestDto](../models/ApiPaymentPayWithCreditCardRequestDto.md) | ❌       | Request Body                       |

**Return Type**

`ApiPaymentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCreditCardHolderInfoRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiCreditCardRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentPayWithCreditCardRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

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

    ApiPaymentPayWithCreditCardRequestDto apiPaymentPayWithCreditCardRequestDto =
      ApiPaymentPayWithCreditCardRequestDto.builder()
        .id("id")
        .creditCard(apiCreditCardRequestDto)
        .creditCardHolderInfo(apiCreditCardHolderInfoRequestDto)
        .creditCardToken("creditCardToken")
        .build();

    ApiPaymentGetResponseDto response = asaasSdk.payment.payAChargeWithCreditCard(
      "id",
      apiPaymentPayWithCreditCardRequestDto
    );

    System.out.println(response);
  }
}

```

## retrievePaymentBillingInformation

- HTTP Method: `GET`
- Endpoint: `/v3/payments/{id}/billingInfo`

**Parameters**

| Name | Type   | Required | Description                        |
| :--- | :----- | :------- | :--------------------------------- |
| id   | String | ✅       | Unique payment identifier in Asaas |

**Return Type**

`ApiPaymentBillingInfoResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentBillingInfoResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentBillingInfoResponseDto response = asaasSdk.payment.retrievePaymentBillingInformation("id");

    System.out.println(response);
  }
}

```

## paymentViewingInformation

- HTTP Method: `GET`
- Endpoint: `/v3/payments/{id}/viewingInfo`

**Parameters**

| Name | Type   | Required | Description                        |
| :--- | :----- | :------- | :--------------------------------- |
| id   | String | ✅       | Unique payment identifier in Asaas |

**Return Type**

`ApiPaymentViewingInfoResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentViewingInfoResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentViewingInfoResponseDto response = asaasSdk.payment.paymentViewingInformation("id");

    System.out.println(response);
  }
}

```

## retrieveASinglePayment

- HTTP Method: `GET`
- Endpoint: `/v3/payments/{id}`

**Parameters**

| Name | Type   | Required | Description                        |
| :--- | :----- | :------- | :--------------------------------- |
| id   | String | ✅       | Unique payment identifier in Asaas |

**Return Type**

`ApiPaymentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentGetResponseDto response = asaasSdk.payment.retrieveASinglePayment("id");

    System.out.println(response);
  }
}

```

## updateExistingPayment

- HTTP Method: `PUT`
- Endpoint: `/v3/payments/{id}`

**Parameters**

| Name                       | Type                                                                  | Required | Description                        |
| :------------------------- | :-------------------------------------------------------------------- | :------- | :--------------------------------- |
| id                         | String                                                                | ✅       | Unique payment identifier in Asaas |
| apiPaymentUpdateRequestDto | [ApiPaymentUpdateRequestDto](../models/ApiPaymentUpdateRequestDto.md) | ❌       | Request Body                       |

**Return Type**

`ApiPaymentGetResponseDto`

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
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentInterestRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentSplitRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentUpdateRequestBillingType;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentUpdateRequestDto;
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

    ApiPaymentUpdateRequestDto apiPaymentUpdateRequestDto = ApiPaymentUpdateRequestDto.builder()
      .id("pay_080225913252")
      .billingType(ApiPaymentUpdateRequestBillingType.UNDEFINED)
      .value(129.9D)
      .dueDate("2017-06-10")
      .description("Pedido 056984")
      .daysAfterDueDateToRegistrationCancellation(1L)
      .externalReference("056984")
      .discount(apiPaymentDiscountDto)
      .interest(apiPaymentInterestRequestDto)
      .fine(apiPaymentFineRequestDto)
      .postalService(false)
      .split(splitList)
      .callback(apiPaymentCallbackRequestDto)
      .build();

    ApiPaymentGetResponseDto response = asaasSdk.payment.updateExistingPayment(
      "pay_080225913252",
      apiPaymentUpdateRequestDto
    );

    System.out.println(response);
  }
}

```

## deletePayment

- HTTP Method: `DELETE`
- Endpoint: `/v3/payments/{id}`

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

    ApiPaymentDeleteResponseDto response = asaasSdk.payment.deletePayment("id");

    System.out.println(response);
  }
}

```

## restoreRemovedPayment

- HTTP Method: `POST`
- Endpoint: `/v3/payments/{id}/restore`

**Parameters**

| Name                       | Type                                                                  | Required | Description                        |
| :------------------------- | :-------------------------------------------------------------------- | :------- | :--------------------------------- |
| id                         | String                                                                | ✅       | Unique payment identifier in Asaas |
| apiPaymentPathIdRequestDto | [ApiPaymentPathIdRequestDto](../models/ApiPaymentPathIdRequestDto.md) | ❌       | Request Body                       |

**Return Type**

`ApiPaymentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentPathIdRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentPathIdRequestDto apiPaymentPathIdRequestDto = ApiPaymentPathIdRequestDto.builder().id("id").build();

    ApiPaymentGetResponseDto response = asaasSdk.payment.restoreRemovedPayment("id", apiPaymentPathIdRequestDto);

    System.out.println(response);
  }
}

```

## retrieveStatusOfAPayment

- HTTP Method: `GET`
- Endpoint: `/v3/payments/{id}/status`

**Parameters**

| Name | Type   | Required | Description                        |
| :--- | :----- | :------- | :--------------------------------- |
| id   | String | ✅       | Unique payment identifier in Asaas |

**Return Type**

`ApiPaymentStatusResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentStatusResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentStatusResponseDto response = asaasSdk.payment.retrieveStatusOfAPayment("id");

    System.out.println(response);
  }
}

```

## refundPayment

- HTTP Method: `POST`
- Endpoint: `/v3/payments/{id}/refund`

**Parameters**

| Name                       | Type                                                                  | Required | Description                        |
| :------------------------- | :-------------------------------------------------------------------- | :------- | :--------------------------------- |
| id                         | String                                                                | ✅       | Unique payment identifier in Asaas |
| apiPaymentRefundRequestDto | [ApiPaymentRefundRequestDto](../models/ApiPaymentRefundRequestDto.md) | ❌       | Request Body                       |

**Return Type**

`ApiPaymentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentRefundRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentRefundRequestDto apiPaymentRefundRequestDto = ApiPaymentRefundRequestDto.builder()
      .id("id")
      .value(5D)
      .description("Valor a mais")
      .build();

    ApiPaymentGetResponseDto response = asaasSdk.payment.refundPayment("id", apiPaymentRefundRequestDto);

    System.out.println(response);
  }
}

```

## getDigitableBillLine

- HTTP Method: `GET`
- Endpoint: `/v3/payments/{id}/identificationField`

**Parameters**

| Name | Type   | Required | Description                        |
| :--- | :----- | :------- | :--------------------------------- |
| id   | String | ✅       | Unique payment identifier in Asaas |

**Return Type**

`ApiPaymentIdentificationFieldResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentIdentificationFieldResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentIdentificationFieldResponseDto response = asaasSdk.payment.getDigitableBillLine("id");

    System.out.println(response);
  }
}

```

## getQrCodeForPixPayments

- HTTP Method: `GET`
- Endpoint: `/v3/payments/{id}/pixQrCode`

**Parameters**

| Name | Type   | Required | Description                        |
| :--- | :----- | :------- | :--------------------------------- |
| id   | String | ✅       | Unique payment identifier in Asaas |

**Return Type**

`ApiPaymentPixQrCodeResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentPixQrCodeResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentPixQrCodeResponseDto response = asaasSdk.payment.getQrCodeForPixPayments("id");

    System.out.println(response);
  }
}

```

## confirmCashReceipt

- HTTP Method: `POST`
- Endpoint: `/v3/payments/{id}/receiveInCash`

**Parameters**

| Name                              | Type                                                                                | Required | Description                        |
| :-------------------------------- | :---------------------------------------------------------------------------------- | :------- | :--------------------------------- |
| id                                | String                                                                              | ✅       | Unique payment identifier in Asaas |
| apiPaymentReceiveInCashRequestDto | [ApiPaymentReceiveInCashRequestDto](../models/ApiPaymentReceiveInCashRequestDto.md) | ❌       | Request Body                       |

**Return Type**

`ApiPaymentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentReceiveInCashRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentReceiveInCashRequestDto apiPaymentReceiveInCashRequestDto = ApiPaymentReceiveInCashRequestDto.builder()
      .id("id")
      .paymentDate("23/05/2025")
      .value(129.9D)
      .notifyCustomer(true)
      .build();

    ApiPaymentGetResponseDto response = asaasSdk.payment.confirmCashReceipt("id", apiPaymentReceiveInCashRequestDto);

    System.out.println(response);
  }
}

```

## undoCashReceiptConfirmation

- HTTP Method: `POST`
- Endpoint: `/v3/payments/{id}/undoReceivedInCash`

**Parameters**

| Name                       | Type                                                                  | Required | Description                        |
| :------------------------- | :-------------------------------------------------------------------- | :------- | :--------------------------------- |
| id                         | String                                                                | ✅       | Unique payment identifier in Asaas |
| apiPaymentPathIdRequestDto | [ApiPaymentPathIdRequestDto](../models/ApiPaymentPathIdRequestDto.md) | ❌       | Request Body                       |

**Return Type**

`ApiPaymentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentPathIdRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentPathIdRequestDto apiPaymentPathIdRequestDto = ApiPaymentPathIdRequestDto.builder().id("id").build();

    ApiPaymentGetResponseDto response = asaasSdk.payment.undoCashReceiptConfirmation("id", apiPaymentPathIdRequestDto);

    System.out.println(response);
  }
}

```

## salesSimulator

- HTTP Method: `POST`
- Endpoint: `/v3/payments/simulate`

**Parameters**

| Name                         | Type                                                                      | Required | Description  |
| :--------------------------- | :------------------------------------------------------------------------ | :------- | :----------- |
| apiPaymentSimulateRequestDto | [ApiPaymentSimulateRequestDto](../models/ApiPaymentSimulateRequestDto.md) | ❌       | Request Body |

**Return Type**

`ApiPaymentSimulateResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentSimulateRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentSimulateResponseDto;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    List<String> billingTypesList = Arrays.asList("billingTypes");

    ApiPaymentSimulateRequestDto apiPaymentSimulateRequestDto = ApiPaymentSimulateRequestDto.builder()
      .value(100D)
      .installmentCount(2L)
      .billingTypes(billingTypesList)
      .build();

    ApiPaymentSimulateResponseDto response = asaasSdk.payment.salesSimulator(apiPaymentSimulateRequestDto);

    System.out.println(response);
  }
}

```

## retrievePaymentEscrowInTheEscrowAccount

- HTTP Method: `GET`
- Endpoint: `/v3/payments/{id}/escrow`

**Parameters**

| Name | Type   | Required | Description                        |
| :--- | :----- | :------- | :--------------------------------- |
| id   | String | ✅       | Unique payment identifier in Asaas |

**Return Type**

`ApiPaymentCustodyGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentCustodyGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentCustodyGetResponseDto response = asaasSdk.payment.retrievePaymentEscrowInTheEscrowAccount("id");

    System.out.println(response);
  }
}

```

## recoveringPaymentLimits

- HTTP Method: `GET`
- Endpoint: `/v3/payments/limits`

**Return Type**

`ApiPaymentLimitsResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentLimitsResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentLimitsResponseDto response = asaasSdk.payment.recoveringPaymentLimits();

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
