package br.com.jpcchaves.infrastructure.dto;

import jakarta.validation.constraints.NotBlank;

public class TodoRequestDTO {
  @NotBlank(message = "The to do is a required field!")
  private String todo;

  public TodoRequestDTO() {}

  public TodoRequestDTO(String todo) {
    this.todo = todo;
  }

  public String getTodo() {
    return todo;
  }

  public void setTodo(String todo) {
    this.todo = todo;
  }
}
