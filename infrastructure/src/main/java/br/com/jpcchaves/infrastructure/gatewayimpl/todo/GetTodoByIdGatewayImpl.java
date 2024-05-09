package br.com.jpcchaves.infrastructure.gatewayimpl.todo;

import br.com.jpcchaves.application.todo.gateway.GetTodoGateway;
import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.core.exception.TodoException;
import br.com.jpcchaves.core.exception.enums.ExceptionDefinition;
import br.com.jpcchaves.infrastructure.mapper.TodoMapper;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.ITodoRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class GetTodoByIdGatewayImpl implements GetTodoGateway {
  @Qualifier("${deploy.repo}")
  private final ITodoRepository<TodoEntity, Long> todoRepository;

  private final TodoMapper todoMapper;

  public GetTodoByIdGatewayImpl(
      ITodoRepository<TodoEntity, Long> todoRepository, TodoMapper todoMapper) {
    this.todoRepository = todoRepository;
    this.todoMapper = todoMapper;
  }

  @Override
  @Transactional(readOnly = true)
  public Todo getTodo(Long id) {
    TodoEntity todoEntity =
        todoRepository
            .findById(id)
            .orElseThrow(() -> new TodoException(ExceptionDefinition.TD0001));

    return todoMapper.toTodo(todoEntity);
  }
}
