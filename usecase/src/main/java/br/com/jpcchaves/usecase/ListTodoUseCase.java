package br.com.jpcchaves.usecase;

import br.com.jpcchaves.core.domain.Todo;

public interface ListTodoUseCase {
    PaginationResponse<Todo> list();
}
