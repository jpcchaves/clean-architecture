package br.com.jpcchaves.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "todos")
public class TodoEntity extends AuditedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String todo;

    public TodoEntity() {
    }

    public TodoEntity(Long id,
                      String todo) {
        this.id = id;
        this.todo = todo;
    }

    public TodoEntity(Long id,
                String todo,
                LocalDateTime createdAt,
                LocalDateTime updatedAt,
                Long createdBy,
                Long modifiedBy) {
        super(createdAt, updatedAt, createdBy, modifiedBy);
        this.id = id;
        this.todo = todo;
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
}
