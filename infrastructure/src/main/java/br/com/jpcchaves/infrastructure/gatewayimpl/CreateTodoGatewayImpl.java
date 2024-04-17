package br.com.jpcchaves.infrastructure.gatewayimpl;

import br.com.jpcchaves.application.gateway.CreateTodoGateway;
import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.mapper.TodoMapper;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.TodoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CreateTodoGatewayImpl implements CreateTodoGateway {
  private final TodoRepository todoRepository;
  private final TodoMapper todoMapper;

  public CreateTodoGatewayImpl(TodoRepository todoRepository, TodoMapper todoMapper) {
    this.todoRepository = todoRepository;
    this.todoMapper = todoMapper;
  }

  @Override
  @Transactional
  public Todo create(Todo todo) {
    TodoEntity createdTodo = todoRepository.save(todoMapper.toTodoEntity(todo));

    return todoMapper.toTodo(createdTodo);
  }
}
