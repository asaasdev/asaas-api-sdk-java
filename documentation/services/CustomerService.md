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

`ListCustomersOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ListCustomersOkResponse;
import com.asaas.sdk.asaasjavasdk.models.ListCustomersParameters;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ListCustomersParameters requestParameters = ListCustomersParameters.builder()
      .offset(0L)
      .limit(10L)
      .name("John Doe")
      .email("john.doe@asaas.com.br")
      .cpfCnpj("24971563792")
      .groupName("groupName")
      .externalReference("externalReference")
      .build();

    ListCustomersOkResponse response = asaasSdk.customer.listCustomers(requestParameters);

    System.out.println(response);
  }
}

```

## createNewCustomer

- HTTP Method: `POST`
- Endpoint: `/v3/customers`

**Parameters**

| Name                     | Type                                                              | Required | Description  |
| :----------------------- | :---------------------------------------------------------------- | :------- | :----------- |
| createNewCustomerRequest | [CreateNewCustomerRequest](../models/CreateNewCustomerRequest.md) | ❌       | Request Body |

**Return Type**

`ApiCustomerAccountGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerAccountGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.CreateNewCustomerRequest;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    CreateNewCustomerRequest createNewCustomerRequest = CreateNewCustomerRequest.builder()
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
      .notificationDisabled(false)
      .additionalEmails("john.doe@asaas.com,john.doe.silva@asaas.com.br")
      .municipalInscription("46683695908")
      .stateInscription("646681195275")
      .observations("great payer, no problems so far")
      .groupName("groupName")
      .company("company")
      .foreignCustomer(true)
      .build();

    ApiCustomerAccountGetResponseDto response = asaasSdk.customer.createNewCustomer(createNewCustomerRequest);

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

`ApiCustomerAccountGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerAccountGetResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    ApiCustomerAccountGetResponseDto response = asaasSdk.customer.retrieveASingleCustomer("cus_000005401844");

    System.out.println(response);
  }
}

```

## updateExistingCustomer

- HTTP Method: `PUT`
- Endpoint: `/v3/customers/{id}`

**Parameters**

| Name                          | Type                                                                        | Required | Description                                      |
| :---------------------------- | :-------------------------------------------------------------------------- | :------- | :----------------------------------------------- |
| id                            | String                                                                      | ✅       | Unique identifier of the customer to be updated. |
| updateExistingCustomerRequest | [UpdateExistingCustomerRequest](../models/UpdateExistingCustomerRequest.md) | ❌       | Request Body                                     |

**Return Type**

`ApiCustomerAccountGetResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.ApiCustomerAccountGetResponseDto;
import com.asaas.sdk.asaasjavasdk.models.UpdateExistingCustomerRequest;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    UpdateExistingCustomerRequest updateExistingCustomerRequest = UpdateExistingCustomerRequest.builder()
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

    ApiCustomerAccountGetResponseDto response = asaasSdk.customer.updateExistingCustomer(
      "cus_000005401844",
      updateExistingCustomerRequest
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

`RemoveCustomerOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.RemoveCustomerOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    RemoveCustomerOkResponse response = asaasSdk.customer.removeCustomer("cus_000005401844");

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

`RestoreRemovedCustomerOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.RestoreRemovedCustomerOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    RestoreRemovedCustomerOkResponse response = asaasSdk.customer.restoreRemovedCustomer(
      "cus_000005401844",
      new Object()
    );

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

`RetrieveNotificationsFromACustomerOkResponse`

**Example Usage Code Snippet**

```java
import com.asaas.sdk.asaasjavasdk.AsaasSdk;
import com.asaas.sdk.asaasjavasdk.config.ApiKeyAuthConfig;
import com.asaas.sdk.asaasjavasdk.config.AsaasSdkConfig;
import com.asaas.sdk.asaasjavasdk.models.RetrieveNotificationsFromACustomerOkResponse;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    RetrieveNotificationsFromACustomerOkResponse response = asaasSdk.customer.retrieveNotificationsFromACustomer(
      "cus_000005401844"
    );

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
