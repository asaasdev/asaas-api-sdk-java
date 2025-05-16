# FiscalInfoService

A list of all methods in the `FiscalInfoService` service. Click on the method name to view detailed information about that method.

| Methods                                                         | Description                                                                         |
| :-------------------------------------------------------------- | :---------------------------------------------------------------------------------- |
| [listMunicipalConfigurations](#listmunicipalconfigurations)     |                                                                                     |
| [retrieveTaxInformation](#retrievetaxinformation)               |                                                                                     |
| [createAndUpdateTaxInformation](#createandupdatetaxinformation) |                                                                                     |
| [listMunicipalServices](#listmunicipalservices)                 |                                                                                     |
| [listNbsCodes](#listnbscodes)                                   | List of possible NBS Codes (Brazilian Nomenclature of Services)                     |
| [configureInvoiceIssuingPortal](#configureinvoiceissuingportal) | Here you can enable or disable the use of the national portal as an invoice issuer. |

## listMunicipalConfigurations

- HTTP Method: `GET`
- Endpoint: `/v3/fiscalInfo/municipalOptions`

**Return Type**

`ListMunicipalConfigurationsOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ListMunicipalConfigurationsOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListMunicipalConfigurationsOkResponse response = asaasSdk.fiscalInfo.listMunicipalConfigurations();

    System.out.println(response);
  }
}

```

## retrieveTaxInformation

- HTTP Method: `GET`
- Endpoint: `/v3/fiscalInfo/`

**Return Type**

`RetrieveTaxInformationOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.RetrieveTaxInformationOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    RetrieveTaxInformationOkResponse response = asaasSdk.fiscalInfo.retrieveTaxInformation();

    System.out.println(response);
  }
}

```

## createAndUpdateTaxInformation

- HTTP Method: `POST`
- Endpoint: `/v3/fiscalInfo/`

**Parameters**

| Name                                 | Type                                                                                      | Required | Description  |
| :----------------------------------- | :---------------------------------------------------------------------------------------- | :------- | :----------- |
| createAndUpdateTaxInformationRequest | [CreateAndUpdateTaxInformationRequest](../models/CreateAndUpdateTaxInformationRequest.md) | ❌       | Request Body |

**Return Type**

`ApiCustomerFiscalInfoGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerFiscalInfoGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.CreateAndUpdateTaxInformationRequest;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    CreateAndUpdateTaxInformationRequest createAndUpdateTaxInformationRequest =
      CreateAndUpdateTaxInformationRequest.builder()
        .email("john.doe@asaas.com.br")
        .municipalInscription("21779501")
        .simplesNacional(false)
        .culturalProjectsPromoter(true)
        .cnae("6209100")
        .specialTaxRegime("1")
        .serviceListItem("serviceListItem")
        .nbsCode("1.0101")
        .rpsSerie("1")
        .rpsNumber(1L)
        .loteNumber(1L)
        .username("johndoe")
        .password("password")
        .accessToken("accessToken")
        .certificateFile(aliquip)
        .certificatePassword("certificatePassword")
        .nationalPortalTaxCalculationRegime("nationalPortalTaxCalculationRegime")
        .build();

    ApiCustomerFiscalInfoGetResponseDto response = asaasSdk.fiscalInfo.createAndUpdateTaxInformation(
      createAndUpdateTaxInformationRequest
    );

    System.out.println(response);
  }
}

```

## listMunicipalServices

- HTTP Method: `GET`
- Endpoint: `/v3/fiscalInfo/services`

**Parameters**

| Name              | Type                                                                            | Required | Description               |
| :---------------- | :------------------------------------------------------------------------------ | :------- | :------------------------ |
| requestParameters | [ListMunicipalServicesParameters](../models/ListMunicipalServicesParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ListMunicipalServicesOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ListMunicipalServicesOkResponse;
import com.asaas.sdk.asaasjavasdk.models.ListMunicipalServicesParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListMunicipalServicesParameters requestParameters = ListMunicipalServicesParameters.builder()
      .offset(0L)
      .limit(10L)
      .description("1.01")
      .build();

    ListMunicipalServicesOkResponse response = asaasSdk.fiscalInfo.listMunicipalServices(requestParameters);

    System.out.println(response);
  }
}

```

## listNbsCodes

List of possible NBS Codes (Brazilian Nomenclature of Services)

- HTTP Method: `GET`
- Endpoint: `/v3/fiscalInfo/nbsCodes`

**Parameters**

| Name              | Type                                                          | Required | Description               |
| :---------------- | :------------------------------------------------------------ | :------- | :------------------------ |
| requestParameters | [ListNbsCodesParameters](../models/ListNbsCodesParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`ListNbsCodesOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ListNbsCodesOkResponse;
import com.asaas.sdk.asaasjavasdk.models.ListNbsCodesParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListNbsCodesParameters requestParameters = ListNbsCodesParameters.builder()
      .offset(4L)
      .limit(10L)
      .codeDescription("1.0101")
      .build();

    ListNbsCodesOkResponse response = asaasSdk.fiscalInfo.listNbsCodes(requestParameters);

    System.out.println(response);
  }
}

```

## configureInvoiceIssuingPortal

Here you can enable or disable the use of the national portal as an invoice issuer.

- HTTP Method: `POST`
- Endpoint: `/v3/fiscalInfo/nationalPortal`

**Parameters**

| Name                                 | Type                                                                                      | Required | Description  |
| :----------------------------------- | :---------------------------------------------------------------------------------------- | :------- | :----------- |
| configureInvoiceIssuingPortalRequest | [ConfigureInvoiceIssuingPortalRequest](../models/ConfigureInvoiceIssuingPortalRequest.md) | ❌       | Request Body |

**Return Type**

`ConfigureInvoiceIssuingPortalOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ConfigureInvoiceIssuingPortalOkResponse;
import com.asaas.sdk.asaasjavasdk.models.ConfigureInvoiceIssuingPortalRequest;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ConfigureInvoiceIssuingPortalRequest configureInvoiceIssuingPortalRequest =
      ConfigureInvoiceIssuingPortalRequest.builder().enabled(true).build();

    ConfigureInvoiceIssuingPortalOkResponse response = asaasSdk.fiscalInfo.configureInvoiceIssuingPortal(
      configureInvoiceIssuingPortalRequest
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
