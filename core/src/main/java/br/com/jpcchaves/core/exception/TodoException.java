package br.com.jpcchaves.core.exception;

import br.com.jpcchaves.core.exception.enums.ErrorCode;

public class TodoException extends BaseException {
  public TodoException(String message, String code, int httpStatus) {
    super(message, code, httpStatus);
  }

  public TodoException(ErrorCode errorCode) {
    super(errorCode);
  }
}
