package br.com.jpcchaves.infrastructure.dto;

import jakarta.validation.constraints.NotBlank;

public class TodoRequestDTO {
  @NotBlank(message = "The to do is a required field!")
  private String todo = null;

  @NotBlank(message = "The category is a required field!")
  private Long categoryId;

  public TodoRequestDTO() {}

  public TodoRequestDTO(String todo) {
    this.todo = todo;
  }

  public TodoRequestDTO(String todo, Long categoryId) {
    this.todo = todo;
    this.categoryId = categoryId;
  }

  public String getTodo() {
    return todo;
  }

  public void setTodo(String todo) {
    this.todo = todo;
  }

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }
}
