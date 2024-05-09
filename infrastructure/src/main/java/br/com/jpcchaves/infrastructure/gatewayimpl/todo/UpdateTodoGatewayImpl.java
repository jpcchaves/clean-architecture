package br.com.jpcchaves.infrastructure.gatewayimpl.todo;

import br.com.jpcchaves.application.todo.gateway.UpdateTodoGateway;
import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.mapper.TodoMapper;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.ITodoRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UpdateTodoGatewayImpl implements UpdateTodoGateway {
  @Qualifier("${deploy.repo}")
  private final ITodoRepository<TodoEntity, Long> todoRepository;

  private final TodoMapper todoMapper;

  public UpdateTodoGatewayImpl(
      ITodoRepository<TodoEntity, Long> todoRepository, TodoMapper todoMapper) {
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
