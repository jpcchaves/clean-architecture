package br.com.jpcchaves.application.gateway;

import br.com.jpcchaves.core.domain.enums.TodoStatus;

public interface UpdateTodoStatusGateway {
  void updateStatus(Long id, TodoStatus status);
}
