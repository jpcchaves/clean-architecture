package br.com.jpcchaves.infrastructure.gatewayimpl.todo;

import br.com.jpcchaves.application.todo.gateway.CreateTodoGateway;
import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.mapper.TodoMapper;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.ITodoRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CreateTodoGatewayImpl implements CreateTodoGateway {

  @Qualifier("${deploy.repo}")
  private final ITodoRepository<TodoEntity, Long> todoRepository;

  private final TodoMapper todoMapper;

  public CreateTodoGatewayImpl(
      ITodoRepository<TodoEntity, Long> todoRepository, TodoMapper todoMapper) {
    this.todoRepository = todoRepository;
    this.todoMapper = todoMapper;
  }

  @Override
  @Transactional
  public Todo create(Todo todo) {
    TodoEntity todoEntity = todoMapper.toTodoEntity(todo);
    TodoEntity createdTodo = todoRepository.save(todoEntity);

    return todoMapper.toTodo(createdTodo);
  }
}
