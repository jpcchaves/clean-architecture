package br.com.jpcchaves.infrastructure.service;

import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.usecase.CreateTodoUseCase;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {
    private final CreateTodoUseCase createTodoUseCase;

    public TodoServiceImpl(CreateTodoUseCase createTodoUseCase) {
        this.createTodoUseCase = createTodoUseCase;
    }

    @Override
    public TodoEntity create(Todo todo) {
        Todo createdTodo = createTodoUseCase.create(todo);
        return new TodoEntity(createdTodo.getId(),
                createdTodo.getTodo(), createdTodo.getCreatedAt(),
                createdTodo.getUpdatedAt(), createdTodo.getCreatedBy(),
                createdTodo.getModifiedBy());
    }
}
