package br.com.jpcchaves.infrastructure.service.todo;

import br.com.jpcchaves.core.domain.Category;
import br.com.jpcchaves.core.domain.PaginatedResponse;
import br.com.jpcchaves.core.domain.PaginationRequest;
import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.core.domain.enums.TodoStatus;
import br.com.jpcchaves.infrastructure.dto.todo.TodoRequestDTO;
import br.com.jpcchaves.infrastructure.dto.todo.TodoResponseDTO;
import br.com.jpcchaves.infrastructure.mapper.TodoMapper;
import br.com.jpcchaves.usecase.category.GetCategoryByIdUseCase;
import br.com.jpcchaves.usecase.todo.CreateTodoUseCase;
import br.com.jpcchaves.usecase.todo.DeleteTodoUseCase;
import br.com.jpcchaves.usecase.todo.GetTodoByIdUseCase;
import br.com.jpcchaves.usecase.todo.ListTodoPaginatedUseCase;
import br.com.jpcchaves.usecase.todo.ListTodoUseCase;
import br.com.jpcchaves.usecase.todo.ListTodosByCategoryUseCase;
import br.com.jpcchaves.usecase.todo.UpdateTodoStatusUseCase;
import br.com.jpcchaves.usecase.todo.UpdateTodoUseCase;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoServiceImpl implements TodoService {

  private final CreateTodoUseCase createTodoUseCase;
  private final ListTodoUseCase listTodoUseCase;
  private final ListTodoPaginatedUseCase listTodoPaginatedUseCase;
  private final GetTodoByIdUseCase getTodoByIdUseCase;
  private final DeleteTodoUseCase deleteTodoUseCase;
  private final UpdateTodoUseCase updateTodoUseCase;
  private final UpdateTodoStatusUseCase updateTodoStatusUseCase;
  private final GetCategoryByIdUseCase getCategoryByIdUseCase;
  private final ListTodosByCategoryUseCase listTodosByCategoryUseCase;
  private final TodoMapper todoMapper;

  public TodoServiceImpl(
      CreateTodoUseCase createTodoUseCase,
      ListTodoUseCase listTodoUseCase,
      ListTodoPaginatedUseCase listTodoPaginatedUseCase,
      GetTodoByIdUseCase getTodoByIdUseCase,
      DeleteTodoUseCase deleteTodoUseCase,
      UpdateTodoUseCase updateTodoUseCase,
      UpdateTodoStatusUseCase updateTodoStatusUseCase,
      TodoMapper todoMapper,
      GetCategoryByIdUseCase getCategoryByIdUseCase,
      ListTodosByCategoryUseCase listTodosByCategoryUseCase) {
    this.createTodoUseCase = createTodoUseCase;
    this.listTodoUseCase = listTodoUseCase;
    this.listTodoPaginatedUseCase = listTodoPaginatedUseCase;
    this.getTodoByIdUseCase = getTodoByIdUseCase;
    this.deleteTodoUseCase = deleteTodoUseCase;
    this.updateTodoUseCase = updateTodoUseCase;
    this.updateTodoStatusUseCase = updateTodoStatusUseCase;
    this.todoMapper = todoMapper;
    this.getCategoryByIdUseCase = getCategoryByIdUseCase;
    this.listTodosByCategoryUseCase = listTodosByCategoryUseCase;
  }

  @Override
  public TodoResponseDTO create(TodoRequestDTO requestDTO) {
    Category category = getCategoryByIdUseCase.getById(requestDTO.getCategoryId());

    Todo coreTodo = todoMapper.toTodo(requestDTO);
    coreTodo.setCategory(category);

    Todo createdTodo = createTodoUseCase.create(coreTodo);

    return todoMapper.toResponseDTO(createdTodo);
  }

  @Override
  @Transactional(readOnly = true)
  public List<TodoResponseDTO> list() {
    return todoMapper.toResponseDTOList(listTodoUseCase.list());
  }

  @Override
  public PaginatedResponse<TodoResponseDTO> list(PaginationRequest paginationRequest) {
    PaginatedResponse<Todo> todoPaginationRequest =
        listTodoPaginatedUseCase.list(paginationRequest);

    return new PaginatedResponse<>(
        todoMapper.toResponseDTOList(todoPaginationRequest.getContent()),
        todoPaginationRequest.getPage(),
        todoPaginationRequest.getSize(),
        todoPaginationRequest.getTotalElements(),
        todoPaginationRequest.getTotalPages(),
        todoPaginationRequest.isLast());
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
  public TodoResponseDTO update(Long id, TodoRequestDTO requestDTO) {
    Category category = getCategoryByIdUseCase.getById(requestDTO.getCategoryId());
    Todo todo = getTodoByIdUseCase.getById(id);

    todo.setTodo(requestDTO.getTodo());
    todo.setCategory(category);

    Todo updatedTodo = updateTodoUseCase.update(id, todo);

    return todoMapper.toResponseDTO(updatedTodo);
  }

  @Override
  @Transactional
  public void updateStatus(Long id, TodoStatus status) {
    updateTodoStatusUseCase.updateStatus(id, status);
  }

  @Override
  @Transactional(readOnly = true)
  public List<TodoResponseDTO> listByCategory(Long categoryId) {
    List<Todo> todosList = listTodosByCategoryUseCase.listByCategory(categoryId);
    return todoMapper.toResponseDTO(todosList);
  }
}
