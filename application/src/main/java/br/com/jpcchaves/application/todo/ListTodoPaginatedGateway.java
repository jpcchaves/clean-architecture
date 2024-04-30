package br.com.jpcchaves.application.todo;

import br.com.jpcchaves.core.domain.PaginatedResponse;
import br.com.jpcchaves.core.domain.PaginationRequest;
import br.com.jpcchaves.core.domain.Todo;

public interface ListTodoPaginatedGateway {
  PaginatedResponse<Todo> list(PaginationRequest paginationRequest);
}
