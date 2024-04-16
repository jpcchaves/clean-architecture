package br.com.jpcchaves.infrastructure.service;

import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;

import java.util.List;

public interface TodoService {
    TodoEntity create(TodoEntity todo);

    List<TodoEntity> list();

    TodoEntity getById(Long id);

    void delete(Long id);

    TodoEntity update(Long id,
                      TodoEntity todoEntity);
}
