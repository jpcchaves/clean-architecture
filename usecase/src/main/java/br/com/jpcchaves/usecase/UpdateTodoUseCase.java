package br.com.jpcchaves.usecase;

import br.com.jpcchaves.core.domain.Todo;

public interface UpdateTodoUseCase {
    Todo update(Long id, Todo todo);
}
