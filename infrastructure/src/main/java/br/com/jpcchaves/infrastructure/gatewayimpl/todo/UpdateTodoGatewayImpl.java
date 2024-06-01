package br.com.jpcchaves.infrastructure.gatewayimpl.todo;

import br.com.jpcchaves.application.todo.gateway.UpdateTodoGateway;
import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.mapper.contracts.ITodoMapper;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.ITodoRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UpdateTodoGatewayImpl implements UpdateTodoGateway {
  @Qualifier("${application.config.libraries.repo}")
  private final ITodoRepository<TodoEntity, Long> todoRepository;

  private final ITodoMapper todoMapper;

  public UpdateTodoGatewayImpl(
      ITodoRepository<TodoEntity, Long> todoRepository, ITodoMapper todoMapper) {
    this.todoRepository = todoRepository;
    this.todoMapper = todoMapper;
  }

  @Override
  @Transactional
  public Todo update(Long id, Todo todo) {
    TodoEntity entity = todoMapper.toTodoEntity(todo);
    TodoEntity updatedTodo = todoRepository.save(entity);

    return todoMapper.toTodo(updatedTodo);
  }
}
