package br.com.jpcchaves.core.exception.enums;

public enum ErrorCode {
  TD0001("TODO not found with the given ID", "TD-0001");

  private String message;
  private String code;

  ErrorCode(String message, String code) {
    this.message = message;
    this.code = code;
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
}
