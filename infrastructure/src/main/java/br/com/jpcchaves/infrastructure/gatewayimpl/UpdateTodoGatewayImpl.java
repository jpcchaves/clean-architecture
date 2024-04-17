package br.com.jpcchaves.infrastructure.gatewayimpl;

import br.com.jpcchaves.application.gateway.UpdateTodoGateway;
import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.core.exception.TodoException;
import br.com.jpcchaves.core.exception.enums.ErrorCode;
import br.com.jpcchaves.infrastructure.mapper.TodoMapper;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.TodoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UpdateTodoGatewayImpl implements UpdateTodoGateway {
  private final TodoRepository todoRepository;
  private final TodoMapper todoMapper;

  public UpdateTodoGatewayImpl(TodoRepository todoRepository, TodoMapper todoMapper) {
    this.todoRepository = todoRepository;
    this.todoMapper = todoMapper;
  }

  @Override
  @Transactional
  public Todo update(Long id, Todo todo) {
    TodoEntity todoEntity =
        todoRepository
            .findById(id)
            .orElseThrow(
                () ->
                    new TodoException(
                        ErrorCode.TD0001.getMessage(),
                        ErrorCode.TD0001.getCode(),
                        ErrorCode.TD0001.getHttpStatus()));

    todoEntity.setTodo(todo.getTodo());

    TodoEntity updatedTodo = todoRepository.save(todoEntity);

    return todoMapper.toTodo(updatedTodo);
  }
}
