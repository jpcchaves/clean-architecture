package br.com.jpcchaves.usecase.todo;

import br.com.jpcchaves.core.domain.PaginatedResponse;
import br.com.jpcchaves.core.domain.PaginationRequest;
import br.com.jpcchaves.core.domain.Todo;

public interface ListTodoPaginatedUseCase {
  PaginatedResponse<Todo> list(PaginationRequest paginationRequest);
}
