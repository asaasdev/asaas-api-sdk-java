# FinanceService

A list of all methods in the `FinanceService` service. Click on the method name to view detailed information about that method.

| Methods                                           | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| :------------------------------------------------ | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [retrieveAccountBalance](#retrieveaccountbalance) |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |
| [billingStatistics](#billingstatistics)           | Return total values of charges from your Asaas account according to the provided filters. ### Examples of filters: Total amount to receive: `GET https://api.asaas.com/v3/finance/payment/statistics?status=PENDING` Total amount to receive with charges by bank slip: `GET https://api.asaas.com/v3/finance/payment/statistics?billingType=BOLETO&status=PENDING` Total amount received for charges by credit card: `GET https://api.asaas.com/v3/finance/payment/statistics?billingType=CREDIT_CARD&status=RECEIVED` |
| [retrieveSplitValues](#retrievesplitvalues)       |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |

## retrieveAccountBalance

- HTTP Method: `GET`
- Endpoint: `/v3/finance/balance`

**Return Type**

`FinanceBalanceResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.FinanceBalanceResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    FinanceBalanceResponseDto response = asaasSdk.finance.retrieveAccountBalance();

    System.out.println(response);
  }
}

```

## billingStatistics

Return total values of charges from your Asaas account according to the provided filters. ### Examples of filters: Total amount to receive: `GET https://api.asaas.com/v3/finance/payment/statistics?status=PENDING` Total amount to receive with charges by bank slip: `GET https://api.asaas.com/v3/finance/payment/statistics?billingType=BOLETO&status=PENDING` Total amount received for charges by credit card: `GET https://api.asaas.com/v3/finance/payment/statistics?billingType=CREDIT_CARD&status=RECEIVED`

- HTTP Method: `GET`
- Endpoint: `/v3/finance/payment/statistics`

**Parameters**

| Name              | Type                                                                    | Required | Description               |
| :---------------- | :---------------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [BillingStatisticsParameters](../models/BillingStatisticsParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`FinanceGetPaymentStatisticsResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.BillingStatisticsParameters;
import com.asaas.apisdk.models.FinanceGetPaymentStatisticsRequestBillingType;
import com.asaas.apisdk.models.FinanceGetPaymentStatisticsRequestPaymentStatus;
import com.asaas.apisdk.models.FinanceGetPaymentStatisticsResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    BillingStatisticsParameters requestParameters = BillingStatisticsParameters.builder()
      .customer("cus_3EZfkUThUMAt")
      .billingType(FinanceGetPaymentStatisticsRequestBillingType.BOLETO)
      .status(FinanceGetPaymentStatisticsRequestPaymentStatus.PENDING)
      .anticipated(false)
      .dateCreatedGe("2023-01-01")
      .dateCreatedLe("2023-01-01")
      .dueDateGe("2023-01-01")
      .dueDateLe("2023-01-01")
      .estimatedCreditDateGe("2023-01-01")
      .estimatedCreditDateLe("2023-01-01")
      .externalReference("056984")
      .build();

    FinanceGetPaymentStatisticsResponseDto response = asaasSdk.finance.billingStatistics(requestParameters);

    System.out.println(response);
  }
}

```

## retrieveSplitValues

- HTTP Method: `GET`
- Endpoint: `/v3/finance/split/statistics`

**Return Type**

`FinanceGetSplitStatisticsResponseDto`

**Example Usage Code Snippet**

```java
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.models.FinanceGetSplitStatisticsResponseDto;

public class Main {

  public static void main(String[] args) {
    AsaasSdkConfig config = AsaasSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    AsaasSdk asaasSdk = new AsaasSdk(config);

    FinanceGetSplitStatisticsResponseDto response = asaasSdk.finance.retrieveSplitValues();

    System.out.println(response);
  }
}

```

<!-- This file was generated by liblab | https://liblab.com/ -->
