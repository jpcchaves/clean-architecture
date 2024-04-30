package br.com.jpcchaves.core.domain.enums;

import br.com.jpcchaves.core.exception.PaginationException;
import br.com.jpcchaves.core.exception.enums.ExceptionDefinition;

public enum PaginationDirection {
  ASC("ASC"),
  DESC("DESC");

  private final String direction;

  PaginationDirection(String direction) {
    this.direction = direction;
  }

  public static String isValid(String dir) {
    for (PaginationDirection direction : values()) {
      if (direction.getDirection().equals(dir.toUpperCase())) {
        return direction.getDirection();
      }
    }

    throw new PaginationException(ExceptionDefinition.PG0001);
  }

  public String getDirection() {
    return direction;
  }
}
