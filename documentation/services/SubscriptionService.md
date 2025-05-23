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

`ApiSubscriptionListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionListRequestBillingType;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionListRequestSubscriptionStatus;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionListResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ListSubscriptionsParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListSubscriptionsParameters requestParameters = ListSubscriptionsParameters.builder()
      .offset(1L)
      .limit(10L)
      .customer("customer")
      .customerGroupName("customerGroupName")
      .billingType(ApiSubscriptionListRequestBillingType.UNDEFINED)
      .status(ApiSubscriptionListRequestSubscriptionStatus.ACTIVE)
      .deletedOnly("deletedOnly")
      .includeDeleted("includeDeleted")
      .externalReference("externalReference")
      .order("order")
      .sort("sort")
      .build();

    ApiSubscriptionListResponseDto response = asaasSdk.subscription.listSubscriptions(requestParameters);

    System.out.println(response);
  }
}

```

## createNewSubscription

- HTTP Method: `POST`
- Endpoint: `/v3/subscriptions`

**Parameters**

| Name                          | Type                                                                        | Required | Description  |
| :---------------------------- | :-------------------------------------------------------------------------- | :------- | :----------- |
| apiSubscriptionSaveRequestDto | [ApiSubscriptionSaveRequestDto](../models/ApiSubscriptionSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`ApiSubscriptionGetResponseDto`

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
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionSaveRequestBillingType;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionSaveRequestCycle;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionSaveRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionSplitRequestDto;
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

    ApiSubscriptionSplitRequestDto apiSubscriptionSplitRequestDto = ApiSubscriptionSplitRequestDto.builder()
      .walletId("walletId")
      .fixedValue(3.49D)
      .percentualValue(7.56D)
      .externalReference("externalReference")
      .description("description")
      .build();

    List<ApiSubscriptionSplitRequestDto> splitList = Arrays.asList(apiSubscriptionSplitRequestDto);

    ApiPaymentCallbackRequestDto apiPaymentCallbackRequestDto = ApiPaymentCallbackRequestDto.builder()
      .successUrl("successUrl")
      .autoRedirect(true)
      .build();

    ApiSubscriptionSaveRequestDto apiSubscriptionSaveRequestDto = ApiSubscriptionSaveRequestDto.builder()
      .customer("cus_0T1mdomVMi39")
      .billingType(ApiSubscriptionSaveRequestBillingType.UNDEFINED)
      .value(19.9D)
      .nextDueDate("2017-05-15")
      .discount(apiPaymentDiscountDto)
      .interest(apiPaymentInterestRequestDto)
      .fine(apiPaymentFineRequestDto)
      .cycle(ApiSubscriptionSaveRequestCycle.WEEKLY)
      .description("Pro Plan Subscription")
      .endDate("endDate")
      .maxPayments(6L)
      .externalReference("externalReference")
      .split(splitList)
      .callback(apiPaymentCallbackRequestDto)
      .build();

    ApiSubscriptionGetResponseDto response = asaasSdk.subscription.createNewSubscription(apiSubscriptionSaveRequestDto);

    System.out.println(response);
  }
}

```

## createSubscriptionWithCreditCard

- HTTP Method: `POST`
- Endpoint: `/v3/subscriptions/`

**Parameters**

| Name                                        | Type                                                                                                    | Required | Description  |
| :------------------------------------------ | :------------------------------------------------------------------------------------------------------ | :------- | :----------- |
| apiSubscriptionSaveWithCreditCardRequestDto | [ApiSubscriptionSaveWithCreditCardRequestDto](../models/ApiSubscriptionSaveWithCreditCardRequestDto.md) | ❌       | Request Body |

**Return Type**

`ApiSubscriptionSaveWithCreditCardResponseDto`

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
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionSaveWithCreditCardRequestBillingType;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionSaveWithCreditCardRequestCycle;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionSaveWithCreditCardRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionSaveWithCreditCardResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionSplitRequestDto;
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

    ApiSubscriptionSplitRequestDto apiSubscriptionSplitRequestDto = ApiSubscriptionSplitRequestDto.builder()
      .walletId("walletId")
      .fixedValue(3.49D)
      .percentualValue(7.56D)
      .externalReference("externalReference")
      .description("description")
      .build();

    List<ApiSubscriptionSplitRequestDto> splitList = Arrays.asList(apiSubscriptionSplitRequestDto);

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

    ApiSubscriptionSaveWithCreditCardRequestDto apiSubscriptionSaveWithCreditCardRequestDto =
      ApiSubscriptionSaveWithCreditCardRequestDto.builder()
        .customer("cus_0T1mdomVMi39")
        .billingType(ApiSubscriptionSaveWithCreditCardRequestBillingType.UNDEFINED)
        .value(19.9D)
        .nextDueDate("2017-05-15")
        .discount(apiPaymentDiscountDto)
        .interest(apiPaymentInterestRequestDto)
        .fine(apiPaymentFineRequestDto)
        .cycle(ApiSubscriptionSaveWithCreditCardRequestCycle.WEEKLY)
        .description("Pro Plan Subscription")
        .endDate("endDate")
        .maxPayments(7L)
        .externalReference("externalReference")
        .split(splitList)
        .callback(apiPaymentCallbackRequestDto)
        .creditCard(apiCreditCardRequestDto)
        .creditCardHolderInfo(apiCreditCardHolderInfoRequestDto)
        .creditCardToken("a75a1d98-c52d-4a6b-a413-71e00b193c99")
        .remoteIp("remoteIp")
        .build();

    ApiSubscriptionSaveWithCreditCardResponseDto response = asaasSdk.subscription.createSubscriptionWithCreditCard(
      apiSubscriptionSaveWithCreditCardRequestDto
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

`ApiSubscriptionGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiSubscriptionGetResponseDto response = asaasSdk.subscription.retrieveASingleSubscription("sub_VXJBYgP2u0eO");

    System.out.println(response);
  }
}

```

## updateExistingSubscription

- HTTP Method: `PUT`
- Endpoint: `/v3/subscriptions/{id}`

**Parameters**

| Name                            | Type                                                                            | Required | Description                             |
| :------------------------------ | :------------------------------------------------------------------------------ | :------- | :-------------------------------------- |
| id                              | String                                                                          | ✅       | Unique subscription identifier in Asaas |
| apiSubscriptionUpdateRequestDto | [ApiSubscriptionUpdateRequestDto](../models/ApiSubscriptionUpdateRequestDto.md) | ❌       | Request Body                            |

**Return Type**

`ApiSubscriptionGetResponseDto`

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
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionSplitRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionUpdateRequestBillingType;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionUpdateRequestCycle;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionUpdateRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionUpdateRequestSubscriptionStatus;
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

    ApiSubscriptionSplitRequestDto apiSubscriptionSplitRequestDto = ApiSubscriptionSplitRequestDto.builder()
      .walletId("walletId")
      .fixedValue(3.49D)
      .percentualValue(7.56D)
      .externalReference("externalReference")
      .description("description")
      .build();

    List<ApiSubscriptionSplitRequestDto> splitList = Arrays.asList(apiSubscriptionSplitRequestDto);

    ApiPaymentCallbackRequestDto apiPaymentCallbackRequestDto = ApiPaymentCallbackRequestDto.builder()
      .successUrl("successUrl")
      .autoRedirect(true)
      .build();

    ApiSubscriptionUpdateRequestDto apiSubscriptionUpdateRequestDto = ApiSubscriptionUpdateRequestDto.builder()
      .id("sub_VXJBYgP2u0eO")
      .billingType(ApiSubscriptionUpdateRequestBillingType.UNDEFINED)
      .status(ApiSubscriptionUpdateRequestSubscriptionStatus.ACTIVE)
      .nextDueDate("2017-05-15")
      .discount(apiPaymentDiscountDto)
      .interest(apiPaymentInterestRequestDto)
      .fine(apiPaymentFineRequestDto)
      .cycle(ApiSubscriptionUpdateRequestCycle.WEEKLY)
      .description("Pro Plan Subscription")
      .endDate("endDate")
      .updatePendingPayments(true)
      .externalReference("externalReference")
      .split(splitList)
      .callback(apiPaymentCallbackRequestDto)
      .build();

    ApiSubscriptionGetResponseDto response = asaasSdk.subscription.updateExistingSubscription(
      "sub_VXJBYgP2u0eO",
      apiSubscriptionUpdateRequestDto
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

`ApiSubscriptionDeleteResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionDeleteResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiSubscriptionDeleteResponseDto response = asaasSdk.subscription.removeSubscription("sub_VXJBYgP2u0eO");

    System.out.println(response);
  }
}

```

## updateSubscriptionCreditCard

This endpoint updates the subscription's credit card without triggering an immediate charge. Additionally, all pending charges linked to the subscription are also updated.

- HTTP Method: `PUT`
- Endpoint: `/v3/subscriptions/{id}/creditCard`

**Parameters**

| Name                                      | Type                                                                                                | Required | Description                             |
| :---------------------------------------- | :-------------------------------------------------------------------------------------------------- | :------- | :-------------------------------------- |
| id                                        | String                                                                                              | ✅       | Unique subscription identifier in Asaas |
| apiSubscriptionUpdateCreditCardRequestDto | [ApiSubscriptionUpdateCreditCardRequestDto](../models/ApiSubscriptionUpdateCreditCardRequestDto.md) | ❌       | Request Body                            |

**Return Type**

`ApiSubscriptionGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCreditCardHolderInfoRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiCreditCardRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionUpdateCreditCardRequestDto;

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

    ApiSubscriptionUpdateCreditCardRequestDto apiSubscriptionUpdateCreditCardRequestDto =
      ApiSubscriptionUpdateCreditCardRequestDto.builder()
        .id("sub_VXJBYgP2u0eO")
        .creditCard(apiCreditCardRequestDto)
        .creditCardHolderInfo(apiCreditCardHolderInfoRequestDto)
        .creditCardToken("a75a1d98-c52d-4a6b-a413-71e00b193c99")
        .remoteIp("116.213.42.532")
        .build();

    ApiSubscriptionGetResponseDto response = asaasSdk.subscription.updateSubscriptionCreditCard(
      "sub_VXJBYgP2u0eO",
      apiSubscriptionUpdateCreditCardRequestDto
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

`ApiPaymentListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentListResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionListPaymentsRequestPaymentStatus;
import com.asaas.sdk.asaasjavasdk.models.ListPaymentsOfASubscriptionParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListPaymentsOfASubscriptionParameters requestParameters = ListPaymentsOfASubscriptionParameters.builder()
      .status(ApiSubscriptionListPaymentsRequestPaymentStatus.PENDING)
      .build();

    ApiPaymentListResponseDto response = asaasSdk.subscription.listPaymentsOfASubscription(
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
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.GenerateSignatureBookletParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    GenerateSignatureBookletParameters requestParameters = GenerateSignatureBookletParameters.builder()
      .month(10L)
      .year(10L)
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

`ApiSubscriptionInvoiceConfigGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionInvoiceConfigGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiSubscriptionInvoiceConfigGetResponseDto response =
      asaasSdk.subscription.retrieveConfigurationForIssuanceOfInvoices("sub_VXJBYgP2u0eO");

    System.out.println(response);
  }
}

```

## createConfigurationForIssuanceOfInvoices

- HTTP Method: `POST`
- Endpoint: `/v3/subscriptions/{id}/invoiceSettings`

**Parameters**

| Name                                      | Type                                                                                                | Required | Description                             |
| :---------------------------------------- | :-------------------------------------------------------------------------------------------------- | :------- | :-------------------------------------- |
| id                                        | String                                                                                              | ✅       | Unique subscription identifier in Asaas |
| apiSubscriptionConfigureInvoiceRequestDto | [ApiSubscriptionConfigureInvoiceRequestDto](../models/ApiSubscriptionConfigureInvoiceRequestDto.md) | ❌       | Request Body                            |

**Return Type**

`ApiSubscriptionInvoiceConfigGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerInvoiceTaxesDto;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionConfigureInvoiceRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionConfigureInvoiceRequestDtoEffectiveDatePeriod;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionInvoiceConfigGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiCustomerInvoiceTaxesDto apiCustomerInvoiceTaxesDto = ApiCustomerInvoiceTaxesDto.builder()
      .retainIss(true)
      .cofins(1D)
      .csll(1D)
      .inss(1D)
      .ir(1D)
      .pis(1D)
      .iss(1D)
      .build();

    ApiSubscriptionConfigureInvoiceRequestDto apiSubscriptionConfigureInvoiceRequestDto =
      ApiSubscriptionConfigureInvoiceRequestDto.builder()
        .id("sub_VXJBYgP2u0eO")
        .municipalServiceId("municipalServiceId")
        .municipalServiceCode("1.01")
        .municipalServiceName("municipalServiceName")
        .updatePayment(true)
        .deductions(55D)
        .effectiveDatePeriod(ApiSubscriptionConfigureInvoiceRequestDtoEffectiveDatePeriod.ON_PAYMENT_CONFIRMATION)
        .receivedOnly(false)
        .daysBeforeDueDate(2L)
        .observations("Regarding March work")
        .taxes(apiCustomerInvoiceTaxesDto)
        .build();

    ApiSubscriptionInvoiceConfigGetResponseDto response =
      asaasSdk.subscription.createConfigurationForIssuanceOfInvoices(
        "sub_VXJBYgP2u0eO",
        apiSubscriptionConfigureInvoiceRequestDto
      );

    System.out.println(response);
  }
}

```

## updateConfigurationForIssuanceOfInvoices

- HTTP Method: `PUT`
- Endpoint: `/v3/subscriptions/{id}/invoiceSettings`

**Parameters**

| Name                                         | Type                                                                                                      | Required | Description                             |
| :------------------------------------------- | :-------------------------------------------------------------------------------------------------------- | :------- | :-------------------------------------- |
| id                                           | String                                                                                                    | ✅       | Unique subscription identifier in Asaas |
| apiSubscriptionInvoiceConfigUpdateRequestDto | [ApiSubscriptionInvoiceConfigUpdateRequestDto](../models/ApiSubscriptionInvoiceConfigUpdateRequestDto.md) | ❌       | Request Body                            |

**Return Type**

`ApiSubscriptionInvoiceConfigGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerInvoiceTaxesDto;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionInvoiceConfigGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionInvoiceConfigUpdateRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionInvoiceConfigUpdateRequestDtoEffectiveDatePeriod;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiCustomerInvoiceTaxesDto apiCustomerInvoiceTaxesDto = ApiCustomerInvoiceTaxesDto.builder()
      .retainIss(true)
      .cofins(1D)
      .csll(1D)
      .inss(1D)
      .ir(1D)
      .pis(1D)
      .iss(1D)
      .build();

    ApiSubscriptionInvoiceConfigUpdateRequestDto apiSubscriptionInvoiceConfigUpdateRequestDto =
      ApiSubscriptionInvoiceConfigUpdateRequestDto.builder()
        .id("sub_VXJBYgP2u0eO")
        .deductions(55D)
        .effectiveDatePeriod(ApiSubscriptionInvoiceConfigUpdateRequestDtoEffectiveDatePeriod.ON_PAYMENT_CONFIRMATION)
        .receivedOnly(true)
        .daysBeforeDueDate(2L)
        .observations("Regarding March work")
        .taxes(apiCustomerInvoiceTaxesDto)
        .build();

    ApiSubscriptionInvoiceConfigGetResponseDto response =
      asaasSdk.subscription.updateConfigurationForIssuanceOfInvoices(
        "sub_VXJBYgP2u0eO",
        apiSubscriptionInvoiceConfigUpdateRequestDto
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

`ApiSubscriptionDeleteInvoiceConfigResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionDeleteInvoiceConfigResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiSubscriptionDeleteInvoiceConfigResponseDto response =
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

`ApiCustomerInvoiceListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerInvoiceListResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionGetInvoicesRequestInvoiceStatus;
import com.asaas.sdk.asaasjavasdk.models.ListInvoicesForSubscriptionChargesParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListInvoicesForSubscriptionChargesParameters requestParameters =
      ListInvoicesForSubscriptionChargesParameters.builder()
        .offset(5L)
        .limit(10L)
        .effectiveDateGe("2024-08-20")
        .effectiveDateLe("2024-08-20")
        .externalReference("externalReference")
        .status(ApiSubscriptionGetInvoicesRequestInvoiceStatus.SCHEDULED)
        .customer("cus_000000002750")
        .build();

    ApiCustomerInvoiceListResponseDto response = asaasSdk.subscription.listInvoicesForSubscriptionCharges(
      "inv_000000000232",
      requestParameters
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
