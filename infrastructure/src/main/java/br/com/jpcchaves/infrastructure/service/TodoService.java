package br.com.jpcchaves.infrastructure.service;

import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;

public interface TodoService {
    TodoEntity create(Todo todo);
}
