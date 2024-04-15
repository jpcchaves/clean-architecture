package br.com.jpcchaves.infrastructure.service;

import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.usecase.CreateTodoUseCase;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {
    private final CreateTodoUseCase createTodoUseCase;

    public TodoServiceImpl(CreateTodoUseCase createTodoUseCase) {
        this.createTodoUseCase = createTodoUseCase;
    }

    @Override
    public Todo create(Todo todo) {
        return createTodoUseCase.create(todo);
    }
}
