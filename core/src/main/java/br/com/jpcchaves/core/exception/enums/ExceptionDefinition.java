package br.com.jpcchaves.core.exception.enums;

import br.com.jpcchaves.core.domain.enums.HttpStatus;

public enum ExceptionDefinition {
  TD0001("TODO not found with the given ID", "TD-0001", HttpStatus.NOT_FOUND.value());

  private String message;
  private String code;
  private int httpStatus;

  ExceptionDefinition(String message, String code, int httpStatus) {
    this.message = message;
    this.code = code;
    this.httpStatus = httpStatus;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public int getHttpStatus() {
    return httpStatus;
  }

  public void setHttpStatus(int httpStatus) {
    this.httpStatus = httpStatus;
  }
}