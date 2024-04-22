package br.com.jpcchaves.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class CategoryEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 50, nullable = false, unique = true)
  private String name;

  @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "category")
  private List<TodoEntity> todoList = new ArrayList<>();

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
    this.name = name;
  }

  public List<TodoEntity> getTodoList() {
    return todoList;
  }

  public void setTodoList(List<TodoEntity> todoList) {
    this.todoList = todoList;
  }
}
