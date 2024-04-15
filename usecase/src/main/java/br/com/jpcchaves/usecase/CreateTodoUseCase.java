package br.com.jpcchaves.usecase;

import br.com.jpcchaves.core.domain.Todo;

public interface CreateTodoUseCase {
    Todo create(Todo todo);
}
