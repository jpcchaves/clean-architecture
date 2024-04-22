package br.com.jpcchaves.infrastructure.persistence.entity;

import br.com.jpcchaves.core.domain.enums.TodoStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id")
  private CategoryEntity category;

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

  public TodoEntity(
      LocalDateTime createdAt,
      LocalDateTime updatedAt,
      Long createdBy,
      Long modifiedBy,
      Long id,
      String todo,
      TodoStatus status,
      CategoryEntity category) {
    super(createdAt, updatedAt, createdBy, modifiedBy);
    this.id = id;
    this.todo = todo;
    this.status = TodoStatus.NOT_STARTED;
    this.category = category;
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

  public CategoryEntity getCategory() {
    return category;
  }

  public void setCategory(CategoryEntity category) {
    this.category = category;
  }
}
