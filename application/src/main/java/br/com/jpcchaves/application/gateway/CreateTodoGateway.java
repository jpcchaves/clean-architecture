package br.com.jpcchaves.application.gateway;

import br.com.jpcchaves.core.domain.Todo;

public interface CreateTodoGateway {
    Todo create(Todo todo);
}
