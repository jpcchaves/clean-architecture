package br.com.jpcchaves.infrastructure.service;

import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.usecase.CreateTodoUseCase;
import br.com.jpcchaves.usecase.ListTodoUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {
    private final CreateTodoUseCase createTodoUseCase;
    private final ListTodoUseCase listTodoUseCase;

    public TodoServiceImpl(CreateTodoUseCase createTodoUseCase,
                           ListTodoUseCase listTodoUseCase) {
        this.createTodoUseCase = createTodoUseCase;
        this.listTodoUseCase = listTodoUseCase;
    }

    @Override
    public TodoEntity create(Todo todo) {
        Todo createdTodo = createTodoUseCase.create(todo);
        return new TodoEntity(createdTodo.getId(),
                createdTodo.getTodo(), createdTodo.getCreatedAt(),
                createdTodo.getUpdatedAt(), createdTodo.getCreatedBy(),
                createdTodo.getModifiedBy());
    }

    @Override
    public List<TodoEntity> list() {
        List<Todo> todos = listTodoUseCase.list();

        return todos
                .stream()
                .map(todo -> new TodoEntity(
                        todo.getId(),
                        todo.getTodo(),
                        todo.getCreatedAt(),
                        todo.getUpdatedAt(),
                        todo.getCreatedBy(),
                        todo.getModifiedBy()
                ))
                .collect(Collectors.toList());
    }
}
