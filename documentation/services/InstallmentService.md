# InstallmentService

A list of all methods in the `InstallmentService` service. Click on the method name to view detailed information about that method.

| Methods                                                             | Description                                                                                                                                                                                                                                                                                                                                                                           |
| :------------------------------------------------------------------ | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| [listInstallments](#listinstallments)                               |                                                                                                                                                                                                                                                                                                                                                                                       |
| [createInstallment](#createinstallment)                             |                                                                                                                                                                                                                                                                                                                                                                                       |
| [createInstallmentWithCreditCard](#createinstallmentwithcreditcard) |                                                                                                                                                                                                                                                                                                                                                                                       |
| [retrieveASingleInstallment](#retrieveasingleinstallment)           |                                                                                                                                                                                                                                                                                                                                                                                       |
| [removeInstallment](#removeinstallment)                             |                                                                                                                                                                                                                                                                                                                                                                                       |
| [listPaymentsOfAInstallment](#listpaymentsofainstallment)           |                                                                                                                                                                                                                                                                                                                                                                                       |
| [generateInstallmentBooklet](#generateinstallmentbooklet)           |                                                                                                                                                                                                                                                                                                                                                                                       |
| [refundInstallment](#refundinstallment)                             | It is possible to refund an installment received or confirmed via credit card. Just like the process of refunding a standalone credit card billing, the corresponding balance of the installment is debited from your account on Asaas, and the billing is canceled on your customer's card. The cancellation may take up to 10 business days to appear on your customer's statement. |
| [updateInstallmentSplits](#updateinstallmentsplits)                 |                                                                                                                                                                                                                                                                                                                                                                                       |

## listInstallments

- HTTP Method: `GET`
- Endpoint: `/v3/installments`

**Parameters**

| Name              | Type                                                                  | Required | Description               |
| :---------------- | :-------------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [ListInstallmentsParameters](../models/ListInstallmentsParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ApiInstallmentListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiInstallmentListResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ListInstallmentsParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListInstallmentsParameters requestParameters = ListInstallmentsParameters.builder().offset(10L).limit(10L).build();

    ApiInstallmentListResponseDto response = asaasSdk.installment.listInstallments(requestParameters);

    System.out.println(response);
  }
}

```

## createInstallment

- HTTP Method: `POST`
- Endpoint: `/v3/installments`

**Parameters**

| Name                         | Type                                                                      | Required | Description  |
| :--------------------------- | :------------------------------------------------------------------------ | :------- | :----------- |
| apiInstallmentSaveRequestDto | [ApiInstallmentSaveRequestDto](../models/ApiInstallmentSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`ApiInstallmentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiInstallmentGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiInstallmentSaveRequestBillingType;
import com.asaas.sdk.asaasjavasdk.models.ApiInstallmentSaveRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiInstallmentSplitRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDiscountDiscountType;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDiscountDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentFineRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentFineRequestFineType;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentInterestRequestDto;
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

    ApiInstallmentSplitRequestDto apiInstallmentSplitRequestDto = ApiInstallmentSplitRequestDto.builder()
      .walletId("walletId")
      .fixedValue(2.11D)
      .percentualValue(0.03D)
      .totalFixedValue(4.67D)
      .externalReference("externalReference")
      .description("description")
      .installmentNumber(1L)
      .build();

    List<ApiInstallmentSplitRequestDto> splitsList = Arrays.asList(apiInstallmentSplitRequestDto);

    ApiInstallmentSaveRequestDto apiInstallmentSaveRequestDto = ApiInstallmentSaveRequestDto.builder()
      .installmentCount(3L)
      .customer("cus_G7Dvo4iphUNk")
      .value(100D)
      .totalValue(150D)
      .billingType(ApiInstallmentSaveRequestBillingType.UNDEFINED)
      .dueDate("2025-07-08")
      .description("Installment 08652")
      .postalService(true)
      .daysAfterDueDateToRegistrationCancellation(1L)
      .paymentExternalReference("056984")
      .discount(apiPaymentDiscountDto)
      .interest(apiPaymentInterestRequestDto)
      .fine(apiPaymentFineRequestDto)
      .splits(splitsList)
      .build();

    ApiInstallmentGetResponseDto response = asaasSdk.installment.createInstallment(apiInstallmentSaveRequestDto);

    System.out.println(response);
  }
}

```

## createInstallmentWithCreditCard

- HTTP Method: `POST`
- Endpoint: `/v3/installments/`

**Parameters**

| Name                                       | Type                                                                                                  | Required | Description  |
| :----------------------------------------- | :---------------------------------------------------------------------------------------------------- | :------- | :----------- |
| apiInstallmentSaveWithCreditCardRequestDto | [ApiInstallmentSaveWithCreditCardRequestDto](../models/ApiInstallmentSaveWithCreditCardRequestDto.md) | ❌       | Request Body |

**Return Type**

`ApiInstallmentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCreditCardHolderInfoRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiCreditCardRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiInstallmentGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiInstallmentSaveWithCreditCardRequestBillingType;
import com.asaas.sdk.asaasjavasdk.models.ApiInstallmentSaveWithCreditCardRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiInstallmentSplitRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDiscountDiscountType;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentDiscountDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentFineRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentFineRequestFineType;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentInterestRequestDto;
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

    ApiInstallmentSplitRequestDto apiInstallmentSplitRequestDto = ApiInstallmentSplitRequestDto.builder()
      .walletId("walletId")
      .fixedValue(2.11D)
      .percentualValue(0.03D)
      .totalFixedValue(4.67D)
      .externalReference("externalReference")
      .description("description")
      .installmentNumber(1L)
      .build();

    List<ApiInstallmentSplitRequestDto> splitsList = Arrays.asList(apiInstallmentSplitRequestDto);

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

    ApiInstallmentSaveWithCreditCardRequestDto apiInstallmentSaveWithCreditCardRequestDto =
      ApiInstallmentSaveWithCreditCardRequestDto.builder()
        .installmentCount(3L)
        .customer("cus_G7Dvo4iphUNk")
        .value(100D)
        .totalValue(150D)
        .billingType(ApiInstallmentSaveWithCreditCardRequestBillingType.UNDEFINED)
        .dueDate("2025-07-08")
        .description("Installment 08652")
        .postalService(false)
        .daysAfterDueDateToRegistrationCancellation(1L)
        .paymentExternalReference("056984")
        .discount(apiPaymentDiscountDto)
        .interest(apiPaymentInterestRequestDto)
        .fine(apiPaymentFineRequestDto)
        .splits(splitsList)
        .creditCard(apiCreditCardRequestDto)
        .creditCardHolderInfo(apiCreditCardHolderInfoRequestDto)
        .creditCardToken("a75a1d98-c52d-4a6b-a413-71e00b193c99")
        .authorizeOnly(false)
        .remoteIp("remoteIp")
        .build();

    ApiInstallmentGetResponseDto response = asaasSdk.installment.createInstallmentWithCreditCard(
      apiInstallmentSaveWithCreditCardRequestDto
    );

    System.out.println(response);
  }
}

```

## retrieveASingleInstallment

- HTTP Method: `GET`
- Endpoint: `/v3/installments/{id}`

**Parameters**

| Name | Type   | Required | Description                            |
| :--- | :----- | :------- | :------------------------------------- |
| id   | String | ✅       | Unique installment identifier in Asaas |

**Return Type**

`ApiInstallmentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiInstallmentGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiInstallmentGetResponseDto response = asaasSdk.installment.retrieveASingleInstallment(
      "2765d086-c7c5-5cca-898a-4262d212587c"
    );

    System.out.println(response);
  }
}

```

## removeInstallment

- HTTP Method: `DELETE`
- Endpoint: `/v3/installments/{id}`

**Parameters**

| Name | Type   | Required | Description                                         |
| :--- | :----- | :------- | :-------------------------------------------------- |
| id   | String | ✅       | Unique identifier of the installment to be removed. |

**Return Type**

`ApiInstallmentDeleteResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiInstallmentDeleteResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiInstallmentDeleteResponseDto response = asaasSdk.installment.removeInstallment(
      "5a2c890b-dd63-4b5a-9169-96c8d7828f4c"
    );

    System.out.println(response);
  }
}

```

## listPaymentsOfAInstallment

- HTTP Method: `GET`
- Endpoint: `/v3/installments/{id}/payments`

**Parameters**

| Name              | Type                                                                                      | Required | Description                            |
| :---------------- | :---------------------------------------------------------------------------------------- | :------- | :------------------------------------- |
| id                | String                                                                                    | ✅       | Unique installment identifier in Asaas |
| requestParameters | [ListPaymentsOfAInstallmentParameters](../models/ListPaymentsOfAInstallmentParameters.md) | ❌       | Request Parameters Object              |

**Return Type**

`ApiPaymentListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiInstallmentListPaymentsRequestPaymentStatus;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentListResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ListPaymentsOfAInstallmentParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListPaymentsOfAInstallmentParameters requestParameters = ListPaymentsOfAInstallmentParameters.builder()
      .status(ApiInstallmentListPaymentsRequestPaymentStatus.PENDING)
      .build();

    ApiPaymentListResponseDto response = asaasSdk.installment.listPaymentsOfAInstallment(
      "2765d086-c7c5-5cca-898a-4262d212587c",
      requestParameters
    );

    System.out.println(response);
  }
}

```

## generateInstallmentBooklet

- HTTP Method: `GET`
- Endpoint: `/v3/installments/{id}/paymentBook`

**Parameters**

| Name              | Type                                                                                      | Required | Description                            |
| :---------------- | :---------------------------------------------------------------------------------------- | :------- | :------------------------------------- |
| id                | String                                                                                    | ✅       | Unique installment identifier in Asaas |
| requestParameters | [GenerateInstallmentBookletParameters](../models/GenerateInstallmentBookletParameters.md) | ❌       | Request Parameters Object              |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.GenerateInstallmentBookletParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    GenerateInstallmentBookletParameters requestParameters = GenerateInstallmentBookletParameters.builder()
      .sort("sort")
      .order("asc")
      .build();

    Object response = asaasSdk.installment.generateInstallmentBooklet(
      "2765d086-c7c5-5cca-898a-4262d212587c",
      requestParameters
    );

    System.out.println(response);
  }
}

```

## refundInstallment

It is possible to refund an installment received or confirmed via credit card. Just like the process of refunding a standalone credit card billing, the corresponding balance of the installment is debited from your account on Asaas, and the billing is canceled on your customer's card. The cancellation may take up to 10 business days to appear on your customer's statement.

- HTTP Method: `POST`
- Endpoint: `/v3/installments/{id}/refund`

**Parameters**

| Name  | Type   | Required | Description                                          |
| :---- | :----- | :------- | :--------------------------------------------------- |
| id    | String | ✅       | Unique identifier of the installment to be refunded. |
| input | Object | ❌       | Request Body                                         |

**Return Type**

`ApiInstallmentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiInstallmentGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiInstallmentGetResponseDto response = asaasSdk.installment.refundInstallment(
      "2765d086-c7c5-5cca-898a-4262d212587c",
      new Object()
    );

    System.out.println(response);
  }
}

```

## updateInstallmentSplits

- HTTP Method: `PUT`
- Endpoint: `/v3/installments/{id}/splits`

**Parameters**

| Name                                | Type                                                                                    | Required | Description    |
| :---------------------------------- | :-------------------------------------------------------------------------------------- | :------- | :------------- |
| id                                  | String                                                                                  | ✅       | Installment ID |
| apiInstallmentUpdateSplitRequestDto | [ApiInstallmentUpdateSplitRequestDto](../models/ApiInstallmentUpdateSplitRequestDto.md) | ❌       | Request Body   |

**Return Type**

`ApiInstallmentUpdateSplitResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiInstallmentSplitRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiInstallmentUpdateSplitRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiInstallmentUpdateSplitResponseDto;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiInstallmentSplitRequestDto apiInstallmentSplitRequestDto = ApiInstallmentSplitRequestDto.builder()
      .walletId("walletId")
      .fixedValue(2.11D)
      .percentualValue(0.03D)
      .totalFixedValue(4.67D)
      .externalReference("externalReference")
      .description("description")
      .installmentNumber(1L)
      .build();

    List<ApiInstallmentSplitRequestDto> splitsList = Arrays.asList(apiInstallmentSplitRequestDto);

    ApiInstallmentUpdateSplitRequestDto apiInstallmentUpdateSplitRequestDto =
      ApiInstallmentUpdateSplitRequestDto.builder().splits(splitsList).build();

    ApiInstallmentUpdateSplitResponseDto response = asaasSdk.installment.updateInstallmentSplits(
      "2765d086-c7c5-5cca-898a-4262d212587c",
      apiInstallmentUpdateSplitRequestDto
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
