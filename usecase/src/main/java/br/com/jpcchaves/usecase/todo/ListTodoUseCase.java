package br.com.jpcchaves.usecase.todo;

import br.com.jpcchaves.core.domain.PaginatedResponse;
import br.com.jpcchaves.core.domain.PaginationRequest;
import br.com.jpcchaves.core.domain.Todo;
import java.util.List;

public interface ListTodoUseCase {
  List<Todo> list();

  PaginatedResponse<Todo> list(PaginationRequest paginationRequest);
}
