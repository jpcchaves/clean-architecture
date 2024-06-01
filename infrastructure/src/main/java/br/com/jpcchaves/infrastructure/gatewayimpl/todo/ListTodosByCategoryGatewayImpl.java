package br.com.jpcchaves.infrastructure.gatewayimpl.todo;

import br.com.jpcchaves.application.todo.gateway.ListTodosByCategoryGateway;
import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.mapper.contracts.ITodoMapper;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.ITodoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ListTodosByCategoryGatewayImpl implements ListTodosByCategoryGateway {

  @Qualifier("${application.config.libraries.repo}")
  private final ITodoRepository<TodoEntity, Long> todoRepository;

  private final ITodoMapper todoMapper;

  public ListTodosByCategoryGatewayImpl(
      ITodoRepository<TodoEntity, Long> todoRepository, ITodoMapper todoMapper) {
    this.todoRepository = todoRepository;
    this.todoMapper = todoMapper;
  }

  @Override
  public List<Todo> listByCategory(Long categoryId) {
    List<TodoEntity> entityList = todoRepository.findAllByCategory_Id(categoryId);
    return todoMapper.toTodoList(entityList);
  }
}
