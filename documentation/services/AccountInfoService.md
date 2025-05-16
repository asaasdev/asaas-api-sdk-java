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

`RetrieveBusinessDataOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.RetrieveBusinessDataOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    RetrieveBusinessDataOkResponse response = asaasSdk.accountInfo.retrieveBusinessData();

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
| updateBusinessDataRequest | [UpdateBusinessDataRequest](../models/UpdateBusinessDataRequest.md) | ❌       | Request Body |

**Return Type**

`ApiCustomerUpdateRequestGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerUpdateRequestGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerUpdateRequestSaveRequestCompanyType;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerUpdateRequestSaveRequestPersonType;
import com.asaas.sdk.asaasjavasdk.models.UpdateBusinessDataRequest;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    UpdateBusinessDataRequest updateBusinessDataRequest = UpdateBusinessDataRequest.builder()
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
      updateBusinessDataRequest
    );

    System.out.println(response);
  }
}

```

## retrievePersonalizationSettings

- HTTP Method: `GET`
- Endpoint: `/v3/myAccount/paymentCheckoutConfig/`

**Return Type**

`RetrievePersonalizationSettingsOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.RetrievePersonalizationSettingsOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    RetrievePersonalizationSettingsOkResponse response = asaasSdk.accountInfo.retrievePersonalizationSettings();

    System.out.println(response);
  }
}

```

## savePaymentCheckoutPersonalization

- HTTP Method: `POST`
- Endpoint: `/v3/myAccount/paymentCheckoutConfig/`

**Parameters**

| Name                                      | Type                                                                                                | Required | Description  |
| :---------------------------------------- | :-------------------------------------------------------------------------------------------------- | :------- | :----------- |
| savePaymentCheckoutPersonalizationRequest | [SavePaymentCheckoutPersonalizationRequest](../models/SavePaymentCheckoutPersonalizationRequest.md) | ❌       | Request Body |

**Return Type**

`ApiPaymentCheckoutConfigGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiPaymentCheckoutConfigGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.SavePaymentCheckoutPersonalizationRequest;

public class Main {
    public static void main(String[] args) {
		AsaasSdkConfig config = AsaasSdkConfig.builder()
			.apiKeyAuthConfig(
				ApiKeyAuthConfig.builder()
					.apiKey("YOUR_API_KEY")
					.build()
			)
			.build();

		AsaasSdk asaasSdk = new AsaasSdk(config);

		SavePaymentCheckoutPersonalizationRequest savePaymentCheckoutPersonalizationRequest = SavePaymentCheckoutPersonalizationRequest.builder()
			.logoBackgroundColor("#00ff00")
			.infoBackgroundColor("#000fff")
			.fontColor("#00ff0")
			.enabled(true)
			.logoFile(magna pro)
			.build();

		ApiPaymentCheckoutConfigGetResponseDto response = asaasSdk.accountInfo.savePaymentCheckoutPersonalization(savePaymentCheckoutPersonalizationRequest);

		System.out.println(response);
    }
}
```

## retrieveAsaasAccountNumber

- HTTP Method: `GET`
- Endpoint: `/v3/myAccount/accountNumber`

**Return Type**

`RetrieveAsaasAccountNumberOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.RetrieveAsaasAccountNumberOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    RetrieveAsaasAccountNumberOkResponse response = asaasSdk.accountInfo.retrieveAsaasAccountNumber();

    System.out.println(response);
  }
}

```

## retrieveAccountFees

- HTTP Method: `GET`
- Endpoint: `/v3/myAccount/fees/`

**Return Type**

`RetrieveAccountFeesOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.RetrieveAccountFeesOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    RetrieveAccountFeesOkResponse response = asaasSdk.accountInfo.retrieveAccountFees();

    System.out.println(response);
  }
}

```

## checkAccountRegistrationStatus

- HTTP Method: `GET`
- Endpoint: `/v3/myAccount/status/`

**Return Type**

`CheckAccountRegistrationStatusOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.CheckAccountRegistrationStatusOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    CheckAccountRegistrationStatusOkResponse response = asaasSdk.accountInfo.checkAccountRegistrationStatus();

    System.out.println(response);
  }
}

```

## retrieveWalletid

- HTTP Method: `GET`
- Endpoint: `/v3/wallets/`

**Return Type**

`RetrieveWalletidOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.RetrieveWalletidOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    RetrieveWalletidOkResponse response = asaasSdk.accountInfo.retrieveWalletid();

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

`DeleteWhiteLabelSubaccountOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.DeleteWhiteLabelSubaccountOkResponse;
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

    DeleteWhiteLabelSubaccountOkResponse response = asaasSdk.accountInfo.deleteWhiteLabelSubaccount(requestParameters);

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
