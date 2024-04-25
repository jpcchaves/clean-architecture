package br.com.jpcchaves.application.usecaseimpl.todo;

import br.com.jpcchaves.application.gateway.todo.CreateTodoGateway;
import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.usecase.todo.CreateTodoUseCase;

public class CreateTodoUseCaseImpl implements CreateTodoUseCase {
  private final CreateTodoGateway createTodoGateway;

  public CreateTodoUseCaseImpl(CreateTodoGateway createTodoGateway) {
    this.createTodoGateway = createTodoGateway;
  }

  @Override
  public Todo create(Todo todo) {
    return createTodoGateway.create(todo);
  }
}
