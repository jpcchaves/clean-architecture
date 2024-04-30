package br.com.jpcchaves.application.todo;

import br.com.jpcchaves.application.todo.UpdateTodoGateway;
import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.usecase.todo.UpdateTodoUseCase;

public class UpdateTodoUseCaseImpl implements UpdateTodoUseCase {
  private final UpdateTodoGateway updateTodoGateway;

  public UpdateTodoUseCaseImpl(UpdateTodoGateway updateTodoGateway) {
    this.updateTodoGateway = updateTodoGateway;
  }

  @Override
  public Todo update(Long id, Todo todo) {
    return updateTodoGateway.update(id, todo);
  }
}
