// This file was generated by liblab | https://liblab.com/

package com.asaas.apisdk.validation.validators;

import com.asaas.apisdk.validation.Violation;

public interface Validator<T> {
  Violation[] validate(T value);
}
