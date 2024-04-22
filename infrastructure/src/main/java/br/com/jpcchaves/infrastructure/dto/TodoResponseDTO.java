package br.com.jpcchaves.infrastructure.dto;

import br.com.jpcchaves.core.domain.enums.TodoStatus;

public class TodoResponseDTO {
  private Long id;
  private String todo;
  private TodoStatus status;

  public TodoResponseDTO() {}

  public TodoResponseDTO(Long id, String todo) {
    this.id = id;
    this.todo = todo;
  }

  public TodoResponseDTO(Long id, String todo, TodoStatus status) {
    this.id = id;
    this.todo = todo;
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTodo() {
    return todo;
  }

  public void setTodo(String todo) {
    this.todo = todo;
  }

  public TodoStatus getStatus() {
    return status;
  }

  public void setStatus(TodoStatus status) {
    this.status = status;
  }
}
