# TransferService

A list of all methods in the `TransferService` service. Click on the method name to view detailed information about that method.

| Methods                                                                                     | Description                                                                     |
| :------------------------------------------------------------------------------------------ | :------------------------------------------------------------------------------ |
| [listTransfers](#listtransfers)                                                             | This method returns a paginated list of all transfers for the specified filter. |
| [transferToAnotherInstitutionAccountOrPixKey](#transfertoanotherinstitutionaccountorpixkey) |                                                                                 |
| [transferToAsaasAccount](#transfertoasaasaccount)                                           |                                                                                 |
| [retrieveASingleTransfer](#retrieveasingletransfer)                                         |                                                                                 |
| [cancelATransfer](#cancelatransfer)                                                         |                                                                                 |

## listTransfers

This method returns a paginated list of all transfers for the specified filter.

- HTTP Method: `GET`
- Endpoint: `/v3/transfers`

**Parameters**

| Name              | Type                                                            | Required | Description               |
| :---------------- | :-------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [ListTransfersParameters](../models/ListTransfersParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`TransferListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ListTransfersParameters;
import com.asaas.apisdk.models.TransferListResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListTransfersParameters requestParameters = ListTransfersParameters.builder()
      .dateCreatedLeGe("dateCreatedLe[ge]")
      .dateCreatedLeLe("dateCreatedLe[le]")
      .transferDateGe("transferDate[ge]")
      .transferDateLe("transferDate[le]")
      .type("ASAAS_ACCOUNT")
      .build();

    TransferListResponseDto response = asaasSdk.transfer.listTransfers(requestParameters);

    System.out.println(response);
  }
}

```

## transferToAnotherInstitutionAccountOrPixKey

- HTTP Method: `POST`
- Endpoint: `/v3/transfers`

**Parameters**

| Name                   | Type                                                          | Required | Description  |
| :--------------------- | :------------------------------------------------------------ | :------- | :----------- |
| transferSaveRequestDto | [TransferSaveRequestDto](../models/TransferSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`TransferGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.TransferBankAccountSaveRequestBankAccountType;
import com.asaas.apisdk.models.TransferBankAccountSaveRequestDto;
import com.asaas.apisdk.models.TransferBankSaveRequestDto;
import com.asaas.apisdk.models.TransferGetResponseDto;
import com.asaas.apisdk.models.TransferRecurringSaveRequestDto;
import com.asaas.apisdk.models.TransferRecurringSaveRequestRecurringCheckoutScheduleFrequency;
import com.asaas.apisdk.models.TransferSaveRequestDto;
import com.asaas.apisdk.models.TransferSaveRequestPixAddressKeyType;
import com.asaas.apisdk.models.TransferSaveRequestTransferType;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    TransferBankSaveRequestDto transferBankSaveRequestDto = TransferBankSaveRequestDto.builder().code("237").build();

    TransferBankAccountSaveRequestDto transferBankAccountSaveRequestDto = TransferBankAccountSaveRequestDto.builder()
      .bank(transferBankSaveRequestDto)
      .accountName("Bradesco account")
      .ownerName("John Doe")
      .ownerBirthDate("1995-04-12")
      .cpfCnpj("52233424611")
      .agency("1263")
      .account("9999991")
      .accountDigit("1")
      .bankAccountType(TransferBankAccountSaveRequestBankAccountType.CONTA_CORRENTE)
      .ispb("60746948")
      .build();

    TransferRecurringSaveRequestDto transferRecurringSaveRequestDto = TransferRecurringSaveRequestDto.builder()
      .frequency(TransferRecurringSaveRequestRecurringCheckoutScheduleFrequency.WEEKLY)
      .quantity(3L)
      .build();

    TransferSaveRequestDto transferSaveRequestDto = TransferSaveRequestDto.builder()
      .value(1000D)
      .bankAccount(transferBankAccountSaveRequestDto)
      .operationType(TransferSaveRequestTransferType.PIX)
      .pixAddressKey("pixAddressKey")
      .pixAddressKeyType(TransferSaveRequestPixAddressKeyType.CPF)
      .description("Barbecue paid via Pix scheduled")
      .scheduleDate("2018-01-26")
      .externalReference("externalReference")
      .recurring(transferRecurringSaveRequestDto)
      .build();

    TransferGetResponseDto response = asaasSdk.transfer.transferToAnotherInstitutionAccountOrPixKey(
      transferSaveRequestDto
    );

    System.out.println(response);
  }
}

```

## transferToAsaasAccount

- HTTP Method: `POST`
- Endpoint: `/v3/transfers/`

**Parameters**

| Name                                   | Type                                                                                          | Required | Description  |
| :------------------------------------- | :-------------------------------------------------------------------------------------------- | :------- | :----------- |
| transferSaveInternalTransferRequestDto | [TransferSaveInternalTransferRequestDto](../models/TransferSaveInternalTransferRequestDto.md) | ❌       | Request Body |

**Return Type**

`TransferSaveInternalTransferResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.TransferSaveInternalTransferRequestDto;
import com.asaas.apisdk.models.TransferSaveInternalTransferResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    TransferSaveInternalTransferRequestDto transferSaveInternalTransferRequestDto =
      TransferSaveInternalTransferRequestDto.builder()
        .value(1000D)
        .walletId("021c712-d963-4d86-a59d-031e7ac51a2e")
        .externalReference("externalReference")
        .build();

    TransferSaveInternalTransferResponseDto response = asaasSdk.transfer.transferToAsaasAccount(
      transferSaveInternalTransferRequestDto
    );

    System.out.println(response);
  }
}

```

## retrieveASingleTransfer

- HTTP Method: `GET`
- Endpoint: `/v3/transfers/{id}`

**Parameters**

| Name | Type   | Required | Description                         |
| :--- | :----- | :------- | :---------------------------------- |
| id   | String | ✅       | Unique transfer identifier in Asaas |

**Return Type**

`TransferGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.TransferGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    TransferGetResponseDto response = asaasSdk.transfer.retrieveASingleTransfer("777eb7c8-b1a2-4356-8fd8-a1b0644b528");

    System.out.println(response);
  }
}

```

## cancelATransfer

- HTTP Method: `DELETE`
- Endpoint: `/v3/transfers/{id}/cancel`

**Parameters**

| Name | Type   | Required | Description                         |
| :--- | :----- | :------- | :---------------------------------- |
| id   | String | ✅       | Unique transfer identifier in Asaas |

**Return Type**

`TransferGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.TransferGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    TransferGetResponseDto response = asaasSdk.transfer.cancelATransfer("777eb7c8-b1a2-4356-8fd8-a1b0644b5282");

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
