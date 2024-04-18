package br.com.jpcchaves.infrastructure.gatewayimpl;

import br.com.jpcchaves.application.gateway.ListTodoGateway;
import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.mapper.TodoMapper;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.IRepository;
import br.com.jpcchaves.infrastructure.persistence.repository.TodoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ListTodoGatewayImpl implements ListTodoGateway {
  @Qualifier("jpa-repository")
  private final IRepository<TodoEntity, Long> todoRepository;

  private final TodoMapper todoMapper;

  public ListTodoGatewayImpl(TodoRepository todoRepository, TodoMapper todoMapper) {
    this.todoRepository = todoRepository;
    this.todoMapper = todoMapper;
  }

  @Override
  @Transactional(readOnly = true)
  public List<Todo> list() {
    return todoMapper.toTodoList(todoRepository.findAll());
  }
}
