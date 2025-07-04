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

`InvoiceListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.InvoiceListRequestInvoiceStatus;
import com.asaas.apisdk.models.InvoiceListResponseDto;
import com.asaas.apisdk.models.ListInvoicesParameters;

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
      .status(InvoiceListRequestInvoiceStatus.SCHEDULED)
      .customer("customer")
      .build();

    InvoiceListResponseDto response = asaasSdk.invoice.listInvoices(requestParameters);

    System.out.println(response);
  }
}

```

## scheduleInvoice

- HTTP Method: `POST`
- Endpoint: `/v3/invoices`

**Parameters**

| Name                  | Type                                                        | Required | Description  |
| :-------------------- | :---------------------------------------------------------- | :------- | :----------- |
| invoiceSaveRequestDto | [InvoiceSaveRequestDto](../models/InvoiceSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`InvoiceGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.InvoiceGetResponseDto;
import com.asaas.apisdk.models.InvoiceSaveRequestDto;
import com.asaas.apisdk.models.InvoiceTaxesDto;

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

    InvoiceSaveRequestDto invoiceSaveRequestDto = InvoiceSaveRequestDto.builder()
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
      .taxes(invoiceTaxesDto)
      .build();

    InvoiceGetResponseDto response = asaasSdk.invoice.scheduleInvoice(invoiceSaveRequestDto);

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

`InvoiceGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.InvoiceGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    InvoiceGetResponseDto response = asaasSdk.invoice.retrieveASingleInvoice("inv_000000000232");

    System.out.println(response);
  }
}

```

## updateInvoice

- HTTP Method: `PUT`
- Endpoint: `/v3/invoices/{id}`

**Parameters**

| Name                    | Type                                                            | Required | Description                        |
| :---------------------- | :-------------------------------------------------------------- | :------- | :--------------------------------- |
| id                      | String                                                          | ✅       | Unique invoice identifier in Asaas |
| invoiceUpdateRequestDto | [InvoiceUpdateRequestDto](../models/InvoiceUpdateRequestDto.md) | ❌       | Request Body                       |

**Return Type**

`InvoiceGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.InvoiceGetResponseDto;
import com.asaas.apisdk.models.InvoiceTaxesDto;
import com.asaas.apisdk.models.InvoiceUpdateRequestDto;

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

    InvoiceUpdateRequestDto invoiceUpdateRequestDto = InvoiceUpdateRequestDto.builder()
      .serviceDescription("serviceDescription")
      .observations("Monthly for June work.")
      .externalReference("externalReference")
      .value(300D)
      .deductions(10D)
      .effectiveDate("2024-08-20")
      .updatePayment(true)
      .taxes(invoiceTaxesDto)
      .build();

    InvoiceGetResponseDto response = asaasSdk.invoice.updateInvoice("inv_000000000232", invoiceUpdateRequestDto);

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

`InvoiceGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.InvoiceGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    InvoiceGetResponseDto response = asaasSdk.invoice.issueAnInvoice("inv_000000000232", new Object());

    System.out.println(response);
  }
}

```

## cancelAnInvoice

- HTTP Method: `POST`
- Endpoint: `/v3/invoices/{id}/cancel`

**Parameters**

| Name                    | Type                                                            | Required | Description                        |
| :---------------------- | :-------------------------------------------------------------- | :------- | :--------------------------------- |
| id                      | String                                                          | ✅       | Unique invoice identifier in Asaas |
| invoiceCancelRequestDto | [InvoiceCancelRequestDto](../models/InvoiceCancelRequestDto.md) | ❌       | Request Body                       |

**Return Type**

`InvoiceGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.InvoiceCancelRequestDto;
import com.asaas.apisdk.models.InvoiceGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    InvoiceCancelRequestDto invoiceCancelRequestDto = InvoiceCancelRequestDto.builder()
      .cancelOnlyOnAsaas(false)
      .build();

    InvoiceGetResponseDto response = asaasSdk.invoice.cancelAnInvoice("inv_000000000232", invoiceCancelRequestDto);

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
