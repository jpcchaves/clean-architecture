package br.com.jpcchaves.usecase;

import br.com.jpcchaves.core.domain.enums.TodoStatus;

public interface UpdateTodoStatusUseCase {
  void updateStatus(Long id, TodoStatus status);
}
