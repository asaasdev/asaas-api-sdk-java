# AccountDocumentGroupResponseDto

List of objects

**Properties**

| Name                        | Type                                              | Required | Description                                                             |
| :-------------------------- | :------------------------------------------------ | :------- | :---------------------------------------------------------------------- |
| id                          | String                                            | ❌       | Unique document group identifier in Asaas                               |
| status                      | AccountDocumentGroupResponseAccountDocumentStatus | ❌       | Document group status                                                   |
| type                        | AccountDocumentGroupResponseAccountDocumentType   | ❌       | Type of documents                                                       |
| title                       | String                                            | ❌       | Document group title                                                    |
| description                 | String                                            | ❌       | Description                                                             |
| responsible                 | AccountDocumentResponsibleResponseDto             | ❌       | Who is responsible for sending these documents                          |
| onboardingUrl               | String                                            | ❌       | URL for sending documents                                               |
| onboardingUrlExpirationDate | String                                            | ❌       | Expiration date of the URL for sending documents                        |
| documents                   | List\<AccountDocumentGetResponseDto\>             | ❌       | Documents that have already been sent with their respective identifiers |

<!-- This file was generated by liblab | https://liblab.com/ -->
