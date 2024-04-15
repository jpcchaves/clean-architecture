package br.com.jpcchaves.usecase;

import br.com.jpcchaves.core.domain.Page;
import br.com.jpcchaves.core.domain.Todo;

public interface ListTodoUseCase {
    Page<Todo> list();
}
