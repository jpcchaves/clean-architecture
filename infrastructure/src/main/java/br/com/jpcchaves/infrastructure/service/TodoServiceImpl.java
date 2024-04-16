package br.com.jpcchaves.infrastructure.service;

import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.usecase.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {
    private final CreateTodoUseCase createTodoUseCase;
    private final ListTodoUseCase listTodoUseCase;
    private final GetTodoByIdUseCase getTodoByIdUseCase;
    private final DeleteTodoUseCase deleteTodoUseCase;
    private final UpdateTodoUseCase updateTodoUseCase;

    public TodoServiceImpl(CreateTodoUseCase createTodoUseCase,
                           ListTodoUseCase listTodoUseCase,
                           GetTodoByIdUseCase getTodoByIdUseCase,
                           DeleteTodoUseCase deleteTodoUseCase,
                           UpdateTodoUseCase updateTodoUseCase) {
        this.createTodoUseCase = createTodoUseCase;
        this.listTodoUseCase = listTodoUseCase;
        this.getTodoByIdUseCase = getTodoByIdUseCase;
        this.deleteTodoUseCase = deleteTodoUseCase;
        this.updateTodoUseCase = updateTodoUseCase;
    }

    @Override
    public TodoEntity create(TodoEntity todo) {

        Todo createdTodo = createTodoUseCase.create(new Todo(todo.getId(),
                todo.getTodo(), todo.getCreatedAt(),
                todo.getUpdatedAt(), todo.getCreatedBy(),
                todo.getModifiedBy()));

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

    @Override
    public TodoEntity update(Long id,
                             TodoEntity todoEntity) {
        Todo updatedTodo = updateTodoUseCase.update(id, new Todo(
                todoEntity.getId(),
                todoEntity.getTodo(),
                todoEntity.getCreatedAt(),
                todoEntity.getUpdatedAt(),
                todoEntity.getCreatedBy(),
                todoEntity.getModifiedBy()
        ));

        return new TodoEntity(
                updatedTodo.getId(),
                updatedTodo.getTodo(),
                updatedTodo.getCreatedAt(),
                updatedTodo.getUpdatedAt(),
                updatedTodo.getCreatedBy(),
                updatedTodo.getModifiedBy()
        );
    }
}
