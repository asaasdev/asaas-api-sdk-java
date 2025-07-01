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

`FiscalInfoMunicipalOptionsGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.FiscalInfoMunicipalOptionsGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    FiscalInfoMunicipalOptionsGetResponseDto response = asaasSdk.fiscalInfo.listMunicipalConfigurations();

    System.out.println(response);
  }
}

```

## retrieveTaxInformation

- HTTP Method: `GET`
- Endpoint: `/v3/fiscalInfo/`

**Return Type**

`FiscalInfoGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.FiscalInfoGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    FiscalInfoGetResponseDto response = asaasSdk.fiscalInfo.retrieveTaxInformation();

    System.out.println(response);
  }
}

```

## createAndUpdateTaxInformation

- HTTP Method: `POST`
- Endpoint: `/v3/fiscalInfo/`

**Parameters**

| Name                     | Type                                                              | Required | Description                    |
| :----------------------- | :---------------------------------------------------------------- | :------- | :----------------------------- |
| fiscalInfoSaveRequestDto | [FiscalInfoSaveRequestDto](../models/FiscalInfoSaveRequestDto.md) | ❌       | Request Body                   |
| \_filename               | [String](../models/String.md)                                     | ✅       | Filename for the uploaded file |

**Return Type**

`FiscalInfoGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.FiscalInfoGetResponseDto;
import com.asaas.apisdk.models.FiscalInfoSaveRequestDto;

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

		FiscalInfoSaveRequestDto fiscalInfoSaveRequestDto = FiscalInfoSaveRequestDto.builder()
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
			.certificateFile(enim ut cupid)
			.certificatePassword("certificatePassword")
			.nationalPortalTaxCalculationRegime("nationalPortalTaxCalculationRegime")
			.build();
		FiscalInfoSaveRequestDto fiscalInfoSaveRequestDto = FiscalInfoSaveRequestDto.builder()
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
			.certificateFile(enim ut cupid)
			.certificatePassword("certificatePassword")
			.nationalPortalTaxCalculationRegime("nationalPortalTaxCalculationRegime")
			.build();

		FiscalInfoGetResponseDto response = asaasSdk.fiscalInfo.createAndUpdateTaxInformation(fiscalInfoSaveRequestDto, fiscalInfoSaveRequestDto);

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

`FiscalInfoListMunicipalServicesResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.FiscalInfoListMunicipalServicesResponseDto;
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

    FiscalInfoListMunicipalServicesResponseDto response = asaasSdk.fiscalInfo.listMunicipalServices(requestParameters);

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

`FiscalInfoListInvoiceNbsCodesResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.FiscalInfoListInvoiceNbsCodesResponseDto;
import com.asaas.apisdk.models.ListNbsCodesParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListNbsCodesParameters requestParameters = ListNbsCodesParameters.builder()
      .offset(5L)
      .limit(10L)
      .codeDescription("1.0101")
      .build();

    FiscalInfoListInvoiceNbsCodesResponseDto response = asaasSdk.fiscalInfo.listNbsCodes(requestParameters);

    System.out.println(response);
  }
}

```

## configureInvoiceIssuingPortal

Here you can enable or disable the use of the national portal as an invoice issuer.

- HTTP Method: `POST`
- Endpoint: `/v3/fiscalInfo/nationalPortal`

**Parameters**

| Name                                        | Type                                                                                                    | Required | Description  |
| :------------------------------------------ | :------------------------------------------------------------------------------------------------------ | :------- | :----------- |
| fiscalInfoUpdateUseNationalPortalRequestDto | [FiscalInfoUpdateUseNationalPortalRequestDto](../models/FiscalInfoUpdateUseNationalPortalRequestDto.md) | ❌       | Request Body |

**Return Type**

`FiscalInfoUpdateUseNationalPortalResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.FiscalInfoUpdateUseNationalPortalRequestDto;
import com.asaas.apisdk.models.FiscalInfoUpdateUseNationalPortalResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    FiscalInfoUpdateUseNationalPortalRequestDto fiscalInfoUpdateUseNationalPortalRequestDto =
      FiscalInfoUpdateUseNationalPortalRequestDto.builder().enabled(true).build();

    FiscalInfoUpdateUseNationalPortalResponseDto response = asaasSdk.fiscalInfo.configureInvoiceIssuingPortal(
      fiscalInfoUpdateUseNationalPortalRequestDto
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
