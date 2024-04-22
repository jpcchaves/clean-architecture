package br.com.jpcchaves.core.exception;

import br.com.jpcchaves.core.exception.enums.ExceptionDefinition;

public class CategoryException extends BaseException {

  public CategoryException(String message, String code, int httpStatus) {
    super(message, code, httpStatus);
  }

  public CategoryException(ExceptionDefinition exceptionDefinition) {
    super(exceptionDefinition);
  }
}
