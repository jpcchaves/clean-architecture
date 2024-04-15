package br.com.jpcchaves.infrastructure.gatewayimpl;

import br.com.jpcchaves.application.gateway.CreateTodoGateway;
import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.TodoRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateTodoGatewayImpl implements CreateTodoGateway {
    private final TodoRepository todoRepository;

    public CreateTodoGatewayImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo create(Todo todo) {
        TodoEntity createdTodo =
                todoRepository
                        .save(new TodoEntity(todo.getId(),
                                todo.getTodo(), todo.getCreatedAt(),
                                todo.getUpdatedAt(), todo.getCreatedBy(),
                                todo.getModifiedBy()));

        return new Todo(createdTodo.getId(),
                createdTodo.getTodo(), createdTodo.getCreatedAt(),
                createdTodo.getUpdatedAt(), createdTodo.getCreatedBy(),
                createdTodo.getModifiedBy());
    }
}
