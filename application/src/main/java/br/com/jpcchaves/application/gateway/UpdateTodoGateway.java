package br.com.jpcchaves.application.gateway;

import br.com.jpcchaves.core.domain.Todo;

public interface UpdateTodoGateway {
    Todo update(Long id,
                Todo todo);
}
