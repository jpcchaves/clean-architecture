package br.com.jpcchaves.infrastructure.gatewayimpl;

import br.com.jpcchaves.application.gateway.UpdateTodoStatusGateway;
import br.com.jpcchaves.core.domain.enums.TodoStatus;
import br.com.jpcchaves.core.exception.TodoException;
import br.com.jpcchaves.core.exception.enums.ErrorCode;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.IRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UpdateTodoStatusGatewayImpl implements UpdateTodoStatusGateway {
  @Qualifier("in-memo")
  private final IRepository<TodoEntity, Long> todoRepository;

  public UpdateTodoStatusGatewayImpl(IRepository<TodoEntity, Long> todoRepository) {
    this.todoRepository = todoRepository;
  }

  @Override
  public void updateStatus(Long id, TodoStatus status) {
    TodoEntity todoEntity =
        todoRepository
            .findById(id)
            .orElseThrow(
                () ->
                    new TodoException(
                        ErrorCode.TD0001.getMessage(),
                        ErrorCode.TD0001.getCode(),
                        ErrorCode.TD0001.getHttpStatus()));

    todoEntity.setStatus(status);

    todoRepository.save(todoEntity);
  }
}
