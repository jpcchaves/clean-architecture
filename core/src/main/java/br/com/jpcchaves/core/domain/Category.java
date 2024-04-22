package br.com.jpcchaves.core.domain;

import br.com.jpcchaves.core.exception.CategoryException;
import br.com.jpcchaves.core.exception.enums.ExceptionDefinition;
import java.util.ArrayList;
import java.util.List;

public class Category {
  private Long id;
  private String name;
  private List<Todo> todoList = new ArrayList<>();

  public Category() {}

  public Category(Long id, String name, List<Todo> todoList) {
    this.id = id;
    this.name = name;
    this.todoList = todoList;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (name.isBlank()) {
      throw new CategoryException(ExceptionDefinition.CT0001);
    }

    this.name = name;
  }

  public List<Todo> getTodoList() {
    return todoList;
  }

  public void setTodoList(List<Todo> todoList) {
    this.todoList = todoList;
  }
}
