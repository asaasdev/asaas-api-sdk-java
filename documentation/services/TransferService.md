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

`ListTransfersOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ListTransfersOkResponse;
import com.asaas.sdk.asaasjavasdk.models.ListTransfersParameters;

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

    ListTransfersOkResponse response = asaasSdk.transfer.listTransfers(requestParameters);

    System.out.println(response);
  }
}

```

## transferToAnotherInstitutionAccountOrPixKey

- HTTP Method: `POST`
- Endpoint: `/v3/transfers`

**Parameters**

| Name                                               | Type                                                                                                                  | Required | Description  |
| :------------------------------------------------- | :-------------------------------------------------------------------------------------------------------------------- | :------- | :----------- |
| transferToAnotherInstitutionAccountOrPixKeyRequest | [TransferToAnotherInstitutionAccountOrPixKeyRequest](../models/TransferToAnotherInstitutionAccountOrPixKeyRequest.md) | ❌       | Request Body |

**Return Type**

`ApiTransferGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiTransferBankAccountSaveRequestBankAccountType;
import com.asaas.sdk.asaasjavasdk.models.ApiTransferBankAccountSaveRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiTransferBankSaveRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiTransferGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiTransferRecurringSaveRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiTransferRecurringSaveRequestRecurringCheckoutScheduleFrequency;
import com.asaas.sdk.asaasjavasdk.models.ApiTransferSaveRequestPixAddressKeyType;
import com.asaas.sdk.asaasjavasdk.models.ApiTransferSaveRequestTransferType;
import com.asaas.sdk.asaasjavasdk.models.TransferToAnotherInstitutionAccountOrPixKeyRequest;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiTransferBankSaveRequestDto apiTransferBankSaveRequestDto = ApiTransferBankSaveRequestDto.builder()
      .code("237")
      .build();

    ApiTransferBankAccountSaveRequestDto apiTransferBankAccountSaveRequestDto =
      ApiTransferBankAccountSaveRequestDto.builder()
        .bank(apiTransferBankSaveRequestDto)
        .accountName("Bradesco account")
        .ownerName("John Doe")
        .ownerBirthDate("1995-04-12")
        .cpfCnpj("52233424611")
        .agency("1263")
        .account("9999991")
        .accountDigit("1")
        .bankAccountType(ApiTransferBankAccountSaveRequestBankAccountType.CONTA_CORRENTE)
        .ispb("60746948")
        .build();

    ApiTransferRecurringSaveRequestDto apiTransferRecurringSaveRequestDto = ApiTransferRecurringSaveRequestDto.builder()
      .frequency(ApiTransferRecurringSaveRequestRecurringCheckoutScheduleFrequency.WEEKLY)
      .quantity(3L)
      .build();

    TransferToAnotherInstitutionAccountOrPixKeyRequest transferToAnotherInstitutionAccountOrPixKeyRequest =
      TransferToAnotherInstitutionAccountOrPixKeyRequest.builder()
        .value(1000D)
        .bankAccount(apiTransferBankAccountSaveRequestDto)
        .operationType(ApiTransferSaveRequestTransferType.PIX)
        .pixAddressKey("pixAddressKey")
        .pixAddressKeyType(ApiTransferSaveRequestPixAddressKeyType.CPF)
        .description("Barbecue paid via Pix scheduled")
        .scheduleDate("2018-01-26")
        .externalReference("externalReference")
        .recurring(apiTransferRecurringSaveRequestDto)
        .build();

    ApiTransferGetResponseDto response = asaasSdk.transfer.transferToAnotherInstitutionAccountOrPixKey(
      transferToAnotherInstitutionAccountOrPixKeyRequest
    );

    System.out.println(response);
  }
}

```

## transferToAsaasAccount

- HTTP Method: `POST`
- Endpoint: `/v3/transfers/`

**Parameters**

| Name                          | Type                                                                        | Required | Description  |
| :---------------------------- | :-------------------------------------------------------------------------- | :------- | :----------- |
| transferToAsaasAccountRequest | [TransferToAsaasAccountRequest](../models/TransferToAsaasAccountRequest.md) | ❌       | Request Body |

**Return Type**

`TransferToAsaasAccountOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.TransferToAsaasAccountOkResponse;
import com.asaas.sdk.asaasjavasdk.models.TransferToAsaasAccountRequest;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    TransferToAsaasAccountRequest transferToAsaasAccountRequest = TransferToAsaasAccountRequest.builder()
      .value(1000D)
      .walletId("021c712-d963-4d86-a59d-031e7ac51a2e")
      .externalReference("externalReference")
      .build();

    TransferToAsaasAccountOkResponse response = asaasSdk.transfer.transferToAsaasAccount(transferToAsaasAccountRequest);

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

`ApiTransferGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiTransferGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiTransferGetResponseDto response = asaasSdk.transfer.retrieveASingleTransfer(
      "777eb7c8-b1a2-4356-8fd8-a1b0644b528"
    );

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

`CancelATransferOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.CancelATransferOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    CancelATransferOkResponse response = asaasSdk.transfer.cancelATransfer("777eb7c8-b1a2-4356-8fd8-a1b0644b5282");

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
