package br.com.jpcchaves.infrastructure.gatewayimpl;

import br.com.jpcchaves.application.gateway.CreateTodoGateway;
import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.mapper.TodoMapper;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.IRepository;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CreateTodoGatewayImpl implements CreateTodoGateway {
  @Qualifier("in-memo")
  private final IRepository<TodoEntity, Long> todoRepository;

  private final TodoMapper todoMapper;

  public CreateTodoGatewayImpl(
      IRepository<TodoEntity, Long> todoRepository, TodoMapper todoMapper) {
    this.todoRepository = todoRepository;
    this.todoMapper = todoMapper;
  }

  @Override
  @Transactional
  public Todo create(Todo todo) {
    Long id = Instant.now().getLong(ChronoField.MILLI_OF_SECOND);
    todo.setId(id);
    todo.setModifiedBy(1L);
    todo.setCreatedAt(LocalDateTime.now());
    todo.setCreatedBy(1L);
    todo.setUpdatedAt(LocalDateTime.now());
    TodoEntity createdTodo = todoRepository.save(todoMapper.toTodoEntity(todo));

    return todoMapper.toTodo(createdTodo);
  }
}
