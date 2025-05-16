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

`ListSubscriptionsOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionListRequestBillingType;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionListRequestSubscriptionStatus;
import com.asaas.sdk.asaasjavasdk.models.ListSubscriptionsOkResponse;
import com.asaas.sdk.asaasjavasdk.models.ListSubscriptionsParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListSubscriptionsParameters requestParameters = ListSubscriptionsParameters.builder()
      .offset(4L)
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

    ListSubscriptionsOkResponse response = asaasSdk.subscription.listSubscriptions(requestParameters);

    System.out.println(response);
  }
}

```

## createNewSubscription

- HTTP Method: `POST`
- Endpoint: `/v3/subscriptions`

**Parameters**

| Name                         | Type                                                                      | Required | Description  |
| :--------------------------- | :------------------------------------------------------------------------ | :------- | :----------- |
| createNewSubscriptionRequest | [CreateNewSubscriptionRequest](../models/CreateNewSubscriptionRequest.md) | ❌       | Request Body |

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
import com.asaas.sdk.asaasjavasdk.models.CreateNewSubscriptionRequest;
import com.asaas.sdk.asaasjavasdk.models.CreateNewSubscriptionRequestSplit;
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

    CreateNewSubscriptionRequestSplit createNewSubscriptionRequestSplit = CreateNewSubscriptionRequestSplit.builder()
      .walletId("walletId")
      .fixedValue(5.33D)
      .percentualValue(5.17D)
      .externalReference("externalReference")
      .description("description")
      .build();

    List<CreateNewSubscriptionRequestSplit> splitList = Arrays.asList(createNewSubscriptionRequestSplit);

    ApiPaymentCallbackRequestDto apiPaymentCallbackRequestDto = ApiPaymentCallbackRequestDto.builder()
      .successUrl("successUrl")
      .autoRedirect(false)
      .build();

    CreateNewSubscriptionRequest createNewSubscriptionRequest = CreateNewSubscriptionRequest.builder()
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
      .maxPayments(8L)
      .externalReference("externalReference")
      .split(splitList)
      .callback(apiPaymentCallbackRequestDto)
      .build();

    ApiSubscriptionGetResponseDto response = asaasSdk.subscription.createNewSubscription(createNewSubscriptionRequest);

    System.out.println(response);
  }
}

```

## createSubscriptionWithCreditCard

- HTTP Method: `POST`
- Endpoint: `/v3/subscriptions/`

**Parameters**

| Name                                    | Type                                                                                            | Required | Description  |
| :-------------------------------------- | :---------------------------------------------------------------------------------------------- | :------- | :----------- |
| createSubscriptionWithCreditCardRequest | [CreateSubscriptionWithCreditCardRequest](../models/CreateSubscriptionWithCreditCardRequest.md) | ❌       | Request Body |

**Return Type**

`CreateSubscriptionWithCreditCardOkResponse`

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
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionSplitRequestDto;
import com.asaas.sdk.asaasjavasdk.models.CreateSubscriptionWithCreditCardOkResponse;
import com.asaas.sdk.asaasjavasdk.models.CreateSubscriptionWithCreditCardRequest;
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

    ApiSubscriptionSplitRequestDto apiSubscriptionSplitRequestDto = ApiSubscriptionSplitRequestDto.builder()
      .walletId("walletId")
      .fixedValue(6.9D)
      .percentualValue(7.7D)
      .externalReference("externalReference")
      .description("description")
      .build();

    List<ApiSubscriptionSplitRequestDto> splitList = Arrays.asList(apiSubscriptionSplitRequestDto);

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

    CreateSubscriptionWithCreditCardRequest createSubscriptionWithCreditCardRequest =
      CreateSubscriptionWithCreditCardRequest.builder()
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
        .maxPayments(4L)
        .externalReference("externalReference")
        .split(splitList)
        .callback(apiPaymentCallbackRequestDto)
        .creditCard(apiCreditCardRequestDto)
        .creditCardHolderInfo(apiCreditCardHolderInfoRequestDto)
        .creditCardToken("a75a1d98-c52d-4a6b-a413-71e00b193c99")
        .remoteIp("remoteIp")
        .build();

    CreateSubscriptionWithCreditCardOkResponse response = asaasSdk.subscription.createSubscriptionWithCreditCard(
      createSubscriptionWithCreditCardRequest
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

| Name                              | Type                                                                                | Required | Description                             |
| :-------------------------------- | :---------------------------------------------------------------------------------- | :------- | :-------------------------------------- |
| id                                | String                                                                              | ✅       | Unique subscription identifier in Asaas |
| updateExistingSubscriptionRequest | [UpdateExistingSubscriptionRequest](../models/UpdateExistingSubscriptionRequest.md) | ❌       | Request Body                            |

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
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionUpdateRequestSubscriptionStatus;
import com.asaas.sdk.asaasjavasdk.models.UpdateExistingSubscriptionRequest;
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

    ApiSubscriptionSplitRequestDto apiSubscriptionSplitRequestDto = ApiSubscriptionSplitRequestDto.builder()
      .walletId("walletId")
      .fixedValue(6.9D)
      .percentualValue(7.7D)
      .externalReference("externalReference")
      .description("description")
      .build();

    List<ApiSubscriptionSplitRequestDto> splitList = Arrays.asList(apiSubscriptionSplitRequestDto);

    ApiPaymentCallbackRequestDto apiPaymentCallbackRequestDto = ApiPaymentCallbackRequestDto.builder()
      .successUrl("successUrl")
      .autoRedirect(false)
      .build();

    UpdateExistingSubscriptionRequest updateExistingSubscriptionRequest = UpdateExistingSubscriptionRequest.builder()
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
      updateExistingSubscriptionRequest
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

`RemoveSubscriptionOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.RemoveSubscriptionOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    RemoveSubscriptionOkResponse response = asaasSdk.subscription.removeSubscription("sub_VXJBYgP2u0eO");

    System.out.println(response);
  }
}

```

## updateSubscriptionCreditCard

This endpoint updates the subscription's credit card without triggering an immediate charge. Additionally, all pending charges linked to the subscription are also updated.

- HTTP Method: `PUT`
- Endpoint: `/v3/subscriptions/{id}/creditCard`

**Parameters**

| Name                                | Type                                                                                    | Required | Description                             |
| :---------------------------------- | :-------------------------------------------------------------------------------------- | :------- | :-------------------------------------- |
| id                                  | String                                                                                  | ✅       | Unique subscription identifier in Asaas |
| updateSubscriptionCreditCardRequest | [UpdateSubscriptionCreditCardRequest](../models/UpdateSubscriptionCreditCardRequest.md) | ❌       | Request Body                            |

**Return Type**

`UpdateSubscriptionCreditCardOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCreditCardHolderInfoRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiCreditCardRequestDto;
import com.asaas.sdk.asaasjavasdk.models.UpdateSubscriptionCreditCardOkResponse;
import com.asaas.sdk.asaasjavasdk.models.UpdateSubscriptionCreditCardRequest;

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

    UpdateSubscriptionCreditCardRequest updateSubscriptionCreditCardRequest =
      UpdateSubscriptionCreditCardRequest.builder()
        .creditCard(apiCreditCardRequestDto)
        .creditCardHolderInfo(apiCreditCardHolderInfoRequestDto)
        .creditCardToken("a75a1d98-c52d-4a6b-a413-71e00b193c99")
        .remoteIp("116.213.42.532")
        .build();

    UpdateSubscriptionCreditCardOkResponse response = asaasSdk.subscription.updateSubscriptionCreditCard(
      "sub_VXJBYgP2u0eO",
      updateSubscriptionCreditCardRequest
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
      .month(3L)
      .year(6L)
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

`RetrieveConfigurationForIssuanceOfInvoicesOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.RetrieveConfigurationForIssuanceOfInvoicesOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    RetrieveConfigurationForIssuanceOfInvoicesOkResponse response =
      asaasSdk.subscription.retrieveConfigurationForIssuanceOfInvoices("sub_VXJBYgP2u0eO");

    System.out.println(response);
  }
}

```

## createConfigurationForIssuanceOfInvoices

- HTTP Method: `POST`
- Endpoint: `/v3/subscriptions/{id}/invoiceSettings`

**Parameters**

| Name                                            | Type                                                                                                            | Required | Description                             |
| :---------------------------------------------- | :-------------------------------------------------------------------------------------------------------------- | :------- | :-------------------------------------- |
| id                                              | String                                                                                                          | ✅       | Unique subscription identifier in Asaas |
| createConfigurationForIssuanceOfInvoicesRequest | [CreateConfigurationForIssuanceOfInvoicesRequest](../models/CreateConfigurationForIssuanceOfInvoicesRequest.md) | ❌       | Request Body                            |

**Return Type**

`ApiSubscriptionInvoiceConfigGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerInvoiceTaxesDto;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionInvoiceConfigGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.CreateConfigurationForIssuanceOfInvoicesRequest;
import com.asaas.sdk.asaasjavasdk.models.CreateConfigurationForIssuanceOfInvoicesRequestEffectiveDatePeriod;

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

    CreateConfigurationForIssuanceOfInvoicesRequest createConfigurationForIssuanceOfInvoicesRequest =
      CreateConfigurationForIssuanceOfInvoicesRequest.builder()
        .municipalServiceId("municipalServiceId")
        .municipalServiceCode("1.01")
        .municipalServiceName("municipalServiceName")
        .updatePayment(false)
        .deductions(55D)
        .effectiveDatePeriod(CreateConfigurationForIssuanceOfInvoicesRequestEffectiveDatePeriod.ON_PAYMENT_CONFIRMATION)
        .receivedOnly(false)
        .daysBeforeDueDate(4L)
        .observations("Regarding March work")
        .taxes(apiCustomerInvoiceTaxesDto)
        .build();

    ApiSubscriptionInvoiceConfigGetResponseDto response =
      asaasSdk.subscription.createConfigurationForIssuanceOfInvoices(
        "sub_VXJBYgP2u0eO",
        createConfigurationForIssuanceOfInvoicesRequest
      );

    System.out.println(response);
  }
}

```

## updateConfigurationForIssuanceOfInvoices

- HTTP Method: `PUT`
- Endpoint: `/v3/subscriptions/{id}/invoiceSettings`

**Parameters**

| Name                                            | Type                                                                                                            | Required | Description                             |
| :---------------------------------------------- | :-------------------------------------------------------------------------------------------------------------- | :------- | :-------------------------------------- |
| id                                              | String                                                                                                          | ✅       | Unique subscription identifier in Asaas |
| updateConfigurationForIssuanceOfInvoicesRequest | [UpdateConfigurationForIssuanceOfInvoicesRequest](../models/UpdateConfigurationForIssuanceOfInvoicesRequest.md) | ❌       | Request Body                            |

**Return Type**

`ApiSubscriptionInvoiceConfigGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerInvoiceTaxesDto;
import com.asaas.sdk.asaasjavasdk.models.ApiSubscriptionInvoiceConfigGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.UpdateConfigurationForIssuanceOfInvoicesRequest;
import com.asaas.sdk.asaasjavasdk.models.UpdateConfigurationForIssuanceOfInvoicesRequestEffectiveDatePeriod;

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

    UpdateConfigurationForIssuanceOfInvoicesRequest updateConfigurationForIssuanceOfInvoicesRequest =
      UpdateConfigurationForIssuanceOfInvoicesRequest.builder()
        .deductions(55D)
        .effectiveDatePeriod(UpdateConfigurationForIssuanceOfInvoicesRequestEffectiveDatePeriod.ON_PAYMENT_CONFIRMATION)
        .receivedOnly(false)
        .daysBeforeDueDate(4L)
        .observations("Regarding March work")
        .taxes(apiCustomerInvoiceTaxesDto)
        .build();

    ApiSubscriptionInvoiceConfigGetResponseDto response =
      asaasSdk.subscription.updateConfigurationForIssuanceOfInvoices(
        "sub_VXJBYgP2u0eO",
        updateConfigurationForIssuanceOfInvoicesRequest
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

`RemoveConfigurationForIssuanceOfInvoicesOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.RemoveConfigurationForIssuanceOfInvoicesOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    RemoveConfigurationForIssuanceOfInvoicesOkResponse response =
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
        .offset(2L)
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
