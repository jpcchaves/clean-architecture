package br.com.jpcchaves.infrastructure.dto;

public class TodoResponseDTO {
    private Long id;
    private String todo;

    public TodoResponseDTO() {
    }

    public TodoResponseDTO(Long id,
                           String todo) {
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
