// This file was generated by liblab | https://liblab.com/

package com.asaas.apisdk.services;

import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.exceptions.ApiError;
import com.asaas.apisdk.exceptions.ErrorResponseDtoException;
import com.asaas.apisdk.http.Environment;
import com.asaas.apisdk.http.HttpMethod;
import com.asaas.apisdk.http.ModelConverter;
import com.asaas.apisdk.http.util.RequestBuilder;
import com.asaas.apisdk.models.ErrorResponseDto;
import com.asaas.apisdk.models.ListMobileRechargesParameters;
import com.asaas.apisdk.models.MobilePhoneRechargeFindProviderResponseDto;
import com.asaas.apisdk.models.MobilePhoneRechargeGetResponseDto;
import com.asaas.apisdk.models.MobilePhoneRechargeListResponseDto;
import com.asaas.apisdk.models.MobilePhoneRechargeSaveRequestDto;
import com.asaas.apisdk.validation.ViolationAggregator;
import com.asaas.apisdk.validation.exceptions.ValidationException;
import com.asaas.apisdk.validation.validators.modelValidators.ListMobileRechargesParametersValidator;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * MobilePhoneRechargeService Service
 */
public class MobilePhoneRechargeService extends BaseService {

  public MobilePhoneRechargeService(@NonNull OkHttpClient httpClient, AsaasSdkConfig config) {
    super(httpClient, config);
  }

  /**
   * List cell phone top-ups
   *
   * @return response of {@code MobilePhoneRechargeListResponseDto}
   */
  public MobilePhoneRechargeListResponseDto listMobileRecharges() throws ApiError, ValidationException {
    return this.listMobileRecharges(ListMobileRechargesParameters.builder().build());
  }

  /**
   * List cell phone top-ups
   *
   * @param requestParameters {@link ListMobileRechargesParameters} Request Parameters Object
   * @return response of {@code MobilePhoneRechargeListResponseDto}
   */
  public MobilePhoneRechargeListResponseDto listMobileRecharges(
    @NonNull ListMobileRechargesParameters requestParameters
  ) throws ApiError, ValidationException {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request = this.buildListMobileRechargesRequest(requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<MobilePhoneRechargeListResponseDto>() {});
  }

  /**
   * List cell phone top-ups
   *
   * @return response of {@code CompletableFuture<MobilePhoneRechargeListResponseDto>}
   */
  public CompletableFuture<MobilePhoneRechargeListResponseDto> listMobileRechargesAsync()
    throws ApiError, ValidationException {
    return this.listMobileRechargesAsync(ListMobileRechargesParameters.builder().build());
  }

  /**
   * List cell phone top-ups
   *
   * @param requestParameters {@link ListMobileRechargesParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<MobilePhoneRechargeListResponseDto>}
   */
  public CompletableFuture<MobilePhoneRechargeListResponseDto> listMobileRechargesAsync(
    @NonNull ListMobileRechargesParameters requestParameters
  ) throws ApiError, ValidationException {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request = this.buildListMobileRechargesRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<MobilePhoneRechargeListResponseDto>() {})
    );
  }

  private Request buildListMobileRechargesRequest(@NonNull ListMobileRechargesParameters requestParameters)
    throws ValidationException {
    new ViolationAggregator()
      .add(new ListMobileRechargesParametersValidator("requestParameters").optional().validate(requestParameters))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v3/mobilePhoneRecharges"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setOptionalQueryParameter("offset", requestParameters.getOffset())
      .setOptionalQueryParameter("limit", requestParameters.getLimit())
      .build();
  }

  /**
   * Request recharge
   *
   * @return response of {@code MobilePhoneRechargeGetResponseDto}
   */
  public MobilePhoneRechargeGetResponseDto requestRecharge() throws ApiError {
    return this.requestRecharge(MobilePhoneRechargeSaveRequestDto.builder().build());
  }

  /**
   * Request recharge
   *
   * @param mobilePhoneRechargeSaveRequestDto {@link MobilePhoneRechargeSaveRequestDto} Request Body
   * @return response of {@code MobilePhoneRechargeGetResponseDto}
   */
  public MobilePhoneRechargeGetResponseDto requestRecharge(
    @NonNull MobilePhoneRechargeSaveRequestDto mobilePhoneRechargeSaveRequestDto
  ) throws ApiError {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request = this.buildRequestRechargeRequest(mobilePhoneRechargeSaveRequestDto);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<MobilePhoneRechargeGetResponseDto>() {});
  }

  /**
   * Request recharge
   *
   * @return response of {@code CompletableFuture<MobilePhoneRechargeGetResponseDto>}
   */
  public CompletableFuture<MobilePhoneRechargeGetResponseDto> requestRechargeAsync() throws ApiError {
    return this.requestRechargeAsync(MobilePhoneRechargeSaveRequestDto.builder().build());
  }

  /**
   * Request recharge
   *
   * @param mobilePhoneRechargeSaveRequestDto {@link MobilePhoneRechargeSaveRequestDto} Request Body
   * @return response of {@code CompletableFuture<MobilePhoneRechargeGetResponseDto>}
   */
  public CompletableFuture<MobilePhoneRechargeGetResponseDto> requestRechargeAsync(
    @NonNull MobilePhoneRechargeSaveRequestDto mobilePhoneRechargeSaveRequestDto
  ) throws ApiError {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request = this.buildRequestRechargeRequest(mobilePhoneRechargeSaveRequestDto);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<MobilePhoneRechargeGetResponseDto>() {})
    );
  }

  private Request buildRequestRechargeRequest(
    @NonNull MobilePhoneRechargeSaveRequestDto mobilePhoneRechargeSaveRequestDto
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v3/mobilePhoneRecharges"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setJsonContent(mobilePhoneRechargeSaveRequestDto)
      .build();
  }

  /**
   * Recover a single cell phone recharge
   *
   * @param id String Unique identifier for cell phone recharge on Asaas
   * @return response of {@code MobilePhoneRechargeGetResponseDto}
   */
  public MobilePhoneRechargeGetResponseDto recoverASingleCellphoneRecharge(@NonNull String id) throws ApiError {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request = this.buildRecoverASingleCellphoneRechargeRequest(id);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<MobilePhoneRechargeGetResponseDto>() {});
  }

  /**
   * Recover a single cell phone recharge
   *
   * @param id String Unique identifier for cell phone recharge on Asaas
   * @return response of {@code CompletableFuture<MobilePhoneRechargeGetResponseDto>}
   */
  public CompletableFuture<MobilePhoneRechargeGetResponseDto> recoverASingleCellphoneRechargeAsync(@NonNull String id)
    throws ApiError {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request = this.buildRecoverASingleCellphoneRechargeRequest(id);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<MobilePhoneRechargeGetResponseDto>() {})
    );
  }

  private Request buildRecoverASingleCellphoneRechargeRequest(@NonNull String id) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v3/mobilePhoneRecharges/{id}"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setPathParameter("id", id)
      .build();
  }

  /**
   * Cancel a cell phone recharge
   *
   * @param id String Unique identifier for cell phone recharge on Asaas
   * @param input Object Request Body
   * @return response of {@code MobilePhoneRechargeGetResponseDto}
   */
  public MobilePhoneRechargeGetResponseDto cancelACellphoneRecharge(@NonNull String id, @NonNull Object input)
    throws ApiError {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request = this.buildCancelACellphoneRechargeRequest(id, input);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<MobilePhoneRechargeGetResponseDto>() {});
  }

  /**
   * Cancel a cell phone recharge
   *
   * @param id String Unique identifier for cell phone recharge on Asaas
   * @param input Object Request Body
   * @return response of {@code CompletableFuture<MobilePhoneRechargeGetResponseDto>}
   */
  public CompletableFuture<MobilePhoneRechargeGetResponseDto> cancelACellphoneRechargeAsync(
    @NonNull String id,
    @NonNull Object input
  ) throws ApiError {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request = this.buildCancelACellphoneRechargeRequest(id, input);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<MobilePhoneRechargeGetResponseDto>() {})
    );
  }

  private Request buildCancelACellphoneRechargeRequest(@NonNull String id, @NonNull Object input) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v3/mobilePhoneRecharges/{id}/cancel"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setPathParameter("id", id)
      .setJsonContent(input)
      .build();
  }

  /**
   * Search for cell phone provider
   *
   * @param phoneNumber String Cell phone number that will be consulted.
   * @return response of {@code MobilePhoneRechargeFindProviderResponseDto}
   */
  public MobilePhoneRechargeFindProviderResponseDto searchForCellPhoneProvider(@NonNull String phoneNumber)
    throws ApiError {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request = this.buildSearchForCellPhoneProviderRequest(phoneNumber);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<MobilePhoneRechargeFindProviderResponseDto>() {});
  }

  /**
   * Search for cell phone provider
   *
   * @param phoneNumber String Cell phone number that will be consulted.
   * @return response of {@code CompletableFuture<MobilePhoneRechargeFindProviderResponseDto>}
   */
  public CompletableFuture<MobilePhoneRechargeFindProviderResponseDto> searchForCellPhoneProviderAsync(
    @NonNull String phoneNumber
  ) throws ApiError {
    this.addErrorMapping(400, ErrorResponseDto.class, ErrorResponseDtoException.class);
    Request request = this.buildSearchForCellPhoneProviderRequest(phoneNumber);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<MobilePhoneRechargeFindProviderResponseDto>() {})
    );
  }

  private Request buildSearchForCellPhoneProviderRequest(@NonNull String phoneNumber) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v3/mobilePhoneRecharges/{phoneNumber}/provider"
    )
      .setApiKeyAuth(this.config.getApiKeyAuthConfig())
      .setPathParameter("phoneNumber", phoneNumber)
      .build();
  }
}
