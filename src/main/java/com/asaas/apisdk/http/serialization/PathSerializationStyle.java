// This file was generated by liblab | https://liblab.com/

package com.asaas.apisdk.http.serialization;

public enum PathSerializationStyle {
  SIMPLE(SerializationStyle.SIMPLE),
  LABEL(SerializationStyle.LABEL),
  MATRIX(SerializationStyle.MATRIX);

  public final SerializationStyle style;

  PathSerializationStyle(SerializationStyle style) {
    this.style = style;
  }
}
