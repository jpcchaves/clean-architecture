package br.com.jpcchaves.application.usecaseimpl.todo;

import br.com.jpcchaves.application.gateway.todo.ListTodoPaginatedGateway;
import br.com.jpcchaves.core.domain.PaginatedResponse;
import br.com.jpcchaves.core.domain.PaginationRequest;
import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.usecase.todo.ListTodoPaginatedUseCase;

public class ListTodoPaginatedUseCaseImpl implements ListTodoPaginatedUseCase {
  private final ListTodoPaginatedGateway listTodoPaginatedGateway;

  public ListTodoPaginatedUseCaseImpl(ListTodoPaginatedGateway listTodoPaginatedGateway) {
    this.listTodoPaginatedGateway = listTodoPaginatedGateway;
  }

  @Override
  public PaginatedResponse<Todo> list(PaginationRequest paginationRequest) {
    return listTodoPaginatedGateway.list(paginationRequest);
  }
}
