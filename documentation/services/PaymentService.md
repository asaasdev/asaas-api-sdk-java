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

`PaymentListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ListPaymentsParameters;
import com.asaas.apisdk.models.PaymentListRequestBillingType;
import com.asaas.apisdk.models.PaymentListRequestInvoiceStatus;
import com.asaas.apisdk.models.PaymentListRequestPaymentStatus;
import com.asaas.apisdk.models.PaymentListResponseDto;

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
      .billingType(PaymentListRequestBillingType.UNDEFINED)
      .status(PaymentListRequestPaymentStatus.PENDING)
      .subscription("subscription")
      .externalReference("externalReference")
      .paymentDate("paymentDate")
      .invoiceStatus(PaymentListRequestInvoiceStatus.SCHEDULED)
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

    PaymentListResponseDto response = asaasSdk.payment.listPayments(requestParameters);

    System.out.println(response);
  }
}

```

## createNewPayment

- HTTP Method: `POST`
- Endpoint: `/v3/payments`

**Parameters**

| Name                  | Type                                                        | Required | Description  |
| :-------------------- | :---------------------------------------------------------- | :------- | :----------- |
| paymentSaveRequestDto | [PaymentSaveRequestDto](../models/PaymentSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`PaymentGetResponseDto`

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
import com.asaas.apisdk.models.PaymentGetResponseDto;
import com.asaas.apisdk.models.PaymentInterestRequestDto;
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

    PaymentGetResponseDto response = asaasSdk.payment.createNewPayment(paymentSaveRequestDto);

    System.out.println(response);
  }
}

```

## createNewPaymentWithCreditCard

- HTTP Method: `POST`
- Endpoint: `/v3/payments/`

**Parameters**

| Name                                | Type                                                                                    | Required | Description  |
| :---------------------------------- | :-------------------------------------------------------------------------------------- | :------- | :----------- |
| paymentSaveWithCreditCardRequestDto | [PaymentSaveWithCreditCardRequestDto](../models/PaymentSaveWithCreditCardRequestDto.md) | ❌       | Request Body |

**Return Type**

`PaymentGetResponseDto`

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
import com.asaas.apisdk.models.PaymentGetResponseDto;
import com.asaas.apisdk.models.PaymentInterestRequestDto;
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

    PaymentGetResponseDto response = asaasSdk.payment.createNewPaymentWithCreditCard(
      paymentSaveWithCreditCardRequestDto
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

`PaymentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentGetResponseDto response = asaasSdk.payment.capturePaymentWithPreAuthorization("id", new Object());

    System.out.println(response);
  }
}

```

## payAChargeWithCreditCard

- HTTP Method: `POST`
- Endpoint: `/v3/payments/{id}/payWithCreditCard`

**Parameters**

| Name                               | Type                                                                                  | Required | Description                        |
| :--------------------------------- | :------------------------------------------------------------------------------------ | :------- | :--------------------------------- |
| id                                 | String                                                                                | ✅       | Unique payment identifier in Asaas |
| paymentPayWithCreditCardRequestDto | [PaymentPayWithCreditCardRequestDto](../models/PaymentPayWithCreditCardRequestDto.md) | ❌       | Request Body                       |

**Return Type**

`PaymentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.CreditCardHolderInfoRequestDto;
import com.asaas.apisdk.models.CreditCardRequestDto;
import com.asaas.apisdk.models.PaymentGetResponseDto;
import com.asaas.apisdk.models.PaymentPayWithCreditCardRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

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

    PaymentPayWithCreditCardRequestDto paymentPayWithCreditCardRequestDto = PaymentPayWithCreditCardRequestDto.builder()
      .creditCard(creditCardRequestDto)
      .creditCardHolderInfo(creditCardHolderInfoRequestDto)
      .creditCardToken("creditCardToken")
      .build();

    PaymentGetResponseDto response = asaasSdk.payment.payAChargeWithCreditCard(
      "id",
      paymentPayWithCreditCardRequestDto
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

`PaymentBillingInfoResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentBillingInfoResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentBillingInfoResponseDto response = asaasSdk.payment.retrievePaymentBillingInformation("id");

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

`PaymentViewingInfoResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentViewingInfoResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentViewingInfoResponseDto response = asaasSdk.payment.paymentViewingInformation("id");

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

`PaymentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentGetResponseDto response = asaasSdk.payment.retrieveASinglePayment("id");

    System.out.println(response);
  }
}

```

## updateExistingPayment

- HTTP Method: `PUT`
- Endpoint: `/v3/payments/{id}`

**Parameters**

| Name                    | Type                                                            | Required | Description                        |
| :---------------------- | :-------------------------------------------------------------- | :------- | :--------------------------------- |
| id                      | String                                                          | ✅       | Unique payment identifier in Asaas |
| paymentUpdateRequestDto | [PaymentUpdateRequestDto](../models/PaymentUpdateRequestDto.md) | ❌       | Request Body                       |

**Return Type**

`PaymentGetResponseDto`

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
import com.asaas.apisdk.models.PaymentGetResponseDto;
import com.asaas.apisdk.models.PaymentInterestRequestDto;
import com.asaas.apisdk.models.PaymentSplitRequestDto;
import com.asaas.apisdk.models.PaymentUpdateRequestBillingType;
import com.asaas.apisdk.models.PaymentUpdateRequestDto;
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

    PaymentUpdateRequestDto paymentUpdateRequestDto = PaymentUpdateRequestDto.builder()
      .billingType(PaymentUpdateRequestBillingType.UNDEFINED)
      .value(129.9D)
      .dueDate("2017-06-10")
      .description("Pedido 056984")
      .daysAfterDueDateToRegistrationCancellation(1L)
      .externalReference("056984")
      .discount(paymentDiscountDto)
      .interest(paymentInterestRequestDto)
      .fine(paymentFineRequestDto)
      .postalService(false)
      .split(splitList)
      .callback(paymentCallbackRequestDto)
      .build();

    PaymentGetResponseDto response = asaasSdk.payment.updateExistingPayment(
      "pay_080225913252",
      paymentUpdateRequestDto
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

    PaymentDeleteResponseDto response = asaasSdk.payment.deletePayment("id");

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

`PaymentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentGetResponseDto response = asaasSdk.payment.restoreRemovedPayment("id", new Object());

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

`PaymentStatusResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentStatusResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentStatusResponseDto response = asaasSdk.payment.retrieveStatusOfAPayment("id");

    System.out.println(response);
  }
}

```

## refundPayment

- HTTP Method: `POST`
- Endpoint: `/v3/payments/{id}/refund`

**Parameters**

| Name                    | Type                                                            | Required | Description                        |
| :---------------------- | :-------------------------------------------------------------- | :------- | :--------------------------------- |
| id                      | String                                                          | ✅       | Unique payment identifier in Asaas |
| paymentRefundRequestDto | [PaymentRefundRequestDto](../models/PaymentRefundRequestDto.md) | ❌       | Request Body                       |

**Return Type**

`PaymentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentGetResponseDto;
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

    PaymentGetResponseDto response = asaasSdk.payment.refundPayment("id", paymentRefundRequestDto);

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

`PaymentIdentificationFieldResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentIdentificationFieldResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentIdentificationFieldResponseDto response = asaasSdk.payment.getDigitableBillLine("id");

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

`PaymentPixQrCodeResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentPixQrCodeResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentPixQrCodeResponseDto response = asaasSdk.payment.getQrCodeForPixPayments("id");

    System.out.println(response);
  }
}

```

## confirmCashReceipt

- HTTP Method: `POST`
- Endpoint: `/v3/payments/{id}/receiveInCash`

**Parameters**

| Name                           | Type                                                                          | Required | Description                        |
| :----------------------------- | :---------------------------------------------------------------------------- | :------- | :--------------------------------- |
| id                             | String                                                                        | ✅       | Unique payment identifier in Asaas |
| paymentReceiveInCashRequestDto | [PaymentReceiveInCashRequestDto](../models/PaymentReceiveInCashRequestDto.md) | ❌       | Request Body                       |

**Return Type**

`PaymentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentGetResponseDto;
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

    PaymentGetResponseDto response = asaasSdk.payment.confirmCashReceipt("id", paymentReceiveInCashRequestDto);

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

`PaymentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentGetResponseDto response = asaasSdk.payment.undoCashReceiptConfirmation("id", new Object());

    System.out.println(response);
  }
}

```

## salesSimulator

- HTTP Method: `POST`
- Endpoint: `/v3/payments/simulate`

**Parameters**

| Name                      | Type                                                                | Required | Description  |
| :------------------------ | :------------------------------------------------------------------ | :------- | :----------- |
| paymentSimulateRequestDto | [PaymentSimulateRequestDto](../models/PaymentSimulateRequestDto.md) | ❌       | Request Body |

**Return Type**

`PaymentSimulateResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentSimulateRequestBillingType;
import com.asaas.apisdk.models.PaymentSimulateRequestDto;
import com.asaas.apisdk.models.PaymentSimulateResponseDto;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    List<PaymentSimulateRequestBillingType> billingTypesList = Arrays.asList(
      PaymentSimulateRequestBillingType.UNDEFINED
    );

    PaymentSimulateRequestDto paymentSimulateRequestDto = PaymentSimulateRequestDto.builder()
      .value(100D)
      .installmentCount(2L)
      .billingTypes(billingTypesList)
      .build();

    PaymentSimulateResponseDto response = asaasSdk.payment.salesSimulator(paymentSimulateRequestDto);

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

`PaymentEscrowGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentEscrowGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentEscrowGetResponseDto response = asaasSdk.payment.retrievePaymentEscrowInTheEscrowAccount("id");

    System.out.println(response);
  }
}

```

## recoveringPaymentLimits

- HTTP Method: `GET`
- Endpoint: `/v3/payments/limits`

**Return Type**

`PaymentLimitsResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentLimitsResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentLimitsResponseDto response = asaasSdk.payment.recoveringPaymentLimits();

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
