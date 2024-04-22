package br.com.jpcchaves.infrastructure.gatewayimpl.todo;

import br.com.jpcchaves.application.gateway.todo.UpdateTodoGateway;
import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.core.exception.TodoException;
import br.com.jpcchaves.core.exception.enums.ExceptionDefinition;
import br.com.jpcchaves.infrastructure.mapper.TodoMapper;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.IRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UpdateTodoGatewayImpl implements UpdateTodoGateway {
  @Qualifier("${deploy.repo}")
  private final IRepository<TodoEntity, Long> todoRepository;

  private final TodoMapper todoMapper;

  public UpdateTodoGatewayImpl(
      IRepository<TodoEntity, Long> todoRepository, TodoMapper todoMapper) {
    this.todoRepository = todoRepository;
    this.todoMapper = todoMapper;
  }

  @Override
  @Transactional
  public Todo update(Long id, Todo todo) {
    TodoEntity todoEntity =
        todoRepository
            .findById(id)
            .orElseThrow(() -> new TodoException(ExceptionDefinition.TD0001));

    todoEntity.setTodo(todo.getTodo());

    TodoEntity updatedTodo = todoRepository.save(todoEntity);

    return todoMapper.toTodo(updatedTodo);
  }
}
