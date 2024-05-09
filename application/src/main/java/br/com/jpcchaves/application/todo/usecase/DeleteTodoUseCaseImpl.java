package br.com.jpcchaves.application.todo.usecase;

import br.com.jpcchaves.application.todo.gateway.DeleteTodoGateway;
import br.com.jpcchaves.usecase.todo.DeleteTodoUseCase;

public class DeleteTodoUseCaseImpl implements DeleteTodoUseCase {
  private final DeleteTodoGateway deleteTodoGateway;

  public DeleteTodoUseCaseImpl(DeleteTodoGateway deleteTodoGateway) {
    this.deleteTodoGateway = deleteTodoGateway;
  }

  @Override
  public void delete(Long id) {
    deleteTodoGateway.delete(id);
  }
}
