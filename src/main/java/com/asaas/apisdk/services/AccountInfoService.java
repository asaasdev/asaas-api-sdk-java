// This file was generated by liblab | https://liblab.com/

package com.asaas.apisdk.services;

import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.exceptions.ApiError;
import com.asaas.apisdk.exceptions.ErrorResponseDtoException;
import com.asaas.apisdk.http.Environment;
import com.asaas.apisdk.http.HttpMethod;
import com.asaas.apisdk.http.ModelConverter;
import com.asaas.apisdk.http.util.RequestBuilder;
import com.asaas.apisdk.models.AccountInfoGetResponseDto;
import com.asaas.apisdk.models.AccountInfoSaveRequestDto;
import com.asaas.apisdk.models.DeleteWhiteLabelSubaccountParameters;
import com.asaas.apisdk.models.ErrorResponseDto;
import com.asaas.apisdk.models.MyAccountDisableAccountResponseDto;
import com.asaas.apisdk.models.MyAccountGetAccountFeesResponseDto;
import com.asaas.apisdk.models.MyAccountGetAccountNumberResponseDto;
import com.asaas.apisdk.models.MyAccountGetStatusResponseDto;
import com.asaas.apisdk.models.PaymentCheckoutConfigGetResponseDto;
import com.asaas.apisdk.models.PaymentCheckoutConfigSaveRequestDto;
import com.asaas.apisdk.models.WalletShowResponseDto;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * AccountInfoService Service
 */
public class AccountInfoService extends BaseService {

  public AccountInfoService(@NonNull OkHttpClient httpClient, AsaasSdkConfig config) {
    super(httpClient, config);
  }

  /**
   * Retrieve business data
   *
   * @return response of {@code AccountInfoGetResponseDto}
   */
  public AccountInfoGetResponseDto retrieveBusinessData() throws ApiError {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request = this.buildRetrieveBusinessDataRequest();
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<AccountInfoGetResponseDto>() {});
  }

  /**
   * Retrieve business data
   *
   * @return response of {@code CompletableFuture<AccountInfoGetResponseDto>}
   */
  public CompletableFuture<AccountInfoGetResponseDto> retrieveBusinessDataAsync() throws ApiError {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request = this.buildRetrieveBusinessDataRequest();
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<AccountInfoGetResponseDto>() {})
    );
  }

  private Request buildRetrieveBusinessDataRequest() {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v3/myAccount/commercialInfo/"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .build();
  }

  /**
   * Update business data
   *
   * @return response of {@code AccountInfoGetResponseDto}
   */
  public AccountInfoGetResponseDto updateBusinessData() throws ApiError {
    return this.updateBusinessData(AccountInfoSaveRequestDto.builder().build());
  }

  /**
   * Update business data
   *
   * @param accountInfoSaveRequestDto {@link AccountInfoSaveRequestDto} Request Body
   * @return response of {@code AccountInfoGetResponseDto}
   */
  public AccountInfoGetResponseDto updateBusinessData(@NonNull AccountInfoSaveRequestDto accountInfoSaveRequestDto)
    throws ApiError {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request = this.buildUpdateBusinessDataRequest(accountInfoSaveRequestDto);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<AccountInfoGetResponseDto>() {});
  }

  /**
   * Update business data
   *
   * @return response of {@code CompletableFuture<AccountInfoGetResponseDto>}
   */
  public CompletableFuture<AccountInfoGetResponseDto> updateBusinessDataAsync() throws ApiError {
    return this.updateBusinessDataAsync(AccountInfoSaveRequestDto.builder().build());
  }

  /**
   * Update business data
   *
   * @param accountInfoSaveRequestDto {@link AccountInfoSaveRequestDto} Request Body
   * @return response of {@code CompletableFuture<AccountInfoGetResponseDto>}
   */
  public CompletableFuture<AccountInfoGetResponseDto> updateBusinessDataAsync(
    @NonNull AccountInfoSaveRequestDto accountInfoSaveRequestDto
  ) throws ApiError {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request = this.buildUpdateBusinessDataRequest(accountInfoSaveRequestDto);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<AccountInfoGetResponseDto>() {})
    );
  }

  private Request buildUpdateBusinessDataRequest(@NonNull AccountInfoSaveRequestDto accountInfoSaveRequestDto) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v3/myAccount/commercialInfo/"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setJsonContent(accountInfoSaveRequestDto)
      .build();
  }

  /**
   * Retrieve personalization settings
   *
   * @return response of {@code PaymentCheckoutConfigGetResponseDto}
   */
  public PaymentCheckoutConfigGetResponseDto retrievePersonalizationSettings() throws ApiError {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request = this.buildRetrievePersonalizationSettingsRequest();
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<PaymentCheckoutConfigGetResponseDto>() {});
  }

  /**
   * Retrieve personalization settings
   *
   * @return response of {@code CompletableFuture<PaymentCheckoutConfigGetResponseDto>}
   */
  public CompletableFuture<PaymentCheckoutConfigGetResponseDto> retrievePersonalizationSettingsAsync() throws ApiError {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request = this.buildRetrievePersonalizationSettingsRequest();
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<PaymentCheckoutConfigGetResponseDto>() {})
    );
  }

  private Request buildRetrievePersonalizationSettingsRequest() {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v3/myAccount/paymentCheckoutConfig/"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .build();
  }

  /**
   * Save payment checkout customization
   *
   * @param paymentCheckoutConfigSaveRequestDto {@link PaymentCheckoutConfigSaveRequestDto} Request Body
   * @param _filename String Filename for the uploaded file
   * @return response of {@code PaymentCheckoutConfigGetResponseDto}
   */
  public PaymentCheckoutConfigGetResponseDto savePaymentCheckoutPersonalization(
    @NonNull PaymentCheckoutConfigSaveRequestDto paymentCheckoutConfigSaveRequestDto,
    @NonNull String _filename
  ) throws ApiError {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request =
      this.buildSavePaymentCheckoutPersonalizationRequest(paymentCheckoutConfigSaveRequestDto, _filename);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<PaymentCheckoutConfigGetResponseDto>() {});
  }

  /**
   * Save payment checkout customization
   *
   * @param paymentCheckoutConfigSaveRequestDto {@link PaymentCheckoutConfigSaveRequestDto} Request Body
   * @param _filename String Filename for the uploaded file
   * @return response of {@code CompletableFuture<PaymentCheckoutConfigGetResponseDto>}
   */
  public CompletableFuture<PaymentCheckoutConfigGetResponseDto> savePaymentCheckoutPersonalizationAsync(
    @NonNull PaymentCheckoutConfigSaveRequestDto paymentCheckoutConfigSaveRequestDto,
    @NonNull String _filename
  ) throws ApiError {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request =
      this.buildSavePaymentCheckoutPersonalizationRequest(paymentCheckoutConfigSaveRequestDto, _filename);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<PaymentCheckoutConfigGetResponseDto>() {})
    );
  }

  private Request buildSavePaymentCheckoutPersonalizationRequest(
    @NonNull PaymentCheckoutConfigSaveRequestDto paymentCheckoutConfigSaveRequestDto,
    @NonNull String _filename
  ) {
    MultipartBody.Builder multipartBodyBuilder = new MultipartBody.Builder()
      .setType(MultipartBody.FORM)
      .addFormDataPart("logoBackgroundColor", paymentCheckoutConfigSaveRequestDto.getLogoBackgroundColor())
      .addFormDataPart("infoBackgroundColor", paymentCheckoutConfigSaveRequestDto.getInfoBackgroundColor())
      .addFormDataPart("fontColor", paymentCheckoutConfigSaveRequestDto.getFontColor());
    if (paymentCheckoutConfigSaveRequestDto.getEnabled() != null) {
      multipartBodyBuilder.addFormDataPart("enabled", paymentCheckoutConfigSaveRequestDto.getEnabled().toString());
    }
    if (paymentCheckoutConfigSaveRequestDto.getLogoFile() != null) {
      multipartBodyBuilder.addFormDataPart(
        "logoFile",
        _filename,
        RequestBody.create(
          paymentCheckoutConfigSaveRequestDto.getLogoFile(),
          MediaType.parse("application/octet-stream")
        )
      );
    }
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v3/myAccount/paymentCheckoutConfig/"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setBody(multipartBodyBuilder.build())
      .build();
  }

  /**
   * Retrieve Asaas account number
   *
   * @return response of {@code MyAccountGetAccountNumberResponseDto}
   */
  public MyAccountGetAccountNumberResponseDto retrieveAsaasAccountNumber() throws ApiError {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request = this.buildRetrieveAsaasAccountNumberRequest();
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<MyAccountGetAccountNumberResponseDto>() {});
  }

  /**
   * Retrieve Asaas account number
   *
   * @return response of {@code CompletableFuture<MyAccountGetAccountNumberResponseDto>}
   */
  public CompletableFuture<MyAccountGetAccountNumberResponseDto> retrieveAsaasAccountNumberAsync() throws ApiError {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request = this.buildRetrieveAsaasAccountNumberRequest();
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<MyAccountGetAccountNumberResponseDto>() {})
    );
  }

  private Request buildRetrieveAsaasAccountNumberRequest() {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v3/myAccount/accountNumber"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .build();
  }

  /**
   * Retrieve account fees
   *
   * @return response of {@code MyAccountGetAccountFeesResponseDto}
   */
  public MyAccountGetAccountFeesResponseDto retrieveAccountFees() throws ApiError {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request = this.buildRetrieveAccountFeesRequest();
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<MyAccountGetAccountFeesResponseDto>() {});
  }

  /**
   * Retrieve account fees
   *
   * @return response of {@code CompletableFuture<MyAccountGetAccountFeesResponseDto>}
   */
  public CompletableFuture<MyAccountGetAccountFeesResponseDto> retrieveAccountFeesAsync() throws ApiError {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request = this.buildRetrieveAccountFeesRequest();
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<MyAccountGetAccountFeesResponseDto>() {})
    );
  }

  private Request buildRetrieveAccountFeesRequest() {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v3/myAccount/fees/"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .build();
  }

  /**
   * Check account registration status
   *
   * @return response of {@code MyAccountGetStatusResponseDto}
   */
  public MyAccountGetStatusResponseDto checkAccountRegistrationStatus() throws ApiError {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request = this.buildCheckAccountRegistrationStatusRequest();
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<MyAccountGetStatusResponseDto>() {});
  }

  /**
   * Check account registration status
   *
   * @return response of {@code CompletableFuture<MyAccountGetStatusResponseDto>}
   */
  public CompletableFuture<MyAccountGetStatusResponseDto> checkAccountRegistrationStatusAsync() throws ApiError {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request = this.buildCheckAccountRegistrationStatusRequest();
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<MyAccountGetStatusResponseDto>() {})
    );
  }

  private Request buildCheckAccountRegistrationStatusRequest() {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v3/myAccount/status/"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .build();
  }

  /**
   * Retrieve WalletId
   *
   * @return response of {@code WalletShowResponseDto}
   */
  public WalletShowResponseDto retrieveWalletid() throws ApiError {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request = this.buildRetrieveWalletidRequest();
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<WalletShowResponseDto>() {});
  }

  /**
   * Retrieve WalletId
   *
   * @return response of {@code CompletableFuture<WalletShowResponseDto>}
   */
  public CompletableFuture<WalletShowResponseDto> retrieveWalletidAsync() throws ApiError {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request = this.buildRetrieveWalletidRequest();
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<WalletShowResponseDto>() {})
    );
  }

  private Request buildRetrieveWalletidRequest() {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v3/wallets/"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .build();
  }

  /**
   * Delete White Label subaccount
   *
   * @return response of {@code MyAccountDisableAccountResponseDto}
   */
  public MyAccountDisableAccountResponseDto deleteWhiteLabelSubaccount() throws ApiError {
    return this.deleteWhiteLabelSubaccount(DeleteWhiteLabelSubaccountParameters.builder().build());
  }

  /**
   * Delete White Label subaccount
   *
   * @param requestParameters {@link DeleteWhiteLabelSubaccountParameters} Request Parameters Object
   * @return response of {@code MyAccountDisableAccountResponseDto}
   */
  public MyAccountDisableAccountResponseDto deleteWhiteLabelSubaccount(
    @NonNull DeleteWhiteLabelSubaccountParameters requestParameters
  ) throws ApiError {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request = this.buildDeleteWhiteLabelSubaccountRequest(requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<MyAccountDisableAccountResponseDto>() {});
  }

  /**
   * Delete White Label subaccount
   *
   * @return response of {@code CompletableFuture<MyAccountDisableAccountResponseDto>}
   */
  public CompletableFuture<MyAccountDisableAccountResponseDto> deleteWhiteLabelSubaccountAsync() throws ApiError {
    return this.deleteWhiteLabelSubaccountAsync(DeleteWhiteLabelSubaccountParameters.builder().build());
  }

  /**
   * Delete White Label subaccount
   *
   * @param requestParameters {@link DeleteWhiteLabelSubaccountParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<MyAccountDisableAccountResponseDto>}
   */
  public CompletableFuture<MyAccountDisableAccountResponseDto> deleteWhiteLabelSubaccountAsync(
    @NonNull DeleteWhiteLabelSubaccountParameters requestParameters
  ) throws ApiError {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request = this.buildDeleteWhiteLabelSubaccountRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<MyAccountDisableAccountResponseDto>() {})
    );
  }

  private Request buildDeleteWhiteLabelSubaccountRequest(
    @NonNull DeleteWhiteLabelSubaccountParameters requestParameters
  ) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v3/myAccount/"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setOptionalQueryParameter("removeReason", requestParameters.getRemoveReason())
      .build();
  }
}
