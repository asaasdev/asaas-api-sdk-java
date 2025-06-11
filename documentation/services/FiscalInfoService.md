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

`ApiCustomerFiscalInfoMunicipalOptionsGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ApiCustomerFiscalInfoMunicipalOptionsGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiCustomerFiscalInfoMunicipalOptionsGetResponseDto response = asaasSdk.fiscalInfo.listMunicipalConfigurations();

    System.out.println(response);
  }
}

```

## retrieveTaxInformation

- HTTP Method: `GET`
- Endpoint: `/v3/fiscalInfo/`

**Return Type**

`ApiCustomerFiscalInfoGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ApiCustomerFiscalInfoGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiCustomerFiscalInfoGetResponseDto response = asaasSdk.fiscalInfo.retrieveTaxInformation();

    System.out.println(response);
  }
}

```

## createAndUpdateTaxInformation

- HTTP Method: `POST`
- Endpoint: `/v3/fiscalInfo/`

**Parameters**

| Name                                | Type                                                                                    | Required | Description                    |
| :---------------------------------- | :-------------------------------------------------------------------------------------- | :------- | :----------------------------- |
| apiCustomerFiscalInfoSaveRequestDto | [ApiCustomerFiscalInfoSaveRequestDto](../models/ApiCustomerFiscalInfoSaveRequestDto.md) | ❌       | Request Body                   |
| \_filename                          | [String](../models/String.md)                                                           | ✅       | Filename for the uploaded file |

**Return Type**

`ApiCustomerFiscalInfoGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ApiCustomerFiscalInfoGetResponseDto;
import com.asaas.apisdk.models.ApiCustomerFiscalInfoSaveRequestDto;

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

		ApiCustomerFiscalInfoSaveRequestDto apiCustomerFiscalInfoSaveRequestDto = ApiCustomerFiscalInfoSaveRequestDto.builder()
			.email("john.doe@asaas.com.br")
			.municipalInscription("21779501")
			.simplesNacional(false)
			.culturalProjectsPromoter(false)
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
			.certificateFile(nostrud sit in)
			.certificatePassword("certificatePassword")
			.nationalPortalTaxCalculationRegime("nationalPortalTaxCalculationRegime")
			.build();
		ApiCustomerFiscalInfoSaveRequestDto apiCustomerFiscalInfoSaveRequestDto = ApiCustomerFiscalInfoSaveRequestDto.builder()
			.email("john.doe@asaas.com.br")
			.municipalInscription("21779501")
			.simplesNacional(false)
			.culturalProjectsPromoter(false)
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
			.certificateFile(nostrud sit in)
			.certificatePassword("certificatePassword")
			.nationalPortalTaxCalculationRegime("nationalPortalTaxCalculationRegime")
			.build();

		ApiCustomerFiscalInfoGetResponseDto response = asaasSdk.fiscalInfo.createAndUpdateTaxInformation(apiCustomerFiscalInfoSaveRequestDto, apiCustomerFiscalInfoSaveRequestDto);

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

`ApiCustomerFiscalInfoListMunicipalServicesResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ApiCustomerFiscalInfoListMunicipalServicesResponseDto;
import com.asaas.apisdk.models.ListMunicipalServicesParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListMunicipalServicesParameters requestParameters = ListMunicipalServicesParameters.builder()
      .offset(8L)
      .limit(10L)
      .description("1.01")
      .build();

    ApiCustomerFiscalInfoListMunicipalServicesResponseDto response = asaasSdk.fiscalInfo.listMunicipalServices(
      requestParameters
    );

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

`ApiCustomerFiscalInfoListInvoiceNbsCodesResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ApiCustomerFiscalInfoListInvoiceNbsCodesResponseDto;
import com.asaas.apisdk.models.ListNbsCodesParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListNbsCodesParameters requestParameters = ListNbsCodesParameters.builder()
      .offset(6L)
      .limit(10L)
      .codeDescription("1.0101")
      .build();

    ApiCustomerFiscalInfoListInvoiceNbsCodesResponseDto response = asaasSdk.fiscalInfo.listNbsCodes(requestParameters);

    System.out.println(response);
  }
}

```

## configureInvoiceIssuingPortal

Here you can enable or disable the use of the national portal as an invoice issuer.

- HTTP Method: `POST`
- Endpoint: `/v3/fiscalInfo/nationalPortal`

**Parameters**

| Name                                                   | Type                                                                                                                          | Required | Description  |
| :----------------------------------------------------- | :---------------------------------------------------------------------------------------------------------------------------- | :------- | :----------- |
| apiCustomerFiscalInfoUpdateUseNationalPortalRequestDto | [ApiCustomerFiscalInfoUpdateUseNationalPortalRequestDto](../models/ApiCustomerFiscalInfoUpdateUseNationalPortalRequestDto.md) | ❌       | Request Body |

**Return Type**

`ApiCustomerFiscalInfoUpdateUseNationalPortalResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.ApiCustomerFiscalInfoUpdateUseNationalPortalRequestDto;
import com.asaas.apisdk.models.ApiCustomerFiscalInfoUpdateUseNationalPortalResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiCustomerFiscalInfoUpdateUseNationalPortalRequestDto apiCustomerFiscalInfoUpdateUseNationalPortalRequestDto =
      ApiCustomerFiscalInfoUpdateUseNationalPortalRequestDto.builder().enabled(true).build();

    ApiCustomerFiscalInfoUpdateUseNationalPortalResponseDto response =
      asaasSdk.fiscalInfo.configureInvoiceIssuingPortal(apiCustomerFiscalInfoUpdateUseNationalPortalRequestDto);

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
