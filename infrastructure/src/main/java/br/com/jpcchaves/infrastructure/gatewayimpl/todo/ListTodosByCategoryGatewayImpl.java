package br.com.jpcchaves.infrastructure.gatewayimpl.todo;

import br.com.jpcchaves.application.gateway.todo.ListTodosByCategoryGateway;
import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.mapper.TodoMapper;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.infrastructure.persistence.repository.ITodoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ListTodosByCategoryGatewayImpl implements ListTodosByCategoryGateway {

  @Qualifier("${deploy.repo}")
  private final ITodoRepository<TodoEntity, Long> todoRepository;

  private final TodoMapper todoMapper;

  public ListTodosByCategoryGatewayImpl(
      ITodoRepository<TodoEntity, Long> todoRepository, TodoMapper todoMapper) {
    this.todoRepository = todoRepository;
    this.todoMapper = todoMapper;
  }

  @Override
  public List<Todo> listByCategory(Long categoryId) {
    List<TodoEntity> entityList = todoRepository.findAllByCategory_Id(categoryId);
    return todoMapper.toTodoList(entityList);
  }
}
