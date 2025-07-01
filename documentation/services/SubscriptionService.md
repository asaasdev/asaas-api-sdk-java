# SubscriptionService

A list of all methods in the `SubscriptionService` service. Click on the method name to view detailed information about that method.

| Methods                                                                                   | Description                                                                                                                                                                 |
| :---------------------------------------------------------------------------------------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [listSubscriptions](#listsubscriptions)                                                   |                                                                                                                                                                             |
| [createNewSubscription](#createnewsubscription)                                           |                                                                                                                                                                             |
| [createSubscriptionWithCreditCard](#createsubscriptionwithcreditcard)                     |                                                                                                                                                                             |
| [retrieveASingleSubscription](#retrieveasinglesubscription)                               |                                                                                                                                                                             |
| [updateExistingSubscription](#updateexistingsubscription)                                 |                                                                                                                                                                             |
| [removeSubscription](#removesubscription)                                                 |                                                                                                                                                                             |
| [updateSubscriptionCreditCard](#updatesubscriptioncreditcard)                             | This endpoint updates the subscription's credit card without triggering an immediate charge. Additionally, all pending charges linked to the subscription are also updated. |
| [listPaymentsOfASubscription](#listpaymentsofasubscription)                               |                                                                                                                                                                             |
| [generateSignatureBooklet](#generatesignaturebooklet)                                     |                                                                                                                                                                             |
| [retrieveConfigurationForIssuanceOfInvoices](#retrieveconfigurationforissuanceofinvoices) |                                                                                                                                                                             |
| [createConfigurationForIssuanceOfInvoices](#createconfigurationforissuanceofinvoices)     |                                                                                                                                                                             |
| [updateConfigurationForIssuanceOfInvoices](#updateconfigurationforissuanceofinvoices)     |                                                                                                                                                                             |
| [removeConfigurationForIssuanceOfInvoices](#removeconfigurationforissuanceofinvoices)     |                                                                                                                                                                             |
| [listInvoicesForSubscriptionCharges](#listinvoicesforsubscriptioncharges)                 |                                                                                                                                                                             |

## listSubscriptions

- HTTP Method: `GET`
- Endpoint: `/v3/subscriptions`

**Parameters**

| Name              | Type                                                                    | Required | Description               |
| :---------------- | :---------------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [ListSubscriptionsParameters](../models/ListSubscriptionsParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`SubscriptionListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ListSubscriptionsParameters;
import com.asaas.apisdk.models.SubscriptionListRequestBillingType;
import com.asaas.apisdk.models.SubscriptionListRequestSubscriptionStatus;
import com.asaas.apisdk.models.SubscriptionListResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListSubscriptionsParameters requestParameters = ListSubscriptionsParameters.builder()
      .offset(10L)
      .limit(10L)
      .customer("customer")
      .customerGroupName("customerGroupName")
      .billingType(SubscriptionListRequestBillingType.UNDEFINED)
      .status(SubscriptionListRequestSubscriptionStatus.ACTIVE)
      .deletedOnly("deletedOnly")
      .includeDeleted("includeDeleted")
      .externalReference("externalReference")
      .order("order")
      .sort("sort")
      .build();

    SubscriptionListResponseDto response = asaasSdk.subscription.listSubscriptions(requestParameters);

    System.out.println(response);
  }
}

```

## createNewSubscription

- HTTP Method: `POST`
- Endpoint: `/v3/subscriptions`

**Parameters**

| Name                       | Type                                                                  | Required | Description  |
| :------------------------- | :-------------------------------------------------------------------- | :------- | :----------- |
| subscriptionSaveRequestDto | [SubscriptionSaveRequestDto](../models/SubscriptionSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`SubscriptionGetResponseDto`

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
import com.asaas.apisdk.models.SubscriptionGetResponseDto;
import com.asaas.apisdk.models.SubscriptionSaveRequestBillingType;
import com.asaas.apisdk.models.SubscriptionSaveRequestCycle;
import com.asaas.apisdk.models.SubscriptionSaveRequestDto;
import com.asaas.apisdk.models.SubscriptionSplitRequestDto;
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

    SubscriptionSplitRequestDto subscriptionSplitRequestDto = SubscriptionSplitRequestDto.builder()
      .walletId("walletId")
      .fixedValue(8.29D)
      .percentualValue(7.44D)
      .externalReference("externalReference")
      .description("description")
      .build();

    List<SubscriptionSplitRequestDto> splitList = Arrays.asList(subscriptionSplitRequestDto);

    PaymentCallbackRequestDto paymentCallbackRequestDto = PaymentCallbackRequestDto.builder()
      .successUrl("successUrl")
      .autoRedirect(true)
      .build();

    SubscriptionSaveRequestDto subscriptionSaveRequestDto = SubscriptionSaveRequestDto.builder()
      .customer("cus_0T1mdomVMi39")
      .billingType(SubscriptionSaveRequestBillingType.UNDEFINED)
      .value(19.9D)
      .nextDueDate("2017-05-15")
      .discount(paymentDiscountDto)
      .interest(paymentInterestRequestDto)
      .fine(paymentFineRequestDto)
      .cycle(SubscriptionSaveRequestCycle.WEEKLY)
      .description("Pro Plan Subscription")
      .endDate("endDate")
      .maxPayments(10L)
      .externalReference("externalReference")
      .split(splitList)
      .callback(paymentCallbackRequestDto)
      .build();

    SubscriptionGetResponseDto response = asaasSdk.subscription.createNewSubscription(subscriptionSaveRequestDto);

    System.out.println(response);
  }
}

```

## createSubscriptionWithCreditCard

- HTTP Method: `POST`
- Endpoint: `/v3/subscriptions/`

**Parameters**

| Name                                     | Type                                                                                              | Required | Description  |
| :--------------------------------------- | :------------------------------------------------------------------------------------------------ | :------- | :----------- |
| subscriptionSaveWithCreditCardRequestDto | [SubscriptionSaveWithCreditCardRequestDto](../models/SubscriptionSaveWithCreditCardRequestDto.md) | ❌       | Request Body |

**Return Type**

`SubscriptionSaveWithCreditCardResponseDto`

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
import com.asaas.apisdk.models.SubscriptionSaveWithCreditCardRequestBillingType;
import com.asaas.apisdk.models.SubscriptionSaveWithCreditCardRequestCycle;
import com.asaas.apisdk.models.SubscriptionSaveWithCreditCardRequestDto;
import com.asaas.apisdk.models.SubscriptionSaveWithCreditCardResponseDto;
import com.asaas.apisdk.models.SubscriptionSplitRequestDto;
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

    SubscriptionSplitRequestDto subscriptionSplitRequestDto = SubscriptionSplitRequestDto.builder()
      .walletId("walletId")
      .fixedValue(8.29D)
      .percentualValue(7.44D)
      .externalReference("externalReference")
      .description("description")
      .build();

    List<SubscriptionSplitRequestDto> splitList = Arrays.asList(subscriptionSplitRequestDto);

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

    SubscriptionSaveWithCreditCardRequestDto subscriptionSaveWithCreditCardRequestDto =
      SubscriptionSaveWithCreditCardRequestDto.builder()
        .customer("cus_0T1mdomVMi39")
        .billingType(SubscriptionSaveWithCreditCardRequestBillingType.UNDEFINED)
        .value(19.9D)
        .nextDueDate("2017-05-15")
        .discount(paymentDiscountDto)
        .interest(paymentInterestRequestDto)
        .fine(paymentFineRequestDto)
        .cycle(SubscriptionSaveWithCreditCardRequestCycle.WEEKLY)
        .description("Pro Plan Subscription")
        .endDate("endDate")
        .maxPayments(0L)
        .externalReference("externalReference")
        .split(splitList)
        .callback(paymentCallbackRequestDto)
        .creditCard(creditCardRequestDto)
        .creditCardHolderInfo(creditCardHolderInfoRequestDto)
        .creditCardToken("a75a1d98-c52d-4a6b-a413-71e00b193c99")
        .remoteIp("remoteIp")
        .build();

    SubscriptionSaveWithCreditCardResponseDto response = asaasSdk.subscription.createSubscriptionWithCreditCard(
      subscriptionSaveWithCreditCardRequestDto
    );

    System.out.println(response);
  }
}

```

## retrieveASingleSubscription

- HTTP Method: `GET`
- Endpoint: `/v3/subscriptions/{id}`

**Parameters**

| Name | Type   | Required | Description                             |
| :--- | :----- | :------- | :-------------------------------------- |
| id   | String | ✅       | Unique subscription identifier in Asaas |

**Return Type**

`SubscriptionGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.SubscriptionGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    SubscriptionGetResponseDto response = asaasSdk.subscription.retrieveASingleSubscription("sub_VXJBYgP2u0eO");

    System.out.println(response);
  }
}

```

## updateExistingSubscription

- HTTP Method: `PUT`
- Endpoint: `/v3/subscriptions/{id}`

**Parameters**

| Name                         | Type                                                                      | Required | Description                             |
| :--------------------------- | :------------------------------------------------------------------------ | :------- | :-------------------------------------- |
| id                           | String                                                                    | ✅       | Unique subscription identifier in Asaas |
| subscriptionUpdateRequestDto | [SubscriptionUpdateRequestDto](../models/SubscriptionUpdateRequestDto.md) | ❌       | Request Body                            |

**Return Type**

`SubscriptionGetResponseDto`

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
import com.asaas.apisdk.models.SubscriptionGetResponseDto;
import com.asaas.apisdk.models.SubscriptionSplitRequestDto;
import com.asaas.apisdk.models.SubscriptionUpdateRequestBillingType;
import com.asaas.apisdk.models.SubscriptionUpdateRequestCycle;
import com.asaas.apisdk.models.SubscriptionUpdateRequestDto;
import com.asaas.apisdk.models.SubscriptionUpdateRequestSubscriptionStatus;
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

    SubscriptionSplitRequestDto subscriptionSplitRequestDto = SubscriptionSplitRequestDto.builder()
      .walletId("walletId")
      .fixedValue(8.29D)
      .percentualValue(7.44D)
      .externalReference("externalReference")
      .description("description")
      .build();

    List<SubscriptionSplitRequestDto> splitList = Arrays.asList(subscriptionSplitRequestDto);

    PaymentCallbackRequestDto paymentCallbackRequestDto = PaymentCallbackRequestDto.builder()
      .successUrl("successUrl")
      .autoRedirect(true)
      .build();

    SubscriptionUpdateRequestDto subscriptionUpdateRequestDto = SubscriptionUpdateRequestDto.builder()
      .billingType(SubscriptionUpdateRequestBillingType.UNDEFINED)
      .status(SubscriptionUpdateRequestSubscriptionStatus.ACTIVE)
      .nextDueDate("2017-05-15")
      .discount(paymentDiscountDto)
      .interest(paymentInterestRequestDto)
      .fine(paymentFineRequestDto)
      .cycle(SubscriptionUpdateRequestCycle.WEEKLY)
      .description("Pro Plan Subscription")
      .endDate("endDate")
      .updatePendingPayments(true)
      .externalReference("externalReference")
      .split(splitList)
      .callback(paymentCallbackRequestDto)
      .build();

    SubscriptionGetResponseDto response = asaasSdk.subscription.updateExistingSubscription(
      "sub_VXJBYgP2u0eO",
      subscriptionUpdateRequestDto
    );

    System.out.println(response);
  }
}

```

## removeSubscription

- HTTP Method: `DELETE`
- Endpoint: `/v3/subscriptions/{id}`

**Parameters**

| Name | Type   | Required | Description                             |
| :--- | :----- | :------- | :-------------------------------------- |
| id   | String | ✅       | Unique subscription identifier in Asaas |

**Return Type**

`SubscriptionDeleteResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.SubscriptionDeleteResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    SubscriptionDeleteResponseDto response = asaasSdk.subscription.removeSubscription("sub_VXJBYgP2u0eO");

    System.out.println(response);
  }
}

```

## updateSubscriptionCreditCard

This endpoint updates the subscription's credit card without triggering an immediate charge. Additionally, all pending charges linked to the subscription are also updated.

- HTTP Method: `PUT`
- Endpoint: `/v3/subscriptions/{id}/creditCard`

**Parameters**

| Name                                   | Type                                                                                          | Required | Description                             |
| :------------------------------------- | :-------------------------------------------------------------------------------------------- | :------- | :-------------------------------------- |
| id                                     | String                                                                                        | ✅       | Unique subscription identifier in Asaas |
| subscriptionUpdateCreditCardRequestDto | [SubscriptionUpdateCreditCardRequestDto](../models/SubscriptionUpdateCreditCardRequestDto.md) | ❌       | Request Body                            |

**Return Type**

`SubscriptionGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.CreditCardHolderInfoRequestDto;
import com.asaas.apisdk.models.CreditCardRequestDto;
import com.asaas.apisdk.models.SubscriptionGetResponseDto;
import com.asaas.apisdk.models.SubscriptionUpdateCreditCardRequestDto;

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

    SubscriptionUpdateCreditCardRequestDto subscriptionUpdateCreditCardRequestDto =
      SubscriptionUpdateCreditCardRequestDto.builder()
        .creditCard(creditCardRequestDto)
        .creditCardHolderInfo(creditCardHolderInfoRequestDto)
        .creditCardToken("a75a1d98-c52d-4a6b-a413-71e00b193c99")
        .remoteIp("116.213.42.532")
        .build();

    SubscriptionGetResponseDto response = asaasSdk.subscription.updateSubscriptionCreditCard(
      "sub_VXJBYgP2u0eO",
      subscriptionUpdateCreditCardRequestDto
    );

    System.out.println(response);
  }
}

```

## listPaymentsOfASubscription

- HTTP Method: `GET`
- Endpoint: `/v3/subscriptions/{id}/payments`

**Parameters**

| Name              | Type                                                                                        | Required | Description                             |
| :---------------- | :------------------------------------------------------------------------------------------ | :------- | :-------------------------------------- |
| id                | String                                                                                      | ✅       | Unique subscription identifier in Asaas |
| requestParameters | [ListPaymentsOfASubscriptionParameters](../models/ListPaymentsOfASubscriptionParameters.md) | ❌       | Request Parameters Object               |

**Return Type**

`PaymentListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ListPaymentsOfASubscriptionParameters;
import com.asaas.apisdk.models.PaymentListResponseDto;
import com.asaas.apisdk.models.SubscriptionListPaymentsRequestPaymentStatus;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListPaymentsOfASubscriptionParameters requestParameters = ListPaymentsOfASubscriptionParameters.builder()
      .status(SubscriptionListPaymentsRequestPaymentStatus.PENDING)
      .build();

    PaymentListResponseDto response = asaasSdk.subscription.listPaymentsOfASubscription(
      "sub_VXJBYgP2u0eO",
      requestParameters
    );

    System.out.println(response);
  }
}

```

## generateSignatureBooklet

- HTTP Method: `GET`
- Endpoint: `/v3/subscriptions/{id}/paymentBook`

**Parameters**

| Name              | Type                                                                                  | Required | Description                             |
| :---------------- | :------------------------------------------------------------------------------------ | :------- | :-------------------------------------- |
| id                | String                                                                                | ✅       | Unique subscription identifier in Asaas |
| requestParameters | [GenerateSignatureBookletParameters](../models/GenerateSignatureBookletParameters.md) | ❌       | Request Parameters Object               |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.GenerateSignatureBookletParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    GenerateSignatureBookletParameters requestParameters = GenerateSignatureBookletParameters.builder()
      .month(2L)
      .year(5L)
      .sort("sort")
      .order("asc")
      .build();

    Object response = asaasSdk.subscription.generateSignatureBooklet("sub_VXJBYgP2u0eO", requestParameters);

    System.out.println(response);
  }
}

```

## retrieveConfigurationForIssuanceOfInvoices

- HTTP Method: `GET`
- Endpoint: `/v3/subscriptions/{id}/invoiceSettings`

**Parameters**

| Name | Type   | Required | Description                             |
| :--- | :----- | :------- | :-------------------------------------- |
| id   | String | ✅       | Unique subscription identifier in Asaas |

**Return Type**

`SubscriptionInvoiceConfigGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.SubscriptionInvoiceConfigGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    SubscriptionInvoiceConfigGetResponseDto response = asaasSdk.subscription.retrieveConfigurationForIssuanceOfInvoices(
      "sub_VXJBYgP2u0eO"
    );

    System.out.println(response);
  }
}

```

## createConfigurationForIssuanceOfInvoices

- HTTP Method: `POST`
- Endpoint: `/v3/subscriptions/{id}/invoiceSettings`

**Parameters**

| Name                                   | Type                                                                                          | Required | Description                             |
| :------------------------------------- | :-------------------------------------------------------------------------------------------- | :------- | :-------------------------------------- |
| id                                     | String                                                                                        | ✅       | Unique subscription identifier in Asaas |
| subscriptionConfigureInvoiceRequestDto | [SubscriptionConfigureInvoiceRequestDto](../models/SubscriptionConfigureInvoiceRequestDto.md) | ❌       | Request Body                            |

**Return Type**

`SubscriptionInvoiceConfigGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.InvoiceTaxesDto;
import com.asaas.apisdk.models.SubscriptionConfigureInvoiceRequestDto;
import com.asaas.apisdk.models.SubscriptionConfigureInvoiceRequestDtoEffectiveDatePeriod;
import com.asaas.apisdk.models.SubscriptionInvoiceConfigGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    InvoiceTaxesDto invoiceTaxesDto = InvoiceTaxesDto.builder()
      .retainIss(true)
      .cofins(1D)
      .csll(1D)
      .inss(1D)
      .ir(1D)
      .pis(1D)
      .iss(1D)
      .build();

    SubscriptionConfigureInvoiceRequestDto subscriptionConfigureInvoiceRequestDto =
      SubscriptionConfigureInvoiceRequestDto.builder()
        .municipalServiceId("municipalServiceId")
        .municipalServiceCode("1.01")
        .municipalServiceName("municipalServiceName")
        .updatePayment(true)
        .deductions(55D)
        .effectiveDatePeriod(SubscriptionConfigureInvoiceRequestDtoEffectiveDatePeriod.ON_PAYMENT_CONFIRMATION)
        .receivedOnly(true)
        .daysBeforeDueDate(9L)
        .observations("Regarding March work")
        .taxes(invoiceTaxesDto)
        .build();

    SubscriptionInvoiceConfigGetResponseDto response = asaasSdk.subscription.createConfigurationForIssuanceOfInvoices(
      "sub_VXJBYgP2u0eO",
      subscriptionConfigureInvoiceRequestDto
    );

    System.out.println(response);
  }
}

```

## updateConfigurationForIssuanceOfInvoices

- HTTP Method: `PUT`
- Endpoint: `/v3/subscriptions/{id}/invoiceSettings`

**Parameters**

| Name                                      | Type                                                                                                | Required | Description                             |
| :---------------------------------------- | :-------------------------------------------------------------------------------------------------- | :------- | :-------------------------------------- |
| id                                        | String                                                                                              | ✅       | Unique subscription identifier in Asaas |
| subscriptionInvoiceConfigUpdateRequestDto | [SubscriptionInvoiceConfigUpdateRequestDto](../models/SubscriptionInvoiceConfigUpdateRequestDto.md) | ❌       | Request Body                            |

**Return Type**

`SubscriptionInvoiceConfigGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.InvoiceTaxesDto;
import com.asaas.apisdk.models.SubscriptionInvoiceConfigGetResponseDto;
import com.asaas.apisdk.models.SubscriptionInvoiceConfigUpdateRequestDto;
import com.asaas.apisdk.models.SubscriptionInvoiceConfigUpdateRequestDtoEffectiveDatePeriod;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    InvoiceTaxesDto invoiceTaxesDto = InvoiceTaxesDto.builder()
      .retainIss(true)
      .cofins(1D)
      .csll(1D)
      .inss(1D)
      .ir(1D)
      .pis(1D)
      .iss(1D)
      .build();

    SubscriptionInvoiceConfigUpdateRequestDto subscriptionInvoiceConfigUpdateRequestDto =
      SubscriptionInvoiceConfigUpdateRequestDto.builder()
        .deductions(55D)
        .effectiveDatePeriod(SubscriptionInvoiceConfigUpdateRequestDtoEffectiveDatePeriod.ON_PAYMENT_CONFIRMATION)
        .receivedOnly(true)
        .daysBeforeDueDate(10L)
        .observations("Regarding March work")
        .taxes(invoiceTaxesDto)
        .build();

    SubscriptionInvoiceConfigGetResponseDto response = asaasSdk.subscription.updateConfigurationForIssuanceOfInvoices(
      "sub_VXJBYgP2u0eO",
      subscriptionInvoiceConfigUpdateRequestDto
    );

    System.out.println(response);
  }
}

```

## removeConfigurationForIssuanceOfInvoices

- HTTP Method: `DELETE`
- Endpoint: `/v3/subscriptions/{id}/invoiceSettings`

**Parameters**

| Name | Type   | Required | Description                             |
| :--- | :----- | :------- | :-------------------------------------- |
| id   | String | ✅       | Unique subscription identifier in Asaas |

**Return Type**

`SubscriptionDeleteInvoiceConfigResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.SubscriptionDeleteInvoiceConfigResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    SubscriptionDeleteInvoiceConfigResponseDto response =
      asaasSdk.subscription.removeConfigurationForIssuanceOfInvoices("sub_VXJBYgP2u0eO");

    System.out.println(response);
  }
}

```

## listInvoicesForSubscriptionCharges

- HTTP Method: `GET`
- Endpoint: `/v3/subscriptions/{id}/invoices`

**Parameters**

| Name              | Type                                                                                                      | Required | Description                             |
| :---------------- | :-------------------------------------------------------------------------------------------------------- | :------- | :-------------------------------------- |
| id                | String                                                                                                    | ✅       | Unique subscription identifier in Asaas |
| requestParameters | [ListInvoicesForSubscriptionChargesParameters](../models/ListInvoicesForSubscriptionChargesParameters.md) | ❌       | Request Parameters Object               |

**Return Type**

`InvoiceListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.InvoiceListResponseDto;
import com.asaas.apisdk.models.ListInvoicesForSubscriptionChargesParameters;
import com.asaas.apisdk.models.SubscriptionGetInvoicesRequestInvoiceStatus;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListInvoicesForSubscriptionChargesParameters requestParameters =
      ListInvoicesForSubscriptionChargesParameters.builder()
        .offset(0L)
        .limit(10L)
        .effectiveDateGe("2024-08-20")
        .effectiveDateLe("2024-08-20")
        .externalReference("externalReference")
        .status(SubscriptionGetInvoicesRequestInvoiceStatus.SCHEDULED)
        .customer("cus_000000002750")
        .build();

    InvoiceListResponseDto response = asaasSdk.subscription.listInvoicesForSubscriptionCharges(
      "inv_000000000232",
      requestParameters
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
