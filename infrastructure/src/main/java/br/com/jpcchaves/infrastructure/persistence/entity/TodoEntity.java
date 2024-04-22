package br.com.jpcchaves.infrastructure.persistence.entity;

import br.com.jpcchaves.core.domain.enums.TodoStatus;
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "todos")
@EntityListeners(AuditingEntityListener.class)
public class TodoEntity extends AuditedEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private String todo;

  @Enumerated(EnumType.STRING)
  private TodoStatus status;

  public TodoEntity() {}

  public TodoEntity(Long id, String todo) {
    this.id = id;
    this.todo = todo;
    this.status = TodoStatus.NOT_STARTED;
  }

  public TodoEntity(
      Long id,
      String todo,
      LocalDateTime createdAt,
      LocalDateTime updatedAt,
      Long createdBy,
      Long modifiedBy) {
    super(createdAt, updatedAt, createdBy, modifiedBy);
    this.id = id;
    this.todo = todo;
    this.status = TodoStatus.NOT_STARTED;
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
