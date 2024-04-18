package br.com.jpcchaves.infrastructure.gatewayimpl;

import br.com.jpcchaves.application.gateway.GetTodoGateway;
import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.core.exception.TodoException;
import br.com.jpcchaves.core.exception.enums.ErrorCode;
import br.com.jpcchaves.infrastructure.mapper.TodoMapper;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.IRepository;
import br.com.jpcchaves.infrastructure.persistence.repository.TodoJpaRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class GetTodoByIdGatewayImpl implements GetTodoGateway {
  @Qualifier("jpa-repository")
  private final IRepository<TodoEntity, Long> todoRepository;

  private final TodoMapper todoMapper;

  public GetTodoByIdGatewayImpl(TodoJpaRepository todoJpaRepository, TodoMapper todoMapper) {
    this.todoRepository = todoJpaRepository;
    this.todoMapper = todoMapper;
  }

  @Override
  @Transactional(readOnly = true)
  public Todo getTodo(Long id) {
    TodoEntity todoEntity =
        todoRepository
            .findById(id)
            .orElseThrow(
                () ->
                    new TodoException(
                        ErrorCode.TD0001.getMessage(),
                        ErrorCode.TD0001.getCode(),
                        ErrorCode.TD0001.getHttpStatus()));

    return todoMapper.toTodo(todoEntity);
  }
}
