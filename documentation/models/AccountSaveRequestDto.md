# AccountSaveRequestDto

**Properties**

| Name          | Type                                | Required | Description                                                                    |
| :------------ | :---------------------------------- | :------- | :----------------------------------------------------------------------------- |
| name          | String                              | ✅       | Subaccount name                                                                |
| email         | String                              | ✅       | Subaccount email                                                               |
| cpfCnpj       | String                              | ✅       | CPF or CNPJ of the subaccount owner                                            |
| mobilePhone   | String                              | ✅       | Cellphone                                                                      |
| incomeValue   | Double                              | ✅       | Billing/Monthly income                                                         |
| address       | String                              | ✅       | Public place                                                                   |
| addressNumber | String                              | ✅       | Address number                                                                 |
| province      | String                              | ✅       | Neighborhood                                                                   |
| postalCode    | String                              | ✅       | Address zip code                                                               |
| loginEmail    | String                              | ❌       | Email for subaccount login, if not provided, the subaccount email will be used |
| birthDate     | String                              | ❌       | Date of birth (only for Individuals)                                           |
| companyType   | AccountSaveRequestCompanyType       | ❌       | Type of company (only when Legal Entity)                                       |
| phone         | String                              | ❌       | Telephone                                                                      |
| site          | String                              | ❌       | Url reffered to the subaccount                                                 |
| complement    | String                              | ❌       | Address complement                                                             |
| webhooks      | List\<WebhookConfigSaveRequestDto\> | ❌       | Array with desired Webhooks settings                                           |

<!-- This file was generated by liblab | https://liblab.com/ -->
