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

`InstallmentListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.InstallmentListResponseDto;
import com.asaas.apisdk.models.ListInstallmentsParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListInstallmentsParameters requestParameters = ListInstallmentsParameters.builder().offset(10L).limit(10L).build();

    InstallmentListResponseDto response = asaasSdk.installment.listInstallments(requestParameters);

    System.out.println(response);
  }
}

```

## createInstallment

- HTTP Method: `POST`
- Endpoint: `/v3/installments`

**Parameters**

| Name                      | Type                                                                | Required | Description  |
| :------------------------ | :------------------------------------------------------------------ | :------- | :----------- |
| installmentSaveRequestDto | [InstallmentSaveRequestDto](../models/InstallmentSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`InstallmentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.InstallmentGetResponseDto;
import com.asaas.apisdk.models.InstallmentSaveRequestBillingType;
import com.asaas.apisdk.models.InstallmentSaveRequestDto;
import com.asaas.apisdk.models.InstallmentSplitRequestDto;
import com.asaas.apisdk.models.PaymentDiscountDiscountType;
import com.asaas.apisdk.models.PaymentDiscountDto;
import com.asaas.apisdk.models.PaymentFineRequestDto;
import com.asaas.apisdk.models.PaymentFineRequestFineType;
import com.asaas.apisdk.models.PaymentInterestRequestDto;
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

    InstallmentSplitRequestDto installmentSplitRequestDto = InstallmentSplitRequestDto.builder()
      .walletId("walletId")
      .fixedValue(2.11D)
      .percentualValue(0.03D)
      .totalFixedValue(4.67D)
      .externalReference("externalReference")
      .description("description")
      .installmentNumber(1L)
      .build();

    List<InstallmentSplitRequestDto> splitsList = Arrays.asList(installmentSplitRequestDto);

    InstallmentSaveRequestDto installmentSaveRequestDto = InstallmentSaveRequestDto.builder()
      .installmentCount(3L)
      .customer("cus_G7Dvo4iphUNk")
      .value(100D)
      .totalValue(150D)
      .billingType(InstallmentSaveRequestBillingType.UNDEFINED)
      .dueDate("2025-07-08")
      .description("Installment 08652")
      .postalService(true)
      .daysAfterDueDateToRegistrationCancellation(1L)
      .paymentExternalReference("056984")
      .discount(paymentDiscountDto)
      .interest(paymentInterestRequestDto)
      .fine(paymentFineRequestDto)
      .splits(splitsList)
      .build();

    InstallmentGetResponseDto response = asaasSdk.installment.createInstallment(installmentSaveRequestDto);

    System.out.println(response);
  }
}

```

## createInstallmentWithCreditCard

- HTTP Method: `POST`
- Endpoint: `/v3/installments/`

**Parameters**

| Name                                    | Type                                                                                            | Required | Description  |
| :-------------------------------------- | :---------------------------------------------------------------------------------------------- | :------- | :----------- |
| installmentSaveWithCreditCardRequestDto | [InstallmentSaveWithCreditCardRequestDto](../models/InstallmentSaveWithCreditCardRequestDto.md) | ❌       | Request Body |

**Return Type**

`InstallmentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.CreditCardHolderInfoRequestDto;
import com.asaas.apisdk.models.CreditCardRequestDto;
import com.asaas.apisdk.models.InstallmentGetResponseDto;
import com.asaas.apisdk.models.InstallmentSaveWithCreditCardRequestBillingType;
import com.asaas.apisdk.models.InstallmentSaveWithCreditCardRequestDto;
import com.asaas.apisdk.models.InstallmentSplitRequestDto;
import com.asaas.apisdk.models.PaymentDiscountDiscountType;
import com.asaas.apisdk.models.PaymentDiscountDto;
import com.asaas.apisdk.models.PaymentFineRequestDto;
import com.asaas.apisdk.models.PaymentFineRequestFineType;
import com.asaas.apisdk.models.PaymentInterestRequestDto;
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

    InstallmentSplitRequestDto installmentSplitRequestDto = InstallmentSplitRequestDto.builder()
      .walletId("walletId")
      .fixedValue(2.11D)
      .percentualValue(0.03D)
      .totalFixedValue(4.67D)
      .externalReference("externalReference")
      .description("description")
      .installmentNumber(1L)
      .build();

    List<InstallmentSplitRequestDto> splitsList = Arrays.asList(installmentSplitRequestDto);

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

    InstallmentSaveWithCreditCardRequestDto installmentSaveWithCreditCardRequestDto =
      InstallmentSaveWithCreditCardRequestDto.builder()
        .installmentCount(3L)
        .customer("cus_G7Dvo4iphUNk")
        .value(100D)
        .totalValue(150D)
        .billingType(InstallmentSaveWithCreditCardRequestBillingType.UNDEFINED)
        .dueDate("2025-07-08")
        .description("Installment 08652")
        .postalService(false)
        .daysAfterDueDateToRegistrationCancellation(1L)
        .paymentExternalReference("056984")
        .discount(paymentDiscountDto)
        .interest(paymentInterestRequestDto)
        .fine(paymentFineRequestDto)
        .splits(splitsList)
        .creditCard(creditCardRequestDto)
        .creditCardHolderInfo(creditCardHolderInfoRequestDto)
        .creditCardToken("a75a1d98-c52d-4a6b-a413-71e00b193c99")
        .authorizeOnly(false)
        .remoteIp("remoteIp")
        .build();

    InstallmentGetResponseDto response = asaasSdk.installment.createInstallmentWithCreditCard(
      installmentSaveWithCreditCardRequestDto
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

`InstallmentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.InstallmentGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    InstallmentGetResponseDto response = asaasSdk.installment.retrieveASingleInstallment(
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

`InstallmentDeleteResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.InstallmentDeleteResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    InstallmentDeleteResponseDto response = asaasSdk.installment.removeInstallment(
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

`PaymentListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.InstallmentListPaymentsRequestPaymentStatus;
import com.asaas.apisdk.models.ListPaymentsOfAInstallmentParameters;
import com.asaas.apisdk.models.PaymentListResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListPaymentsOfAInstallmentParameters requestParameters = ListPaymentsOfAInstallmentParameters.builder()
      .status(InstallmentListPaymentsRequestPaymentStatus.PENDING)
      .build();

    PaymentListResponseDto response = asaasSdk.installment.listPaymentsOfAInstallment(
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

`InstallmentPaymentBookResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.GenerateInstallmentBookletParameters;
import com.asaas.apisdk.models.InstallmentPaymentBookResponseDto;

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

    InstallmentPaymentBookResponseDto response = asaasSdk.installment.generateInstallmentBooklet(
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

`InstallmentGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.InstallmentGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    InstallmentGetResponseDto response = asaasSdk.installment.refundInstallment(
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

| Name                             | Type                                                                              | Required | Description    |
| :------------------------------- | :-------------------------------------------------------------------------------- | :------- | :------------- |
| id                               | String                                                                            | ✅       | Installment ID |
| installmentUpdateSplitRequestDto | [InstallmentUpdateSplitRequestDto](../models/InstallmentUpdateSplitRequestDto.md) | ❌       | Request Body   |

**Return Type**

`InstallmentUpdateSplitResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.InstallmentSplitRequestDto;
import com.asaas.apisdk.models.InstallmentUpdateSplitRequestDto;
import com.asaas.apisdk.models.InstallmentUpdateSplitResponseDto;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    InstallmentSplitRequestDto installmentSplitRequestDto = InstallmentSplitRequestDto.builder()
      .walletId("walletId")
      .fixedValue(2.11D)
      .percentualValue(0.03D)
      .totalFixedValue(4.67D)
      .externalReference("externalReference")
      .description("description")
      .installmentNumber(1L)
      .build();

    List<InstallmentSplitRequestDto> splitsList = Arrays.asList(installmentSplitRequestDto);

    InstallmentUpdateSplitRequestDto installmentUpdateSplitRequestDto = InstallmentUpdateSplitRequestDto.builder()
      .splits(splitsList)
      .build();

    InstallmentUpdateSplitResponseDto response = asaasSdk.installment.updateInstallmentSplits(
      "2765d086-c7c5-5cca-898a-4262d212587c",
      installmentUpdateSplitRequestDto
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
