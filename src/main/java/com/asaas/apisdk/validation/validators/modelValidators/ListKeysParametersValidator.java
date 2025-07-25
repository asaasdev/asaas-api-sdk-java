// This file was generated by liblab | https://liblab.com/

package com.asaas.apisdk.validation.validators.modelValidators;

import com.asaas.apisdk.models.ListKeysParameters;
import com.asaas.apisdk.validation.Violation;
import com.asaas.apisdk.validation.ViolationAggregator;
import com.asaas.apisdk.validation.validators.NumericValidator;

public class ListKeysParametersValidator extends AbstractModelValidator<ListKeysParameters> {

  public ListKeysParametersValidator(String fieldName) {
    super(fieldName);
  }

  public ListKeysParametersValidator() {}

  @Override
  protected Violation[] validateModel(ListKeysParameters requestParameters) {
    return new ViolationAggregator()
      .add(new NumericValidator<Long>("limit").max(100L).optional().validate(requestParameters.getLimit()))
      .aggregate();
  }
}
