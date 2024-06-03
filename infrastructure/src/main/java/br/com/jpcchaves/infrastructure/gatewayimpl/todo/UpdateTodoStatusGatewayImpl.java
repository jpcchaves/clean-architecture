package br.com.jpcchaves.infrastructure.gatewayimpl.todo;

import br.com.jpcchaves.application.todo.gateway.UpdateTodoStatusGateway;
import br.com.jpcchaves.core.domain.enums.TodoStatus;
import br.com.jpcchaves.core.exception.TodoException;
import br.com.jpcchaves.core.exception.enums.ExceptionDefinition;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.ITodoRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UpdateTodoStatusGatewayImpl implements UpdateTodoStatusGateway {
  @Qualifier("${application.config.libraries.repo}")
  private final ITodoRepository<TodoEntity, Long> todoRepository;

  public UpdateTodoStatusGatewayImpl(ITodoRepository<TodoEntity, Long> todoRepository) {
    this.todoRepository = todoRepository;
  }

  @Override
  public void updateStatus(Long id, TodoStatus status) {
    TodoEntity todoEntity =
        todoRepository
            .findById(id)
            .orElseThrow(() -> new TodoException(ExceptionDefinition.TD0001));

    todoEntity.setStatus(status);

    todoRepository.save(todoEntity);
  }
}
