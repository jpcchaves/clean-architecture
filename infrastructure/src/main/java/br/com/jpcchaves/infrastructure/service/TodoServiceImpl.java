package br.com.jpcchaves.infrastructure.service;

import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.usecase.CreateTodoUseCase;
import br.com.jpcchaves.usecase.DeleteTodoUseCase;
import br.com.jpcchaves.usecase.GetTodoByIdUseCase;
import br.com.jpcchaves.usecase.ListTodoUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {
    private final CreateTodoUseCase createTodoUseCase;
    private final ListTodoUseCase listTodoUseCase;
    private final GetTodoByIdUseCase getTodoByIdUseCase;
    private final DeleteTodoUseCase deleteTodoUseCase;

    public TodoServiceImpl(CreateTodoUseCase createTodoUseCase,
                           ListTodoUseCase listTodoUseCase,
                           GetTodoByIdUseCase getTodoByIdUseCase,
                           DeleteTodoUseCase deleteTodoUseCase) {
        this.createTodoUseCase = createTodoUseCase;
        this.listTodoUseCase = listTodoUseCase;
        this.getTodoByIdUseCase = getTodoByIdUseCase;
        this.deleteTodoUseCase = deleteTodoUseCase;
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

    @Override
    public TodoEntity getById(Long id) {
        Todo todo = getTodoByIdUseCase.getById(id);

        return new TodoEntity(
                todo.getId(),
                todo.getTodo(),
                todo.getCreatedAt(),
                todo.getUpdatedAt(),
                todo.getCreatedBy(),
                todo.getModifiedBy()
        );
    }

    @Override
    public void delete(Long id) {
        deleteTodoUseCase.delete(id);
    }
}
