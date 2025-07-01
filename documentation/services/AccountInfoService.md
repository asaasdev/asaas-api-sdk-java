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

`AccountInfoGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.AccountInfoGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    AccountInfoGetResponseDto response = asaasSdk.accountInfo.retrieveBusinessData();

    System.out.println(response);
  }
}

```

## updateBusinessData

- HTTP Method: `POST`
- Endpoint: `/v3/myAccount/commercialInfo/`

**Parameters**

| Name                      | Type                                                                | Required | Description  |
| :------------------------ | :------------------------------------------------------------------ | :------- | :----------- |
| accountInfoSaveRequestDto | [AccountInfoSaveRequestDto](../models/AccountInfoSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`AccountInfoGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.AccountInfoGetResponseDto;
import com.asaas.apisdk.models.AccountInfoSaveRequestCompanyType;
import com.asaas.apisdk.models.AccountInfoSaveRequestDto;
import com.asaas.apisdk.models.AccountInfoSaveRequestPersonType;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    AccountInfoSaveRequestDto accountInfoSaveRequestDto = AccountInfoSaveRequestDto.builder()
      .personType(AccountInfoSaveRequestPersonType.JURIDICA)
      .cpfCnpj("66625514000140")
      .birthDate("1995-04-12")
      .companyType(AccountInfoSaveRequestCompanyType.MEI)
      .companyName("ASAAS")
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

    AccountInfoGetResponseDto response = asaasSdk.accountInfo.updateBusinessData(accountInfoSaveRequestDto);

    System.out.println(response);
  }
}

```

## retrievePersonalizationSettings

- HTTP Method: `GET`
- Endpoint: `/v3/myAccount/paymentCheckoutConfig/`

**Return Type**

`PaymentCheckoutConfigGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentCheckoutConfigGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentCheckoutConfigGetResponseDto response = asaasSdk.accountInfo.retrievePersonalizationSettings();

    System.out.println(response);
  }
}

```

## savePaymentCheckoutPersonalization

- HTTP Method: `POST`
- Endpoint: `/v3/myAccount/paymentCheckoutConfig/`

**Parameters**

| Name                                | Type                                                                                    | Required | Description                    |
| :---------------------------------- | :-------------------------------------------------------------------------------------- | :------- | :----------------------------- |
| paymentCheckoutConfigSaveRequestDto | [PaymentCheckoutConfigSaveRequestDto](../models/PaymentCheckoutConfigSaveRequestDto.md) | ❌       | Request Body                   |
| \_filename                          | [String](../models/String.md)                                                           | ✅       | Filename for the uploaded file |

**Return Type**

`PaymentCheckoutConfigGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.PaymentCheckoutConfigGetResponseDto;
import com.asaas.apisdk.models.PaymentCheckoutConfigSaveRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    PaymentCheckoutConfigSaveRequestDto paymentCheckoutConfigSaveRequestDto =
      PaymentCheckoutConfigSaveRequestDto.builder()
        .logoBackgroundColor("#00ff00")
        .infoBackgroundColor("#000fff")
        .fontColor("#00ff0")
        .enabled(true)
        .logoFile(adipisicing)
        .build();
    PaymentCheckoutConfigSaveRequestDto paymentCheckoutConfigSaveRequestDto =
      PaymentCheckoutConfigSaveRequestDto.builder()
        .logoBackgroundColor("#00ff00")
        .infoBackgroundColor("#000fff")
        .fontColor("#00ff0")
        .enabled(true)
        .logoFile(adipisicing)
        .build();

    PaymentCheckoutConfigGetResponseDto response = asaasSdk.accountInfo.savePaymentCheckoutPersonalization(
      paymentCheckoutConfigSaveRequestDto,
      paymentCheckoutConfigSaveRequestDto
    );

    System.out.println(response);
  }
}

```

## retrieveAsaasAccountNumber

- HTTP Method: `GET`
- Endpoint: `/v3/myAccount/accountNumber`

**Return Type**

`MyAccountGetAccountNumberResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.MyAccountGetAccountNumberResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    MyAccountGetAccountNumberResponseDto response = asaasSdk.accountInfo.retrieveAsaasAccountNumber();

    System.out.println(response);
  }
}

```

## retrieveAccountFees

- HTTP Method: `GET`
- Endpoint: `/v3/myAccount/fees/`

**Return Type**

`MyAccountGetAccountFeesResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.MyAccountGetAccountFeesResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    MyAccountGetAccountFeesResponseDto response = asaasSdk.accountInfo.retrieveAccountFees();

    System.out.println(response);
  }
}

```

## checkAccountRegistrationStatus

- HTTP Method: `GET`
- Endpoint: `/v3/myAccount/status/`

**Return Type**

`MyAccountGetStatusResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.MyAccountGetStatusResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    MyAccountGetStatusResponseDto response = asaasSdk.accountInfo.checkAccountRegistrationStatus();

    System.out.println(response);
  }
}

```

## retrieveWalletid

- HTTP Method: `GET`
- Endpoint: `/v3/wallets/`

**Return Type**

`WalletShowResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.WalletShowResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    WalletShowResponseDto response = asaasSdk.accountInfo.retrieveWalletid();

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

`MyAccountDisableAccountResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.DeleteWhiteLabelSubaccountParameters;
import com.asaas.apisdk.models.MyAccountDisableAccountResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    DeleteWhiteLabelSubaccountParameters requestParameters = DeleteWhiteLabelSubaccountParameters.builder()
      .removeReason("Release data")
      .build();

    MyAccountDisableAccountResponseDto response = asaasSdk.accountInfo.deleteWhiteLabelSubaccount(requestParameters);

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
