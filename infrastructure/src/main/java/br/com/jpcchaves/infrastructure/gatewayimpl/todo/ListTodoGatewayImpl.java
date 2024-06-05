package br.com.jpcchaves.infrastructure.gatewayimpl.todo;

import br.com.jpcchaves.application.todo.gateway.ListTodoGateway;
import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.mapper.contracts.ITodoMapper;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.ITodoRepository;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ListTodoGatewayImpl implements ListTodoGateway {

  private final ITodoRepository<TodoEntity, Long> todoRepository;
  private final ITodoMapper todoMapper;
  
  public ListTodoGatewayImpl(
      ITodoRepository<TodoEntity, Long> todoRepository,
      ITodoMapper todoMapper) {
    this.todoRepository = todoRepository;
    this.todoMapper = todoMapper;
  }

  @Override
  @Transactional(readOnly = true)
  public List<Todo> list() {
    return todoMapper.toTodoList(todoRepository.findAll());
  }
}
