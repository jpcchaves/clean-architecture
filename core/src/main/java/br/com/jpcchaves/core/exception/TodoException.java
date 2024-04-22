package br.com.jpcchaves.core.exception;

import br.com.jpcchaves.core.exception.enums.ExceptionDefinition;

public class TodoException extends BaseException {
  public TodoException(String message, String code, int httpStatus) {
    super(message, code, httpStatus);
  }

  public TodoException(ExceptionDefinition exceptionDefinition) {
    super(exceptionDefinition);
  }
}
