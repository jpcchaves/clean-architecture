package br.com.jpcchaves.infrastructure.service.todo;

import br.com.jpcchaves.core.domain.PaginatedResponse;
import br.com.jpcchaves.core.domain.PaginationRequest;
import br.com.jpcchaves.core.domain.enums.TodoStatus;
import br.com.jpcchaves.infrastructure.dto.todo.TodoRequestDTO;
import br.com.jpcchaves.infrastructure.dto.todo.TodoResponseDTO;
import java.util.List;

public interface TodoService {
  TodoResponseDTO create(TodoRequestDTO request);

  List<TodoResponseDTO> list();

  PaginatedResponse<TodoResponseDTO> list(PaginationRequest paginationRequest);

  TodoResponseDTO getById(Long id);

  void delete(Long id);

  TodoResponseDTO update(Long id, TodoRequestDTO request);

  List<TodoResponseDTO> listByCategory(Long categoryId);

  void updateStatus(Long id, TodoStatus status);
}
