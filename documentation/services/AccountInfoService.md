# AccountInfoService

A list of all methods in the `AccountInfoService` service. Click on the method name to view detailed information about that method.

| Methods                                                                   | Description |
| :------------------------------------------------------------------------ | :---------- |
| [retrieveBusinessData](#retrievebusinessdata)                             |             |
| [updateBusinessData](#updatebusinessdata)                                 |             |
| [retrievePersonalizationSettings](#retrievepersonalizationsettings)       |             |
| [savePaymentCheckoutPersonalization](#savepaymentcheckoutpersonalization) |             |
| [retrieveAsaasAccountNumber](#retrieveasaasaccountnumber)                 |             |
| [retrieveAccountFees](#retrieveaccountfees)                               |             |
| [checkAccountRegistrationStatus](#checkaccountregistrationstatus)         |             |
| [retrieveWalletid](#retrievewalletid)                                     |             |
| [deleteWhiteLabelSubaccount](#deletewhitelabelsubaccount)                 |             |

## retrieveBusinessData

- HTTP Method: `GET`
- Endpoint: `/v3/myAccount/commercialInfo/`

**Return Type**

`ApiCustomerUpdateRequestGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerUpdateRequestGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiCustomerUpdateRequestGetResponseDto response = asaasSdk.accountInfo.retrieveBusinessData();

    System.out.println(response);
  }
}

```

## updateBusinessData

- HTTP Method: `POST`
- Endpoint: `/v3/myAccount/commercialInfo/`

**Parameters**

| Name                                   | Type                                                                                          | Required | Description  |
| :------------------------------------- | :-------------------------------------------------------------------------------------------- | :------- | :----------- |
| apiCustomerUpdateRequestSaveRequestDto | [ApiCustomerUpdateRequestSaveRequestDto](../models/ApiCustomerUpdateRequestSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`ApiCustomerUpdateRequestGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerUpdateRequestGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerUpdateRequestSaveRequestCompanyType;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerUpdateRequestSaveRequestDto;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerUpdateRequestSaveRequestPersonType;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiCustomerUpdateRequestSaveRequestDto apiCustomerUpdateRequestSaveRequestDto =
      ApiCustomerUpdateRequestSaveRequestDto.builder()
        .personType(ApiCustomerUpdateRequestSaveRequestPersonType.JURIDICA)
        .cpfCnpj("66625514000140")
        .birthDate("1995-04-12")
        .companyType(ApiCustomerUpdateRequestSaveRequestCompanyType.MEI)
        .incomeValue(25000D)
        .email("john.doe@asaas.com.br")
        .phone("phone")
        .mobilePhone("mobilePhone")
        .site("site")
        .postalCode("89223005")
        .address("Av. Rolf Wiest")
        .addressNumber("659")
        .complement("complement")
        .province("Bom Retiro")
        .build();

    ApiCustomerUpdateRequestGetResponseDto response = asaasSdk.accountInfo.updateBusinessData(
      apiCustomerUpdateRequestSaveRequestDto
    );

    System.out.println(response);
  }
}

```

## retrievePersonalizationSettings

- HTTP Method: `GET`
- Endpoint: `/v3/myAccount/paymentCheckoutConfig/`

**Return Type**

`ApiPaymentCheckoutConfigGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentCheckoutConfigGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentCheckoutConfigGetResponseDto response = asaasSdk.accountInfo.retrievePersonalizationSettings();

    System.out.println(response);
  }
}

```

## savePaymentCheckoutPersonalization

- HTTP Method: `POST`
- Endpoint: `/v3/myAccount/paymentCheckoutConfig/`

**Parameters**

| Name                                   | Type                                                                                          | Required | Description                    |
| :------------------------------------- | :-------------------------------------------------------------------------------------------- | :------- | :----------------------------- |
| apiPaymentCheckoutConfigSaveRequestDto | [ApiPaymentCheckoutConfigSaveRequestDto](../models/ApiPaymentCheckoutConfigSaveRequestDto.md) | ❌       | Request Body                   |
| \_filename                             | [String](../models/String.md)                                                                 | ❌       | Filename for the uploaded file |

**Return Type**

`ApiPaymentCheckoutConfigGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentCheckoutConfigGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentCheckoutConfigSaveRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiPaymentCheckoutConfigSaveRequestDto apiPaymentCheckoutConfigSaveRequestDto =
      ApiPaymentCheckoutConfigSaveRequestDto.builder()
        .logoBackgroundColor("#00ff00")
        .infoBackgroundColor("#000fff")
        .fontColor("#00ff0")
        .enabled(true)
        .logoFile(nostrud)
        .build();
    ApiPaymentCheckoutConfigSaveRequestDto apiPaymentCheckoutConfigSaveRequestDto =
      ApiPaymentCheckoutConfigSaveRequestDto.builder()
        .logoBackgroundColor("#00ff00")
        .infoBackgroundColor("#000fff")
        .fontColor("#00ff0")
        .enabled(true)
        .logoFile(nostrud)
        .build();

    ApiPaymentCheckoutConfigGetResponseDto response = asaasSdk.accountInfo.savePaymentCheckoutPersonalization(
      apiPaymentCheckoutConfigSaveRequestDto,
      apiPaymentCheckoutConfigSaveRequestDto
    );

    System.out.println(response);
  }
}

```

## retrieveAsaasAccountNumber

- HTTP Method: `GET`
- Endpoint: `/v3/myAccount/accountNumber`

**Return Type**

`ApiMyAccountGetAccountNumberResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiMyAccountGetAccountNumberResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiMyAccountGetAccountNumberResponseDto response = asaasSdk.accountInfo.retrieveAsaasAccountNumber();

    System.out.println(response);
  }
}

```

## retrieveAccountFees

- HTTP Method: `GET`
- Endpoint: `/v3/myAccount/fees/`

**Return Type**

`ApiMyAccountGetAccountFeesResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiMyAccountGetAccountFeesResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiMyAccountGetAccountFeesResponseDto response = asaasSdk.accountInfo.retrieveAccountFees();

    System.out.println(response);
  }
}

```

## checkAccountRegistrationStatus

- HTTP Method: `GET`
- Endpoint: `/v3/myAccount/status/`

**Return Type**

`ApiMyAccountGetStatusResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiMyAccountGetStatusResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiMyAccountGetStatusResponseDto response = asaasSdk.accountInfo.checkAccountRegistrationStatus();

    System.out.println(response);
  }
}

```

## retrieveWalletid

- HTTP Method: `GET`
- Endpoint: `/v3/wallets/`

**Return Type**

`ApiWalletShowResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiWalletShowResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiWalletShowResponseDto response = asaasSdk.accountInfo.retrieveWalletid();

    System.out.println(response);
  }
}

```

## deleteWhiteLabelSubaccount

- HTTP Method: `DELETE`
- Endpoint: `/v3/myAccount/`

**Parameters**

| Name              | Type                                                                                      | Required | Description               |
| :---------------- | :---------------------------------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [DeleteWhiteLabelSubaccountParameters](../models/DeleteWhiteLabelSubaccountParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ApiMyAccountDisableAccountResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiMyAccountDisableAccountResponseDto;
import com.asaas.sdk.asaasjavasdk.models.DeleteWhiteLabelSubaccountParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    DeleteWhiteLabelSubaccountParameters requestParameters = DeleteWhiteLabelSubaccountParameters.builder()
      .removeReason("Release data")
      .build();

    ApiMyAccountDisableAccountResponseDto response = asaasSdk.accountInfo.deleteWhiteLabelSubaccount(requestParameters);

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
