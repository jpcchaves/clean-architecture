package br.com.jpcchaves.infrastructure.dto;

import br.com.jpcchaves.core.domain.enums.TodoStatus;

public class UpdateTodoStatusDTO {
  private TodoStatus status;

  public UpdateTodoStatusDTO() {}

  public UpdateTodoStatusDTO(TodoStatus status) {
    this.status = status;
  }

  public TodoStatus getStatus() {
    return status;
  }

  public void setStatus(TodoStatus status) {
    this.status = status;
  }
}
