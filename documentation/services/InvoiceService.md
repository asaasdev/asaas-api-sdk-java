# InvoiceService

A list of all methods in the `InvoiceService` service. Click on the method name to view detailed information about that method.

| Methods                                           | Description |
| :------------------------------------------------ | :---------- |
| [listInvoices](#listinvoices)                     |             |
| [scheduleInvoice](#scheduleinvoice)               |             |
| [retrieveASingleInvoice](#retrieveasingleinvoice) |             |
| [updateInvoice](#updateinvoice)                   |             |
| [issueAnInvoice](#issueaninvoice)                 |             |
| [cancelAnInvoice](#cancelaninvoice)               |             |

## listInvoices

- HTTP Method: `GET`
- Endpoint: `/v3/invoices`

**Parameters**

| Name              | Type                                                          | Required | Description               |
| :---------------- | :------------------------------------------------------------ | :------- | :------------------------ |
| requestParameters | [ListInvoicesParameters](../models/ListInvoicesParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ApiCustomerInvoiceListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerInvoiceListRequestInvoiceStatus;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerInvoiceListResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ListInvoicesParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListInvoicesParameters requestParameters = ListInvoicesParameters.builder()
      .offset(10L)
      .limit(10L)
      .effectiveDateGe("2024-08-03")
      .effectiveDateLe("2024-09-03")
      .payment("payment")
      .installment("installment")
      .externalReference("externalReference")
      .status(ApiCustomerInvoiceListRequestInvoiceStatus.SCHEDULED)
      .customer("customer")
      .build();

    ApiCustomerInvoiceListResponseDto response = asaasSdk.invoice.listInvoices(requestParameters);

    System.out.println(response);
  }
}

```

## scheduleInvoice

- HTTP Method: `POST`
- Endpoint: `/v3/invoices`

**Parameters**

| Name                             | Type                                                                              | Required | Description  |
| :------------------------------- | :-------------------------------------------------------------------------------- | :------- | :----------- |
| apiCustomerInvoiceSaveRequestDto | [ApiCustomerInvoiceSaveRequestDto](../models/ApiCustomerInvoiceSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`ApiCustomerInvoiceGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerInvoiceGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerInvoiceSaveRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerInvoiceTaxesDto;

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

    ApiCustomerInvoiceSaveRequestDto apiCustomerInvoiceSaveRequestDto = ApiCustomerInvoiceSaveRequestDto.builder()
      .payment("pay_637959110194")
      .installment("installment")
      .customer("cus_000000002750")
      .serviceDescription("serviceDescription")
      .observations("Monthly for June work.")
      .externalReference("externalReference")
      .value(300D)
      .deductions(10D)
      .effectiveDate("2024-08-20")
      .municipalServiceId("municipalServiceId")
      .municipalServiceCode("1.01")
      .municipalServiceName("Systems analysis and development")
      .updatePayment(false)
      .taxes(apiCustomerInvoiceTaxesDto)
      .build();

    ApiCustomerInvoiceGetResponseDto response = asaasSdk.invoice.scheduleInvoice(apiCustomerInvoiceSaveRequestDto);

    System.out.println(response);
  }
}

```

## retrieveASingleInvoice

- HTTP Method: `GET`
- Endpoint: `/v3/invoices/{id}`

**Parameters**

| Name | Type   | Required | Description                        |
| :--- | :----- | :------- | :--------------------------------- |
| id   | String | ✅       | Unique invoice identifier in Asaas |

**Return Type**

`ApiCustomerInvoiceGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerInvoiceGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiCustomerInvoiceGetResponseDto response = asaasSdk.invoice.retrieveASingleInvoice("inv_000000000232");

    System.out.println(response);
  }
}

```

## updateInvoice

- HTTP Method: `PUT`
- Endpoint: `/v3/invoices/{id}`

**Parameters**

| Name                               | Type                                                                                  | Required | Description                        |
| :--------------------------------- | :------------------------------------------------------------------------------------ | :------- | :--------------------------------- |
| id                                 | String                                                                                | ✅       | Unique invoice identifier in Asaas |
| apiCustomerInvoiceUpdateRequestDto | [ApiCustomerInvoiceUpdateRequestDto](../models/ApiCustomerInvoiceUpdateRequestDto.md) | ❌       | Request Body                       |

**Return Type**

`ApiCustomerInvoiceGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerInvoiceGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerInvoiceTaxesDto;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerInvoiceUpdateRequestDto;

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

    ApiCustomerInvoiceUpdateRequestDto apiCustomerInvoiceUpdateRequestDto = ApiCustomerInvoiceUpdateRequestDto.builder()
      .serviceDescription("serviceDescription")
      .observations("Monthly for June work.")
      .externalReference("externalReference")
      .value(300D)
      .deductions(10D)
      .effectiveDate("2024-08-20")
      .updatePayment(true)
      .taxes(apiCustomerInvoiceTaxesDto)
      .build();

    ApiCustomerInvoiceGetResponseDto response = asaasSdk.invoice.updateInvoice(
      "inv_000000000232",
      apiCustomerInvoiceUpdateRequestDto
    );

    System.out.println(response);
  }
}

```

## issueAnInvoice

- HTTP Method: `POST`
- Endpoint: `/v3/invoices/{id}/authorize`

**Parameters**

| Name  | Type   | Required | Description                        |
| :---- | :----- | :------- | :--------------------------------- |
| id    | String | ✅       | Unique invoice identifier in Asaas |
| input | Object | ❌       | Request Body                       |

**Return Type**

`ApiCustomerInvoiceGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerInvoiceGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiCustomerInvoiceGetResponseDto response = asaasSdk.invoice.issueAnInvoice("inv_000000000232", new Object());

    System.out.println(response);
  }
}

```

## cancelAnInvoice

- HTTP Method: `POST`
- Endpoint: `/v3/invoices/{id}/cancel`

**Parameters**

| Name                               | Type                                                                                  | Required | Description                        |
| :--------------------------------- | :------------------------------------------------------------------------------------ | :------- | :--------------------------------- |
| id                                 | String                                                                                | ✅       | Unique invoice identifier in Asaas |
| apiCustomerInvoiceCancelRequestDto | [ApiCustomerInvoiceCancelRequestDto](../models/ApiCustomerInvoiceCancelRequestDto.md) | ❌       | Request Body                       |

**Return Type**

`ApiCustomerInvoiceGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerInvoiceCancelRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerInvoiceGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiCustomerInvoiceCancelRequestDto apiCustomerInvoiceCancelRequestDto = ApiCustomerInvoiceCancelRequestDto.builder()
      .cancelOnlyOnAsaas(false)
      .build();

    ApiCustomerInvoiceGetResponseDto response = asaasSdk.invoice.cancelAnInvoice(
      "inv_000000000232",
      apiCustomerInvoiceCancelRequestDto
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
