package br.com.jpcchaves.infrastructure.service.todo;

import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.core.domain.enums.TodoStatus;
import br.com.jpcchaves.infrastructure.dto.TodoRequestDTO;
import br.com.jpcchaves.infrastructure.dto.TodoResponseDTO;
import br.com.jpcchaves.infrastructure.mapper.TodoMapper;
import br.com.jpcchaves.usecase.todo.CreateTodoUseCase;
import br.com.jpcchaves.usecase.todo.DeleteTodoUseCase;
import br.com.jpcchaves.usecase.todo.GetTodoByIdUseCase;
import br.com.jpcchaves.usecase.todo.ListTodoUseCase;
import br.com.jpcchaves.usecase.todo.UpdateTodoStatusUseCase;
import br.com.jpcchaves.usecase.todo.UpdateTodoUseCase;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoServiceImpl implements TodoService {
  private final CreateTodoUseCase createTodoUseCase;
  private final ListTodoUseCase listTodoUseCase;
  private final GetTodoByIdUseCase getTodoByIdUseCase;
  private final DeleteTodoUseCase deleteTodoUseCase;
  private final UpdateTodoUseCase updateTodoUseCase;
  private final UpdateTodoStatusUseCase updateTodoStatusUseCase;
  private final TodoMapper todoMapper;

  public TodoServiceImpl(
      CreateTodoUseCase createTodoUseCase,
      ListTodoUseCase listTodoUseCase,
      GetTodoByIdUseCase getTodoByIdUseCase,
      DeleteTodoUseCase deleteTodoUseCase,
      UpdateTodoUseCase updateTodoUseCase,
      UpdateTodoStatusUseCase updateTodoStatusUseCase,
      TodoMapper todoMapper) {
    this.createTodoUseCase = createTodoUseCase;
    this.listTodoUseCase = listTodoUseCase;
    this.getTodoByIdUseCase = getTodoByIdUseCase;
    this.deleteTodoUseCase = deleteTodoUseCase;
    this.updateTodoUseCase = updateTodoUseCase;
    this.updateTodoStatusUseCase = updateTodoStatusUseCase;
    this.todoMapper = todoMapper;
  }

  @Override
  @Transactional
  public TodoResponseDTO create(TodoRequestDTO todo) {

    Todo createdTodo = createTodoUseCase.create(todoMapper.toTodo(todo));

    return todoMapper.toResponseDTO(createdTodo);
  }

  @Override
  @Transactional(readOnly = true)
  public List<TodoResponseDTO> list() {
    return todoMapper.toResponseDTOList(listTodoUseCase.list());
  }

  @Override
  @Transactional(readOnly = true)
  public TodoResponseDTO getById(Long id) {
    Todo todo = getTodoByIdUseCase.getById(id);

    return todoMapper.toResponseDTO(todo);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    deleteTodoUseCase.delete(id);
  }

  @Override
  @Transactional
  public TodoResponseDTO update(Long id, TodoRequestDTO todoEntity) {
    Todo updatedTodo = updateTodoUseCase.update(id, todoMapper.toTodo(todoEntity));

    return todoMapper.toResponseDTO(updatedTodo);
  }

  @Override
  @Transactional
  public void updateStatus(Long id, TodoStatus status) {
    updateTodoStatusUseCase.updateStatus(id, status);
  }
}
