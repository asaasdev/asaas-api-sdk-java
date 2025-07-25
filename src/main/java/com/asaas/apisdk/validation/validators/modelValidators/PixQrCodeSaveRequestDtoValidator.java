// This file was generated by liblab | https://liblab.com/

package com.asaas.apisdk.validation.validators.modelValidators;

import com.asaas.apisdk.models.PixQrCodeSaveRequestDto;
import com.asaas.apisdk.validation.Violation;
import com.asaas.apisdk.validation.ViolationAggregator;
import com.asaas.apisdk.validation.validators.StringValidator;

public class PixQrCodeSaveRequestDtoValidator extends AbstractModelValidator<PixQrCodeSaveRequestDto> {

  public PixQrCodeSaveRequestDtoValidator(String fieldName) {
    super(fieldName);
  }

  public PixQrCodeSaveRequestDtoValidator() {}

  @Override
  protected Violation[] validateModel(PixQrCodeSaveRequestDto pixQrCodeSaveRequestDto) {
    return new ViolationAggregator()
      .add(
        new StringValidator("externalReference")
          .maxLength(100)
          .optional()
          .validate(pixQrCodeSaveRequestDto.getExternalReference())
      )
      .aggregate();
  }
}
