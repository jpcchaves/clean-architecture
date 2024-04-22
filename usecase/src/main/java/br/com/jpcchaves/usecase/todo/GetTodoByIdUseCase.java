package br.com.jpcchaves.usecase.todo;

import br.com.jpcchaves.core.domain.Todo;

public interface GetTodoByIdUseCase {
  Todo getById(Long id);
}
