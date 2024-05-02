package br.com.jpcchaves.core.exception.enums;

import br.com.jpcchaves.core.domain.enums.HttpStatus;

public enum ExceptionDefinition {
  TD0001("TODO not found with the given ID", "TD-0001", HttpStatus.NOT_FOUND.value()),
  TD0002(
      "The category is a required field to create a Todo",
      "TD-0002",
      HttpStatus.BAD_REQUEST.value()),
  TD0003("Invalid todo status", "TD-0003", HttpStatus.BAD_REQUEST.value()),
  CT0001("The category name is a required field", "CT-0001", HttpStatus.BAD_REQUEST.value()),
  CT0002("Category not found with the given ID", "CT-0002", HttpStatus.NOT_FOUND.value()),
  PG0001("Invalid pagination direction", "PG-0001", HttpStatus.BAD_REQUEST.value());

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
