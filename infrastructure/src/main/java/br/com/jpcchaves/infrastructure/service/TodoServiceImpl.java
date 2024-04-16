package br.com.jpcchaves.infrastructure.service;

import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.mapper.TodoMapper;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.usecase.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private final CreateTodoUseCase createTodoUseCase;
    private final ListTodoUseCase listTodoUseCase;
    private final GetTodoByIdUseCase getTodoByIdUseCase;
    private final DeleteTodoUseCase deleteTodoUseCase;
    private final UpdateTodoUseCase updateTodoUseCase;
    private final TodoMapper todoMapper;

    public TodoServiceImpl(CreateTodoUseCase createTodoUseCase,
                           ListTodoUseCase listTodoUseCase,
                           GetTodoByIdUseCase getTodoByIdUseCase,
                           DeleteTodoUseCase deleteTodoUseCase,
                           UpdateTodoUseCase updateTodoUseCase,
                           TodoMapper todoMapper) {
        this.createTodoUseCase = createTodoUseCase;
        this.listTodoUseCase = listTodoUseCase;
        this.getTodoByIdUseCase = getTodoByIdUseCase;
        this.deleteTodoUseCase = deleteTodoUseCase;
        this.updateTodoUseCase = updateTodoUseCase;
        this.todoMapper = todoMapper;
    }

    @Override
    public TodoEntity create(TodoEntity todo) {

        Todo createdTodo = createTodoUseCase.create(todoMapper.toTodo(todo));

        return todoMapper.toTodoEntity(createdTodo);
    }

    @Override
    public List<TodoEntity> list() {
        return todoMapper.toTodoEntityList(listTodoUseCase.list());
    }

    @Override
    public TodoEntity getById(Long id) {
        Todo todo = getTodoByIdUseCase.getById(id);

        return todoMapper.toTodoEntity(todo);
    }

    @Override
    public void delete(Long id) {
        deleteTodoUseCase.delete(id);
    }

    @Override
    public TodoEntity update(Long id,
                             TodoEntity todoEntity) {
        Todo updatedTodo = updateTodoUseCase.update(id, todoMapper.toTodo(todoEntity));

        return todoMapper.toTodoEntity(updatedTodo);
    }
}
