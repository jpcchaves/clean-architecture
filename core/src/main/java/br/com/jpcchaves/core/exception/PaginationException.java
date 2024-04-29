package br.com.jpcchaves.core.exception;

import br.com.jpcchaves.core.exception.enums.ExceptionDefinition;

public class PaginationException extends BaseException {

  public PaginationException(String message, String code, int httpStatus) {
    super(message, code, httpStatus);
  }

  public PaginationException(ExceptionDefinition exceptionDefinition) {
    super(exceptionDefinition);
  }
}
