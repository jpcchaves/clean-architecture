package br.com.jpcchaves.application.usecaseimpl.todo;

import br.com.jpcchaves.application.gateway.todo.ListTodoGateway;
import br.com.jpcchaves.core.domain.PaginatedResponse;
import br.com.jpcchaves.core.domain.PaginationRequest;
import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.usecase.todo.ListTodoUseCase;
import java.util.List;

public class ListTodoUseCaseImpl implements ListTodoUseCase {
  private final ListTodoGateway listTodoGateway;

  public ListTodoUseCaseImpl(ListTodoGateway listTodoGateway) {
    this.listTodoGateway = listTodoGateway;
  }

  @Override
  public List<Todo> list() {
    return listTodoGateway.list();
  }

  @Override
  public PaginatedResponse<Todo> list(PaginationRequest paginationRequest) {
    return listTodoGateway.list(paginationRequest);
  }
}
