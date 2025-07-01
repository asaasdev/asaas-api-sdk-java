# CustomerService

A list of all methods in the `CustomerService` service. Click on the method name to view detailed information about that method.

| Methods                                                                   | Description |
| :------------------------------------------------------------------------ | :---------- |
| [listCustomers](#listcustomers)                                           |             |
| [createNewCustomer](#createnewcustomer)                                   |             |
| [retrieveASingleCustomer](#retrieveasinglecustomer)                       |             |
| [updateExistingCustomer](#updateexistingcustomer)                         |             |
| [removeCustomer](#removecustomer)                                         |             |
| [restoreRemovedCustomer](#restoreremovedcustomer)                         |             |
| [retrieveNotificationsFromACustomer](#retrievenotificationsfromacustomer) |             |

## listCustomers

- HTTP Method: `GET`
- Endpoint: `/v3/customers`

**Parameters**

| Name              | Type                                                            | Required | Description               |
| :---------------- | :-------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [ListCustomersParameters](../models/ListCustomersParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`CustomerListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.CustomerListResponseDto;
import com.asaas.apisdk.models.ListCustomersParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListCustomersParameters requestParameters = ListCustomersParameters.builder()
      .offset(10L)
      .limit(10L)
      .name("John Doe")
      .email("john.doe@asaas.com.br")
      .cpfCnpj("24971563792")
      .groupName("groupName")
      .externalReference("externalReference")
      .build();

    CustomerListResponseDto response = asaasSdk.customer.listCustomers(requestParameters);

    System.out.println(response);
  }
}

```

## createNewCustomer

- HTTP Method: `POST`
- Endpoint: `/v3/customers`

**Parameters**

| Name                   | Type                                                          | Required | Description  |
| :--------------------- | :------------------------------------------------------------ | :------- | :----------- |
| customerSaveRequestDto | [CustomerSaveRequestDto](../models/CustomerSaveRequestDto.md) | ❌       | Request Body |

**Return Type**

`CustomerGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.CustomerGetResponseDto;
import com.asaas.apisdk.models.CustomerSaveRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    CustomerSaveRequestDto customerSaveRequestDto = CustomerSaveRequestDto.builder()
      .name("John Doe")
      .cpfCnpj("24971563792")
      .email("john.doe@asaas.com.br")
      .phone("4738010919")
      .mobilePhone("4799376637")
      .address("Av. Paulista")
      .addressNumber("150")
      .complement("Sala 201")
      .province("Centro")
      .postalCode("01310-000")
      .externalReference("12987382")
      .notificationDisabled(true)
      .additionalEmails("john.doe@asaas.com,john.doe.silva@asaas.com.br")
      .municipalInscription("46683695908")
      .stateInscription("646681195275")
      .observations("great payer, no problems so far")
      .groupName("groupName")
      .company("company")
      .foreignCustomer(false)
      .build();

    CustomerGetResponseDto response = asaasSdk.customer.createNewCustomer(customerSaveRequestDto);

    System.out.println(response);
  }
}

```

## retrieveASingleCustomer

- HTTP Method: `GET`
- Endpoint: `/v3/customers/{id}`

**Parameters**

| Name | Type   | Required | Description                         |
| :--- | :----- | :------- | :---------------------------------- |
| id   | String | ✅       | Unique customer identifier in Asaas |

**Return Type**

`CustomerGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.CustomerGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    CustomerGetResponseDto response = asaasSdk.customer.retrieveASingleCustomer("cus_000005401844");

    System.out.println(response);
  }
}

```

## updateExistingCustomer

- HTTP Method: `PUT`
- Endpoint: `/v3/customers/{id}`

**Parameters**

| Name                     | Type                                                              | Required | Description                                      |
| :----------------------- | :---------------------------------------------------------------- | :------- | :----------------------------------------------- |
| id                       | String                                                            | ✅       | Unique identifier of the customer to be updated. |
| customerUpdateRequestDto | [CustomerUpdateRequestDto](../models/CustomerUpdateRequestDto.md) | ❌       | Request Body                                     |

**Return Type**

`CustomerGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.CustomerGetResponseDto;
import com.asaas.apisdk.models.CustomerUpdateRequestDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    CustomerUpdateRequestDto customerUpdateRequestDto = CustomerUpdateRequestDto.builder()
      .name("John Doe")
      .cpfCnpj("24971563792")
      .email("john.doe@asaas.com.br")
      .phone("4738010919")
      .mobilePhone("4799376637")
      .address("Av. Paulista")
      .addressNumber("150")
      .complement("Sala 201")
      .province("Centro")
      .postalCode("01310-000")
      .externalReference("12987382")
      .notificationDisabled(true)
      .additionalEmails("john.doe@asaas.com,john.doe.silva@asaas.com.br")
      .municipalInscription("46683695908")
      .stateInscription("646681195275")
      .observations("great payer, no problems so far")
      .groupName("groupName")
      .company("company")
      .foreignCustomer(true)
      .build();

    CustomerGetResponseDto response = asaasSdk.customer.updateExistingCustomer(
      "cus_000005401844",
      customerUpdateRequestDto
    );

    System.out.println(response);
  }
}

```

## removeCustomer

- HTTP Method: `DELETE`
- Endpoint: `/v3/customers/{id}`

**Parameters**

| Name | Type   | Required | Description                                     |
| :--- | :----- | :------- | :---------------------------------------------- |
| id   | String | ✅       | Unique identifier of the customer to be removed |

**Return Type**

`CustomerDeleteResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.CustomerDeleteResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    CustomerDeleteResponseDto response = asaasSdk.customer.removeCustomer("cus_000005401844");

    System.out.println(response);
  }
}

```

## restoreRemovedCustomer

- HTTP Method: `POST`
- Endpoint: `/v3/customers/{id}/restore`

**Parameters**

| Name  | Type   | Required | Description                                     |
| :---- | :----- | :------- | :---------------------------------------------- |
| id    | String | ✅       | Unique identifier of the client to be restored. |
| input | Object | ❌       | Request Body                                    |

**Return Type**

`CustomerGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.CustomerGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    CustomerGetResponseDto response = asaasSdk.customer.restoreRemovedCustomer("cus_000005401844", new Object());

    System.out.println(response);
  }
}

```

## retrieveNotificationsFromACustomer

- HTTP Method: `GET`
- Endpoint: `/v3/customers/{id}/notifications`

**Parameters**

| Name | Type   | Required | Description                         |
| :--- | :----- | :------- | :---------------------------------- |
| id   | String | ✅       | Unique customer identifier in Asaas |

**Return Type**

`NotificationListResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.NotificationListResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    NotificationListResponseDto response = asaasSdk.customer.retrieveNotificationsFromACustomer("cus_000005401844");

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
