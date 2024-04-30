package br.com.jpcchaves.application.todo;

import br.com.jpcchaves.core.domain.Todo;

public interface GetTodoGateway {
  Todo getTodo(Long id);
}
