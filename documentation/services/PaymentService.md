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

`ListPaymentsOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentListRequestBillingType;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentListRequestInvoiceStatus;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentListRequestPaymentStatus;
import com.asaas.sdk.asaasjavasdk.models.ListPaymentsOkResponse;
import com.asaas.sdk.asaasjavasdk.models.ListPaymentsParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListPaymentsParameters requestParameters = ListPaymentsParameters.builder()
      .installment("installment")
      .offset(6L)
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

    ListPaymentsOkResponse response = asaasSdk.payment.listPayments(requestParameters);

    System.out.println(response);
  }
}

```

## createNewPayment

- HTTP Method: `POST`
- Endpoint: `/v3/payments`

**Parameters**

| Name                    | Type                                                            | Required | Description  |
| :---------------------- | :-------------------------------------------------------------- | :------- | :----------- |
| createNewPaymentRequest | [CreateNewPaymentRequest](../models/CreateNewPaymentRequest.md) | ❌       | Request Body |

**Return Type**

`CreateNewPaymentOkResponse`

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
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentSaveRequestBillingType;
import com.asaas.sdk.asaasjavasdk.models.CreateNewPaymentOkResponse;
import com.asaas.sdk.asaasjavasdk.models.CreateNewPaymentRequest;
import com.asaas.sdk.asaasjavasdk.models.CreateNewPaymentRequestSplit;
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
      .dueDateLimitDays(7L)
      .type(ApiPaymentDiscountDiscountType.FIXED)
      .build();

    ApiPaymentInterestRequestDto apiPaymentInterestRequestDto = ApiPaymentInterestRequestDto.builder()
      .value(5.39D)
      .build();

    ApiPaymentFineRequestDto apiPaymentFineRequestDto = ApiPaymentFineRequestDto.builder()
      .value(4.4D)
      .type(ApiPaymentFineRequestFineType.FIXED)
      .build();

    CreateNewPaymentRequestSplit createNewPaymentRequestSplit = CreateNewPaymentRequestSplit.builder()
      .walletId("walletId")
      .fixedValue(6.81D)
      .percentualValue(7.95D)
      .totalFixedValue(1.39D)
      .externalReference("externalReference")
      .description("description")
      .build();

    List<CreateNewPaymentRequestSplit> splitList = Arrays.asList(createNewPaymentRequestSplit);

    ApiPaymentCallbackRequestDto apiPaymentCallbackRequestDto = ApiPaymentCallbackRequestDto.builder()
      .successUrl("successUrl")
      .autoRedirect(false)
      .build();

    CreateNewPaymentRequest createNewPaymentRequest = CreateNewPaymentRequest.builder()
      .customer("cus_G7Dvo4iphUNk")
      .billingType(ApiPaymentSaveRequestBillingType.UNDEFINED)
      .value(129.9D)
      .dueDate("2017-06-10")
      .description("Pedido 056984")
      .daysAfterDueDateToRegistrationCancellation(1L)
      .externalReference("056984")
      .installmentCount(3L)
      .totalValue(3.3D)
      .installmentValue(8.57D)
      .discount(apiPaymentDiscountDto)
      .interest(apiPaymentInterestRequestDto)
      .fine(apiPaymentFineRequestDto)
      .postalService(false)
      .split(splitList)
      .callback(apiPaymentCallbackRequestDto)
      .build();

    CreateNewPaymentOkResponse response = asaasSdk.payment.createNewPayment(createNewPaymentRequest);

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
      .dueDateLimitDays(7L)
      .type(ApiPaymentDiscountDiscountType.FIXED)
      .build();

    ApiPaymentInterestRequestDto apiPaymentInterestRequestDto = ApiPaymentInterestRequestDto.builder()
      .value(5.39D)
      .build();

    ApiPaymentFineRequestDto apiPaymentFineRequestDto = ApiPaymentFineRequestDto.builder()
      .value(4.4D)
      .type(ApiPaymentFineRequestFineType.FIXED)
      .build();

    ApiPaymentSplitRequestDto apiPaymentSplitRequestDto = ApiPaymentSplitRequestDto.builder()
      .walletId("walletId")
      .fixedValue(4.96D)
      .percentualValue(8.66D)
      .totalFixedValue(4.85D)
      .externalReference("externalReference")
      .description("description")
      .build();

    List<ApiPaymentSplitRequestDto> splitList = Arrays.asList(apiPaymentSplitRequestDto);

    ApiPaymentCallbackRequestDto apiPaymentCallbackRequestDto = ApiPaymentCallbackRequestDto.builder()
      .successUrl("successUrl")
      .autoRedirect(false)
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
        .installmentCount(0L)
        .totalValue(9.9D)
        .installmentValue(3.59D)
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

| Name  | Type   | Required | Description                        |
| :---- | :----- | :------- | :--------------------------------- |
| id    | String | ✅       | Unique payment identifier in Asaas |
| input | Object | ❌       | Request Body                       |

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

    ApiPaymentGetResponseDto response = asaasSdk.payment.capturePaymentWithPreAuthorization("id", new Object());

    System.out.println(response);
  }
}

```

## payAChargeWithCreditCard

- HTTP Method: `POST`
- Endpoint: `/v3/payments/{id}/payWithCreditCard`

**Parameters**

| Name                            | Type                                                                            | Required | Description                        |
| :------------------------------ | :------------------------------------------------------------------------------ | :------- | :--------------------------------- |
| id                              | String                                                                          | ✅       | Unique payment identifier in Asaas |
| payAChargeWithCreditCardRequest | [PayAChargeWithCreditCardRequest](../models/PayAChargeWithCreditCardRequest.md) | ❌       | Request Body                       |

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
import com.asaas.sdk.asaasjavasdk.models.PayAChargeWithCreditCardRequest;

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

    PayAChargeWithCreditCardRequest payAChargeWithCreditCardRequest = PayAChargeWithCreditCardRequest.builder()
      .creditCard(apiCreditCardRequestDto)
      .creditCardHolderInfo(apiCreditCardHolderInfoRequestDto)
      .creditCardToken("creditCardToken")
      .build();

    ApiPaymentGetResponseDto response = asaasSdk.payment.payAChargeWithCreditCard(
      "id",
      payAChargeWithCreditCardRequest
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

`RetrievePaymentBillingInformationOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.RetrievePaymentBillingInformationOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    RetrievePaymentBillingInformationOkResponse response = asaasSdk.payment.retrievePaymentBillingInformation("id");

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

`PaymentViewingInformationOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.PaymentViewingInformationOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentViewingInformationOkResponse response = asaasSdk.payment.paymentViewingInformation("id");

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

| Name                         | Type                                                                      | Required | Description                        |
| :--------------------------- | :------------------------------------------------------------------------ | :------- | :--------------------------------- |
| id                           | String                                                                    | ✅       | Unique payment identifier in Asaas |
| updateExistingPaymentRequest | [UpdateExistingPaymentRequest](../models/UpdateExistingPaymentRequest.md) | ❌       | Request Body                       |

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
import com.asaas.sdk.asaasjavasdk.models.UpdateExistingPaymentRequest;
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
      .dueDateLimitDays(7L)
      .type(ApiPaymentDiscountDiscountType.FIXED)
      .build();

    ApiPaymentInterestRequestDto apiPaymentInterestRequestDto = ApiPaymentInterestRequestDto.builder()
      .value(5.39D)
      .build();

    ApiPaymentFineRequestDto apiPaymentFineRequestDto = ApiPaymentFineRequestDto.builder()
      .value(4.4D)
      .type(ApiPaymentFineRequestFineType.FIXED)
      .build();

    ApiPaymentSplitRequestDto apiPaymentSplitRequestDto = ApiPaymentSplitRequestDto.builder()
      .walletId("walletId")
      .fixedValue(4.96D)
      .percentualValue(8.66D)
      .totalFixedValue(4.85D)
      .externalReference("externalReference")
      .description("description")
      .build();

    List<ApiPaymentSplitRequestDto> splitList = Arrays.asList(apiPaymentSplitRequestDto);

    ApiPaymentCallbackRequestDto apiPaymentCallbackRequestDto = ApiPaymentCallbackRequestDto.builder()
      .successUrl("successUrl")
      .autoRedirect(false)
      .build();

    UpdateExistingPaymentRequest updateExistingPaymentRequest = UpdateExistingPaymentRequest.builder()
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
      updateExistingPaymentRequest
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

`DeletePaymentOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.DeletePaymentOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    DeletePaymentOkResponse response = asaasSdk.payment.deletePayment("id");

    System.out.println(response);
  }
}

```

## restoreRemovedPayment

- HTTP Method: `POST`
- Endpoint: `/v3/payments/{id}/restore`

**Parameters**

| Name  | Type   | Required | Description                        |
| :---- | :----- | :------- | :--------------------------------- |
| id    | String | ✅       | Unique payment identifier in Asaas |
| input | Object | ❌       | Request Body                       |

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

    ApiPaymentGetResponseDto response = asaasSdk.payment.restoreRemovedPayment("id", new Object());

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

`RetrieveStatusOfAPaymentOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.RetrieveStatusOfAPaymentOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    RetrieveStatusOfAPaymentOkResponse response = asaasSdk.payment.retrieveStatusOfAPayment("id");

    System.out.println(response);
  }
}

```

## refundPayment

- HTTP Method: `POST`
- Endpoint: `/v3/payments/{id}/refund`

**Parameters**

| Name                 | Type                                                      | Required | Description                        |
| :------------------- | :-------------------------------------------------------- | :------- | :--------------------------------- |
| id                   | String                                                    | ✅       | Unique payment identifier in Asaas |
| refundPaymentRequest | [RefundPaymentRequest](../models/RefundPaymentRequest.md) | ❌       | Request Body                       |

**Return Type**

`ApiPaymentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.RefundPaymentRequest;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    RefundPaymentRequest refundPaymentRequest = RefundPaymentRequest.builder()
      .value(5D)
      .description("Valor a mais")
      .build();

    ApiPaymentGetResponseDto response = asaasSdk.payment.refundPayment("id", refundPaymentRequest);

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

`GetDigitableBillLineOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.GetDigitableBillLineOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    GetDigitableBillLineOkResponse response = asaasSdk.payment.getDigitableBillLine("id");

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

| Name                      | Type                                                                | Required | Description                        |
| :------------------------ | :------------------------------------------------------------------ | :------- | :--------------------------------- |
| id                        | String                                                              | ✅       | Unique payment identifier in Asaas |
| confirmCashReceiptRequest | [ConfirmCashReceiptRequest](../models/ConfirmCashReceiptRequest.md) | ❌       | Request Body                       |

**Return Type**

`ApiPaymentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ConfirmCashReceiptRequest;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ConfirmCashReceiptRequest confirmCashReceiptRequest = ConfirmCashReceiptRequest.builder()
      .paymentDate("16/05/2025")
      .value(129.9D)
      .notifyCustomer(true)
      .build();

    ApiPaymentGetResponseDto response = asaasSdk.payment.confirmCashReceipt("id", confirmCashReceiptRequest);

    System.out.println(response);
  }
}

```

## undoCashReceiptConfirmation

- HTTP Method: `POST`
- Endpoint: `/v3/payments/{id}/undoReceivedInCash`

**Parameters**

| Name  | Type   | Required | Description                        |
| :---- | :----- | :------- | :--------------------------------- |
| id    | String | ✅       | Unique payment identifier in Asaas |
| input | Object | ❌       | Request Body                       |

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

    ApiPaymentGetResponseDto response = asaasSdk.payment.undoCashReceiptConfirmation("id", new Object());

    System.out.println(response);
  }
}

```

## salesSimulator

- HTTP Method: `POST`
- Endpoint: `/v3/payments/simulate`

**Parameters**

| Name                  | Type                                                        | Required | Description  |
| :-------------------- | :---------------------------------------------------------- | :------- | :----------- |
| salesSimulatorRequest | [SalesSimulatorRequest](../models/SalesSimulatorRequest.md) | ❌       | Request Body |

**Return Type**

`SalesSimulatorOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.SalesSimulatorOkResponse;
import com.asaas.sdk.asaasjavasdk.models.SalesSimulatorRequest;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    List<String> billingTypesList = Arrays.asList("billingTypes");

    SalesSimulatorRequest salesSimulatorRequest = SalesSimulatorRequest.builder()
      .value(100D)
      .installmentCount(2L)
      .billingTypes(billingTypesList)
      .build();

    SalesSimulatorOkResponse response = asaasSdk.payment.salesSimulator(salesSimulatorRequest);

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

`RecoveringPaymentLimitsOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.RecoveringPaymentLimitsOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    RecoveringPaymentLimitsOkResponse response = asaasSdk.payment.recoveringPaymentLimits();

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
