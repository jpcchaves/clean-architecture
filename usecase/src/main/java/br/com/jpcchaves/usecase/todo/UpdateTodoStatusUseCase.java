package br.com.jpcchaves.usecase.todo;

import br.com.jpcchaves.core.domain.enums.TodoStatus;

public interface UpdateTodoStatusUseCase {
  void updateStatus(Long id, TodoStatus status);
}
