package br.com.jpcchaves.application.usecaseimpl.todo;

import br.com.jpcchaves.application.gateway.todo.GetTodoGateway;
import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.usecase.todo.GetTodoByIdUseCase;

public class GetTodoByIdUseCaseImpl implements GetTodoByIdUseCase {
  private final GetTodoGateway getTodoGateway;

  public GetTodoByIdUseCaseImpl(GetTodoGateway getTodoGateway) {
    this.getTodoGateway = getTodoGateway;
  }

  @Override
  public Todo getById(Long id) {
    return getTodoGateway.getTodo(id);
  }
}
