// This file was generated by liblab | https://liblab.com/

package com.asaas.apisdk.validation.validators.modelValidators;

import com.asaas.apisdk.models.ListReceivedSplitsParameters;
import com.asaas.apisdk.validation.Violation;
import com.asaas.apisdk.validation.ViolationAggregator;
import com.asaas.apisdk.validation.validators.NumericValidator;

public class ListReceivedSplitsParametersValidator extends AbstractModelValidator<ListReceivedSplitsParameters> {

  public ListReceivedSplitsParametersValidator(String fieldName) {
    super(fieldName);
  }

  public ListReceivedSplitsParametersValidator() {}

  @Override
  protected Violation[] validateModel(ListReceivedSplitsParameters requestParameters) {
    return new ViolationAggregator()
      .add(new NumericValidator<Long>("limit").max(100L).optional().validate(requestParameters.getLimit()))
      .aggregate();
  }
}
