package br.com.jpcchaves.application.gateway;

import br.com.jpcchaves.core.domain.Todo;

public interface GetTodoGateway {
    Todo getTodo(Long id);
}
