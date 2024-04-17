package br.com.jpcchaves.core.exception;

public class TodoException extends RuntimeException {
  private String code;
  private int statusCode;

  public TodoException(String message, String code) {
    super(message);
    this.code = code;
  }

  public TodoException(String message, String code, int statusCode) {
    super(message);
    this.code = code;
    this.statusCode = statusCode;
  }

  public int getStatusCode() {
    return statusCode;
  }
}
