package br.com.jpcchaves.infrastructure.service;

import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.dto.TodoRequestDTO;
import br.com.jpcchaves.infrastructure.dto.TodoResponseDTO;
import br.com.jpcchaves.infrastructure.mapper.TodoMapper;
import br.com.jpcchaves.usecase.*;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {
  private final CreateTodoUseCase createTodoUseCase;
  private final ListTodoUseCase listTodoUseCase;
  private final GetTodoByIdUseCase getTodoByIdUseCase;
  private final DeleteTodoUseCase deleteTodoUseCase;
  private final UpdateTodoUseCase updateTodoUseCase;
  private final TodoMapper todoMapper;

  public TodoServiceImpl(
      CreateTodoUseCase createTodoUseCase,
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
  public TodoResponseDTO create(TodoRequestDTO todo) {

    Todo createdTodo = createTodoUseCase.create(todoMapper.toTodo(todo));

    return todoMapper.toResponseDTO(createdTodo);
  }

  @Override
  public List<TodoResponseDTO> list() {
    return todoMapper.toResponseDTOList(listTodoUseCase.list());
  }

  @Override
  public TodoResponseDTO getById(Long id) {
    Todo todo = getTodoByIdUseCase.getById(id);

    return todoMapper.toResponseDTO(todo);
  }

  @Override
  public void delete(Long id) {
    deleteTodoUseCase.delete(id);
  }

  @Override
  public TodoResponseDTO update(Long id, TodoRequestDTO todoEntity) {
    Todo updatedTodo = updateTodoUseCase.update(id, todoMapper.toTodo(todoEntity));

    return todoMapper.toResponseDTO(updatedTodo);
  }
}
