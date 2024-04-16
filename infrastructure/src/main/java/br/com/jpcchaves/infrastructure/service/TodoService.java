package br.com.jpcchaves.infrastructure.service;

import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;

import java.util.List;

public interface TodoService {
    TodoEntity create(Todo todo);

    List<TodoEntity> list();

    TodoEntity getById(Long id);
}
